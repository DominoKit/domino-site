package org.dominokit.pages.server.provider;

import io.vertx.core.http.HttpServerResponse;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.templ.thymeleaf.ThymeleafTemplateEngine;
import org.dominokit.domino.api.server.PluginContext;
import org.dominokit.domino.api.server.plugins.DefaultIndexPageProvider;
import org.dominokit.domino.api.server.plugins.IndexPageProvider;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Locale;
import java.util.Objects;
import java.util.function.Consumer;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class ThymeleafIndexPageProvider implements IndexPageProvider {

    private static final Logger LOGGER = LoggerFactory.getLogger(ThymeleafIndexPageProvider.class);

    public static final String TEMPLATE_PREFIX = "dominokitsite/templates/";
    public static final String TEMPLATE_SUFFIX = ".html";

    private ThymeleafTemplateEngine engine;

    @Override
    public HttpServerResponse serveIndexPage(PluginContext pluginContext, RoutingContext routingContext, int statusCode) {
        initEngine(pluginContext);

        HttpServerResponse response = routingContext
                .response();

        String requestPath = routingContext.request().path();
        if (!requestPath.startsWith("assets") && !requestPath.startsWith("service/") && !requestPath.endsWith(".js")) {
            response
                    .setStatusCode(statusCode)
                    .putHeader("Content-type", "text/html");
            String templateName = "index";
            String path = requestPath.toLowerCase(Locale.ROOT);
            if (!path.equals("/") && !path.equals("/home") && !path.contains("css/")) {
                templateName = requestPath;
            }
            engine.render(new JsonObject(), templateName, event -> {
                if (event.succeeded()) {
                    String content = event.result().toString();
                    content = processJavaDocs(content);
                    response.putHeader("Content-length", content.length() + "")
                            .write(content);
                }
                response.end();
            });
        } else {
            routingContext.next();
        }
        return response;
    }

    public void provideContent(String templatePath, ContentConsumer consumer) {
        engine.render(new JsonObject(), templatePath, event -> {
            if (event.succeeded()) {
                String content = event.result().toString();
                content = processJavaDocs(content);
                consumer.onSuccess(content);
            } else {
                consumer.onFailed(event.cause());
            }
        });
    }

    private String processJavaDocs(String content) {

            Document websiteDocument = Jsoup.parse(content);
            Elements docsClassElements = websiteDocument.getElementsByAttribute("dui-site-docs");
            docsClassElements.forEach(docsClassElement -> {
                try {
                if (nonNull(docsClassElement)) {
                    String docsClass = docsClassElement.attributes().get("dui-site-data");
                    String idPrefix = docsClassElement.attributes().get("dui-site-data-id-prefix");
                    if (!docsClass.trim().isEmpty()) {
                        String docsHtml = new String(Objects.requireNonNull(this.getClass().getClassLoader().getResourceAsStream(docsClass.replace(".", "/") + ".html")).readAllBytes(), StandardCharsets.UTF_8);
                        Document docsDocument = Jsoup.parse(docsHtml);
                        Element jClassDocsElement = docsDocument.getElementById("dui-class-docs");
                        Element webSiteClassdDocsElement = websiteDocument.getElementById(idPrefix+"-class-docs");
                        if (nonNull(jClassDocsElement) && nonNull(webSiteClassdDocsElement)) {
                            webSiteClassdDocsElement.html(jClassDocsElement.html());
                        }

                        Element jMethodsDocsElement = docsDocument.selectFirst("#method\\.summary+h3+table.memberSummary");
                        Element webSiteMethodsDocsElement = websiteDocument.getElementById(idPrefix+"-method-docs");

                        if (nonNull(jMethodsDocsElement) && nonNull(webSiteMethodsDocsElement)) {
                            Elements captions = jMethodsDocsElement.getElementsByTag("caption");
                            if(!captions.isEmpty()) {
                                captions.get(0).remove();
                            }
                            webSiteMethodsDocsElement.html(jMethodsDocsElement.outerHtml());
                        }
                    }
                }
                } catch (IOException e) {
                    LOGGER.error("Failed to load classes docs : ", e);
                }
            });

            return websiteDocument.html();

    }

    private void initEngine(PluginContext pluginContext) {
        if (isNull(this.engine)) {
            this.engine = ThymeleafTemplateEngine.create(pluginContext.getVertxContext().vertx());
            ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
            templateResolver.setPrefix(TEMPLATE_PREFIX);
            templateResolver.setSuffix(TEMPLATE_SUFFIX);
            templateResolver.setCacheable(false);
            engine.getThymeleafTemplateEngine().setTemplateResolver(templateResolver);
        }
    }

    public interface ContentConsumer {
        void onSuccess(String content);

        void onFailed(Throwable exception);
    }
}

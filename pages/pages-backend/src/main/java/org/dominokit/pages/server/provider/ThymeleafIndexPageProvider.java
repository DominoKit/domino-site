package org.dominokit.pages.server.provider;

import io.vertx.core.http.HttpServerResponse;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.templ.thymeleaf.ThymeleafTemplateEngine;
import org.dominokit.domino.api.server.PluginContext;
import org.dominokit.domino.api.server.plugins.DefaultIndexPageProvider;
import org.dominokit.domino.api.server.plugins.IndexPageProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import java.util.Arrays;
import java.util.Locale;
import java.util.function.Consumer;

import static java.util.Objects.isNull;

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
        if(!requestPath.startsWith("assets") && !requestPath.startsWith("service/") && !requestPath.endsWith(".js")) {
            response
                    .setStatusCode(statusCode)
                    .putHeader("Content-type", "text/html");
            String templateName = "index";
            String path = requestPath.toLowerCase(Locale.ROOT);
            if(!path.equals("/") && !path.equals("/home") && !path.contains("css/")){
                templateName = requestPath;
            }
            engine.render(new JsonObject(), templateName, event -> {
                if (event.succeeded()) {
                    String content = event.result().toString();
                    response.putHeader("Content-length", content.length() + "")
                            .write(content);
                }
                response.end();
            });
        }else {
            routingContext.next();
        }
        return response;
    }

    public void provideContent(String templatePath, ContentConsumer consumer){
        engine.render(new JsonObject(), templatePath, event -> {
            if (event.succeeded()) {
                String content = event.result().toString();
                consumer.onSuccess(content);
            } else {
                consumer.onFailed(event.cause());
            }
        });
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

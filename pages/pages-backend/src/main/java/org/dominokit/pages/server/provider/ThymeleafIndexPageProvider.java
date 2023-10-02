package org.dominokit.pages.server.provider;

import io.vertx.core.http.HttpServerResponse;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.templ.thymeleaf.ThymeleafTemplateEngine;
import org.dominokit.domino.api.server.PluginContext;
import org.dominokit.domino.api.server.plugins.DefaultIndexPageProvider;
import org.dominokit.domino.api.server.plugins.IndexPageProvider;
import org.dominokit.domino.ui.icons.lib.MdiByTagFactory;
import org.dominokit.domino.ui.icons.lib.MdiTags;
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
import java.util.stream.Collectors;

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

            engine.render(TemplatesContext.get(), templateName, event -> {
                if (event.succeeded()) {
                    String content = event.result().toString();
                    Document websiteDocument = Jsoup.parse(content);
                    processJavaDocs(websiteDocument);
                    processSideNav(websiteDocument);
                    processIconsMenu(websiteDocument);
                    content = websiteDocument.html();
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

    private void processIconsMenu(Document websiteDocument) {
        Element iconsMenu = websiteDocument.getElementById("dui-mdi-icons-menu");
        if (nonNull(iconsMenu)) {

            MdiTags.TAGS.forEach(tag -> {
                iconsMenu.append("<li class=\"dui dui-site-docs-sub-menu-item\">\n" +
                        "\t\t\t\t\t\t<a class=\"dui dui-site-menu-link\" tabindex=\"0\" dui-site-data=\"nav-anchor\" href=\"/solutions/domino-ui/docs/mdi-icons?tag=" + tagToLinkParam(tag) + "\" aria-expanded=\"true\">\n" +
                        "\t\t\t\t\t\t\t<span class=\"dui\">" + tag + "</span>\n" +
                        "\t\t\t\t\t\t</a>\n" +
                        "\t\t\t\t\t</li>");
            });
        }
    }

    private String tagToLinkParam(String tag) {
        return tag.replace(" / ", "_");
    }

    public void provideContent(String templatePath, JsonObject context, ContentConsumer consumer) {
        engine.render(context, templatePath, event -> {
            if (event.succeeded()) {
                String content = event.result().toString();
                Document websiteDocument = Jsoup.parse(content);
                processJavaDocs(websiteDocument);
                processSideNav(websiteDocument);
                processIconsMenu(websiteDocument);
                consumer.onSuccess(websiteDocument.html());
            } else {
                consumer.onFailed(event.cause());
            }
        });
    }

    private void processJavaDocs(Document websiteDocument) {
        Elements docsClassElements = websiteDocument.getElementsByAttribute("dui-site-docs");
        docsClassElements.forEach(docsClassElement -> {
            try {
                if (nonNull(docsClassElement)) {
                    String docsClass = docsClassElement.attributes().get("dui-site-data");
                    String idPrefix = docsClassElement.attributes().get("dui-site-data-id-prefix");
                    if (!docsClass.trim().isEmpty()) {
                        String classDocs = new String(Objects.requireNonNull(this.getClass().getClassLoader().getResourceAsStream(docsClass.replace(".", "/") + "-dui-site-class-docs.html")).readAllBytes(), StandardCharsets.UTF_8);

                        Element webSiteClassdDocsElement = websiteDocument.getElementById(idPrefix + "-class-docs");
                        if (nonNull(webSiteClassdDocsElement)) {
                            webSiteClassdDocsElement.html(classDocs);
                        }

                        String membersDocs = new String(Objects.requireNonNull(this.getClass().getClassLoader().getResourceAsStream(docsClass.replace(".", "/") + "-dui-site-members-docs.html")).readAllBytes(), StandardCharsets.UTF_8);
                        Element webSiteMethodsDocsElement = websiteDocument.getElementById(idPrefix + "-method-docs");
                        if (nonNull(webSiteMethodsDocsElement)) {
                            webSiteMethodsDocsElement.html(membersDocs);
                        }
                    }
                }
            } catch (IOException e) {
                LOGGER.error("Failed to load classes docs : ", e);
            }
        });
    }

    private void processSideNav(Document websiteDocument) {
        Element sideNavElement = websiteDocument.getElementById("dui-site-doc-page-side-nav");
        if (nonNull(sideNavElement)) {

            String navElements = sideNavElement.attributes().get("dui-site-data");
            String sideNavHtml = Arrays.stream(navElements.split(","))
                    .map(navItem -> "<span class=\"dui dui-labeled-icon dui-reversed dui-site-side-nav-item\" onclick=\"scrollToSection('dui-side-nav-" + navItem.toLowerCase().replace(" ", "-") + "')\">\n" +
                            "            <i class=\"dui mdi " + getNavIcon(navItem) + "\"></i>\n" +
                            "            <span class=\"dui dui-mdi-text dui-text-ellipsis\">" + navItem + "</span>\n" +
                            "        </span>")
                    .collect(Collectors.joining("\n"));

            String sideDocsNavButton= "<span id=\"dui-site-doc-page-side-nav-button\" class=\"dui dui-site-doc-page-side-nav-button dui-labeled-icon dui-reversed dui-site-side-nav-item dui-show-on-small-and-down dui-hide-on-medium-and-up\" > <i class=\"dui mdi mdi-gamepad-circle-left\"></i> <span class=\"dui dui-mdi-text dui-text-ellipsis\"></span> </span>\n";
            sideNavElement.append(sideDocsNavButton + sideNavHtml);
        }
    }

    private String getNavIcon(String navItem) {
        switch (navItem.toLowerCase()) {
            case "top":
                return "mdi-arrow-up-thin";
            default:
                return "mdi-circle-small";
        }
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

    public static String capitalizeFirstLetter(String input) {
        return input.substring(0, 1).toUpperCase() + input.substring(1);
    }
}

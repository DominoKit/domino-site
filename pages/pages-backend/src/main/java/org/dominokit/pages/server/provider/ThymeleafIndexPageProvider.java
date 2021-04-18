package org.dominokit.pages.server.provider;

import io.vertx.core.http.HttpServerResponse;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.templ.thymeleaf.ThymeleafTemplateEngine;
import org.dominokit.domino.api.server.PluginContext;
import org.dominokit.domino.api.server.plugins.IndexPageProvider;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import java.util.Arrays;
import java.util.Locale;
import java.util.function.Consumer;

import static java.util.Objects.isNull;

public class ThymeleafIndexPageProvider implements IndexPageProvider {

    public static final String TEMPLATE_PREFIX = "dominokitsite/templates/";
    public static final String TEMPLATE_SUFFIX = ".html";

    private ThymeleafTemplateEngine engine;

    @Override
    public HttpServerResponse serveIndexPage(PluginContext pluginContext, RoutingContext routingContext, int statusCode) {
        initEngine(pluginContext);

        HttpServerResponse response = routingContext
                .response()
                .setStatusCode(statusCode)
                .putHeader("Content-type", "text/html");
        String templateName = "index";
        if (!Arrays.asList("/", "/home").contains(routingContext.request().path().toLowerCase(Locale.ROOT))) {
            templateName = routingContext.request().path();
        }
        engine.render(new JsonObject(), templateName, event -> {
            if (event.succeeded()) {
                String content = event.result().toString();
                response.putHeader("Content-length", content.length() + "")
                        .write(content);
                response.end();
            } else {
                response.end();
            }
        });
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

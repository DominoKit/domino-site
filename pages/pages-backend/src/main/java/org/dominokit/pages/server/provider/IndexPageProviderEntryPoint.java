package org.dominokit.pages.server.provider;

import com.google.auto.service.AutoService;
import io.vertx.core.json.Json;
import org.dominokit.domino.api.server.entrypoint.ServerAppEntryPoint;
import org.dominokit.domino.api.server.entrypoint.VertxContext;
import org.dominokit.domino.api.server.plugins.IndexPageContext;

import javax.ws.rs.core.MediaType;

@AutoService(ServerAppEntryPoint.class)
public class IndexPageProviderEntryPoint implements ServerAppEntryPoint<VertxContext> {

    private ThymeleafIndexPageProvider contentProvider;

    @Override
    public void onModulesLoaded(VertxContext context) {
        contentProvider = new ThymeleafIndexPageProvider();
        IndexPageContext.INSTANCE.setIndexPageProvider(contentProvider);

        context.router().get("/service/content")
                .produces(MediaType.TEXT_HTML)
                .consumes(MediaType.TEXT_PLAIN)
                .handler(routingContext -> {
                    String pagePath = routingContext.request().getParam("pagePath");
                    contentProvider.provideContent(pagePath, new ThymeleafIndexPageProvider.ContentConsumer() {
                        @Override
                        public void onSuccess(String content) {
                            routingContext
                                    .response()
                                    .setStatusCode(200)
                                    .putHeader("Content-type", "text/html")
                                    .putHeader("Content-length", content.length() + "")
                                    .write(content)
                                    .end();
                        }

                        @Override
                        public void onFailed(Throwable exception) {
                            routingContext
                                    .response()
                                    .write("Failed to load content for path : "+pagePath)
                                    .setStatusCode(500).end();
                        }
                    });
                });
    }
}
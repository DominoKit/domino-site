package org.dominokit.pages.server.provider;

import com.google.auto.service.AutoService;
import com.jcabi.github.*;
import io.vertx.core.json.JsonObject;
import org.dominokit.domino.api.server.entrypoint.ServerAppEntryPoint;
import org.dominokit.domino.api.server.entrypoint.VertxContext;
import org.dominokit.domino.api.server.plugins.IndexPageContext;

import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

@AutoService(ServerAppEntryPoint.class)
public class IndexPageProviderEntryPoint implements ServerAppEntryPoint<VertxContext> {

    private ThymeleafIndexPageProvider contentProvider;

    @Override
    public void onModulesLoaded(VertxContext context) {
        contentProvider = new ThymeleafIndexPageProvider();
        IndexPageContext.INSTANCE.setIndexPageProvider(contentProvider);

        context.router().get("/service/content")
                .produces(MediaType.TEXT_HTML)
                .handler(routingContext -> {
                    String path = routingContext.request().getParam("path");
                    String page = routingContext.request().getParam("page");
                    contentProvider.provideContent("pages/" + path+"/"+page, new ThymeleafIndexPageProvider.ContentConsumer() {
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
                                    .write("Failed to load content for path : " + path +"/"+page)
                                    .setStatusCode(500).end();
                        }
                    });
                });
        context.configRetriever().getConfig(event -> {
            JsonObject configuration = event.result();
            context.router().get("/service/source")
                    .produces(MediaType.TEXT_PLAIN)
                    .handler(routingContext -> {
                        String path = routingContext.request().getParam("path");
                        try {
                            Github github = new RtGithub(configuration.getString("domino_github_token"));
                            Repo repo = github.repos().get(new Coordinates.Simple("DominoKit", "domino-site"));
                            InputStream contentStream = repo
                                    .contents()
                                    .get("pages/pages-frontend-ui/src/main/java/" + path.replace(".", "/")+".java", context.config().getString("samples.branch"))
                                    .raw();

                            String content = new String(contentStream.readAllBytes(), StandardCharsets.UTF_8);
                            routingContext
                                    .response()
                                    .setStatusCode(200)
                                    .putHeader("Content-type", "text/plain")
                                    .putHeader("Content-length", content.length() + "")
                                    .write(content)
                                    .end();

                        } catch (IOException e) {
                            routingContext
                                    .response()
                                    .write("Failed to load content for path : " + path)
                                    .setStatusCode(500).end();
                        }
                    });
        });


    }
}
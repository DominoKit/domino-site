package org.dominokit.pages.server.provider;

import com.google.auto.service.AutoService;
import com.jcabi.github.*;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.http.HttpMethod;
import io.vertx.core.json.Json;
import io.vertx.core.json.JsonObject;
import org.dominokit.domino.api.server.entrypoint.ServerAppEntryPoint;
import org.dominokit.domino.api.server.entrypoint.VertxContext;
import org.dominokit.domino.api.server.plugins.IndexPageContext;
import org.dominokit.pages.shared.model.ContactList;
import org.dominokit.pages.shared.model.ContactList_MapperImpl;

import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

import static java.util.Objects.nonNull;

@AutoService(ServerAppEntryPoint.class)
public class IndexPageProviderEntryPoint implements ServerAppEntryPoint<VertxContext> {

    private ThymeleafIndexPageProvider contentProvider;

    @Override
    public void onModulesLoaded(VertxContext context) {
        contentProvider = new ThymeleafIndexPageProvider();
        IndexPageContext.INSTANCE.setIndexPageProvider(contentProvider);

        context
                .router()
                .route(HttpMethod.GET, "/service/contacts")
                .handler(event -> {
                    Buffer buffer = context
                            .vertx()
                            .fileSystem()
                            .readFileBlocking("contacts.json");

                    String contactJson = buffer.toString(StandardCharsets.UTF_8);

                    ContactList contactList = ContactList_MapperImpl.INSTANCE.read(contactJson);
                    event.response()
                            .setStatusCode(200)
                            .end(Json.encode(contactList.getContacts()));
                });

        context.router().get("/service/content")
                .produces(MediaType.TEXT_HTML)
                .handler(routingContext -> {
                    String path = routingContext.request().getParam("path");
                    String page = routingContext.request().getParam("page");
                    boolean docs= Optional.ofNullable(routingContext.request().getParam("docs"))
                            .map(Boolean::valueOf)
                            .orElse(false);

                    JsonObject templateContext = TemplatesContext.get();
                    templateContext.put("ctxParamDocs", docs);

                    contentProvider.provideContent("pages/" + path+"/"+(docs?"body":page), templateContext, new ThymeleafIndexPageProvider.ContentConsumer() {
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
                        context.vertx().executeBlocking(promise -> {
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
                                        .putHeader("Cache-Control", "max-age=86400")
                                        .write(content)
                                        .end();
                                promise.complete();

                            } catch (IOException e) {
                                routingContext
                                        .response()
                                        .write("Failed to load content for path : " + path)
                                        .setStatusCode(500).end();
                                promise.fail(e);
                            }
                        }, asyncResult -> {

                        });

                    });
        });


    }
}
package org.dominokit.pages.server.provider;

import io.vertx.core.json.JsonObject;

public class TemplatesContext {
    public static JsonObject get(){
        JsonObject context = new JsonObject();
        context.put("domino.jackson.version.latest", "1.0.0");
        context.put("domino_jackson_dependencies", "<dependency>\n" +
                "    <groupId>org.dominokit</groupId>\n" +
                "    <artifactId>domino-jackson</artifactId>\n" +
                "    <version>1.0.0</version>\n" +
                "</dependency>\n" +
                "<dependency>\n" +
                "    <groupId>org.dominokit</groupId>\n" +
                "    <artifactId>domino-jackson-processor</artifactId>\n" +
                "    <version>1.0.0</version>\n" +
                "    <scope>provided</scope>\n" +
                "</dependency>");
        context.put("domino_rest_dependencies", "<dependency>\n" +
                "  <groupId>org.dominokit</groupId>\n" +
                "  <artifactId>domino-rest-client</artifactId>\n" +
                "  <version>1.0.0</version>\n" +
                "</dependency>\n" +
                "\n" +
                "<dependency>\n" +
                "    <groupId>org.dominokit</groupId>\n" +
                "    <artifactId>domino-rest-processor</artifactId>\n" +
                "    <version>1.0.0</version>\n" +
                "    <scope>provided</scope>\n" +
                "</dependency>");

        context.put("domino_rest_frontend_dependencies", "<!-- Lib dependency-->\n" +
                "<dependency>\n" +
                "  <groupId>org.dominokit</groupId>\n" +
                "  <artifactId>domino-rest-client</artifactId>\n" +
                "  <version>1.0.0</version>\n" +
                "</dependency>\n" +
                "\n" +
                "<!-- Annotation processor dependency-->\n" +
                "<dependency>\n" +
                "    <groupId>org.dominokit</groupId>\n" +
                "    <artifactId>domino-rest-processor</artifactId>\n" +
                "    <version>1.0.0</version>\n" +
                "    <scope>provided</scope>\n" +
                "</dependency>");

        context.put("domino_rest_backend_dependencies", "<!-- Lib dependency-->\n" +
                "<dependency>\n" +
                "  <groupId>org.dominokit</groupId>\n" +
                "  <artifactId>domino-rest-jvm</artifactId>\n" +
                "  <version>1.0.0</version>\n" +
                "</dependency>\n" +
                "\n" +
                "<!-- Annotation processor dependency-->\n" +
                "<dependency>\n" +
                "    <groupId>org.dominokit</groupId>\n" +
                "    <artifactId>domino-rest-processor</artifactId>\n" +
                "    <version>1.0.0</version>\n" +
                "    <scope>provided</scope>\n" +
                "</dependency>");

        context.put("domino_rest_shared_frontend_dependencies", "<!-- Lib dependency-->\n" +
                "<dependency>\n" +
                "  <groupId>org.dominokit</groupId>\n" +
                "  <artifactId>domino-rest-client</artifactId>\n" +
                "  <version>1.0.0</version>\n" +
                "</dependency>");

        context.put("domino_rest_shared_backend_dependencies", "<!-- Lib dependency-->\n" +
                "<dependency>\n" +
                "  <groupId>org.dominokit</groupId>\n" +
                "  <artifactId>domino-rest-jvm</artifactId>\n" +
                "  <version>1.0.0</version>\n" +
                "</dependency>");

        context.put("domino_rest_shared_dependencies", "<!-- Lib dependency-->\n" +
                "<dependency>\n" +
                "  <groupId>org.dominokit</groupId>\n" +
                "  <artifactId>domino-rest-shared</artifactId>\n" +
                "  <version>1.0.0</version>\n" +
                "</dependency>\n" +
                "\n" +
                "<!-- Annotation processor dependency-->\n" +
                "<dependency>\n" +
                "    <groupId>org.dominokit</groupId>\n" +
                "    <artifactId>domino-rest-processor</artifactId>\n" +
                "    <version>1.0.0</version>\n" +
                "    <scope>provided</scope>\n" +
                "</dependency>");

        context.put("domino_history_dependencies", "<dependency>\n" +
                "  <groupId>org.dominokit</groupId>\n" +
                "  <artifactId>domino-history-client</artifactId>\n" +
                "  <version>1.0.1</version>\n" +
                "</dependency>");
        return context;
    }
}

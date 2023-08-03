package org.dominokit.pages.shared.service;

import org.dominokit.rest.shared.request.StringReader;
import org.dominokit.rest.shared.request.service.annotations.Reader;
import org.dominokit.rest.shared.request.service.annotations.RequestFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@RequestFactory
@Path("/")
public interface LoadContentService {

    @GET
    @Path("content")
    @Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.TEXT_PLAIN)
    @Reader(StringReader.class)
    String getPageContent(@QueryParam("path") String path, @QueryParam("page") String page);

    @GET
    @Path("source")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.TEXT_PLAIN)
    @Reader(StringReader.class)
    String getSourceCode(@QueryParam("path") String path);
}

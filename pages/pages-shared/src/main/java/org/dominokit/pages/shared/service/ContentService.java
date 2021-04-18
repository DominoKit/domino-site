package org.dominokit.pages.shared.service;

import org.dominokit.rest.shared.request.StringReader;
import org.dominokit.rest.shared.request.service.annotations.Reader;
import org.dominokit.rest.shared.request.service.annotations.RequestFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@RequestFactory
public interface ContentService {

    @GET
    @Path("content")
    @Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.TEXT_PLAIN)
    @Reader(StringReader.class)
    String getPageContent(@QueryParam("pagePath") String pagePath);
}

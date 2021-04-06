package org.dominokit.site.home.shared.services;

import org.dominokit.domino.rest.shared.request.service.annotations.RequestFactory;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@RequestFactory
public interface HomeService {

    @GET
    @Path("{page}")
    @Produces(MediaType.TEXT_HTML)
    String loadPage(@PathParam("page") String page);
}

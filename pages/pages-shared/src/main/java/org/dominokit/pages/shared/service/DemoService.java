package org.dominokit.pages.shared.service;

import org.dominokit.pages.shared.model.Contact;
import org.dominokit.rest.shared.request.service.annotations.RequestFactory;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.List;

@RequestFactory
public interface DemoService {
    @GET
    @Path("contacts")
    List<Contact> list();
}

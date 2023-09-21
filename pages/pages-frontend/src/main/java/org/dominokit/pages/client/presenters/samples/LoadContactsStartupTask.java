package org.dominokit.pages.client.presenters.samples;

import com.google.gwt.resources.client.ResourceCallback;
import com.google.gwt.resources.client.ResourceException;
import com.google.gwt.resources.client.TextResource;
import elemental2.dom.DomGlobal;
import org.dominokit.domino.api.client.annotations.StartupTask;
import org.dominokit.domino.api.client.startup.AsyncClientStartupTask;
import org.dominokit.pages.shared.model.Contact;
import org.dominokit.pages.shared.model.ContactList;
import org.dominokit.pages.shared.model.ContactsProvider;

import java.util.ArrayList;
import java.util.List;

@StartupTask
public class LoadContactsStartupTask extends AsyncClientStartupTask<List<Contact>> {
    @Override
    public int order() {
        return 0;
    }

    @Override
    public void execute() {
        try {
            JsonResource.INSTANCE.generatedJson().getText(new ResourceCallback<TextResource>() {
                @Override
                public void onError(ResourceException e) {
                    DomGlobal.console.error("could not load json", e);
                }

                @Override
                public void onSuccess(TextResource resource) {
                    ContactList contactList = ContactList.MAPPER.read(resource.getText());

                    List<Contact> contacts = contactList.getContacts();
                    ContactsProvider.setContacts(contacts);
                    complete(contacts);
                }
            });
        } catch (ResourceException e) {
            complete(new ArrayList<>());
        }
    }
}

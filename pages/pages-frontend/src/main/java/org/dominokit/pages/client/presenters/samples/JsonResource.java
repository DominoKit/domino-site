package org.dominokit.pages.client.presenters.samples;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ExternalTextResource;

public interface JsonResource extends ClientBundle{

    JsonResource INSTANCE= GWT.create(JsonResource.class);

    @Source("generated.json")
    ExternalTextResource generatedJson();
}

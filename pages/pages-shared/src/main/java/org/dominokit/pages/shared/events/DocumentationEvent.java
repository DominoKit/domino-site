package org.dominokit.pages.shared.events;

import org.dominokit.domino.api.shared.extension.ActivationEvent;

public class DocumentationEvent extends ActivationEvent {
    public DocumentationEvent(boolean status) {
        super(status);
    }

    public DocumentationEvent(String serializedEvent) {
        super(serializedEvent);
    }
}

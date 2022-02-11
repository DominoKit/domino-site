package org.dominokit.pages.shared.events;

import org.dominokit.domino.api.shared.extension.ActivationEvent;

public class DocsActivationEvent extends ActivationEvent {
    public DocsActivationEvent(boolean status) {
        super(status);
    }

    public DocsActivationEvent(String serializedEvent) {
        super(serializedEvent);
    }
}

package org.dominokit.pages.shared.events;

import org.dominokit.domino.api.shared.extension.ActivationEvent;

public class PageEnhancedEvent extends ActivationEvent {
    public PageEnhancedEvent(boolean active) {
        super(active);
    }

    public PageEnhancedEvent(String serializedEvent) {
        super(serializedEvent);
    }
}

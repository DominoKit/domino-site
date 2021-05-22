package org.dominokit.pages.shared.events;

import org.dominokit.domino.api.shared.extension.ActivationEvent;

public class SolutionsEvent extends ActivationEvent {
    public SolutionsEvent(boolean status) {
        super(status);
    }

    public SolutionsEvent(String serializedEvent) {
        super(serializedEvent);
    }
}

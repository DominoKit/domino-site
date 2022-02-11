package org.dominokit.pages.shared.events;

import org.dominokit.domino.api.shared.extension.ActivationEvent;

public class SlotRegisteredEvent extends ActivationEvent {
    public SlotRegisteredEvent(boolean active) {
        super(active);
    }

    public SlotRegisteredEvent(String serializedEvent) {
        super(serializedEvent);
    }
}

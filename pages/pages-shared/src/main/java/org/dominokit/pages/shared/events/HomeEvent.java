package org.dominokit.pages.shared.events;

import org.dominokit.domino.api.shared.extension.ActivationEvent;

public class HomeEvent extends ActivationEvent {
    public HomeEvent(boolean status) {
        super(status);
    }

    public HomeEvent(String serializedEvent) {
        super(serializedEvent);
    }
}

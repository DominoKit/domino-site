package org.dominokit.pages.shared.events;

import org.dominokit.domino.api.shared.extension.ActivationEvent;

public class ContentState extends ActivationEvent {
    public ContentState(boolean active) {
        super(active);
    }
}

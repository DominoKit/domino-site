package org.dominokit.pages.client.views;

import org.dominokit.domino.api.client.mvp.view.UiHandlers;

@FunctionalInterface
public interface NavigableUiHandlers extends UiHandlers {
    void navigateTo(String href);
}

package org.dominokit.pages.client.views;

import org.dominokit.domino.api.client.mvp.view.HasUiHandlers;
import org.dominokit.domino.api.client.mvp.view.UiHandlers;
import org.dominokit.domino.api.client.mvp.view.View;

import java.util.function.Consumer;

public interface PagesView extends View, HasUiHandlers<PagesView.PagesUiHandlers> {

    void enhance(Consumer<Void> handler);
    void enhanceContent();

    void updateContent(String content);

    void replaceContent(String content, String targetElementId);

    void enhancePadding();

    void registerSlots();

    interface PagesUiHandlers extends UiHandlers {
    }
}
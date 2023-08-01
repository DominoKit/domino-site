package org.dominokit.pages.client.views;

import org.dominokit.domino.api.client.mvp.view.HasUiHandlers;
import org.dominokit.domino.api.client.mvp.view.UiHandlers;
import org.dominokit.domino.api.client.mvp.view.View;

public interface PagesView extends View, HasUiHandlers<PagesView.PagesUiHandlers> {

    void enhance();
    void enhanceContent();

    void updateContent(String content);

    void replaceContent(String content, String targetElementId);

    void enhancePadding();

    interface PagesUiHandlers extends UiHandlers {
    }
}
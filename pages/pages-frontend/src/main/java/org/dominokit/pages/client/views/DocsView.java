package org.dominokit.pages.client.views;

import org.dominokit.domino.api.client.mvp.view.ContentView;
import org.dominokit.domino.api.client.mvp.view.HasUiHandlers;
import org.dominokit.domino.api.client.mvp.view.UiHandlers;

public interface DocsView extends ContentView, HasUiHandlers<DocsView.DocsUiHandlers> {

    void enhance();

    void updateContent(String content);

    void setPageTitle(String pageTitle);

    interface DocsUiHandlers extends UiHandlers {
        void onLinkClick(String href);
    }
}

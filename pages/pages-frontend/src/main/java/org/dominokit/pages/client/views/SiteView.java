package org.dominokit.pages.client.views;

import org.dominokit.domino.api.client.mvp.view.ContentView;
import org.dominokit.domino.api.client.mvp.view.HasUiHandlers;
import org.dominokit.domino.api.client.mvp.view.UiHandlers;

public interface SiteView extends ContentView, HasUiHandlers<SiteView.SiteUiHandlers> {
    void updateRootContent(String content);

    void setPageTitle(String pageTitle);

    void enhance();

    interface SiteUiHandlers extends UiHandlers {
        void navigateTo(String href);
    }
}

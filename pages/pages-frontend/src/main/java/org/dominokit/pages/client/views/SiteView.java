package org.dominokit.pages.client.views;

import org.dominokit.domino.api.client.mvp.view.ContentView;
import org.dominokit.domino.api.client.mvp.view.HasUiHandlers;
import org.dominokit.domino.api.client.mvp.view.UiHandlers;

public interface SiteView extends ContentView, HasUiHandlers<SiteView.SiteUiHandlers> {
    void updateContent(String content);

    void setPageTitle(String pageTitle);

    void enhance(EnhanceListener listener);

    interface SiteUiHandlers extends UiHandlers {
        void onLinkClick(String href);
    }

    @FunctionalInterface
    interface EnhanceListener {
        void onPageEnhanced();
    }
}

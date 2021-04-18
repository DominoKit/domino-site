package org.dominokit.pages.client.views;

import org.dominokit.domino.api.client.mvp.view.ContentView;
import org.dominokit.domino.api.client.mvp.view.HasUiHandlers;
import org.dominokit.domino.api.client.mvp.view.UiHandlers;

public interface HomeView extends ContentView, HasUiHandlers<HomeView.HomeUiHandlers> {

    void enhance();

    void updateContent(String content);

    void enhanceClientsNavigation();

    void setPageTitle(String pageTitle);

    interface HomeUiHandlers extends UiHandlers {
        void onLinkClick(String href);
    }
}
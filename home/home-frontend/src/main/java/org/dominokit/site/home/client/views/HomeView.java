package org.dominokit.site.home.client.views;

import org.dominokit.domino.api.client.mvp.view.ContentView;
import org.dominokit.domino.api.client.mvp.view.HasUiHandlers;
import org.dominokit.domino.api.client.mvp.view.UiHandlers;

public interface HomeView extends ContentView, HasUiHandlers<HomeView.HomeUiHandlers> {

    interface HomeUiHandlers extends UiHandlers {
        void onPageRequest(String pageName);
    }
}
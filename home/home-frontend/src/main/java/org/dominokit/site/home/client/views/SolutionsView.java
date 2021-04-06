package org.dominokit.site.home.client.views;

import org.dominokit.domino.api.client.mvp.view.ContentView;
import org.dominokit.domino.api.client.mvp.view.HasUiHandlers;
import org.dominokit.domino.api.client.mvp.view.UiHandlers;

public interface SolutionsView extends ContentView, HasUiHandlers<SolutionsView.SolutionsUiHandlers> {

    void enhance();
    void setContent(String content);

    interface SolutionsUiHandlers extends UiHandlers {
        void onPageRequest(String pageName);
    }
}
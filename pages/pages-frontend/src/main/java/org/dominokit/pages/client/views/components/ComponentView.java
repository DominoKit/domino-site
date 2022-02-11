package org.dominokit.pages.client.views.components;

import org.dominokit.domino.api.client.mvp.view.ContentView;

public interface ComponentView extends ContentView {
    void scrollTo(String section);

    void appendContent(String content);

    void enhance();
}

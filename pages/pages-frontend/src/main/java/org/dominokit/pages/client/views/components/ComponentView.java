package org.dominokit.pages.client.views.components;

import org.dominokit.pages.client.views.NavigableView;

public interface ComponentView extends NavigableView {
    void scrollTo(String section);

    void appendContent(String content);

    void enhance();
}

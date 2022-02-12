package org.dominokit.pages.client.presenters;

import org.dominokit.domino.api.client.mvp.presenter.ViewBaseClientPresenter;
import org.dominokit.pages.client.views.NavigableUiHandlers;
import org.dominokit.pages.client.views.NavigableView;

public abstract class NavigableProxy<V extends NavigableView> extends ViewBaseClientPresenter<V> implements NavigableUiHandlers {

    @Override
    public void navigateTo(String href) {
        if (!history().currentToken().path().equals(href)) {
            history().fireState(href);
        }
    }
}

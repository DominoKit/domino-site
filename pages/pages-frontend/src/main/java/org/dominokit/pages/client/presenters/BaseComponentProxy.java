package org.dominokit.pages.client.presenters;

import org.dominokit.domino.api.client.annotations.presenter.OnReveal;
import org.dominokit.domino.api.client.annotations.presenter.RoutingTokenFilter;
import org.dominokit.domino.api.client.annotations.presenter.StartupTokenFilter;
import org.dominokit.domino.api.client.mvp.presenter.ViewBaseClientPresenter;
import org.dominokit.domino.history.TokenFilter;
import org.dominokit.pages.client.views.components.ComponentView;
import org.dominokit.pages.shared.service.ContentServiceFactory;

public class BaseComponentProxy<V extends ComponentView> extends NavigableProxy<V> {

    @StartupTokenFilter
    public static TokenFilter onDirectRoute(String token) {
        return TokenFilter.startsWith(token);
    }

    @RoutingTokenFilter
    public static TokenFilter onRoute(String token) {
        return TokenFilter.startsWith(token);
    }

    @OnReveal
    public void onReveal() {
        String path = "fragments/pages/" + history().currentToken().path();
        ContentServiceFactory.INSTANCE
                .getPageContent(path)
                .onSuccess(content -> {
                    view.appendContent(content);
                    view.enhance();
                })
                .send();
    }
}

package org.dominokit.pages.client.presenters;

import org.dominokit.domino.api.client.annotations.presenter.*;
import org.dominokit.domino.history.TokenFilter;
import org.dominokit.pages.client.views.DocsView;
import org.dominokit.pages.shared.events.DocumentationEvent;

@PresenterProxy(name = DocsProxy.NAME)
@AutoRoute(token = DocsProxy.PATH)
@OnStateChanged(DocumentationEvent.class)
public class DocsProxy extends SitePresenter<DocsView> {

    public static final String PATH = "solutions/:solution/docs";
    public static final String NAME = "DOCS_PROXY";

    @PathParameter
    String solution;

    @RoutingTokenFilter
    public static TokenFilter onRoute(String token) {
        return TokenFilter.startsWith(token);
    }

    @StartupTokenFilter
    public static TokenFilter onDirectRoute(String token) {
        return TokenFilter.startsWith(token);
    }

    @OnReveal
    public void enhanceTree() {
        view.enhanceTree();
        view.selectMenu(getPage());
        history().listen(TokenFilter.startsWith(PATH), state -> view.selectMenu(getPage()));
    }

    private String getPage() {
        return history().currentToken().noRootValue().replace("solutions/" + solution + "/docs", "").replaceFirst("/", "");
    }

    @Override
    protected String getPageTitle() {
        return solution;
    }
}

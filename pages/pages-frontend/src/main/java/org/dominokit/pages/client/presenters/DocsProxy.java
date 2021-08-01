package org.dominokit.pages.client.presenters;

import org.dominokit.domino.api.client.annotations.presenter.*;
import org.dominokit.domino.api.client.mvp.presenter.ViewBaseClientPresenter;
import org.dominokit.domino.api.shared.extension.MainDominoEvent;
import org.dominokit.domino.history.DominoHistory;
import org.dominokit.domino.history.TokenFilter;
import org.dominokit.pages.client.views.DocsView;
import org.dominokit.pages.shared.events.DocumentationEvent;
import org.dominokit.pages.shared.service.ContentServiceFactory;

@PresenterProxy
@AutoRoute(token = "solutions/:solution/docs", reRouteActivated = true)
@Slot("enhance-slot")
@AutoReveal
@OnStateChanged(DocumentationEvent.class)
@DependsOn(@EventsGroup(MainDominoEvent.class))
public class DocsProxy extends ViewBaseClientPresenter<DocsView> implements DocsView.DocsUiHandlers {

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
    public void load() {
        fetchContent("main/content/" + solution + "/docs");
    }

    protected void updateContent(String content) {
        view.updateContent(content);
        view.setPageTitle(solution);
        view.enhance();
    }

    protected void fetchContent(String contentPath) {
        ContentServiceFactory.INSTANCE
                .getPageContent(contentPath)
                .onSuccess(this::updateContent)
                .onFailed(failedResponseBean -> {

                })
                .send();
    }

    @Override
    public void onLinkClick(String href) {
        if (!history().currentToken().containsPath(href)) {
            history().fireState("solutions/" + solution + "/docs/" + href);
        }
    }
}

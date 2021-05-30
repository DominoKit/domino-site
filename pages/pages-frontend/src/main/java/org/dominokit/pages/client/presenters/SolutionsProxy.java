package org.dominokit.pages.client.presenters;

import org.dominokit.domino.api.client.annotations.presenter.*;
import org.dominokit.domino.api.client.mvp.presenter.ViewBaseClientPresenter;
import org.dominokit.domino.api.shared.extension.MainDominoEvent;
import org.dominokit.pages.client.views.SolutionsView;
import org.dominokit.pages.shared.events.SolutionsEvent;
import org.dominokit.pages.shared.service.ContentServiceFactory;

@PresenterProxy
@AutoRoute(token = "solutions/:solution", reRouteActivated = true)
@Slot("enhance-slot")
@AutoReveal
@OnStateChanged(SolutionsEvent.class)
@DependsOn(@EventsGroup(MainDominoEvent.class))
public class SolutionsProxy extends ViewBaseClientPresenter<SolutionsView> implements SolutionsView.SolutionsUiHandlers {

    @PathParameter("solution")
    String solution;

    @OnReveal
    public void load() {
        fetchContent("main/content/" + solution);
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
        history().fireState(href);
    }
}

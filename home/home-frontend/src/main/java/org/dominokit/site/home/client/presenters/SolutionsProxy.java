package org.dominokit.site.home.client.presenters;

import org.dominokit.domino.api.client.annotations.presenter.*;
import org.dominokit.domino.api.client.mvp.presenter.ViewBaseClientPresenter;
import org.dominokit.domino.api.shared.extension.PredefinedSlots;
import org.dominokit.site.home.client.views.HomeView;
import org.dominokit.site.home.client.views.SolutionsView;
import org.dominokit.site.home.shared.services.HomeServiceFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;

@PresenterProxy
@AutoRoute(token = "solutions.html", reRouteActivated = true)
@Slot(PredefinedSlots.BODY_SLOT)
public class SolutionsProxy extends ViewBaseClientPresenter<SolutionsView> implements SolutionsView.SolutionsUiHandlers {

    private static final Logger LOGGER = LoggerFactory.getLogger(SolutionsProxy.class);

    @PostConstruct
    public void loadContent() {
        String page = history().currentToken().paths().get(0);
        HomeServiceFactory.INSTANCE
                .loadPage(page)
                .onSuccess(response -> {
                    view.setContent(response);
                    reveal();
                })
                .onFailed(failedResponse -> {
                })
                .send();
    }

    @OnReveal
    public void onSolutionsRevealed() {
        LOGGER.info("Solutions view revealed");
    }

    @Override
    public void onPageRequest(String pageName) {
        history().pushState(pageName + ".html");
    }
}
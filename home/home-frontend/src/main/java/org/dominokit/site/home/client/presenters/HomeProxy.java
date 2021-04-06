package org.dominokit.site.home.client.presenters;

import org.dominokit.domino.api.client.annotations.presenter.*;
import org.dominokit.domino.api.client.mvp.presenter.ViewBaseClientPresenter;
import org.dominokit.domino.api.shared.extension.PredefinedSlots;
import org.dominokit.site.home.client.views.HomeView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@PresenterProxy
@AutoRoute(token = "home.html")
@Slot(PredefinedSlots.BODY_SLOT)
@AutoReveal
public class HomeProxy extends ViewBaseClientPresenter<HomeView> implements HomeView.HomeUiHandlers {

    private static final Logger LOGGER = LoggerFactory.getLogger(HomeProxy.class);

    @OnReveal
    public void onHomeRevealed() {
        LOGGER.info("Home view revealed");
    }

    @Override
    public void onPageRequest(String pageName) {
        history().fireState(pageName+".html");
    }
}
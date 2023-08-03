package org.dominokit.pages.client.presenters;

import org.dominokit.domino.api.client.annotations.presenter.*;
import org.dominokit.domino.api.client.mvp.presenter.ViewablePresenter;
import org.dominokit.domino.api.shared.extension.PredefinedSlots;
import org.dominokit.domino.history.DominoHistory;
import org.dominokit.pages.client.views.PagesView;
import org.dominokit.pages.shared.events.ContentState;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

@PresenterProxy(name = "Pages")
@AutoRoute(token = "", reRouteActivated = false)
@Slot(PredefinedSlots.NO_CONTENT_SLOT)
@AutoReveal
public class PagesProxy extends ViewablePresenter<PagesView> implements PagesView.PagesUiHandlers {

    private static final Logger LOGGER = LoggerFactory.getLogger(PagesProxy.class);

    private static final List<ContentLoader> loaders = new ArrayList<>(){{
        add(new MainNavigationContentLoader());
        add(new SolutionContentLoader());
    }};

    @OnActivated
    public void onPagesInit() {
        history().listen(this::updateContent);
    }

    @OnReveal
    public void onPagesRevealed() {
        LOGGER.info("Enhancing view ==============================");
        view.enhance(unused -> {
            fireEvent(ContentState.class, new ContentState(true));
        });
    }

    @OnTokenChanged
    public void updateContent(DominoHistory.State state) {
        loaders.stream().filter(contentLoader -> contentLoader.canLoad(state.token()))
                .findFirst()
                .ifPresent(contentLoader -> contentLoader.loadContent(state.token(), view));
    }
}
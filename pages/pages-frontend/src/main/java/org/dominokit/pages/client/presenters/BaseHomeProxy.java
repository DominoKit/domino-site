package org.dominokit.pages.client.presenters;

import org.dominokit.domino.api.client.annotations.presenter.*;
import org.dominokit.domino.api.client.mvp.presenter.ViewBaseClientPresenter;
import org.dominokit.domino.api.shared.extension.MainDominoEvent;
import org.dominokit.pages.client.views.HomeView;
import org.dominokit.pages.shared.events.HomeEvent;
import org.dominokit.pages.shared.service.ContentServiceFactory;
import org.gwtproject.timer.client.Timer;

@Slot("enhance-slot")
@AutoReveal
@OnStateChanged(HomeEvent.class)
@DependsOn(@EventsGroup(MainDominoEvent.class))
public abstract class BaseHomeProxy extends ViewBaseClientPresenter<HomeView> implements HomeView.HomeUiHandlers {

    private static boolean enhanced = false;

    @PresenterProxy
    @AutoRoute(token = "home")
    public static class HomeProxy extends BaseHomeProxy {

        @OnReveal
        public void loadHome() {
            fetchContent("main/content/home");
            new Timer() {
                @Override
                public void run() {
                    view.enhanceClientsNavigation();
                }
            }.schedule(500);
        }

        @Override
        protected String getPageTitle() {
            return "Home";
        }
    }

    @PresenterProxy
    @AutoRoute(token = "news")
    public static class NewsProxy extends BaseHomeProxy {

        @OnReveal
        public void loadNews() {
            fetchContent("main/content/news");
        }

        @Override
        protected String getPageTitle() {
            return "News";
        }
    }

    @PresenterProxy
    @AutoRoute(token = "about")
    public static class AboutProxy extends BaseHomeProxy {

        @OnReveal
        public void loadAbout() {
            fetchContent("main/content/about");
        }

        @Override
        protected String getPageTitle() {
            return "About";
        }
    }

    @OnInit
    public void onPagesInit() {
        if (!enhanced) {
            view.enhance();
            enhanced = true;
        }
    }

    protected void updateContent(String content) {
        view.updateContent(content);
        view.setPageTitle(getPageTitle());
    }

    protected abstract String getPageTitle();

    protected void fetchContent(String contentPath) {
        if (enhanced) {
            ContentServiceFactory.INSTANCE
                    .getPageContent(contentPath)
                    .onSuccess(this::updateContent)
                    .onFailed(failedResponseBean -> {

                    })
                    .send();
        }
    }

    @Override
    public void onLinkClick(String href) {
        history().fireState(href);
    }
}
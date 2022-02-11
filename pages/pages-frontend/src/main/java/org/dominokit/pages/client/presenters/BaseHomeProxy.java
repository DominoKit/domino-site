package org.dominokit.pages.client.presenters;

import org.dominokit.domino.api.client.annotations.presenter.*;
import org.dominokit.domino.api.shared.extension.MainDominoEvent;
import org.dominokit.pages.client.views.HomeView;
import org.dominokit.pages.shared.events.HomeEvent;

@Slot("enhance-slot")
@AutoReveal
@OnStateChanged(HomeEvent.class)
@DependsOn(@EventsGroup(MainDominoEvent.class))
public abstract class BaseHomeProxy extends SitePresenter<HomeView> {

    @PresenterProxy
    @AutoRoute(token = "home")
    public static class HomeProxy extends BaseHomeProxy {

        @Override
        protected String getPageTitle() {
            return "Home";
        }

        @Override
        protected String getPath() {
            return "home";
        }
    }

    @PresenterProxy
    @AutoRoute(token = "services")
    public static class ServicesProxy extends BaseHomeProxy {

        @Override
        protected String getPageTitle() {
            return "Services";
        }

        @Override
        protected String getPath() {
            return "services";
        }
    }

    @PresenterProxy
    @AutoRoute(token = "news")
    public static class NewsProxy extends BaseHomeProxy {

        @Override
        protected String getPageTitle() {
            return "News";
        }

        @Override
        protected String getPath() {
            return "news";
        }

    }

    @PresenterProxy
    @AutoRoute(token = "about")
    public static class AboutProxy extends BaseHomeProxy {

        @Override
        protected String getPageTitle() {
            return "About";
        }

        @Override
        protected String getPath() {
            return "about";
        }
    }
}

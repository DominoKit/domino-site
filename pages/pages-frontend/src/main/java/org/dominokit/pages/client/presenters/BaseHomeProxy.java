package org.dominokit.pages.client.presenters;

import org.dominokit.domino.api.client.annotations.presenter.*;
import org.dominokit.domino.api.shared.extension.MainDominoEvent;
import org.dominokit.pages.client.views.HomeView;
import org.dominokit.pages.shared.events.HomeEvent;
import org.dominokit.pages.shared.service.ContentServiceFactory;

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
    }

    @PresenterProxy
    @AutoRoute(token = "services")
    public static class ServicesProxy extends BaseHomeProxy {

        @Override
        protected String getPageTitle() {
            return "Services";
        }
    }

    @PresenterProxy
    @AutoRoute(token = "news")
    public static class NewsProxy extends BaseHomeProxy {

        @Override
        protected String getPageTitle() {
            return "News";
        }

    }

    @PresenterProxy
    @AutoRoute(token = "about")
    public static class AboutProxy extends BaseHomeProxy {

        @Override
        protected String getPageTitle() {
            return "About";
        }
    }
}

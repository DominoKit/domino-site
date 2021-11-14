package org.dominokit.pages.client.presenters;

import org.dominokit.domino.api.client.annotations.presenter.*;
import org.dominokit.domino.history.TokenFilter;
import org.dominokit.pages.client.views.SolutionsView;
import org.dominokit.pages.shared.events.SolutionsEvent;

@PresenterProxy
@AutoRoute(token = "solutions/:solution", reRouteActivated = true)
@OnStateChanged(SolutionsEvent.class)
public class SolutionsProxy extends SitePresenter<SolutionsView> {

    @PathParameter("solution")
    String solution;

    @RoutingTokenFilter
    public static TokenFilter onRoute(String token){
        return TokenFilter.endsWith(token);
    }

    @StartupTokenFilter
    public static TokenFilter onDirectRoute(String token){
        return TokenFilter.endsWith(token);
    }

    @Override
    protected String getPageTitle() {
        return solution;
    }
}

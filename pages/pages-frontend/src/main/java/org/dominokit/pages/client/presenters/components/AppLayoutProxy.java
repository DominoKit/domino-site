package org.dominokit.pages.client.presenters.components;

import org.dominokit.domino.api.client.annotations.presenter.AutoRoute;
import org.dominokit.domino.api.client.annotations.presenter.PresenterProxy;
import org.dominokit.pages.client.presenters.SampleProxy;

@PresenterProxy(name = "AppLayoutDemo")
@AutoRoute(token = "solutions/domino-ui/docs/layouts/app-layout", reRouteActivated = true)
public class AppLayoutProxy extends SampleProxy {

}
package org.dominokit.pages.client.presenters.samples.layouts;

import org.dominokit.domino.api.client.annotations.presenter.AutoRoute;
import org.dominokit.domino.api.client.annotations.presenter.PresenterProxy;
import org.dominokit.pages.client.presenters.SampleProxy;

@PresenterProxy(name = "AppLayoutDemo")
@AutoRoute(token = "solutions/domino-ui/docs/layouts/grid-layout", reRouteActivated = true)
public class GridLayoutProxy extends SampleProxy {

}
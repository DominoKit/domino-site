package org.dominokit.pages.client.presenters.samples.layouts;

import org.dominokit.domino.api.client.annotations.presenter.AutoRoute;
import org.dominokit.domino.api.client.annotations.presenter.PresenterProxy;
import org.dominokit.pages.client.presenters.SampleProxy;

@PresenterProxy(name = "ResponsiveGridsDemo")
@AutoRoute(token = "solutions/domino-ui/v2/docs/layouts/responsive-grids", reRouteActivated = true)
public class ResponsiveGridsProxy extends SampleProxy {

}
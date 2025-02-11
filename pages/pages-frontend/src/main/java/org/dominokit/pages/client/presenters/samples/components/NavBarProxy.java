package org.dominokit.pages.client.presenters.samples.components;

import org.dominokit.domino.api.client.annotations.presenter.AutoRoute;
import org.dominokit.domino.api.client.annotations.presenter.PresenterProxy;
import org.dominokit.pages.client.presenters.SampleProxy;

@PresenterProxy(name = "NavBarDemo")
@AutoRoute(token = "solutions/domino-ui/v2/docs/components/navbar", reRouteActivated = true)
public class NavBarProxy extends SampleProxy {

}
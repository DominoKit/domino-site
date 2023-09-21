package org.dominokit.pages.client.presenters.samples.helpers;

import org.dominokit.domino.api.client.annotations.presenter.AutoRoute;
import org.dominokit.domino.api.client.annotations.presenter.PresenterProxy;
import org.dominokit.pages.client.presenters.SampleProxy;

@PresenterProxy(name = "HelpersDemo")
@AutoRoute(token = "solutions/domino-ui/docs/helpers", reRouteActivated = true)
public class HelpersProxy extends SampleProxy {

}
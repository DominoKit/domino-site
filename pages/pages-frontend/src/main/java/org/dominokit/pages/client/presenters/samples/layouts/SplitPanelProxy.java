package org.dominokit.pages.client.presenters.samples.layouts;

import org.dominokit.domino.api.client.annotations.presenter.AutoRoute;
import org.dominokit.domino.api.client.annotations.presenter.PresenterProxy;
import org.dominokit.pages.client.presenters.SampleProxy;

@PresenterProxy(name = "SplitPanelDemo")
@AutoRoute(token = "solutions/domino-ui/v2/docs/layouts/split-panel", reRouteActivated = true)
public class SplitPanelProxy extends SampleProxy {

}
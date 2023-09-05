package org.dominokit.pages.client.presenters.samples.components;

import org.dominokit.domino.api.client.annotations.presenter.AutoRoute;
import org.dominokit.domino.api.client.annotations.presenter.PresenterProxy;
import org.dominokit.pages.client.presenters.SampleProxy;

@PresenterProxy(name = "ProgressBarsDemo")
@AutoRoute(token = "solutions/domino-ui/docs/components/progress-bars", reRouteActivated = true)
public class ProgressBarsProxy extends SampleProxy {

}
package org.dominokit.pages.client.presenters.samples.components;

import org.dominokit.domino.api.client.annotations.presenter.AutoRoute;
import org.dominokit.domino.api.client.annotations.presenter.PresenterProxy;
import org.dominokit.pages.client.presenters.SampleProxy;

@PresenterProxy(name = "SlidersDemo")
@AutoRoute(token = "solutions/domino-ui/v2/docs/components/sliders", reRouteActivated = true)
public class SlidersProxy extends SampleProxy {

}
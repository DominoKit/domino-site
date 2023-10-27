package org.dominokit.pages.client.presenters.samples.layouts;

import org.dominokit.domino.api.client.annotations.presenter.AutoRoute;
import org.dominokit.domino.api.client.annotations.presenter.PresenterProxy;
import org.dominokit.pages.client.presenters.SampleProxy;

@PresenterProxy(name = "FlexLayoutDemo")
@AutoRoute(token = "solutions/domino-ui/v2/docs/layouts/flex-layout", reRouteActivated = true)
public class FlexLayoutProxy extends SampleProxy {

}
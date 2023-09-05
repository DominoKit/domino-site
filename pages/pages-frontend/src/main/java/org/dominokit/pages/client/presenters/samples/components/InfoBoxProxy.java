package org.dominokit.pages.client.presenters.samples.components;

import org.dominokit.domino.api.client.annotations.presenter.AutoRoute;
import org.dominokit.domino.api.client.annotations.presenter.PresenterProxy;
import org.dominokit.pages.client.presenters.SampleProxy;

@PresenterProxy(name = "InfoBoxDemo")
@AutoRoute(token = "solutions/domino-ui/docs/components/info-box", reRouteActivated = true)
public class InfoBoxProxy extends SampleProxy {

}
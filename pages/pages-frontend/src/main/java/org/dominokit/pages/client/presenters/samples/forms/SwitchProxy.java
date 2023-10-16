package org.dominokit.pages.client.presenters.samples.forms;

import org.dominokit.domino.api.client.annotations.presenter.AutoRoute;
import org.dominokit.domino.api.client.annotations.presenter.PresenterProxy;
import org.dominokit.pages.client.presenters.SampleProxy;

@PresenterProxy(name = "SwitchDemo")
@AutoRoute(token = "solutions/domino-ui/docs/forms/switch", reRouteActivated = true)
public class SwitchProxy extends SampleProxy {

}
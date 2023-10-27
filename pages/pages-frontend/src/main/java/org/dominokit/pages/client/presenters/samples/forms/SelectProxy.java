package org.dominokit.pages.client.presenters.samples.forms;

import org.dominokit.domino.api.client.annotations.presenter.AutoRoute;
import org.dominokit.domino.api.client.annotations.presenter.PresenterProxy;
import org.dominokit.pages.client.presenters.SampleProxy;

@PresenterProxy(name = "SelectDemo")
@AutoRoute(token = "solutions/domino-ui/v2/docs/forms/select", reRouteActivated = true)
public class SelectProxy extends SampleProxy {

}
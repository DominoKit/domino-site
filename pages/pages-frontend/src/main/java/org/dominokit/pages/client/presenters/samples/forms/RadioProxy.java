package org.dominokit.pages.client.presenters.samples.forms;

import org.dominokit.domino.api.client.annotations.presenter.AutoRoute;
import org.dominokit.domino.api.client.annotations.presenter.PresenterProxy;
import org.dominokit.pages.client.presenters.SampleProxy;

@PresenterProxy(name = "RadioDemo")
@AutoRoute(token = "solutions/domino-ui/v2/docs/forms/radio", reRouteActivated = true)
public class RadioProxy extends SampleProxy {

}
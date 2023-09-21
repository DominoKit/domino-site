package org.dominokit.pages.client.presenters.samples.forms;

import org.dominokit.domino.api.client.annotations.presenter.AutoRoute;
import org.dominokit.domino.api.client.annotations.presenter.PresenterProxy;
import org.dominokit.pages.client.presenters.SampleProxy;

@PresenterProxy(name = "BasicFormsDemo")
@AutoRoute(token = "solutions/domino-ui/docs/forms/basic", reRouteActivated = true)
public class BasicFormsProxy extends SampleProxy {

}
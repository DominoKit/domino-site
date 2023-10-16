package org.dominokit.pages.client.presenters.samples.forms;

import org.dominokit.domino.api.client.annotations.presenter.AutoRoute;
import org.dominokit.domino.api.client.annotations.presenter.PresenterProxy;
import org.dominokit.pages.client.presenters.SampleProxy;

@PresenterProxy(name = "CheckBoxDemo")
@AutoRoute(token = "solutions/domino-ui/docs/forms/check-box", reRouteActivated = true)
public class CheckboxProxy extends SampleProxy {

}
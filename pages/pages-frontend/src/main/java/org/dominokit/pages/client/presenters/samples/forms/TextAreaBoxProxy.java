package org.dominokit.pages.client.presenters.samples.forms;

import org.dominokit.domino.api.client.annotations.presenter.AutoRoute;
import org.dominokit.domino.api.client.annotations.presenter.PresenterProxy;
import org.dominokit.pages.client.presenters.SampleProxy;

@PresenterProxy(name = "TextAreaBoxDemo")
@AutoRoute(token = "solutions/domino-ui/docs/forms/text-area", reRouteActivated = true)
public class TextAreaBoxProxy extends SampleProxy {

}
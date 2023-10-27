package org.dominokit.pages.client.presenters.samples.forms;

import org.dominokit.domino.api.client.annotations.presenter.AutoRoute;
import org.dominokit.domino.api.client.annotations.presenter.PresenterProxy;
import org.dominokit.pages.client.presenters.SampleProxy;

@PresenterProxy(name = "SuggestBoxDemo")
@AutoRoute(token = "solutions/domino-ui/v2/docs/forms/suggest-box", reRouteActivated = true)
public class SuggestBoxProxy extends SampleProxy {

}
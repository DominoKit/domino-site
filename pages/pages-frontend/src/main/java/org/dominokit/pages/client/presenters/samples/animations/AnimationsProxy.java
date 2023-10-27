package org.dominokit.pages.client.presenters.samples.animations;

import org.dominokit.domino.api.client.annotations.presenter.AutoRoute;
import org.dominokit.domino.api.client.annotations.presenter.PresenterProxy;
import org.dominokit.pages.client.presenters.SampleProxy;

@PresenterProxy(name = "AnimationsDemo")
@AutoRoute(token = "solutions/domino-ui/v2/docs/animations", reRouteActivated = true)
public class AnimationsProxy extends SampleProxy {

}
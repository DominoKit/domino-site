package org.dominokit.pages.client.presenters.samples.components;

import org.dominokit.domino.api.client.annotations.presenter.AutoRoute;
import org.dominokit.domino.api.client.annotations.presenter.PresenterProxy;
import org.dominokit.pages.client.presenters.SampleProxy;

@PresenterProxy(name = "PreLoadersDemo")
@AutoRoute(token = "solutions/domino-ui/docs/components/pre-loaders", reRouteActivated = true)
public class PreLoadersProxy extends SampleProxy {

}
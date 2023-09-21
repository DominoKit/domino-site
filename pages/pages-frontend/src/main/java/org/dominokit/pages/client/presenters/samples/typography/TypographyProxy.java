package org.dominokit.pages.client.presenters.samples.typography;

import org.dominokit.domino.api.client.annotations.presenter.AutoRoute;
import org.dominokit.domino.api.client.annotations.presenter.PresenterProxy;
import org.dominokit.pages.client.presenters.SampleProxy;

@PresenterProxy(name = "TypographyDemo")
@AutoRoute(token = "solutions/domino-ui/docs/typography", reRouteActivated = true)
public class TypographyProxy extends SampleProxy {

}
package org.dominokit.pages.client.presenters.samples.components;

import org.dominokit.domino.api.client.annotations.presenter.AutoRoute;
import org.dominokit.domino.api.client.annotations.presenter.PresenterProxy;
import org.dominokit.pages.client.presenters.SampleProxy;

@PresenterProxy(name = "MediaObjectsDemo")
@AutoRoute(token = "solutions/domino-ui/v2/docs/components/media-objects", reRouteActivated = true)
public class MediaObjectsProxy extends SampleProxy {

}
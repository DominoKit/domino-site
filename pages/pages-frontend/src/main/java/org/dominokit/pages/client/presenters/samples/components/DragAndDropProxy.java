package org.dominokit.pages.client.presenters.samples.components;

import org.dominokit.domino.api.client.annotations.presenter.AutoRoute;
import org.dominokit.domino.api.client.annotations.presenter.PresenterProxy;
import org.dominokit.pages.client.presenters.SampleProxy;

@PresenterProxy(name = "DragAndDropDemo")
@AutoRoute(token = "solutions/domino-ui/docs/components/drag-and-drop", reRouteActivated = true)
public class DragAndDropProxy extends SampleProxy {

}
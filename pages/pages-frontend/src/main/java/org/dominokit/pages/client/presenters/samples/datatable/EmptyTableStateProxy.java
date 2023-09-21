package org.dominokit.pages.client.presenters.samples.datatable;

import org.dominokit.domino.api.client.annotations.presenter.AutoRoute;
import org.dominokit.domino.api.client.annotations.presenter.PresenterProxy;
import org.dominokit.pages.client.presenters.SampleProxy;

@PresenterProxy(name = "EmptyTableStateDemo")
@AutoRoute(token = "solutions/domino-ui/docs/data-table/empty-state", reRouteActivated = true)
public class EmptyTableStateProxy extends SampleProxy {

}
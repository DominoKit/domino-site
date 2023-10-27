package org.dominokit.pages.client.presenters.samples.datatable;

import org.dominokit.domino.api.client.annotations.presenter.AutoRoute;
import org.dominokit.domino.api.client.annotations.presenter.PresenterProxy;
import org.dominokit.pages.client.presenters.SampleProxy;

@PresenterProxy(name = "ColumnResizeDemo")
@AutoRoute(token = "solutions/domino-ui/v2/docs/data-table/column-resize", reRouteActivated = true)
public class ColumnResizeProxy extends SampleProxy {

}
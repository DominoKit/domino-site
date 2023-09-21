package org.dominokit.pages.client.presenters.samples.datatable;

import org.dominokit.domino.api.client.annotations.presenter.AutoRoute;
import org.dominokit.domino.api.client.annotations.presenter.PresenterProxy;
import org.dominokit.pages.client.presenters.SampleProxy;

@PresenterProxy(name = "RowMenuDemo")
@AutoRoute(token = "solutions/domino-ui/docs/data-table/row-menu", reRouteActivated = true)
public class RowMenuProxy extends SampleProxy {

}
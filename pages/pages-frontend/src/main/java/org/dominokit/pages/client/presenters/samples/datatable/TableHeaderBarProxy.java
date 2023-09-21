package org.dominokit.pages.client.presenters.samples.datatable;

import org.dominokit.domino.api.client.annotations.presenter.AutoRoute;
import org.dominokit.domino.api.client.annotations.presenter.PresenterProxy;
import org.dominokit.pages.client.presenters.SampleProxy;

@PresenterProxy(name = "TableHeaderBarDemo")
@AutoRoute(token = "solutions/domino-ui/docs/data-table/header-bar", reRouteActivated = true)
public class TableHeaderBarProxy extends SampleProxy {

}
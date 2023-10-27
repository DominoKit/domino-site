package org.dominokit.pages.client.presenters.samples.datatable;

import org.dominokit.domino.api.client.annotations.presenter.AutoRoute;
import org.dominokit.domino.api.client.annotations.presenter.PresenterProxy;
import org.dominokit.pages.client.presenters.SampleProxy;

@PresenterProxy(name = "FixedDatatableDemo")
@AutoRoute(token = "solutions/domino-ui/v2/docs/data-table/fixed-table", reRouteActivated = true)
public class FixedDataTableProxy extends SampleProxy {

}
package org.dominokit.pages.client.presenters.samples.datatable;

import org.dominokit.domino.api.client.annotations.presenter.AutoRoute;
import org.dominokit.domino.api.client.annotations.presenter.PresenterProxy;
import org.dominokit.pages.client.presenters.SampleProxy;

@PresenterProxy(name = "RecordDetailsDemo")
@AutoRoute(token = "solutions/domino-ui/docs/data-table/record-details", reRouteActivated = true)
public class RecordDetailsProxy extends SampleProxy {

}
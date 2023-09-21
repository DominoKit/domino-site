package org.dominokit.pages.client.presenters.samples.datatable;

import org.dominokit.domino.api.client.annotations.presenter.AutoRoute;
import org.dominokit.domino.api.client.annotations.presenter.PresenterProxy;
import org.dominokit.pages.client.presenters.SampleProxy;

@PresenterProxy(name = "EditableTableDemo")
@AutoRoute(token = "solutions/domino-ui/docs/data-table/editable-table", reRouteActivated = true)
public class EditableTableProxy extends SampleProxy {

}
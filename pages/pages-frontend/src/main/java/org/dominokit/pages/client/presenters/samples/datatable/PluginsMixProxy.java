package org.dominokit.pages.client.presenters.samples.datatable;

import org.dominokit.domino.api.client.annotations.presenter.AutoRoute;
import org.dominokit.domino.api.client.annotations.presenter.PresenterProxy;
import org.dominokit.pages.client.presenters.SampleProxy;

@PresenterProxy(name = "PluginMixDemo")
@AutoRoute(token = "solutions/domino-ui/docs/data-table/mix", reRouteActivated = true)
public class PluginsMixProxy extends SampleProxy {

}
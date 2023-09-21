package org.dominokit.pages.client.presenters.samples.forms;

import org.dominokit.domino.api.client.annotations.presenter.AutoRoute;
import org.dominokit.domino.api.client.annotations.presenter.PresenterProxy;
import org.dominokit.pages.client.presenters.SampleProxy;

@PresenterProxy(name = "DatePickerDemo")
@AutoRoute(token = "solutions/domino-ui/docs/forms/date-picker", reRouteActivated = true)
public class DatePickerProxy extends SampleProxy {

}
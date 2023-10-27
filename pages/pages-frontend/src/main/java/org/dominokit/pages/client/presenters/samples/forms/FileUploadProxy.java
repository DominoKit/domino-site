package org.dominokit.pages.client.presenters.samples.forms;

import org.dominokit.domino.api.client.annotations.presenter.AutoRoute;
import org.dominokit.domino.api.client.annotations.presenter.PresenterProxy;
import org.dominokit.pages.client.presenters.SampleProxy;

@PresenterProxy(name = "FileUploadDemo")
@AutoRoute(token = "solutions/domino-ui/v2/docs/forms/file-upload", reRouteActivated = true)
public class FileUploadProxy extends SampleProxy {

}
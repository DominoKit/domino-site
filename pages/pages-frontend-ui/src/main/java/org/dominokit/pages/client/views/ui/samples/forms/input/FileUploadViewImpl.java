package org.dominokit.pages.client.views.ui.samples.forms.input;

import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.pages.client.presenters.samples.forms.FileUploadProxy;
import org.dominokit.pages.client.presenters.samples.forms.TextBoxProxy;
import org.dominokit.pages.client.views.ui.DemoSample;
import org.dominokit.pages.client.views.ui.LazyProvider;
import org.dominokit.pages.client.views.ui.SampleViewImpl;

@UiView(presentable = FileUploadProxy.class)
public class FileUploadViewImpl extends SampleViewImpl {

    public FileUploadViewImpl() {
        register(DemoSample.of("upload-box-sample", UploadBoxSample.class, LazyProvider.of(UploadBoxSample::create)));
        register(DemoSample.of("drag-drop-upload-sample", FileUploadSample.class, LazyProvider.of(FileUploadSample::create)));
    }
}
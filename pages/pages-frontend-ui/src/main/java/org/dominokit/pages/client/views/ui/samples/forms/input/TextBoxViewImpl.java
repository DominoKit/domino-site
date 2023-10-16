package org.dominokit.pages.client.views.ui.samples.forms.input;

import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.pages.client.presenters.samples.forms.TextBoxProxy;
import org.dominokit.pages.client.views.ui.DemoSample;
import org.dominokit.pages.client.views.ui.LazyProvider;
import org.dominokit.pages.client.views.ui.SampleViewImpl;

@UiView(presentable = TextBoxProxy.class)
public class TextBoxViewImpl extends SampleViewImpl {

    public TextBoxViewImpl() {
        register(DemoSample.of("text-box-sample", BasicFormsInputSample.class, LazyProvider.of(BasicFormsInputSample::create)));
    }
}
package org.dominokit.pages.client.views.ui.samples.forms.input;

import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.pages.client.presenters.samples.forms.TextAreaBoxProxy;
import org.dominokit.pages.client.presenters.samples.forms.TextBoxProxy;
import org.dominokit.pages.client.views.ui.DemoSample;
import org.dominokit.pages.client.views.ui.LazyProvider;
import org.dominokit.pages.client.views.ui.SampleViewImpl;

@UiView(presentable = TextAreaBoxProxy.class)
public class TextAreaBoxViewImpl extends SampleViewImpl {
    public TextAreaBoxViewImpl() {
        register(DemoSample.of("text-area-sample", BasicFormsTextAreaSample.class, LazyProvider.of(BasicFormsTextAreaSample::create)));
    }
}
package org.dominokit.pages.client.views.ui.samples.forms.input;

import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.pages.client.presenters.samples.forms.InputMaskProxy;
import org.dominokit.pages.client.presenters.samples.forms.TextBoxProxy;
import org.dominokit.pages.client.views.ui.DemoSample;
import org.dominokit.pages.client.views.ui.LazyProvider;
import org.dominokit.pages.client.views.ui.SampleViewImpl;

@UiView(presentable = InputMaskProxy.class)
public class InputMaskViewImpl extends SampleViewImpl {

    public InputMaskViewImpl() {
        register(DemoSample.of("string-mask-sample", StringMaskSample.class, LazyProvider.of(StringMaskSample::create)));
        register(DemoSample.of("mask-box-sample", MaskBoxSample.class, LazyProvider.of(MaskBoxSample::create)));
        register(DemoSample.of("input-mask-sample", InputMaskSample.class, LazyProvider.of(InputMaskSample::create)));
    }
}
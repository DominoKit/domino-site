package org.dominokit.pages.client.views.ui.samples.forms.input;

import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.pages.client.presenters.samples.forms.RadioProxy;
import org.dominokit.pages.client.presenters.samples.forms.SwitchProxy;
import org.dominokit.pages.client.views.ui.DemoSample;
import org.dominokit.pages.client.views.ui.LazyProvider;
import org.dominokit.pages.client.views.ui.SampleViewImpl;

@UiView(presentable = RadioProxy.class)
public class RadioViewImpl extends SampleViewImpl {
    public RadioViewImpl() {
        register(DemoSample.of("radio-sample", BasicFormsRadioSample.class, LazyProvider.of(BasicFormsRadioSample::create)));
    }
}
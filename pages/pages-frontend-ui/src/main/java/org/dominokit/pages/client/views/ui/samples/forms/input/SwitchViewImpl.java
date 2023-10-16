package org.dominokit.pages.client.views.ui.samples.forms.input;

import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.pages.client.presenters.samples.forms.SwitchProxy;
import org.dominokit.pages.client.presenters.samples.forms.TextBoxProxy;
import org.dominokit.pages.client.views.ui.DemoSample;
import org.dominokit.pages.client.views.ui.LazyProvider;
import org.dominokit.pages.client.views.ui.SampleViewImpl;

@UiView(presentable = SwitchProxy.class)
public class SwitchViewImpl extends SampleViewImpl {

    public SwitchViewImpl() {
        register(DemoSample.of("switch-sample", BasicFormsSwitchSample.class, LazyProvider.of(BasicFormsSwitchSample::create)));
    }
}
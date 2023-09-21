package org.dominokit.pages.client.views.ui.samples.forms.basic;

import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.pages.client.presenters.samples.components.CardsProxy;
import org.dominokit.pages.client.presenters.samples.forms.BasicFormsProxy;
import org.dominokit.pages.client.views.ui.DemoSample;
import org.dominokit.pages.client.views.ui.LazyProvider;
import org.dominokit.pages.client.views.ui.SampleViewImpl;
import org.dominokit.pages.client.views.ui.samples.components.cards.*;

@UiView(presentable = BasicFormsProxy.class)
public class BasicFormsViewImpl extends SampleViewImpl {

    public BasicFormsViewImpl() {
        register(DemoSample.of("forms-basic-input", BasicFormsInputSample.class, LazyProvider.of(BasicFormsInputSample::create)));
        register(DemoSample.of("forms-basic-textarea", BasicFormsTextAreaSample.class, LazyProvider.of(BasicFormsTextAreaSample::create)));
        register(DemoSample.of("forms-basic-select", BasicFormsSelectSample.class, LazyProvider.of(BasicFormsSelectSample::create)));
        register(DemoSample.of("forms-basic-checkbox", BasicFormsCheckboxSample.class, LazyProvider.of(BasicFormsCheckboxSample::create)));
        register(DemoSample.of("forms-basic-radio", BasicFormsRadioSample.class, LazyProvider.of(BasicFormsRadioSample::create)));
        register(DemoSample.of("forms-basic-switch", BasicFormsSwitchSample.class, LazyProvider.of(BasicFormsSwitchSample::create)));
    }
}
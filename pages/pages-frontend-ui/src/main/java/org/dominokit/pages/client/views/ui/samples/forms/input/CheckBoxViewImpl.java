package org.dominokit.pages.client.views.ui.samples.forms.input;

import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.pages.client.presenters.samples.forms.CheckboxProxy;
import org.dominokit.pages.client.views.ui.DemoSample;
import org.dominokit.pages.client.views.ui.LazyProvider;
import org.dominokit.pages.client.views.ui.SampleViewImpl;

@UiView(presentable = CheckboxProxy.class)
public class CheckBoxViewImpl extends SampleViewImpl {

    public CheckBoxViewImpl() {
        register(DemoSample.of("check-box-sample", BasicFormsCheckboxSample.class, LazyProvider.of(BasicFormsCheckboxSample::create)));
    }
}
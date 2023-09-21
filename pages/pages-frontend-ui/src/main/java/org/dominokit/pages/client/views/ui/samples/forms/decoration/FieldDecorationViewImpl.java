package org.dominokit.pages.client.views.ui.samples.forms.decoration;

import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.pages.client.presenters.samples.forms.BasicFormsProxy;
import org.dominokit.pages.client.presenters.samples.forms.FieldDecorationProxy;
import org.dominokit.pages.client.views.ui.DemoSample;
import org.dominokit.pages.client.views.ui.LazyProvider;
import org.dominokit.pages.client.views.ui.SampleViewImpl;
import org.dominokit.pages.client.views.ui.samples.forms.basic.*;

@UiView(presentable = FieldDecorationProxy.class)
public class FieldDecorationViewImpl extends SampleViewImpl {

    public FieldDecorationViewImpl() {
        register(DemoSample.of("field-decoration-helper", FieldDecorationHelperTextSample.class, LazyProvider.of(FieldDecorationHelperTextSample::create)));
        register(DemoSample.of("field-decoration-addons", FieldDecorationAddOnsSample.class, LazyProvider.of(FieldDecorationAddOnsSample::create)));
        register(DemoSample.of("field-decoration-counter", FieldDecorationCounterSample.class, LazyProvider.of(FieldDecorationCounterSample::create)));
        register(DemoSample.of("field-decoration-validation", FieldDecorationValidationSample.class, LazyProvider.of(FieldDecorationValidationSample::create)));
    }
}
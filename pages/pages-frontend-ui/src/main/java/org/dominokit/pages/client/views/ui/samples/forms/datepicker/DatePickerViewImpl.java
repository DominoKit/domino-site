package org.dominokit.pages.client.views.ui.samples.forms.datepicker;

import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.pages.client.presenters.samples.forms.BasicFormsProxy;
import org.dominokit.pages.client.presenters.samples.forms.DatePickerProxy;
import org.dominokit.pages.client.views.ui.DemoSample;
import org.dominokit.pages.client.views.ui.LazyProvider;
import org.dominokit.pages.client.views.ui.SampleViewImpl;
import org.dominokit.pages.client.views.ui.samples.forms.basic.*;

@UiView(presentable = DatePickerProxy.class)
public class DatePickerViewImpl extends SampleViewImpl {

    public DatePickerViewImpl() {
        register(DemoSample.of("date-picker-inlined", InlinedDatePickerSample.class, LazyProvider.of(InlinedDatePickerSample::create)));
        register(DemoSample.of("date-picker-header", DatePickerHeaderSample.class, LazyProvider.of(DatePickerHeaderSample::create)));
        register(DemoSample.of("date-picker-footer", DatePickerFooterSample.class, LazyProvider.of(DatePickerFooterSample::create)));
        register(DemoSample.of("date-picker-dropdown", DropDownDatePickerSample.class, LazyProvider.of(DropDownDatePickerSample::create)));
        register(DemoSample.of("date-picker-datebox", DateBoxSample.class, LazyProvider.of(DateBoxSample::create)));
    }
}
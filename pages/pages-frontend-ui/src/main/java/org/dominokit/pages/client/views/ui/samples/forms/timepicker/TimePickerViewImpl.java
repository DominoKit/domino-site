package org.dominokit.pages.client.views.ui.samples.forms.timepicker;

import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.pages.client.presenters.samples.forms.TimePickerProxy;
import org.dominokit.pages.client.views.ui.DemoSample;
import org.dominokit.pages.client.views.ui.LazyProvider;
import org.dominokit.pages.client.views.ui.SampleViewImpl;

@UiView(presentable = TimePickerProxy.class)
public class TimePickerViewImpl extends SampleViewImpl {

    public TimePickerViewImpl() {
        register(DemoSample.of("time-picker-inlined", InlinedTimePickerSample.class, LazyProvider.of(InlinedTimePickerSample::create)));
        register(DemoSample.of("time-picker-header", TimePickerHeaderSample.class, LazyProvider.of(TimePickerHeaderSample::create)));
        register(DemoSample.of("time-picker-footer", TimePickerFooterSample.class, LazyProvider.of(TimePickerFooterSample::create)));
        register(DemoSample.of("time-picker-dropdown", DropDownTimePickerSample.class, LazyProvider.of(DropDownTimePickerSample::create)));
        register(DemoSample.of("time-picker-datebox", TimeBoxSample.class, LazyProvider.of(TimeBoxSample::create)));
    }
}
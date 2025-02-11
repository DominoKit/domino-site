package org.dominokit.pages.client.views.ui.samples.components.counters;

import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.pages.client.presenters.samples.components.ColorPickerProxy;
import org.dominokit.pages.client.presenters.samples.components.CountersProxy;
import org.dominokit.pages.client.views.ui.DemoSample;
import org.dominokit.pages.client.views.ui.LazyProvider;
import org.dominokit.pages.client.views.ui.SampleViewImpl;
import org.dominokit.pages.client.views.ui.samples.components.colorpicker.BasicColorPickerSample;
import org.dominokit.pages.client.views.ui.samples.components.colorpicker.ColorPickerButtonSample;
import org.dominokit.pages.client.views.ui.samples.components.colorpicker.ColorPickerPopoverSample;

@UiView(presentable = CountersProxy.class)
public class CountersViewImpl extends SampleViewImpl {

    public CountersViewImpl() {
        register(DemoSample.of("counters-simple", SimpleCountersSample.class, LazyProvider.of(SimpleCountersSample::create)));
        register(DemoSample.of("counters-auto", AutoCountersSample.class, LazyProvider.of(AutoCountersSample::create)));
        register(DemoSample.of("counters-date", DateCountDownSample.class, LazyProvider.of(DateCountDownSample::create)));
    }
}
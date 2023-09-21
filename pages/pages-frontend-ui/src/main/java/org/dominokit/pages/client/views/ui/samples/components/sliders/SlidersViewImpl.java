package org.dominokit.pages.client.views.ui.samples.components.sliders;

import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.pages.client.presenters.samples.components.CardsProxy;
import org.dominokit.pages.client.presenters.samples.components.SlidersProxy;
import org.dominokit.pages.client.views.ui.DemoSample;
import org.dominokit.pages.client.views.ui.LazyProvider;
import org.dominokit.pages.client.views.ui.SampleViewImpl;
import org.dominokit.pages.client.views.ui.samples.components.cards.*;

@UiView(presentable = SlidersProxy.class)
public class SlidersViewImpl extends SampleViewImpl {

    public SlidersViewImpl() {
        register(DemoSample.of("sliders-basic", BasicSlidersSample.class, LazyProvider.of(BasicSlidersSample::create)));
        register(DemoSample.of("sliders-colored", ColoredSlidersSample.class, LazyProvider.of(ColoredSlidersSample::create)));
        register(DemoSample.of("sliders-picker", SlidersPickerSample.class, LazyProvider.of(SlidersPickerSample::create)));
    }
}
package org.dominokit.pages.client.views.ui.samples.components.sliders;

import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.pages.client.presenters.samples.components.RangeSliderProxy;
import org.dominokit.pages.client.presenters.samples.components.SlidersProxy;
import org.dominokit.pages.client.views.ui.DemoSample;
import org.dominokit.pages.client.views.ui.LazyProvider;
import org.dominokit.pages.client.views.ui.SampleViewImpl;

@UiView(presentable = RangeSliderProxy.class)
public class RangeSlidersViewImpl extends SampleViewImpl {

    public RangeSlidersViewImpl() {
        register(DemoSample.of("range-slider-basic", BasicRangeSlidersSample.class, LazyProvider.of(BasicRangeSlidersSample::create)));
    }
}
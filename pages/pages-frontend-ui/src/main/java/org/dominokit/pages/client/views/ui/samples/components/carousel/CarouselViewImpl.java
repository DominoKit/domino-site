package org.dominokit.pages.client.views.ui.samples.components.carousel;

import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.pages.client.presenters.samples.components.CardsProxy;
import org.dominokit.pages.client.presenters.samples.components.CarouselProxy;
import org.dominokit.pages.client.views.ui.DemoSample;
import org.dominokit.pages.client.views.ui.LazyProvider;
import org.dominokit.pages.client.views.ui.SampleViewImpl;
import org.dominokit.pages.client.views.ui.samples.components.cards.*;

@UiView(presentable = CarouselProxy.class)
public class CarouselViewImpl extends SampleViewImpl {

    public CarouselViewImpl() {
        register(DemoSample.of("carousel-basic", CarouselBasicSample.class, LazyProvider.of(CarouselBasicSample::create)));
        register(DemoSample.of("carousel-auto", AutoCarouselSample.class, LazyProvider.of(AutoCarouselSample::create)));
    }
}
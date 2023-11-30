package org.dominokit.pages.client.views.ui.samples.components.cards;

import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.pages.client.presenters.samples.components.CardsProxy;
import org.dominokit.pages.client.views.ui.DemoSample;
import org.dominokit.pages.client.views.ui.LazyProvider;
import org.dominokit.pages.client.views.ui.SampleViewImpl;

@UiView(presentable = CardsProxy.class)
public class CardsViewImpl extends SampleViewImpl {

    public CardsViewImpl() {
        register(DemoSample.of("cards-no-header", NoHeaderCardsSample.class, LazyProvider.of(NoHeaderCardsSample::create)));
        register(DemoSample.of("cards-headers", CardsWithHeadersSample.class, LazyProvider.of(CardsWithHeadersSample::create)));
        register(DemoSample.of("cards-colored", ColoredCardsSample.class, LazyProvider.of(ColoredCardsSample::create)));
        register(DemoSample.of("cards-collapsible", CollapsibleCardsSample.class, LazyProvider.of(CollapsibleCardsSample::create)));
        register(DemoSample.of("cards-logo", CardLogoSample.class, LazyProvider.of(CardLogoSample::create)));
        register(DemoSample.of("cards-subheader", CardSubHeaderSample.class, LazyProvider.of(CardSubHeaderSample::create)));
    }
}
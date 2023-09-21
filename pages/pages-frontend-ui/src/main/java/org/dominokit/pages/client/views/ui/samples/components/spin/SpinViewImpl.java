package org.dominokit.pages.client.views.ui.samples.components.spin;

import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.pages.client.presenters.samples.components.CardsProxy;
import org.dominokit.pages.client.presenters.samples.components.SpinProxy;
import org.dominokit.pages.client.views.ui.DemoSample;
import org.dominokit.pages.client.views.ui.LazyProvider;
import org.dominokit.pages.client.views.ui.SampleViewImpl;
import org.dominokit.pages.client.views.ui.samples.components.cards.*;

@UiView(presentable = SpinProxy.class)
public class SpinViewImpl extends SampleViewImpl {

    public SpinViewImpl() {
        register(DemoSample.of("spin-horizontal", HorizontalSpinSample.class, LazyProvider.of(HorizontalSpinSample::create)));
        register(DemoSample.of("spin-vertical", VerticalSpinSample.class, LazyProvider.of(VerticalSpinSample::create)));
    }
}
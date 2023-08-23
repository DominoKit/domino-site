package org.dominokit.pages.client.views.ui.samples.components.collapsible;

import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.pages.client.presenters.samples.components.CardsProxy;
import org.dominokit.pages.client.presenters.samples.components.CollapsibleProxy;
import org.dominokit.pages.client.views.ui.DemoSample;
import org.dominokit.pages.client.views.ui.LazyProvider;
import org.dominokit.pages.client.views.ui.SampleViewImpl;
import org.dominokit.pages.client.views.ui.samples.components.cards.*;

@UiView(presentable = CollapsibleProxy.class)
public class CollapsibleViewImpl extends SampleViewImpl {

    public CollapsibleViewImpl() {
        register(DemoSample.of("collapse-strategy", CollapsibleStrategySample.class, LazyProvider.of(CollapsibleStrategySample::create)));
        register(DemoSample.of("collapse-accordion", AccordionSample.class, LazyProvider.of(AccordionSample::create)));
        register(DemoSample.of("collapse-accordion-multi-open", MultiOpenAccordionSample.class, LazyProvider.of(MultiOpenAccordionSample::create)));
    }
}
package org.dominokit.pages.client.views.ui.samples.components.popover;

import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.pages.client.presenters.samples.components.PopoverProxy;
import org.dominokit.pages.client.views.ui.DemoSample;
import org.dominokit.pages.client.views.ui.LazyProvider;
import org.dominokit.pages.client.views.ui.SampleViewImpl;

@UiView(presentable = PopoverProxy.class)
public class PopoverViewImpl extends SampleViewImpl {

    public PopoverViewImpl() {
        register(DemoSample.of("popovers-tooltip", TooltipSample.class, LazyProvider.of(TooltipSample::create)));
        register(DemoSample.of("popovers-popover", PopoverSample.class, LazyProvider.of(PopoverSample::create)));
    }
}
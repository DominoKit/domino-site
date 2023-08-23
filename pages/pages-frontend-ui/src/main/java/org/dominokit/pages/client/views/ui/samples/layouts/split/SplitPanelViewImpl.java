package org.dominokit.pages.client.views.ui.samples.layouts.split;

import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.pages.client.presenters.samples.layouts.SplitPanelProxy;
import org.dominokit.pages.client.views.ui.DemoSample;
import org.dominokit.pages.client.views.ui.LazyProvider;
import org.dominokit.pages.client.views.ui.SampleViewImpl;

@UiView(presentable = SplitPanelProxy.class)
public class SplitPanelViewImpl extends SampleViewImpl {

    public SplitPanelViewImpl() {
        register(DemoSample.of("split-panel-horizontal", SplitPanelHorizontal.class, LazyProvider.of(SplitPanelHorizontal::create)));
        register(DemoSample.of("split-panel-vertical", SplitPanelVertical.class, LazyProvider.of(SplitPanelVertical::create)));
        register(DemoSample.of("split-panel-min-max", SplitPanelMinMax.class, LazyProvider.of(SplitPanelMinMax::create)));
        register(DemoSample.of("split-panel-multiple", SplitPanelMultiple.class, LazyProvider.of(SplitPanelMultiple::create)));
        register(DemoSample.of("split-panel-combined", SplitPanelCombined.class, LazyProvider.of(SplitPanelCombined::create)));
    }
}
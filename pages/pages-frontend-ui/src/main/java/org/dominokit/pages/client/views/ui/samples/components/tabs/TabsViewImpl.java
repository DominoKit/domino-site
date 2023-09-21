package org.dominokit.pages.client.views.ui.samples.components.tabs;

import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.pages.client.presenters.samples.components.CardsProxy;
import org.dominokit.pages.client.presenters.samples.components.TabsProxy;
import org.dominokit.pages.client.views.ui.DemoSample;
import org.dominokit.pages.client.views.ui.LazyProvider;
import org.dominokit.pages.client.views.ui.SampleViewImpl;
import org.dominokit.pages.client.views.ui.samples.components.cards.*;

@UiView(presentable = TabsProxy.class)
public class TabsViewImpl extends SampleViewImpl {

    public TabsViewImpl() {
        register(DemoSample.of("tabs-basic", BasicTabsSample.class, LazyProvider.of(BasicTabsSample::create)));
        register(DemoSample.of("tabs-alignment", TabsAlignmentSample.class, LazyProvider.of(TabsAlignmentSample::create)));
        register(DemoSample.of("tabs-closable", ClosableTabsSample.class, LazyProvider.of(ClosableTabsSample::create)));
        register(DemoSample.of("tabs-colored", ColoredTabsSample.class, LazyProvider.of(ColoredTabsSample::create)));
        register(DemoSample.of("tabs-content", TabsContentSample.class, LazyProvider.of(TabsContentSample::create)));
        register(DemoSample.of("tabs-animation", TabsAnimationSample.class, LazyProvider.of(TabsAnimationSample::create)));
        register(DemoSample.of("tabs-vertical", VerticalTabsSample.class, LazyProvider.of(VerticalTabsSample::create)));
    }
}
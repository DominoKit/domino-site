package org.dominokit.pages.client.views.ui.samples.layouts.flex;

import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.pages.client.presenters.samples.layouts.FlexLayoutProxy;
import org.dominokit.pages.client.views.ui.DemoSample;
import org.dominokit.pages.client.views.ui.LazyProvider;
import org.dominokit.pages.client.views.ui.SampleViewImpl;

@UiView(presentable = FlexLayoutProxy.class)
public class FlexLayoutViewImpl extends SampleViewImpl {

    public FlexLayoutViewImpl() {
        register(DemoSample.of("flex-layout-playground", FlexLayoutPlayground.class, LazyProvider.of(FlexLayoutPlayground::create)));
        register(DemoSample.of("flex-item-playground", FlexItemPlayground.class, LazyProvider.of(FlexItemPlayground::create)));
    }
}
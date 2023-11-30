package org.dominokit.pages.client.views.ui.samples.datatable.scroll;

import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.pages.client.presenters.samples.datatable.ScrollLoadingProxy;
import org.dominokit.pages.client.views.ui.DemoSample;
import org.dominokit.pages.client.views.ui.LazyProvider;
import org.dominokit.pages.client.views.ui.SampleViewImpl;

@UiView(presentable = ScrollLoadingProxy.class)
public class ScrollLoadingViewImpl extends SampleViewImpl {

    public ScrollLoadingViewImpl() {
        register(DemoSample.of("datatable-scroll-loading", ScrollLoadingSample.class, LazyProvider.of(ScrollLoadingSample::create)));
    }
}
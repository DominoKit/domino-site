package org.dominokit.pages.client.views.ui.samples.components.pagination;

import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.pages.client.presenters.samples.components.PaginationProxy;
import org.dominokit.pages.client.views.ui.DemoSample;
import org.dominokit.pages.client.views.ui.LazyProvider;
import org.dominokit.pages.client.views.ui.SampleViewImpl;

@UiView(presentable = PaginationProxy.class)
public class PaginationViewImpl extends SampleViewImpl {

    public PaginationViewImpl() {
        register(DemoSample.of("pagination-basic", BasicPaginationSample.class, LazyProvider.of(BasicPaginationSample::create)));
        register(DemoSample.of("pagination-scrolling", ScrollingPaginationSample.class, LazyProvider.of(ScrollingPaginationSample::create)));
        register(DemoSample.of("pagination-advanced", AdvancedPaginationSample.class, LazyProvider.of(AdvancedPaginationSample::create)));
        register(DemoSample.of("pagination-pager", PagerPaginationSample.class, LazyProvider.of(PagerPaginationSample::create)));
    }
}
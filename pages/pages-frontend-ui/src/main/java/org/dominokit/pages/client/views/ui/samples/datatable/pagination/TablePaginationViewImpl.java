package org.dominokit.pages.client.views.ui.samples.datatable.pagination;

import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.pages.client.presenters.samples.datatable.BasicDataTableProxy;
import org.dominokit.pages.client.presenters.samples.datatable.TablepaginationProxy;
import org.dominokit.pages.client.views.ui.DemoSample;
import org.dominokit.pages.client.views.ui.LazyProvider;
import org.dominokit.pages.client.views.ui.SampleViewImpl;
import org.dominokit.pages.client.views.ui.samples.datatable.basic.BasicDataTableSample;

@UiView(presentable = TablepaginationProxy.class)
public class TablePaginationViewImpl extends SampleViewImpl {

    public TablePaginationViewImpl() {
        register(DemoSample.of("datatable-pagination-simple", SimplePaginationSample.class, LazyProvider.of(SimplePaginationSample::create)));
        register(DemoSample.of("datatable-pagination-scrolling", ScrollingPaginationSample.class, LazyProvider.of(ScrollingPaginationSample::create)));
        register(DemoSample.of("datatable-pagination-advanced", AdvancedPaginationSample.class, LazyProvider.of(AdvancedPaginationSample::create)));
    }
}
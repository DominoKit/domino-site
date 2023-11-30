package org.dominokit.pages.client.views.ui.samples.datatable.sortsearch;

import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.pages.client.presenters.samples.datatable.TableSortAndSearchProxy;
import org.dominokit.pages.client.views.ui.DemoSample;
import org.dominokit.pages.client.views.ui.LazyProvider;
import org.dominokit.pages.client.views.ui.SampleViewImpl;

@UiView(presentable = TableSortAndSearchProxy.class)
public class TableSortAndSearchViewImpl extends SampleViewImpl {

    public TableSortAndSearchViewImpl() {
        register(DemoSample.of("datatable-sort-search", TableSortAndSearchSample.class, LazyProvider.of(TableSortAndSearchSample::create)));
    }
}
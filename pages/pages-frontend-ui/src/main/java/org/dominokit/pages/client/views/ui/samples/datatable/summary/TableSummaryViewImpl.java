package org.dominokit.pages.client.views.ui.samples.datatable.summary;

import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.pages.client.presenters.samples.datatable.TableSummaryProxy;
import org.dominokit.pages.client.views.ui.DemoSample;
import org.dominokit.pages.client.views.ui.LazyProvider;
import org.dominokit.pages.client.views.ui.SampleViewImpl;

@UiView(presentable = TableSummaryProxy.class)
public class TableSummaryViewImpl extends SampleViewImpl {

    public TableSummaryViewImpl() {
        register(DemoSample.of("datatable-summary", TableSummarySample.class, LazyProvider.of(TableSummarySample::create)));
    }
}
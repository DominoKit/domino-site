package org.dominokit.pages.client.views.ui.samples.datatable.header;

import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.pages.client.presenters.samples.datatable.BasicDataTableProxy;
import org.dominokit.pages.client.presenters.samples.datatable.TableHeaderBarProxy;
import org.dominokit.pages.client.views.ui.DemoSample;
import org.dominokit.pages.client.views.ui.LazyProvider;
import org.dominokit.pages.client.views.ui.SampleViewImpl;
import org.dominokit.pages.client.views.ui.samples.datatable.basic.BasicDataTableSample;

@UiView(presentable = TableHeaderBarProxy.class)
public class TableHeaderViewImpl extends SampleViewImpl {

    public TableHeaderViewImpl() {
        register(DemoSample.of("datatable-header-bar", TableHeaderBarSample.class, LazyProvider.of(TableHeaderBarSample::create)));
    }
}
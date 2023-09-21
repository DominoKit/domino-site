package org.dominokit.pages.client.views.ui.samples.datatable.fixed;

import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.pages.client.presenters.samples.datatable.BasicDataTableProxy;
import org.dominokit.pages.client.presenters.samples.datatable.FixedDataTableProxy;
import org.dominokit.pages.client.views.ui.DemoSample;
import org.dominokit.pages.client.views.ui.LazyProvider;
import org.dominokit.pages.client.views.ui.SampleViewImpl;
import org.dominokit.pages.client.views.ui.samples.datatable.basic.BasicDataTableSample;

@UiView(presentable = FixedDataTableProxy.class)
public class FixedDataTableViewImpl extends SampleViewImpl {

    public FixedDataTableViewImpl() {
        register(DemoSample.of("datatable-fixed", FixedDataTableSample.class, LazyProvider.of(FixedDataTableSample::create)));
    }
}
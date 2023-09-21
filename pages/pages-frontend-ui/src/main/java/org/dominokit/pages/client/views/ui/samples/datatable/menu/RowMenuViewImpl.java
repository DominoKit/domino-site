package org.dominokit.pages.client.views.ui.samples.datatable.menu;

import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.pages.client.presenters.samples.datatable.BasicDataTableProxy;
import org.dominokit.pages.client.presenters.samples.datatable.RowMenuProxy;
import org.dominokit.pages.client.views.ui.DemoSample;
import org.dominokit.pages.client.views.ui.LazyProvider;
import org.dominokit.pages.client.views.ui.SampleViewImpl;
import org.dominokit.pages.client.views.ui.samples.datatable.basic.BasicDataTableSample;

@UiView(presentable = RowMenuProxy.class)
public class RowMenuViewImpl extends SampleViewImpl {

    public RowMenuViewImpl() {
        register(DemoSample.of("datatable-row-menu", RowMenuSample.class, LazyProvider.of(RowMenuSample::create)));
    }
}
package org.dominokit.pages.client.views.ui.samples.datatable.emptystate;

import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.pages.client.presenters.samples.datatable.BasicDataTableProxy;
import org.dominokit.pages.client.presenters.samples.datatable.EmptyTableStateProxy;
import org.dominokit.pages.client.views.ui.DemoSample;
import org.dominokit.pages.client.views.ui.LazyProvider;
import org.dominokit.pages.client.views.ui.SampleViewImpl;
import org.dominokit.pages.client.views.ui.samples.datatable.basic.BasicDataTableSample;

@UiView(presentable = EmptyTableStateProxy.class)
public class EmptyStateTableViewImpl extends SampleViewImpl {

    public EmptyStateTableViewImpl() {
        register(DemoSample.of("datatable-empty-state", EmptyStateTableSample.class, LazyProvider.of(EmptyStateTableSample::create)));
    }
}
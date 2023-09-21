package org.dominokit.pages.client.views.ui.samples.datatable.columnpin;

import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.pages.client.presenters.samples.datatable.ColumnPinProxy;
import org.dominokit.pages.client.presenters.samples.datatable.ColumnResizeProxy;
import org.dominokit.pages.client.views.ui.DemoSample;
import org.dominokit.pages.client.views.ui.LazyProvider;
import org.dominokit.pages.client.views.ui.SampleViewImpl;

@UiView(presentable = ColumnPinProxy.class)
public class ColumnPinViewImpl extends SampleViewImpl {

    public ColumnPinViewImpl() {
        register(DemoSample.of("datatable-column-pin", ColumnPinSample.class, LazyProvider.of(ColumnPinSample::create)));
    }
}
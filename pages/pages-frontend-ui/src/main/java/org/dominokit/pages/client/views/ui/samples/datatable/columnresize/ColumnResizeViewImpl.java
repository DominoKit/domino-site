package org.dominokit.pages.client.views.ui.samples.datatable.columnresize;

import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.pages.client.presenters.samples.datatable.ColumnResizeProxy;
import org.dominokit.pages.client.views.ui.DemoSample;
import org.dominokit.pages.client.views.ui.LazyProvider;
import org.dominokit.pages.client.views.ui.SampleViewImpl;

@UiView(presentable = ColumnResizeProxy.class)
public class ColumnResizeViewImpl extends SampleViewImpl {

    public ColumnResizeViewImpl() {
        register(DemoSample.of("datatable-column-resize", ColumnResizeSample.class, LazyProvider.of(ColumnResizeSample::create)));
    }
}
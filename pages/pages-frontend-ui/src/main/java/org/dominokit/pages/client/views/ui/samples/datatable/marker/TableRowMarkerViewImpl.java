package org.dominokit.pages.client.views.ui.samples.datatable.marker;

import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.pages.client.presenters.samples.datatable.TableRowMarkerProxy;
import org.dominokit.pages.client.views.ui.DemoSample;
import org.dominokit.pages.client.views.ui.LazyProvider;
import org.dominokit.pages.client.views.ui.SampleViewImpl;

@UiView(presentable = TableRowMarkerProxy.class)
public class TableRowMarkerViewImpl extends SampleViewImpl {

    public TableRowMarkerViewImpl() {
        register(DemoSample.of("datatable-marker", TableRowMarkerSample.class, LazyProvider.of(TableRowMarkerSample::create)));
    }
}
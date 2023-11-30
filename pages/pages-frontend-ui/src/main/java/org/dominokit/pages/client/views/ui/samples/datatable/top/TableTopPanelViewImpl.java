package org.dominokit.pages.client.views.ui.samples.datatable.top;

import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.pages.client.presenters.samples.datatable.TableTopPanelProxy;
import org.dominokit.pages.client.views.ui.DemoSample;
import org.dominokit.pages.client.views.ui.LazyProvider;
import org.dominokit.pages.client.views.ui.SampleViewImpl;

@UiView(presentable = TableTopPanelProxy.class)
public class TableTopPanelViewImpl extends SampleViewImpl {

    public TableTopPanelViewImpl() {
        register(DemoSample.of("datatable-top-panel", TableTopPanelSample.class, LazyProvider.of(TableTopPanelSample::create)));
    }
}
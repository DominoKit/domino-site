package org.dominokit.pages.client.views.ui.samples.datatable.livegrid;

import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.pages.client.presenters.samples.datatable.LiveGridProxy;
import org.dominokit.pages.client.views.ui.DemoSample;
import org.dominokit.pages.client.views.ui.LazyProvider;
import org.dominokit.pages.client.views.ui.SampleViewImpl;

@UiView(presentable = LiveGridProxy.class)
public class LiveGridViewImpl extends SampleViewImpl {

    public LiveGridViewImpl() {
        register(DemoSample.of("datatable-live-grid", LiveGridSample.class, LazyProvider.of(LiveGridSample::create)));
    }
}
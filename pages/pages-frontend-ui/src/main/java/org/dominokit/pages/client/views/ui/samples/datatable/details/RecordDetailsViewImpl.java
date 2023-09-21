package org.dominokit.pages.client.views.ui.samples.datatable.details;

import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.pages.client.presenters.samples.datatable.RecordDetailsProxy;
import org.dominokit.pages.client.views.ui.DemoSample;
import org.dominokit.pages.client.views.ui.LazyProvider;
import org.dominokit.pages.client.views.ui.SampleViewImpl;
import org.dominokit.pages.client.views.ui.samples.datatable.RecordDetailsSample;

@UiView(presentable = RecordDetailsProxy.class)
public class RecordDetailsViewImpl extends SampleViewImpl {

    public RecordDetailsViewImpl() {
        register(DemoSample.of("datatable-record-details", RecordDetailsSample.class, LazyProvider.of(RecordDetailsSample::create)));
    }
}
package org.dominokit.pages.client.views.ui.samples.datatable.selection;

import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.pages.client.presenters.samples.datatable.BasicDataTableProxy;
import org.dominokit.pages.client.presenters.samples.datatable.RowSelectionProxy;
import org.dominokit.pages.client.views.ui.DemoSample;
import org.dominokit.pages.client.views.ui.LazyProvider;
import org.dominokit.pages.client.views.ui.SampleViewImpl;
import org.dominokit.pages.client.views.ui.samples.datatable.basic.BasicDataTableSample;

@UiView(presentable = RowSelectionProxy.class)
public class RowSelectionViewImpl extends SampleViewImpl {

    public RowSelectionViewImpl() {
        register(DemoSample.of("datatable-selection-single", SingleRowSelectionSample.class, LazyProvider.of(SingleRowSelectionSample::create)));
        register(DemoSample.of("datatable-selection-multi", MultiRowSelectionSample.class, LazyProvider.of(MultiRowSelectionSample::create)));
    }
}
package org.dominokit.pages.client.views.ui.samples.datatable.dragdrop;

import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.pages.client.presenters.samples.datatable.BasicDataTableProxy;
import org.dominokit.pages.client.presenters.samples.datatable.DragDropTableProxy;
import org.dominokit.pages.client.views.ui.DemoSample;
import org.dominokit.pages.client.views.ui.LazyProvider;
import org.dominokit.pages.client.views.ui.SampleViewImpl;
import org.dominokit.pages.client.views.ui.samples.datatable.basic.BasicDataTableSample;

@UiView(presentable = DragDropTableProxy.class)
public class DragDropTableViewImpl extends SampleViewImpl {

    public DragDropTableViewImpl() {
        register(DemoSample.of("datatable-drag-drop-same", DragDropSameTableSample.class, LazyProvider.of(DragDropSameTableSample::create)));
        register(DemoSample.of("datatable-drag-drop-different", DragDropDifferentTableSample.class, LazyProvider.of(DragDropDifferentTableSample::create)));
    }
}
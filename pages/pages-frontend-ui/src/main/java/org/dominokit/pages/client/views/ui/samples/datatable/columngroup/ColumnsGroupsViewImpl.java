package org.dominokit.pages.client.views.ui.samples.datatable.columngroup;

import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.pages.client.presenters.samples.datatable.ColumnPinProxy;
import org.dominokit.pages.client.presenters.samples.datatable.ColumnsGroupProxy;
import org.dominokit.pages.client.views.ui.DemoSample;
import org.dominokit.pages.client.views.ui.LazyProvider;
import org.dominokit.pages.client.views.ui.SampleViewImpl;
import org.dominokit.pages.client.views.ui.samples.datatable.columnpin.ColumnPinSample;

@UiView(presentable = ColumnsGroupProxy.class)
public class ColumnsGroupsViewImpl extends SampleViewImpl {

    public ColumnsGroupsViewImpl() {
        register(DemoSample.of("datatable-column-group", ColumnGroupsSample.class, LazyProvider.of(ColumnGroupsSample::create)));
        register(DemoSample.of("datatable-column-group-advanced", ColumnGroupsAdvancedSample.class, LazyProvider.of(ColumnGroupsAdvancedSample::create)));
    }
}
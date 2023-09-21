package org.dominokit.pages.client.views.ui.samples.datatable.grouping;

import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.pages.client.presenters.samples.datatable.BasicDataTableProxy;
import org.dominokit.pages.client.presenters.samples.datatable.GroupingDataTableProxy;
import org.dominokit.pages.client.views.ui.DemoSample;
import org.dominokit.pages.client.views.ui.LazyProvider;
import org.dominokit.pages.client.views.ui.SampleViewImpl;
import org.dominokit.pages.client.views.ui.samples.datatable.basic.BasicDataTableSample;

@UiView(presentable = GroupingDataTableProxy.class)
public class GroupingDataTableViewImpl extends SampleViewImpl {

    public GroupingDataTableViewImpl() {
        register(DemoSample.of("datatable-grouping", GroupingDataTableSample.class, LazyProvider.of(GroupingDataTableSample::create)));
    }
}
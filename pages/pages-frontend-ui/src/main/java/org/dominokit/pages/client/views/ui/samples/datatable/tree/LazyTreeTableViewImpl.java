package org.dominokit.pages.client.views.ui.samples.datatable.tree;

import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.pages.client.presenters.samples.datatable.EagerTreeTableProxy;
import org.dominokit.pages.client.presenters.samples.datatable.LazyTreeTableProxy;
import org.dominokit.pages.client.views.ui.DemoSample;
import org.dominokit.pages.client.views.ui.LazyProvider;
import org.dominokit.pages.client.views.ui.SampleViewImpl;

@UiView(presentable = LazyTreeTableProxy.class)
public class LazyTreeTableViewImpl extends SampleViewImpl {

    public LazyTreeTableViewImpl() {
        register(DemoSample.of("datatable-tree-lazy-full", LazyTreeTableFullSpanSample.class, LazyProvider.of(LazyTreeTableFullSpanSample::create)));
        register(DemoSample.of("datatable-tree-lazy-columns", LazyTreeTableColumnsSample.class, LazyProvider.of(LazyTreeTableColumnsSample::create)));
        register(DemoSample.of("datatable-tree-lazy-large", LazyTreeTableLargeDataSetSample.class, LazyProvider.of(LazyTreeTableLargeDataSetSample::create)));
    }
}
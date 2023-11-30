package org.dominokit.pages.client.views.ui.samples.datatable.tree;

import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.pages.client.presenters.samples.datatable.EagerTreeTableProxy;
import org.dominokit.pages.client.views.ui.DemoSample;
import org.dominokit.pages.client.views.ui.LazyProvider;
import org.dominokit.pages.client.views.ui.SampleViewImpl;

@UiView(presentable = EagerTreeTableProxy.class)
public class EagerTreeTableViewImpl extends SampleViewImpl {

    public EagerTreeTableViewImpl() {
        register(DemoSample.of("datatable-tree-eager-full", EagerTreeTableFullSpanSample.class, LazyProvider.of(EagerTreeTableFullSpanSample::create)));
        register(DemoSample.of("datatable-tree-eager-columns", EagerTreeTableColumnsSample.class, LazyProvider.of(EagerTreeTableColumnsSample::create)));
    }
}
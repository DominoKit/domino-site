package org.dominokit.pages.client.views.ui.samples.components.tree;

import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.pages.client.presenters.samples.components.CheckTreeProxy;
import org.dominokit.pages.client.presenters.samples.components.TreeProxy;
import org.dominokit.pages.client.views.ui.DemoSample;
import org.dominokit.pages.client.views.ui.LazyProvider;
import org.dominokit.pages.client.views.ui.SampleViewImpl;

@UiView(presentable = CheckTreeProxy.class)
public class CheckTreeViewImpl extends SampleViewImpl {

    public CheckTreeViewImpl() {
        register(DemoSample.of("check-tree-simple", SimpleCheckTreeSample.class, LazyProvider.of(SimpleCheckTreeSample::create)));
        register(DemoSample.of("check-tree-nested", NestedCheckTreeSample.class, LazyProvider.of(NestedCheckTreeSample::create)));
        register(DemoSample.of("check-tree-featured", FeaturedCheckTreeSample.class, LazyProvider.of(FeaturedCheckTreeSample::create)));
    }
}
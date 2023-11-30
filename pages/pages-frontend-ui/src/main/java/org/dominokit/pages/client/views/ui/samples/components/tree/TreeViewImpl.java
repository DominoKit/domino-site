package org.dominokit.pages.client.views.ui.samples.components.tree;

import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.pages.client.presenters.samples.components.TreeProxy;
import org.dominokit.pages.client.views.ui.DemoSample;
import org.dominokit.pages.client.views.ui.LazyProvider;
import org.dominokit.pages.client.views.ui.SampleViewImpl;

@UiView(presentable = TreeProxy.class)
public class TreeViewImpl extends SampleViewImpl {

    public TreeViewImpl() {
        register(DemoSample.of("tree-basic", BasicTreeSample.class, LazyProvider.of(BasicTreeSample::create)));
        register(DemoSample.of("tree-nested", NestedTreeSample.class, LazyProvider.of(NestedTreeSample::create)));
        register(DemoSample.of("tree-featured", FeaturedTreeSample.class, LazyProvider.of(FeaturedTreeSample::create)));
    }
}
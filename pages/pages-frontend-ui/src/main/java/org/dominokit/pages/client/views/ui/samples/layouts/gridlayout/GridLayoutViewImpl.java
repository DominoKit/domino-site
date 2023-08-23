package org.dominokit.pages.client.views.ui.samples.layouts.gridlayout;

import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.pages.client.presenters.samples.layouts.GridLayoutProxy;
import org.dominokit.pages.client.views.ui.DemoSample;
import org.dominokit.pages.client.views.ui.LazyProvider;
import org.dominokit.pages.client.views.ui.SampleViewImpl;

@UiView(presentable = GridLayoutProxy.class)
public class GridLayoutViewImpl extends SampleViewImpl {

    public GridLayoutViewImpl() {
        register(DemoSample.of("grid-layout", GridLayoutSample.class, LazyProvider.of(GridLayoutSample::create)));
    }
}
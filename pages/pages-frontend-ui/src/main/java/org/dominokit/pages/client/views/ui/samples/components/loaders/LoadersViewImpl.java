package org.dominokit.pages.client.views.ui.samples.components.loaders;

import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.pages.client.presenters.samples.components.LoadersProxy;
import org.dominokit.pages.client.views.ui.DemoSample;
import org.dominokit.pages.client.views.ui.LazyProvider;
import org.dominokit.pages.client.views.ui.SampleViewImpl;

@UiView(presentable = LoadersProxy.class)
public class LoadersViewImpl extends SampleViewImpl {

    public LoadersViewImpl() {
        register(DemoSample.of("loaders-basic", LoadersBasicSample.class, LazyProvider.of(LoadersBasicSample::create)));
    }
}
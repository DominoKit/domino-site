package org.dominokit.pages.client.views.ui.samples.components.preloaders;

import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.pages.client.presenters.samples.components.PreLoadersProxy;
import org.dominokit.pages.client.views.ui.DemoSample;
import org.dominokit.pages.client.views.ui.LazyProvider;
import org.dominokit.pages.client.views.ui.SampleViewImpl;

@UiView(presentable = PreLoadersProxy.class)
public class PreLoadersViewImpl extends SampleViewImpl {

    public PreLoadersViewImpl() {
        register(DemoSample.of("pre-loader-basic", BasicPreLoadersSample.class, LazyProvider.of(BasicPreLoadersSample::create)));
        register(DemoSample.of("pre-loader-colored", ColoredPreLoadersSample.class, LazyProvider.of(ColoredPreLoadersSample::create)));
    }
}
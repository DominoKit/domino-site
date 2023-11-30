package org.dominokit.pages.client.views.ui.samples.datatable.mix;

import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.pages.client.presenters.samples.datatable.PluginsMixProxy;
import org.dominokit.pages.client.views.ui.DemoSample;
import org.dominokit.pages.client.views.ui.LazyProvider;
import org.dominokit.pages.client.views.ui.SampleViewImpl;

@UiView(presentable = PluginsMixProxy.class)
public class PluginMixViewImpl extends SampleViewImpl {

    public PluginMixViewImpl() {
        register(DemoSample.of("datatable-mix", PluginsMixSample.class, LazyProvider.of(PluginsMixSample::create)));
    }
}
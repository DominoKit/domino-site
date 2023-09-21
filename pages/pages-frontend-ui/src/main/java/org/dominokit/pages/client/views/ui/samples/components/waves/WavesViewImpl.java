package org.dominokit.pages.client.views.ui.samples.components.waves;

import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.pages.client.presenters.samples.components.WavesProxy;
import org.dominokit.pages.client.views.ui.DemoSample;
import org.dominokit.pages.client.views.ui.LazyProvider;
import org.dominokit.pages.client.views.ui.SampleViewImpl;

@UiView(presentable = WavesProxy.class)
public class WavesViewImpl extends SampleViewImpl {

    public WavesViewImpl() {
        register(DemoSample.of("waves-basic", WavesSample.class, LazyProvider.of(WavesSample::create)));
    }
}
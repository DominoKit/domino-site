package org.dominokit.pages.client.views.ui.samples.components.progress;

import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.pages.client.presenters.samples.components.ProgressBarsProxy;
import org.dominokit.pages.client.views.ui.DemoSample;
import org.dominokit.pages.client.views.ui.LazyProvider;
import org.dominokit.pages.client.views.ui.SampleViewImpl;

@UiView(presentable = ProgressBarsProxy.class)
public class ProgressBarsViewImpl extends SampleViewImpl {

    public ProgressBarsViewImpl() {
        register(DemoSample.of("progress-bars-basic", BasicProgressBarsSample.class, LazyProvider.of(BasicProgressBarsSample::create)));
        register(DemoSample.of("progress-bars-colored", ColoredProgressBarsSample.class, LazyProvider.of(ColoredProgressBarsSample::create)));
        register(DemoSample.of("progress-bars-striped", StripedProgressBarsSample.class, LazyProvider.of(StripedProgressBarsSample::create)));
        register(DemoSample.of("progress-bars-animation", AnimatedProgressBarsSample.class, LazyProvider.of(AnimatedProgressBarsSample::create)));
        register(DemoSample.of("progress-bars-stacked", StackedProgressBarsSample.class, LazyProvider.of(StackedProgressBarsSample::create)));
    }
}
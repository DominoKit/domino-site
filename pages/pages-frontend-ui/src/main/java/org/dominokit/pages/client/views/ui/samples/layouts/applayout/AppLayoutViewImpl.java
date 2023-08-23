package org.dominokit.pages.client.views.ui.samples.layouts.applayout;

import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.pages.client.presenters.samples.layouts.AppLayoutProxy;
import org.dominokit.pages.client.views.ui.DemoSample;
import org.dominokit.pages.client.views.ui.LazyProvider;
import org.dominokit.pages.client.views.ui.SampleViewImpl;

@UiView(presentable = AppLayoutProxy.class)
public class AppLayoutViewImpl extends SampleViewImpl {

    public AppLayoutViewImpl() {
        register(DemoSample.of("app-layout", AppLayoutSample.class, LazyProvider.of(AppLayoutSample::create))
                .onRender(demoComponent -> {
                    demoComponent
                            .withSampleContainer((demoComponent1, content) -> content.setCssProperty("max-height", "700px"))
                            .withDemoSample((parent, sample) -> {
                                LazyProvider<AppLayoutSample> component = sample.getComponent();
                                AppLayoutSample appLayoutSample = component.get();
                                appLayoutSample.setCssProperty("max-height", "700px");
                            })
                    ;
                })
        );
    }
}
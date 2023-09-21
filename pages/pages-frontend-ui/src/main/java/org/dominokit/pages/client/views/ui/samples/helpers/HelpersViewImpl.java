package org.dominokit.pages.client.views.ui.samples.helpers;

import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.pages.client.presenters.samples.helpers.HelpersProxy;
import org.dominokit.pages.client.presenters.samples.typography.TypographyProxy;
import org.dominokit.pages.client.views.ui.DemoSample;
import org.dominokit.pages.client.views.ui.LazyProvider;
import org.dominokit.pages.client.views.ui.SampleViewImpl;
import org.dominokit.pages.client.views.ui.samples.layouts.applayout.AppLayoutSample;
import org.dominokit.pages.client.views.ui.samples.typography.*;

@UiView(presentable = HelpersProxy.class)
public class HelpersViewImpl extends SampleViewImpl {

    public HelpersViewImpl() {
        register(DemoSample.of("helpers-height", HelpersHeightSample.class, LazyProvider.of(HelpersHeightSample::create))
                .onRender(demoComponent -> {
                    demoComponent
                            .withSampleContainer((demoComponent1, content) -> content
                                    .setCssProperty("max-height", "700px")
                                    .setCssProperty("overflow", "auto")
                                    .setCssProperty("padding", "5px")
                            )
                            .withDemoSample((parent, sample) -> {
                                sample.getComponent()
                                        .get()
                                        .setCssProperty("max-height", "700px");
                            })
                    ;
                })
        );
        register(DemoSample.of("helpers-width", HelpersWidthSample.class, LazyProvider.of(HelpersWidthSample::create))
                .onRender(demoComponent -> {
                    demoComponent
                            .withSampleContainer((demoComponent1, content) -> content
                                    .setCssProperty("max-height", "700px")
                                    .setCssProperty("overflow", "auto")
                                    .setCssProperty("padding", "5px")
                            )
                            .withDemoSample((parent, sample) -> {
                                sample.getComponent()
                                        .get()
                                        .setCssProperty("max-height", "700px");
                            })
                    ;
                })
        );
        register(DemoSample.of("helpers-margin", HelpersMarginSample.class, LazyProvider.of(HelpersMarginSample::create))
                .onRender(demoComponent -> {
                    demoComponent
                            .withSampleContainer((demoComponent1, content) -> content
                                    .setCssProperty("max-height", "700px")
                                    .setCssProperty("overflow", "auto")
                                    .setCssProperty("padding", "5px")
                            )
                            .withDemoSample((parent, sample) -> {
                                sample.getComponent()
                                        .get()
                                        .setCssProperty("max-height", "700px");
                            })
                    ;
                })
        );
        register(DemoSample.of("helpers-padding", HelpersPaddingSample.class, LazyProvider.of(HelpersPaddingSample::create))
                .onRender(demoComponent -> {
                    demoComponent
                            .withSampleContainer((demoComponent1, content) -> content
                                    .setCssProperty("max-height", "700px")
                                    .setCssProperty("overflow", "auto")
                                    .setCssProperty("padding", "5px")
                            )
                            .withDemoSample((parent, sample) -> {
                                sample.getComponent()
                                        .get()
                                        .setCssProperty("max-height", "700px");
                            })
                    ;
                })
        );
    }
}
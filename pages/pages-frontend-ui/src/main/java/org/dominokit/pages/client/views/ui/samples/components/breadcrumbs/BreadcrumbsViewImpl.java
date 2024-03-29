package org.dominokit.pages.client.views.ui.samples.components.breadcrumbs;

import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.pages.client.presenters.samples.components.BreadcrumbsProxy;
import org.dominokit.pages.client.views.ui.DemoSample;
import org.dominokit.pages.client.views.ui.LazyProvider;
import org.dominokit.pages.client.views.ui.SampleViewImpl;

@UiView(presentable = BreadcrumbsProxy.class)
public class BreadcrumbsViewImpl extends SampleViewImpl {

    public BreadcrumbsViewImpl() {
        register(DemoSample.of("breadcrumbs-basic", BreadcrumbsBasicSample.class, LazyProvider.of(BreadcrumbsBasicSample::create)));
        register(DemoSample.of("breadcrumbs-background", BreadcrumbsBackgroundSample.class, LazyProvider.of(BreadcrumbsBackgroundSample::create)));
        register(DemoSample.of("breadcrumbs-alignment", BreadcrumbsAlignmentSample.class, LazyProvider.of(BreadcrumbsAlignmentSample::create)));
    }
}
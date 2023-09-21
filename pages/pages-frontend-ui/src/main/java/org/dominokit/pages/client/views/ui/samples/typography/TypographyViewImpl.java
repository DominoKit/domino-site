package org.dominokit.pages.client.views.ui.samples.typography;

import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.pages.client.presenters.samples.components.AlertsProxy;
import org.dominokit.pages.client.presenters.samples.typography.TypographyProxy;
import org.dominokit.pages.client.views.ui.DemoSample;
import org.dominokit.pages.client.views.ui.LazyProvider;
import org.dominokit.pages.client.views.ui.SampleViewImpl;
import org.dominokit.pages.client.views.ui.samples.components.alerts.BasicAlertsSample;
import org.dominokit.pages.client.views.ui.samples.components.alerts.ContextAlertsSample;
import org.dominokit.pages.client.views.ui.samples.components.alerts.DismissibleAlertsSample;
import org.dominokit.pages.client.views.ui.samples.components.alerts.LinksAlertsSample;

@UiView(presentable = TypographyProxy.class)
public class TypographyViewImpl extends SampleViewImpl {

    public TypographyViewImpl() {
        register(DemoSample.of("typography-lead", TypographyLeadSample.class, LazyProvider.of(TypographyLeadSample::create)));
        register(DemoSample.of("typography-heading", TypographyHeadingSample.class, LazyProvider.of(TypographyHeadingSample::create)));
        register(DemoSample.of("typography-styles", TypographyStylesSample.class, LazyProvider.of(TypographyStylesSample::create)));
        register(DemoSample.of("typography-blockquotes", TypographyBlockquotesSample.class, LazyProvider.of(TypographyBlockquotesSample::create)));
        register(DemoSample.of("typography-lists", TypographyListsSample.class, LazyProvider.of(TypographyListsSample::create)));
        register(DemoSample.of("typography-font-size", TypographyFontSizeSample.class, LazyProvider.of(TypographyFontSizeSample::create)));
    }
}
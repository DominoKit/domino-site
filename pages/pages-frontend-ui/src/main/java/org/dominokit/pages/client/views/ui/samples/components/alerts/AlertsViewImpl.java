package org.dominokit.pages.client.views.ui.samples.components.alerts;

import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.pages.client.presenters.samples.components.AlertsProxy;
import org.dominokit.pages.client.views.ui.DemoSample;
import org.dominokit.pages.client.views.ui.LazyProvider;
import org.dominokit.pages.client.views.ui.SampleViewImpl;

@UiView(presentable = AlertsProxy.class)
public class AlertsViewImpl extends SampleViewImpl {

    public AlertsViewImpl() {
        register(DemoSample.of("alerts-basic", BasicAlertsSample.class, LazyProvider.of(BasicAlertsSample::create)));
        register(DemoSample.of("alerts-context", ContextAlertsSample.class, LazyProvider.of(ContextAlertsSample::create)));
        register(DemoSample.of("alerts-dismissible", DismissibleAlertsSample.class, LazyProvider.of(DismissibleAlertsSample::create)));
        register(DemoSample.of("alerts-links", LinksAlertsSample.class, LazyProvider.of(LinksAlertsSample::create)));
    }
}
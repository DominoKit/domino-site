package org.dominokit.pages.client.views.ui.samples.components.badges;

import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.pages.client.presenters.samples.components.BadgesProxy;
import org.dominokit.pages.client.views.ui.DemoSample;
import org.dominokit.pages.client.views.ui.LazyProvider;
import org.dominokit.pages.client.views.ui.SampleViewImpl;
import org.dominokit.pages.client.views.ui.samples.components.alerts.ContextAlertsSample;
import org.dominokit.pages.client.views.ui.samples.components.alerts.DismissibleAlertsSample;

@UiView(presentable = BadgesProxy.class)
public class BadgesViewImpl extends SampleViewImpl {

    public BadgesViewImpl() {
        register(DemoSample.of("badges-buttons", BadgesButtonsSample.class, LazyProvider.of(BadgesButtonsSample::create)));
        register(DemoSample.of("badges-icons", BadgesIconsSample.class, LazyProvider.of(BadgesIconsSample::create)));
        register(DemoSample.of("badges-lists", BadgesListsSample.class, LazyProvider.of(BadgesListsSample::create)));
    }
}
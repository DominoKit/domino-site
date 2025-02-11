package org.dominokit.pages.client.views.ui.samples.components.navbar;

import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.pages.client.presenters.samples.components.AlertsProxy;
import org.dominokit.pages.client.presenters.samples.components.NavBarProxy;
import org.dominokit.pages.client.views.ui.DemoSample;
import org.dominokit.pages.client.views.ui.LazyProvider;
import org.dominokit.pages.client.views.ui.SampleViewImpl;
import org.dominokit.pages.client.views.ui.samples.components.alerts.BasicAlertsSample;
import org.dominokit.pages.client.views.ui.samples.components.alerts.ContextAlertsSample;
import org.dominokit.pages.client.views.ui.samples.components.alerts.DismissibleAlertsSample;
import org.dominokit.pages.client.views.ui.samples.components.alerts.LinksAlertsSample;

@UiView(presentable = NavBarProxy.class)
public class NavbarViewImpl extends SampleViewImpl {

    public NavbarViewImpl() {
        register(DemoSample.of("navbar-simple", SimpleNavBarSample.class, LazyProvider.of(SimpleNavBarSample::create)));
        register(DemoSample.of("navbar-addons", NavBarAddonsSample.class, LazyProvider.of(NavBarAddonsSample::create)));
        register(DemoSample.of("navbar-body", NavBarBodySample.class, LazyProvider.of(NavBarBodySample::create)));
    }
}
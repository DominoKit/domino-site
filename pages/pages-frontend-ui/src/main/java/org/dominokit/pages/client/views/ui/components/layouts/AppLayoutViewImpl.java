package org.dominokit.pages.client.views.ui.components.layouts;

import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.pages.client.presenters.components.AppLayoutProxy;
import org.dominokit.pages.client.views.ui.DemoSample;
import org.dominokit.pages.client.views.ui.SampleViewImpl;

@UiView(presentable = AppLayoutProxy.class)
public class AppLayoutViewImpl extends SampleViewImpl {

    public AppLayoutViewImpl() {
        register(DemoSample.of("app-layout", AppLayoutSample.class, AppLayoutSample::create));
    }
}
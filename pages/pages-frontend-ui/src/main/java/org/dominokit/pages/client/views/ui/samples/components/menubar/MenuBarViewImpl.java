package org.dominokit.pages.client.views.ui.samples.components.menubar;

import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.pages.client.presenters.samples.components.CountersProxy;
import org.dominokit.pages.client.presenters.samples.components.MenuBarProxy;
import org.dominokit.pages.client.views.ui.DemoSample;
import org.dominokit.pages.client.views.ui.LazyProvider;
import org.dominokit.pages.client.views.ui.SampleViewImpl;
import org.dominokit.pages.client.views.ui.samples.components.counters.AutoCountersSample;
import org.dominokit.pages.client.views.ui.samples.components.counters.DateCountDownSample;
import org.dominokit.pages.client.views.ui.samples.components.counters.SimpleCountersSample;

@UiView(presentable = MenuBarProxy.class)
public class MenuBarViewImpl extends SampleViewImpl {

    public MenuBarViewImpl() {
        register(DemoSample.of("menubar-basic", BasicMenuBarSample.class, LazyProvider.of(BasicMenuBarSample::create)));
        register(DemoSample.of("menubar-background", MenuBarBackgroundSample.class, LazyProvider.of(MenuBarBackgroundSample::create)));
        register(DemoSample.of("menubar-addons", MenuBarAddonsSample.class, LazyProvider.of(MenuBarAddonsSample::create)));
    }
}
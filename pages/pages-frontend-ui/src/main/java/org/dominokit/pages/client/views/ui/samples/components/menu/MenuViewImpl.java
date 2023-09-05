package org.dominokit.pages.client.views.ui.samples.components.menu;

import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.pages.client.presenters.samples.components.CardsProxy;
import org.dominokit.pages.client.presenters.samples.components.MenuProxy;
import org.dominokit.pages.client.views.ui.DemoSample;
import org.dominokit.pages.client.views.ui.LazyProvider;
import org.dominokit.pages.client.views.ui.SampleViewImpl;
import org.dominokit.pages.client.views.ui.samples.components.cards.*;

@UiView(presentable = MenuProxy.class)
public class MenuViewImpl extends SampleViewImpl {

    public MenuViewImpl() {
        register(DemoSample.of("menu-basic", BasicMenuSample.class, LazyProvider.of(BasicMenuSample::create)));
        register(DemoSample.of("menu-header", MenuHeadersSample.class, LazyProvider.of(MenuHeadersSample::create)));
        register(DemoSample.of("menu-search", MenuSearchSample.class, LazyProvider.of(MenuSearchSample::create)));
        register(DemoSample.of("menu-custom", CustomItemSample.class, LazyProvider.of(CustomItemSample::create)));
        register(DemoSample.of("menu-features", MenuFeaturesSample.class, LazyProvider.of(MenuFeaturesSample::create)));
        register(DemoSample.of("menu-embed", MenuEmbedSample.class, LazyProvider.of(MenuEmbedSample::create)));
        register(DemoSample.of("menu-dropdown", DropdownMenuSample.class, LazyProvider.of(DropdownMenuSample::create)));
        register(DemoSample.of("menu-context", ContextMenuSample.class, LazyProvider.of(ContextMenuSample::create)));
        register(DemoSample.of("menu-nested", NestedMenuSample.class, LazyProvider.of(NestedMenuSample::create)));
    }
}
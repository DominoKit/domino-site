package org.dominokit.pages.client.views.ui.samples.components.modals;

import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.pages.client.presenters.samples.components.CardsProxy;
import org.dominokit.pages.client.presenters.samples.components.ModalsProxy;
import org.dominokit.pages.client.views.ui.DemoSample;
import org.dominokit.pages.client.views.ui.LazyProvider;
import org.dominokit.pages.client.views.ui.SampleViewImpl;
import org.dominokit.pages.client.views.ui.samples.components.cards.*;

@UiView(presentable = ModalsProxy.class)
public class ModalsViewImpl extends SampleViewImpl {

    public ModalsViewImpl() {
        register(DemoSample.of("modals-basic", BasicModalsSample.class, LazyProvider.of(BasicModalsSample::create)));
        register(DemoSample.of("modals-sheet", SheetModalsSample.class, LazyProvider.of(SheetModalsSample::create)));
        register(DemoSample.of("modals-colored", ColoredModalsSample.class, LazyProvider.of(ColoredModalsSample::create)));
        register(DemoSample.of("modals-window", WindowModalsSample.class, LazyProvider.of(WindowModalsSample::create)));
    }
}
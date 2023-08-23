package org.dominokit.pages.client.views.ui.samples.components.buttons;

import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.pages.client.presenters.samples.components.ButtonsProxy;
import org.dominokit.pages.client.views.ui.DemoSample;
import org.dominokit.pages.client.views.ui.LazyProvider;
import org.dominokit.pages.client.views.ui.SampleViewImpl;

@UiView(presentable = ButtonsProxy.class)
public class ButtonsViewImpl extends SampleViewImpl {

    public ButtonsViewImpl() {
        register(DemoSample.of("buttons-basic", ButtonsBasicSample.class, LazyProvider.of(ButtonsBasicSample::create)));
        register(DemoSample.of("buttons-sizes", ButtonsSizeSample.class, LazyProvider.of(ButtonsSizeSample::create)));
        register(DemoSample.of("buttons-groups", ButtonsGroupsSample.class, LazyProvider.of(ButtonsGroupsSample::create)));
        register(DemoSample.of("buttons-split-drop", ButtonsDropDownSample.class, LazyProvider.of(ButtonsDropDownSample::create)));
    }
}
package org.dominokit.pages.client.views.ui.samples.components.chips;

import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.pages.client.presenters.samples.components.ChipsProxy;
import org.dominokit.pages.client.views.ui.DemoSample;
import org.dominokit.pages.client.views.ui.LazyProvider;
import org.dominokit.pages.client.views.ui.SampleViewImpl;

@UiView(presentable = ChipsProxy.class)
public class ChipsViewImpl extends SampleViewImpl {

    public ChipsViewImpl() {
        register(DemoSample.of("chip-basic", BasicChipsSample.class, LazyProvider.of(BasicChipsSample::create)));
        register(DemoSample.of("chip-removable", RemovableChipsSample.class, LazyProvider.of(RemovableChipsSample::create)));
        register(DemoSample.of("chip-images", ChipsWithIconsAndImagesSample.class, LazyProvider.of(ChipsWithIconsAndImagesSample::create)));
        register(DemoSample.of("chip-letters", ChipsWithLettersSample.class, LazyProvider.of(ChipsWithLettersSample::create)));
        register(DemoSample.of("chip-selectable", SelectableChipsSample.class, LazyProvider.of(SelectableChipsSample::create)));
    }
}
package org.dominokit.pages.client.views.ui.samples.components.colorpicker;

import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.pages.client.presenters.samples.components.BoardsProxy;
import org.dominokit.pages.client.presenters.samples.components.ColorPickerProxy;
import org.dominokit.pages.client.views.ui.DemoSample;
import org.dominokit.pages.client.views.ui.LazyProvider;
import org.dominokit.pages.client.views.ui.SampleViewImpl;
import org.dominokit.pages.client.views.ui.samples.components.boards.ColumnBoardsSample;
import org.dominokit.pages.client.views.ui.samples.components.boards.ListsBoardsSample;

@UiView(presentable = ColorPickerProxy.class)
public class ColorPickerViewImpl extends SampleViewImpl {

    public ColorPickerViewImpl() {
        register(DemoSample.of("colorpicker-basic", BasicColorPickerSample.class, LazyProvider.of(BasicColorPickerSample::create)));
        register(DemoSample.of("colorpicker-button", ColorPickerButtonSample.class, LazyProvider.of(ColorPickerButtonSample::create)));
        register(DemoSample.of("colorpicker-popover", ColorPickerPopoverSample.class, LazyProvider.of(ColorPickerPopoverSample::create)));
    }
}
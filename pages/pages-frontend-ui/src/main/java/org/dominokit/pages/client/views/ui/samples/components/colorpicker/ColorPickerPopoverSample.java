package org.dominokit.pages.client.views.ui.samples.components.colorpicker;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.popover.Popover;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.pro.domino.ui.colorpicker.ColorPicker;

import static org.dominokit.domino.ui.style.ColorsCss.dui_border_black;
import static org.dominokit.domino.ui.style.DisplayCss.dui_border_solid;
import static org.dominokit.domino.ui.style.SpacingCss.*;
import static org.dominokit.domino.ui.utils.Domino.div;
import static org.dominokit.domino.ui.utils.Domino.dui_p_2;

public class ColorPickerPopoverSample extends BaseDominoElement<HTMLDivElement, ColorPickerPopoverSample> {

    private DivElement element;

    public static ColorPickerPopoverSample create() {
        return new ColorPickerPopoverSample();
    }

    public ColorPickerPopoverSample() {
        this.element = div().addCss(dui_p_2)
                .appendChild(div().addCss(dui_w_4, dui_h_4, dui_border, dui_border_solid, dui_border_black)
                        .apply(self -> {
                            Popover.create(self)
                                    .addCss(dui_rounded_md)
                                    .appendChild(div().addCss(dui_p_2)
                                            .appendChild(ColorPicker.create().addCss(dui_w_64))
                                    );
                        })
                );
        init(this);
    }

    @Override
    public HTMLDivElement element() {
        return this.element.element();
    }
}

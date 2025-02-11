package org.dominokit.pages.client.views.ui.samples.components.colorpicker;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.pro.domino.ui.colorpicker.ColorPicker;

import static org.dominokit.domino.ui.utils.Domino.div;
import static org.dominokit.domino.ui.utils.Domino.dui_p_2;

public class BasicColorPickerSample extends BaseDominoElement<HTMLDivElement, BasicColorPickerSample> {

    private DivElement element;

    public static BasicColorPickerSample create() {
        return new BasicColorPickerSample();
    }

    public BasicColorPickerSample() {
        this.element = div().addCss(dui_p_2)
                .appendChild(ColorPicker.create());
        init(this);
    }

    @Override
    public HTMLDivElement element() {
        return this.element.element();
    }
}

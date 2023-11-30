package org.dominokit.pages.client.views.ui.samples.components.buttons;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.utils.BaseDominoElement;

import static org.dominokit.domino.ui.utils.Domino.*;

public class ButtonsSizeSample extends BaseDominoElement<HTMLDivElement, ButtonsSizeSample> {

    private DivElement element;

    public static ButtonsSizeSample create() {
        return new ButtonsSizeSample();
    }

    public ButtonsSizeSample() {
        this.element = div().addCss(dui_p_2, dui_flex, dui_flex_wrap, dui_gap_4, dui_justify_around)
                .appendChild(div().addCss(dui_flex, dui_flex_col, dui_gap_2)
                        .appendChild(Button.create("LARGE")
                                .addCss(dui_large, dui_w_32)
                        )
                        .appendChild(Button.create("DEFAULT")
                                .addCss(dui_w_32)
                        )
                        .appendChild(Button.create("SMALL")
                                .addCss(dui_small, dui_w_32)
                        )
                        .appendChild(Button.create("XSMALL")
                                .addCss(dui_xsmall, dui_w_32)
                        )
                )
                .appendChild(div().addCss(dui_flex, dui_flex_col, dui_gap_2, dui_justify_center, dui_items_center)
                        .appendChild(Button.create(Icons.widgets())
                                .addCss(dui_large)
                                .circle()
                        )
                        .appendChild(Button.create(Icons.home())
                                .circle()
                        )
                        .appendChild(Button.create(Icons.cog())
                                .addCss(dui_small)
                                .circle()
                        )
                        .appendChild(Button.create(Icons.airplane_off())
                                .addCss(dui_xsmall)
                                .circle()
                        )
                )
        ;
        init(this);
    }

    @Override
    public HTMLDivElement element() {
        return this.element.element();
    }
}

package org.dominokit.pages.client.views.ui.samples.helpers;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.style.CssClass;
import org.dominokit.domino.ui.utils.BaseDominoElement;

import java.util.Arrays;
import java.util.List;

public class HelpersWidthSample extends BaseDominoElement<HTMLDivElement, HelpersWidthSample> {

    private DivElement element;

    public static HelpersWidthSample create() {
        return new HelpersWidthSample();
    }

    public HelpersWidthSample() {
        List<CssClass> heightClasses = Arrays.asList(dui_w_0,
                dui_w_px,
                dui_w_2px,
                dui_w_4px,
                dui_w_8px,
                dui_w_0_5,
                dui_w_1,
                dui_w_1_5,
                dui_w_2,
                dui_w_2_5,
                dui_w_3,
                dui_w_3_5,
                dui_w_4,
                dui_w_5,
                dui_w_6,
                dui_w_7,
                dui_w_8,
                dui_w_9,
                dui_w_10,
                dui_w_11,
                dui_w_12,
                dui_w_14,
                dui_w_16,
                dui_w_20,
                dui_w_24,
                dui_w_28,
                dui_w_32,
                dui_w_36,
                dui_w_40,
                dui_w_44,
                dui_w_48,
                dui_w_52,
                dui_w_56,
                dui_w_60,
                dui_w_64,
                dui_w_72,
                dui_w_80,
                dui_w_96,
                dui_w_1_2p,
                dui_w_1_3p,
                dui_w_1_4p,
                dui_w_2_3p,
                dui_w_3_4p,
                dui_w_full);

        this.element = div().addCss(dui_p_2)
                .appendChild(div().addCss(dui_flex, dui_gap_4, dui_flex_col)
                        .apply(self -> {
                            heightClasses.forEach(cssClass -> {
                                self
                                        .appendChild(span().textContent(cssClass.getCssClass()))
                                        .appendChild(div().addCss(dui_bg_accent, dui_h_4, cssClass));
                            });
                        })
                );
        init(this);
    }

    @Override
    public HTMLDivElement element() {
        return this.element.element();
    }
}

package org.dominokit.pages.client.views.ui.samples.helpers;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.style.CssClass;
import org.dominokit.domino.ui.utils.BaseDominoElement;

import java.util.Arrays;
import java.util.List;

import static org.dominokit.domino.ui.utils.Domino.*;

public class HelpersHeightSample extends BaseDominoElement<HTMLDivElement, HelpersHeightSample> {

    private DivElement element;

    public static HelpersHeightSample create() {
        return new HelpersHeightSample();
    }

    public HelpersHeightSample() {
        List<CssClass> heightClasses = Arrays.asList(dui_h_0,
                dui_h_px,
                dui_h_2px,
                dui_h_4px,
                dui_h_8px,
                dui_h_0_5,
                dui_h_1,
                dui_h_1_5,
                dui_h_2,
                dui_h_2_5,
                dui_h_3,
                dui_h_3_5,
                dui_h_4,
                dui_h_5,
                dui_h_6,
                dui_h_7,
                dui_h_8,
                dui_h_9,
                dui_h_10,
                dui_h_11,
                dui_h_12,
                dui_h_14,
                dui_h_16,
                dui_h_20,
                dui_h_24,
                dui_h_28,
                dui_h_32,
                dui_h_36,
                dui_h_40,
                dui_h_44,
                dui_h_48,
                dui_h_52,
                dui_h_56,
                dui_h_60,
                dui_h_64,
                dui_h_72,
                dui_h_80,
                dui_h_96,
                dui_h_1_2p,
                dui_h_1_3p,
                dui_h_1_4p,
                dui_h_2_3p,
                dui_h_3_4p,
                dui_h_full);


        this.element = div().addCss(dui_p_2)
                .appendChild(div().addCss(dui_flex, dui_gap_4, dui_flex_wrap)
                        .apply(self -> {
                            heightClasses.forEach(cssClass -> {
                                self.appendChild(div().addCss(dui_flex, dui_flex_col, dui_justify_center, dui_gap_1)
                                        .appendChild(span().textContent(cssClass.getCssClass()))
                                        .appendChild(div().addCss(dui_flex, dui_justify_center)
                                                .setHeight("500px")
                                                .appendChild(div().addCss(dui_bg_accent, dui_w_4, cssClass)))

                                );
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

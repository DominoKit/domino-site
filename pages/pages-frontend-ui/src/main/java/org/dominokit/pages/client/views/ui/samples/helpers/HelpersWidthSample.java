package org.dominokit.pages.client.views.ui.samples.helpers;

import static org.dominokit.domino.ui.utils.Domino.div;
import static org.dominokit.domino.ui.utils.Domino.dui_bg_accent;
import static org.dominokit.domino.ui.utils.Domino.dui_flex;
import static org.dominokit.domino.ui.utils.Domino.dui_flex_col;
import static org.dominokit.domino.ui.utils.Domino.dui_gap_4;
import static org.dominokit.domino.ui.utils.Domino.dui_h_4;
import static org.dominokit.domino.ui.utils.Domino.dui_p_2;
import static org.dominokit.domino.ui.utils.Domino.dui_w_0;
import static org.dominokit.domino.ui.utils.Domino.dui_w_0_5;
import static org.dominokit.domino.ui.utils.Domino.dui_w_1;
import static org.dominokit.domino.ui.utils.Domino.dui_w_10;
import static org.dominokit.domino.ui.utils.Domino.dui_w_11;
import static org.dominokit.domino.ui.utils.Domino.dui_w_12;
import static org.dominokit.domino.ui.utils.Domino.dui_w_14;
import static org.dominokit.domino.ui.utils.Domino.dui_w_16;
import static org.dominokit.domino.ui.utils.Domino.dui_w_1_2p;
import static org.dominokit.domino.ui.utils.Domino.dui_w_1_3p;
import static org.dominokit.domino.ui.utils.Domino.dui_w_1_4p;
import static org.dominokit.domino.ui.utils.Domino.dui_w_1_5;
import static org.dominokit.domino.ui.utils.Domino.dui_w_2;
import static org.dominokit.domino.ui.utils.Domino.dui_w_20;
import static org.dominokit.domino.ui.utils.Domino.dui_w_24;
import static org.dominokit.domino.ui.utils.Domino.dui_w_28;
import static org.dominokit.domino.ui.utils.Domino.dui_w_2_3p;
import static org.dominokit.domino.ui.utils.Domino.dui_w_2_5;
import static org.dominokit.domino.ui.utils.Domino.dui_w_2px;
import static org.dominokit.domino.ui.utils.Domino.dui_w_3;
import static org.dominokit.domino.ui.utils.Domino.dui_w_32;
import static org.dominokit.domino.ui.utils.Domino.dui_w_36;
import static org.dominokit.domino.ui.utils.Domino.dui_w_3_4p;
import static org.dominokit.domino.ui.utils.Domino.dui_w_3_5;
import static org.dominokit.domino.ui.utils.Domino.dui_w_4;
import static org.dominokit.domino.ui.utils.Domino.dui_w_40;
import static org.dominokit.domino.ui.utils.Domino.dui_w_44;
import static org.dominokit.domino.ui.utils.Domino.dui_w_48;
import static org.dominokit.domino.ui.utils.Domino.dui_w_4px;
import static org.dominokit.domino.ui.utils.Domino.dui_w_5;
import static org.dominokit.domino.ui.utils.Domino.dui_w_52;
import static org.dominokit.domino.ui.utils.Domino.dui_w_56;
import static org.dominokit.domino.ui.utils.Domino.dui_w_6;
import static org.dominokit.domino.ui.utils.Domino.dui_w_60;
import static org.dominokit.domino.ui.utils.Domino.dui_w_64;
import static org.dominokit.domino.ui.utils.Domino.dui_w_7;
import static org.dominokit.domino.ui.utils.Domino.dui_w_72;
import static org.dominokit.domino.ui.utils.Domino.dui_w_8;
import static org.dominokit.domino.ui.utils.Domino.dui_w_80;
import static org.dominokit.domino.ui.utils.Domino.dui_w_8px;
import static org.dominokit.domino.ui.utils.Domino.dui_w_9;
import static org.dominokit.domino.ui.utils.Domino.dui_w_96;
import static org.dominokit.domino.ui.utils.Domino.dui_w_full;
import static org.dominokit.domino.ui.utils.Domino.dui_w_px;
import static org.dominokit.domino.ui.utils.Domino.span;

import elemental2.dom.HTMLDivElement;
import java.util.Arrays;
import java.util.List;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.style.CssClass;
import org.dominokit.domino.ui.utils.BaseDominoElement;

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

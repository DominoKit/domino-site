package org.dominokit.pages.client.views.ui.samples.components.labels;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.labels.Label;
import org.dominokit.domino.ui.utils.BaseDominoElement;

public class LabelsBasicSample extends BaseDominoElement<HTMLDivElement, LabelsBasicSample> {

    private DivElement element;

    public static LabelsBasicSample create() {
        return new LabelsBasicSample();
    }

    public LabelsBasicSample() {
        this.element = div().addCss(dui_p_2)
                .appendChild(Row.create()
                        .span1(Label.create("DEFAULT").addCss(dui_m_4))
                        .span1(Label.create("PRIMARY").addCss(dui_m_4, dui_primary))
                        .span1(Label.create("SUCCESS").addCss(dui_m_4, dui_success))
                        .span1(Label.create("INFO").addCss(dui_m_4, dui_info))
                        .span1(Label.create("WARNING").addCss(dui_m_4, dui_warning))
                        .span1(Label.create("DANGER").addCss(dui_m_4, dui_error))
                        .span1(Label.create("ROUNDED").addCss(dui_m_4, dui_bg_accent, dui_fg_white, dui_rounded_full))
                )
                .appendChild(h(1).addCss(dui_text_left)
                        .textContent("Example heading ")
                        .appendChild(Label.create("New")
                                .addCss(dui_error)
                        )
                )
                .appendChild(h(2)
                        .textContent("Example heading ")
                        .appendChild(Label.create("New")
                                .addCss(dui_warning)
                        )
                )
                .appendChild(h(3)
                        .textContent("Example heading ")
                        .appendChild(Label.create("New")
                                .addCss(dui_info)
                        )
                )
                .appendChild(h(4)
                        .textContent("Example heading ")
                        .appendChild(Label.create("New")
                                .addCss(dui_success)
                        )
                )
                .appendChild(h(5)
                        .textContent("Example heading ")
                        .appendChild(Label.create("New")
                                .addCss(dui_primary)
                        )
                )
                .appendChild(h(6)
                        .textContent("Example heading ")
                        .appendChild(Label.create("New"))
                )
                .appendChild(div().addCss(dui_flex, dui_flex_wrap, dui_gap_4, dui_justify_center, dui_items_center)
                        .appendChild(Label.create("Red").addCss(dui_m_4, dui_red))
                        .appendChild(Label.create("Pink").addCss(dui_m_4, dui_pink))
                        .appendChild(Label.create("Purple").addCss(dui_m_4, dui_purple))
                        .appendChild(Label.create("Deep Purple").addCss(dui_m_4, dui_deep_purple))
                        .appendChild(Label.create("Indigo").addCss(dui_m_4, dui_indigo))
                        .appendChild(Label.create("Blue").addCss(dui_m_4, dui_blue))
                        .appendChild(Label.create("Light Blue").addCss(dui_m_4, dui_light_blue))
                        .appendChild(Label.create("Cyan").addCss(dui_m_4, dui_cyan))
                        .appendChild(Label.create("Teal").addCss(dui_m_4, dui_teal))
                        .appendChild(Label.create("Green").addCss(dui_m_4, dui_green))
                        .appendChild(Label.create("Orange").addCss(dui_m_4, dui_orange))
                        .appendChild(Label.create("Yellow").addCss(dui_m_4, dui_yellow))
                )

        ;
        init(this);
    }

    @Override
    public HTMLDivElement element() {
        return this.element.element();
    }
}

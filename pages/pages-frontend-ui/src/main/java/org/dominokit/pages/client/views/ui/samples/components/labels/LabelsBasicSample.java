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
                .appendChild(hr())
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
                .appendChild(Row.create()
                        .span1(Label.create("Red").addCss(dui_m_4, dui_red))
                        .span1(Label.create("Pink").addCss(dui_m_4, dui_pink))
                        .span1(Label.create("Purple").addCss(dui_m_4, dui_purple))
                        .span1(Label.create("Deep Purple").addCss(dui_m_4, dui_deep_purple))
                        .span1(Label.create("Indigo").addCss(dui_m_4, dui_indigo))
                        .span1(Label.create("Blue").addCss(dui_m_4, dui_blue))
                        .span1(Label.create("Light Blue").addCss(dui_m_4, dui_light_blue))
                        .span1(Label.create("Cyan").addCss(dui_m_4, dui_cyan))
                        .span1(Label.create("Teal").addCss(dui_m_4, dui_teal))
                        .span1(Label.create("Green").addCss(dui_m_4, dui_green))
                        .span1(Label.create("Orange").addCss(dui_m_4, dui_orange))
                        .span1(Label.create("Yellow").addCss(dui_m_4, dui_yellow))
                )

        ;
        init(this);
    }

    @Override
    public HTMLDivElement element() {
        return this.element.element();
    }
}

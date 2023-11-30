package org.dominokit.pages.client.views.ui.samples.components.buttons;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.button.LinkButton;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.typography.BlockHeader;
import org.dominokit.domino.ui.utils.BaseDominoElement;

import static org.dominokit.domino.ui.utils.Domino.*;

public class ButtonsBasicSample extends BaseDominoElement<HTMLDivElement, ButtonsBasicSample> {

    private DivElement element;

    public static ButtonsBasicSample create() {
        return new ButtonsBasicSample();
    }

    public ButtonsBasicSample() {
        this.element = div().addCss(dui_p_2, dui_flex, dui_flex_col, dui_gap_4, dui_justify_center)
                .appendChild(BlockHeader.create("SIMPLE").addCss(dui_text_center))
                .appendChild(Row.create()
                        .span2(LinkButton.create("DEFAULT")
                                .addCss(dui_w_28, dui_m_1))
                        .span2(Button.create("PRIMARY")
                                .addCss(dui_primary, dui_w_28, dui_m_1))
                        .span2(Button.create("SUCCESS")
                                .addCss(dui_success, dui_w_28, dui_m_1))
                        .span2(Button.create("INFO")
                                .addCss(dui_info, dui_w_28, dui_m_1))
                        .span2(Button.create("WARNING")
                                .addCss(dui_warning, dui_w_28, dui_m_1))
                        .span2(Button.create("DANGER")
                                .addCss(dui_error, dui_w_28, dui_m_1))
                )
                .appendChild(BlockHeader.create("SIMPLE").addCss(dui_text_center))
                .appendChild(Row.create()
                        .span2(LinkButton.create("DEFAULT")
                                .addCss(dui_w_28, dui_m_1)
                                .disable())
                        .span2(Button.create("DEFAULT")
                                .addCss(dui_m_1, dui_w_28)
                                .disable())
                        .span2(Button.create("PRIMARY")
                                .addCss(dui_primary, dui_m_1, dui_w_28)
                                .disable())
                        .span2(Button.create("INFO")
                                .addCss(dui_info, dui_m_1, dui_w_28)
                                .disable())
                        .span2(Button.create("WARNING")
                                .addCss(dui_warning, dui_m_1, dui_w_28)
                                .disable())
                        .span2(Button.create("DANGER")
                                .addCss(dui_error, dui_m_1, dui_w_28)
                                .disable())
                )
                .appendChild(BlockHeader.create("ICON BUTTONS").addCss(dui_text_center))
                .appendChild(Row.create()
                        .span1(Button.create(Icons.home())
                                .addCss(dui_m_1)
                        )
                        .span1(Button.create(Icons.home())
                                .addCss(dui_primary, dui_m_1)
                        )
                        .span1(Button.create(Icons.more())
                                .addCss(dui_info, dui_m_1)
                        )
                        .span1(Button.create(Icons.keyboard())
                                .addCss(dui_success, dui_m_1)
                        )
                        .span1(Button.create(Icons.air_conditioner())
                                .addCss(dui_warning, dui_m_1)
                        )
                        .span1(Button.create(Icons.alarm())
                                .addCss(dui_error, dui_m_1)
                        )
                        .span1(Button.create(Icons.circle())
                                .circle()
                                .addCss(dui_small, dui_m_1)
                        )
                        .span1(Button.create(Icons.select_place())
                                .circle()
                                .addCss(dui_primary, dui_small, dui_m_1)
                        )
                        .span1(Button.create(Icons.airplane_off())
                                .circle()
                                .addCss(dui_info, dui_small, dui_m_1)
                        )
                        .span1(Button.create(Icons.album())
                                .circle()
                                .addCss(dui_success, dui_small, dui_m_1)
                        )
                        .span1(Button.create(Icons.calendar_weekend())
                                .circle()
                                .addCss(dui_warning, dui_small, dui_m_1)
                        )
                        .span1(Button.create(Icons.cast_variant())
                                .circle()
                                .addCss(dui_error, dui_small, dui_m_1)
                        )
                )
                .appendChild(BlockHeader.create("ICON & TEXT").addCss(dui_text_center))
                .appendChild(Row.create()
                        .span3(Button.create(Icons.widgets(), "EXTENSION")
                                .addCss(dui_m_1)
                        )
                        .span3(Button.create(Icons.home(), "Home")
                                .addCss(dui_m_1)
                                .setReversed(true)
                        )
                        .span3(Button.create(Icons.home(), "Home")
                                .addCss(dui_primary, dui_m_1)
                        )
                        .span3(Button.create(Icons.lock(), "LOCK")
                                .addCss(dui_accent, dui_m_1)
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

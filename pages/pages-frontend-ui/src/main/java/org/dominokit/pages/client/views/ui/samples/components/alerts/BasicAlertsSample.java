package org.dominokit.pages.client.views.ui.samples.components.alerts;

import static org.dominokit.domino.ui.utils.Domino.div;
import static org.dominokit.domino.ui.utils.Domino.dui_bg_blue_grey;
import static org.dominokit.domino.ui.utils.Domino.dui_bg_pink;
import static org.dominokit.domino.ui.utils.Domino.dui_bg_purple;
import static org.dominokit.domino.ui.utils.Domino.dui_bg_teal;
import static org.dominokit.domino.ui.utils.Domino.dui_border;
import static org.dominokit.domino.ui.utils.Domino.dui_border_dashed;
import static org.dominokit.domino.ui.utils.Domino.dui_border_teal;
import static org.dominokit.domino.ui.utils.Domino.dui_fg_white;
import static org.dominokit.domino.ui.utils.Domino.dui_m_b_4;
import static org.dominokit.domino.ui.utils.Domino.dui_p_2;
import static org.dominokit.domino.ui.utils.Domino.dui_rounded_full;
import static org.dominokit.domino.ui.utils.Domino.strong;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.alerts.Alert;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.utils.BaseDominoElement;

public class BasicAlertsSample extends BaseDominoElement<HTMLDivElement, BasicAlertsSample> {

    private DivElement element;

    public static BasicAlertsSample create() {
        return new BasicAlertsSample();
    }

    public BasicAlertsSample() {
        this.element = div().addCss(dui_p_2)
                        .appendChild(Alert.create()
                                .addCss(dui_m_b_4, dui_bg_teal, dui_fg_white)
                                .appendChild(strong().textContent("Well done! "))
                                .appendChild("You successfully read this important alert message."))
                        .appendChild(Alert.create()
                                .addCss(dui_m_b_4, dui_bg_blue_grey, dui_fg_white, dui_rounded_full)
                                .appendChild(strong().textContent("Heads up! "))
                                .appendChild("This alert needs your attention, but it's not super important."))
                        .appendChild(Alert.create()
                                .addCss(dui_m_b_4, dui_bg_pink, dui_fg_white, dui_border, dui_border_teal, dui_border_dashed)
                                .appendChild(strong().textContent("New offer! "))
                                .appendChild("Check the new offer and save 40% on the sale."))
                        .appendChild(Alert.create()
                                .addCss(dui_m_b_4, dui_bg_purple, dui_fg_white)
                                .appendChild(strong().textContent("Colorful! "))
                                .appendChild("This alert has a purple background.")
                );
        init(this);
    }

    @Override
    public HTMLDivElement element() {
        return this.element.element();
    }
}

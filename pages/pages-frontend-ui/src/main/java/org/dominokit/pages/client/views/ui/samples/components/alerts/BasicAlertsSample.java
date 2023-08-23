package org.dominokit.pages.client.views.ui.samples.components.alerts;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.alerts.Alert;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.forms.TextBox;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.layout.AppLayout;
import org.dominokit.domino.ui.layout.NavBar;
import org.dominokit.domino.ui.menu.Menu;
import org.dominokit.domino.ui.menu.MenuItem;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.PostfixAddOn;
import org.dominokit.domino.ui.utils.PrefixAddOn;

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

package org.dominokit.pages.client.views.ui.samples.components.alerts;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.alerts.Alert;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.utils.BaseDominoElement;

import static org.dominokit.domino.ui.utils.Domino.*;

public class LinksAlertsSample extends BaseDominoElement<HTMLDivElement, LinksAlertsSample> {

    private DivElement element;

    public static LinksAlertsSample create() {
        return new LinksAlertsSample();
    }

    public LinksAlertsSample() {
        this.element = div().addCss(dui_p_2)
                .appendChild(Alert.success()
                        .addCss(dui_m_b_4)
                        .appendChild(strong().textContent("Well done! "))
                        .appendChild("You successfully read ")
                        .appendChild(a().appendChild("important alert message.")))
                .appendChild(Alert.info()
                        .addCss(dui_m_b_4)
                        .appendChild(strong().textContent("Heads up! "))
                        .appendChild("This ")
                        .appendChild(a().appendChild("alert needs your attention, "))
                        .appendChild("but it's not super important."))
                .appendChild(Alert.warning()
                        .addCss(dui_m_b_4)
                        .appendChild(strong().textContent("Warning! "))
                        .appendChild("Better check yourself, ")
                        .appendChild(a().appendChild("you're not looking too good.")))
                .appendChild(Alert.error()
                        .addCss(dui_m_b_4)
                        .appendChild(strong().textContent("Oh snap!    "))
                        .appendChild(a().appendChild("Change a few things up"))
                        .appendChild(" and try submitting again."))
                .appendChild(Alert.create()
                        .addCss(dui_bg_pink, dui_fg_white, dui_m_b_4)
                        .appendChild("Lorem ipsum dolor sit amet, id fugit tollit pro, illud nostrud aliquando ad est, quo esse dolorum id ")
                );
        init(this);
    }

    @Override
    public HTMLDivElement element() {
        return this.element.element();
    }
}

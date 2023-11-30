package org.dominokit.pages.client.views.ui.samples.components.alerts;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.alerts.Alert;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.utils.BaseDominoElement;

import static org.dominokit.domino.ui.utils.Domino.*;

public class ContextAlertsSample extends BaseDominoElement<HTMLDivElement, ContextAlertsSample> {

    private DivElement element;

    public static ContextAlertsSample create() {
        return new ContextAlertsSample();
    }

    public ContextAlertsSample() {
        this.element = div().addCss(dui_p_2)
                .appendChild(Alert.success()
                        .addCss(dui_m_b_4)
                        .appendChild(strong().textContent("Well done! "))
                        .appendChild("You successfully read this important alert message."))
                .appendChild(Alert.info()
                        .addCss(dui_m_b_4)
                        .appendChild(strong().textContent("Heads up! "))
                        .appendChild("This alert needs your attention, but it's not super important."))
                .appendChild(Alert.warning()
                        .addCss(dui_m_b_4)
                        .appendChild(strong().textContent("Warning! "))
                        .appendChild("Better check yourself, you're not looking too good."))
                .appendChild(Alert.error()
                        .addCss(dui_m_b_4)
                        .appendChild(strong().textContent("Oh snap! "))
                        .appendChild("Change a few things up and try submitting again.")
                );
        init(this);
    }

    @Override
    public HTMLDivElement element() {
        return this.element.element();
    }
}

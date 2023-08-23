package org.dominokit.pages.client.views.ui.samples.components.alerts;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.alerts.Alert;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.utils.BaseDominoElement;

public class DismissibleAlertsSample extends BaseDominoElement<HTMLDivElement, DismissibleAlertsSample> {

    private DivElement element;

    public static DismissibleAlertsSample create() {
        return new DismissibleAlertsSample();
    }

    public DismissibleAlertsSample() {
        this.element = div().addCss(dui_p_2)
                .appendChild(Alert.warning()
                        .addCss(dui_m_b_4)
                        .appendChild("Lorem ipsum dolor sit amet, id fugit tollit pro, illud nostrud aliquando ad est, quo esse dolorum id")
                        .dismissible())
                .appendChild(Alert.create()
                        .addCss(dui_bg_pink, dui_fg_white, dui_m_b_4)
                        .appendChild("Lorem ipsum dolor sit amet, id fugit tollit pro, illud nostrud aliquando ad est, quo esse dolorum id")
                        .dismissible())
                .appendChild(Alert.create()
                        .addCss(dui_bg_teal, dui_fg_white, dui_m_b_4)
                        .appendChild("Lorem ipsum dolor sit amet, id fugit tollit pro, illud nostrud aliquando ad est, quo esse dolorum id")
                        .dismissible())
                .appendChild(Alert.create()
                        .addCss(dui_bg_green, dui_fg_white, dui_m_b_4)
                        .appendChild("Lorem ipsum dolor sit amet, id fugit tollit pro, illud nostrud aliquando ad est, quo esse dolorum id")
                        .dismissible()
                );
        init(this);
    }

    @Override
    public HTMLDivElement element() {
        return this.element.element();
    }
}

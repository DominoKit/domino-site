package org.dominokit.pages.client.views.ui.samples.forms.decoration;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.forms.TextAreaBox;
import org.dominokit.domino.ui.forms.TextBox;
import org.dominokit.domino.ui.utils.BaseDominoElement;

import static org.dominokit.domino.ui.utils.Domino.div;
import static org.dominokit.domino.ui.utils.Domino.dui_p_2;

public class FieldDecorationCounterSample extends BaseDominoElement<HTMLDivElement, FieldDecorationCounterSample> {

    private DivElement element;

    public static FieldDecorationCounterSample create() {
        return new FieldDecorationCounterSample();
    }

    public FieldDecorationCounterSample() {
        this.element = div().addCss(dui_p_2)
                .appendChild(TextBox.create("Name")
                        .setMaxLength(10)
                )
                .appendChild(TextAreaBox.create("Description").setMaxLength(100));
        ;
        init(this);
    }

    @Override
    public HTMLDivElement element() {
        return this.element.element();
    }
}

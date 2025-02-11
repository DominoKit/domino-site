package org.dominokit.pages.client.views.ui.samples.forms.input;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.forms.PasswordBox;
import org.dominokit.domino.ui.forms.TextBox;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.typography.BlockHeader;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.pro.domino.ui.inputmask.StringMask;

import static org.dominokit.domino.ui.utils.Domino.*;
import static org.dominokit.domino.ui.utils.Domino.span;

public class StringMaskSample extends BaseDominoElement<HTMLDivElement, StringMaskSample> {

    private DivElement element;

    public static StringMaskSample create() {
        return new StringMaskSample();
    }

    public StringMaskSample() {
        this.element = div().addCss(dui_p_2)
                .appendChild(Row.create()
                        .appendChild(Column.span6()
                                .appendChild(span().setTextContent("123SDWLMN4567 -> ###-AAA-(AAA)/##/## : "+new StringMask("###-AAA-(AAA)/##/##").maskInput("123SDWLMN4567").getMaskedValue()))
                        )
                        .appendChild(Column.span6()
                                .appendChild(span().setTextContent("03062026 -> ##/##/#### : "+new StringMask("##/##/####").maskInput("03062026").getMaskedValue()))
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

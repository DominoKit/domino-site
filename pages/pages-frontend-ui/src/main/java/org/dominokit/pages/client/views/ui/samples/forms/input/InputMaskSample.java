package org.dominokit.pages.client.views.ui.samples.forms.input;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.forms.TextAreaBox;
import org.dominokit.domino.ui.forms.TextBox;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.typography.BlockHeader;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.pro.domino.ui.inputmask.InputMask;
import org.dominokit.pro.domino.ui.inputmask.StringMask;

import static org.dominokit.domino.ui.utils.Domino.*;

public class InputMaskSample extends BaseDominoElement<HTMLDivElement, InputMaskSample> {

    private DivElement element;

    public static InputMaskSample create() {
        return new InputMaskSample();
    }

    public InputMaskSample() {
        this.element = div().addCss(dui_p_2)
                .appendChild(BlockHeader.create("Input element"))
                .appendChild(Row.create()
                        .appendChild(Column.span4()
                                .appendChild(TextBox.create("Input masking")
                                        .withInputElement((parent, self) -> InputMask.of(self.element(), "###-###.##").startMasking())
                                )
                        )
                        .appendChild(Column.span4()
                                .appendChild(TextAreaBox.create("TextArea masking")
                                        .withInputElement((parent, self) -> InputMask.of(self.element(), "This is a fixed text in a text area and the user should fill a value ###-###.## \n as it can have multi lines").startMasking())
                                )
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

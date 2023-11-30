package org.dominokit.pages.client.views.ui.samples.forms.input;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.forms.TextAreaBox;
import org.dominokit.domino.ui.typography.BlockHeader;
import org.dominokit.domino.ui.utils.BaseDominoElement;

import static org.dominokit.domino.ui.utils.Domino.div;
import static org.dominokit.domino.ui.utils.Domino.dui_p_2;

public class BasicFormsTextAreaSample extends BaseDominoElement<HTMLDivElement, BasicFormsTextAreaSample> {

    private DivElement element;

    public static BasicFormsTextAreaSample create() {
        return new BasicFormsTextAreaSample();
    }

    public BasicFormsTextAreaSample() {
        this.element = div().addCss(dui_p_2)
                .appendChild(BlockHeader.create("Basic Examples"))
                .appendChild(TextAreaBox.create().setPlaceholder("Start typing here..."))
                .appendChild(BlockHeader.create("Auto Growing Vertical Direction"))
                .appendChild(TextAreaBox.create().setPlaceholder("Start typing here...").autoSize())
                .appendChild(BlockHeader.create("Text Area With Label"))
                .appendChild(TextAreaBox.create("Description").autoSize())
        ;
        init(this);
    }

    @Override
    public HTMLDivElement element() {
        return this.element.element();
    }
}

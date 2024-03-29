package org.dominokit.pages.client.views.ui.samples.components.richtext;

import static org.dominokit.domino.ui.utils.Domino.div;
import static org.dominokit.domino.ui.utils.Domino.dui_min_h_72;
import static org.dominokit.domino.ui.utils.Domino.dui_p_2;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.richtext.RichTextEditor;
import org.dominokit.domino.ui.utils.BaseDominoElement;

public class RichTextEditorSample extends BaseDominoElement<HTMLDivElement, RichTextEditorSample> {

    private DivElement element;

    public static RichTextEditorSample create() {
        return new RichTextEditorSample();
    }

    public RichTextEditorSample() {
        this.element = div().addCss(dui_p_2)
                .appendChild(RichTextEditor.create()
                        .addCss(dui_min_h_72)
                );
        init(this);
    }

    @Override
    public HTMLDivElement element() {
        return this.element.element();
    }
}

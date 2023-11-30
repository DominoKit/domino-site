package org.dominokit.pages.client.views.ui.samples.typography;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.typography.Blockquote;
import org.dominokit.domino.ui.utils.BaseDominoElement;

import static org.dominokit.domino.ui.utils.Domino.*;

public class TypographyBlockquotesSample extends BaseDominoElement<HTMLDivElement, TypographyBlockquotesSample> {

    private DivElement element;

    public static TypographyBlockquotesSample create() {
        return new TypographyBlockquotesSample();
    }

    public TypographyBlockquotesSample() {
        this.element = div().addCss(dui_p_2)
                .appendChild(Blockquote.create("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer posuere erat a ante."))
                .appendChild(Blockquote.create("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer posuere erat a ante.")
                        .withFooter((parent, footer) -> {
                            footer
                                    .appendChild(text("Someone famous in "))
                                    .appendChild(cite().textContent("source title."));
                        })
                )
                .appendChild(Blockquote.create("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer posuere erat a ante.")
                        .withFooter((parent, footer) -> {
                            footer
                                    .appendChild(cite().textContent("source title. "))
                                    .appendChild(text("Someone famous in"));
                        })
                );
        init(this);
    }

    @Override
    public HTMLDivElement element() {
        return this.element.element();
    }
}

package org.dominokit.pages.client.views.ui.samples.components.cards;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.button.LinkButton;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.typography.BlockHeader;
import org.dominokit.domino.ui.utils.BaseDominoElement;

public class NoHeaderCardsSample extends BaseDominoElement<HTMLDivElement, NoHeaderCardsSample> {

    private static final String SAMPLE_CONTENT = "Quis pharetra a pharetra fames blandit. Risus faucibus velit Risus imperdiet mattis neque volutpat, etiam lacinia netus dictum magnis per facilisi sociosqu. Volutpat. Ridiculus nostra.";

    private DivElement element;

    public static NoHeaderCardsSample create() {
        return new NoHeaderCardsSample();
    }

    public NoHeaderCardsSample() {
        this.element = div().addCss(dui_p_2)
                .appendChild(Row.create()
                        .appendChild(Column.span4()
                                .appendChild(Card.create()
                                        .appendChild(text(SAMPLE_CONTENT))
                                )
                        )
                        .appendChild(Column.span4()
                                .appendChild(Card.create()
                                        .addCss(dui_bg_accent, dui_fg_white)
                                        .appendChild(text(SAMPLE_CONTENT))
                                )
                        )
                        .appendChild(Column.span4()
                                .appendChild(Card.create()
                                        .addCss(dui_teal)
                                        .appendChild(text(SAMPLE_CONTENT))
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

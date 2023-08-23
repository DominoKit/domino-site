package org.dominokit.pages.client.views.ui.samples.components.cards;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.cards.HeaderPosition;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.notifications.Notification;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.PostfixAddOn;

public class CollapsibleCardsSample extends BaseDominoElement<HTMLDivElement, CollapsibleCardsSample> {

    private static final String SAMPLE_CONTENT = "Quis pharetra a pharetra fames blandit. Risus faucibus velit Risus imperdiet mattis neque volutpat, etiam lacinia netus dictum magnis per facilisi sociosqu. Volutpat. Ridiculus nostra.";

    private DivElement element;

    public static CollapsibleCardsSample create() {
        return new CollapsibleCardsSample();
    }

    public CollapsibleCardsSample() {
        this.element = div().addCss(dui_p_2)
                .appendChild(Row.create()
                        .appendChild(Column.span4()
                                .appendChild(Card.create("Card Title", "Description text here...")
                                        .setCollapsible(true)
                                        .appendChild(text(SAMPLE_CONTENT))
                                        .withHeader((card, header) -> {
                                            header.appendChild(PostfixAddOn.of(Icons.dots_vertical()
                                                    .clickable()
                                                    .addClickListener(evt -> Notification.create("More action selected").show())
                                            ));
                                        })
                                )
                        )
                        .appendChild(Column.span4().addCss(dui_relative)
                                .appendChild(Card.create("Card Title", "Description text here...")
                                        .setCollapsible(true)
                                        .setHeaderPosition(HeaderPosition.BOTTOM)
                                        .addCss(dui_accent, dui_absolute)
                                        .appendChild(text(SAMPLE_CONTENT))
                                        .withHeader((card, header) -> {
                                            header.appendChild(PostfixAddOn.of(Icons.dots_vertical()
                                                    .clickable()
                                                    .addClickListener(evt -> Notification.create("More action selected").show())
                                            ));
                                        })
                                )
                        )
                        .appendChild(Column.span4()
                                .appendChild(Card.create("Card Title", "Description text here...")
                                        .setCollapsible(true)
                                        .setHeaderPosition(HeaderPosition.BOTTOM)
                                        .addCss(dui_teal)
                                        .appendChild(text(SAMPLE_CONTENT))
                                        .withHeader((card, header) -> {
                                            header.appendChild(PostfixAddOn.of(Icons.dots_vertical()
                                                    .clickable()
                                                    .addClickListener(evt -> Notification.create("More action selected").show())
                                            ));
                                        })
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

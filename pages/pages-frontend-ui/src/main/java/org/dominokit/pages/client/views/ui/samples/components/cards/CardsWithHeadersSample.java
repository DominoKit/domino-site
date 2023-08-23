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

public class CardsWithHeadersSample extends BaseDominoElement<HTMLDivElement, CardsWithHeadersSample> {

    private static final String SAMPLE_CONTENT = "Quis pharetra a pharetra fames blandit. Risus faucibus velit Risus imperdiet mattis neque volutpat, etiam lacinia netus dictum magnis per facilisi sociosqu. Volutpat. Ridiculus nostra.";

    private DivElement element;

    public static CardsWithHeadersSample create() {
        return new CardsWithHeadersSample();
    }

    public CardsWithHeadersSample() {
        this.element = div().addCss(dui_p_2)
                .appendChild(Row.create()
                        .appendChild(Column.span4()
                                .appendChild(Card.create("Card Title", "Description text here...")
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
                                        .addCss(dui_bg_accent, dui_fg_white)
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
                .appendChild(Row.create()
                        .appendChild(Column.span4()
                                .appendChild(Card.create("Card Title", "Description text here...")
                                        .setHeaderPosition(HeaderPosition.BOTTOM)
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
                                        .setHeaderPosition(HeaderPosition.BOTTOM)
                                        .addCss(dui_accent)
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

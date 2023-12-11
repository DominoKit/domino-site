package org.dominokit.pages.client.views.ui.samples.components.cards;

import static org.dominokit.domino.ui.utils.Domino.div;
import static org.dominokit.domino.ui.utils.Domino.dui_accent;
import static org.dominokit.domino.ui.utils.Domino.dui_bg_accent_d_2;
import static org.dominokit.domino.ui.utils.Domino.dui_bg_blue_d_2;
import static org.dominokit.domino.ui.utils.Domino.dui_bg_teal_d_2;
import static org.dominokit.domino.ui.utils.Domino.dui_blue;
import static org.dominokit.domino.ui.utils.Domino.dui_fg_white;
import static org.dominokit.domino.ui.utils.Domino.dui_p_2;
import static org.dominokit.domino.ui.utils.Domino.dui_teal;
import static org.dominokit.domino.ui.utils.Domino.text;

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

public class ColoredCardsSample extends BaseDominoElement<HTMLDivElement, ColoredCardsSample> {

    private static final String SAMPLE_CONTENT = "Quis pharetra a pharetra fames blandit. Risus faucibus velit Risus imperdiet mattis neque volutpat, etiam lacinia netus dictum magnis per facilisi sociosqu. Volutpat. Ridiculus nostra.";

    private DivElement element;

    public static ColoredCardsSample create() {
        return new ColoredCardsSample();
    }

    public ColoredCardsSample() {
        this.element = div().addCss(dui_p_2)
                .appendChild(Row.create()
                        .appendChild(Column.span4()
                                .appendChild(Card.create("Card Title", "Description text here...")
                                        .appendChild(text(SAMPLE_CONTENT))
                                        .withHeader((card, header) -> {
                                            header
                                                    .addCss(dui_accent)
                                                    .appendChild(PostfixAddOn.of(Icons.dots_vertical()
                                                            .clickable()
                                                            .addClickListener(evt -> Notification.create("More action selected").show())
                                                    ));
                                        })
                                )
                        )
                        .appendChild(Column.span4()
                                .appendChild(Card.create("Card Title", "Description text here...")
                                        .appendChild(text(SAMPLE_CONTENT))
                                        .withHeader((card, header) -> {
                                            header
                                                    .addCss(dui_blue)
                                                    .appendChild(PostfixAddOn.of(Icons.dots_vertical()
                                                            .clickable()
                                                            .addClickListener(evt -> Notification.create("More action selected").show())
                                                    ));
                                        })
                                )
                        )
                        .appendChild(Column.span4()
                                .appendChild(Card.create("Card Title", "Description text here...")
                                        .appendChild(text(SAMPLE_CONTENT))
                                        .withHeader((card, header) -> {
                                            header
                                                    .addCss(dui_teal)
                                                    .appendChild(PostfixAddOn.of(Icons.dots_vertical()
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
                                            header
                                                    .addCss(dui_accent)
                                                    .appendChild(PostfixAddOn.of(Icons.dots_vertical()
                                                            .clickable()
                                                            .addClickListener(evt -> Notification.create("More action selected").show())
                                                    ));
                                        })
                                )
                        )
                        .appendChild(Column.span4()
                                .appendChild(Card.create("Card Title", "Description text here...")
                                        .setHeaderPosition(HeaderPosition.BOTTOM)
                                        .appendChild(text(SAMPLE_CONTENT))
                                        .withHeader((card, header) -> {
                                            header
                                                    .addCss(dui_blue)
                                                    .appendChild(PostfixAddOn.of(Icons.dots_vertical()
                                                            .clickable()
                                                            .addClickListener(evt -> Notification.create("More action selected").show())
                                                    ));
                                        })
                                )
                        )
                        .appendChild(Column.span4()
                                .appendChild(Card.create("Card Title", "Description text here...")
                                        .setHeaderPosition(HeaderPosition.BOTTOM)
                                        .appendChild(text(SAMPLE_CONTENT))
                                        .withHeader((card, header) -> {
                                            header
                                                    .addCss(dui_teal)
                                                    .appendChild(PostfixAddOn.of(Icons.dots_vertical()
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
                                        .appendChild(text(SAMPLE_CONTENT))
                                        .withBody((card, body) -> body.addCss(dui_accent))
                                        .withHeader((card, header) -> {
                                            header
                                                    .appendChild(PostfixAddOn.of(Icons.dots_vertical()
                                                            .clickable()
                                                            .addClickListener(evt -> Notification.create("More action selected").show())
                                                    ));
                                        })
                                )
                        )
                        .appendChild(Column.span4()
                                .appendChild(Card.create("Card Title", "Description text here...")
                                        .appendChild(text(SAMPLE_CONTENT))
                                        .withBody((card, body) -> body.addCss(dui_blue))
                                        .withHeader((card, header) -> {
                                            header
                                                    .appendChild(PostfixAddOn.of(Icons.dots_vertical()
                                                            .clickable()
                                                            .addClickListener(evt -> Notification.create("More action selected").show())
                                                    ));
                                        })
                                )
                        )
                        .appendChild(Column.span4()
                                .appendChild(Card.create("Card Title", "Description text here...")
                                        .appendChild(text(SAMPLE_CONTENT))
                                        .withBody((card, body) -> body.addCss(dui_teal))
                                        .withHeader((card, header) -> {
                                            header
                                                    .appendChild(PostfixAddOn.of(Icons.dots_vertical()
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
                                        .withBody((card, body) -> body.addCss(dui_accent))
                                        .withHeader((card, header) -> {
                                            header
                                                    .appendChild(PostfixAddOn.of(Icons.dots_vertical()
                                                            .clickable()
                                                            .addClickListener(evt -> Notification.create("More action selected").show())
                                                    ));
                                        })
                                )
                        )
                        .appendChild(Column.span4()
                                .appendChild(Card.create("Card Title", "Description text here...")
                                        .setHeaderPosition(HeaderPosition.BOTTOM)
                                        .appendChild(text(SAMPLE_CONTENT))
                                        .withBody((card, body) -> body.addCss(dui_blue))
                                        .withHeader((card, header) -> {
                                            header
                                                    .appendChild(PostfixAddOn.of(Icons.dots_vertical()
                                                            .clickable()
                                                            .addClickListener(evt -> Notification.create("More action selected").show())
                                                    ));
                                        })
                                )
                        )
                        .appendChild(Column.span4()
                                .appendChild(Card.create("Card Title", "Description text here...")
                                        .setHeaderPosition(HeaderPosition.BOTTOM)
                                        .appendChild(text(SAMPLE_CONTENT))
                                        .withBody((card, body) -> body.addCss(dui_teal))
                                        .withHeader((card, header) -> {
                                            header
                                                    .appendChild(PostfixAddOn.of(Icons.dots_vertical()
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
                                        .appendChild(text(SAMPLE_CONTENT))
                                        .withBody((card, body) -> body.addCss(dui_accent))
                                        .withHeader((card, header) -> {
                                            header
                                                    .addCss(dui_bg_accent_d_2, dui_fg_white)
                                                    .appendChild(PostfixAddOn.of(Icons.dots_vertical()
                                                            .clickable()
                                                            .addClickListener(evt -> Notification.create("More action selected").show())
                                                    ));
                                        })
                                )
                        )
                        .appendChild(Column.span4()
                                .appendChild(Card.create("Card Title", "Description text here...")
                                        .appendChild(text(SAMPLE_CONTENT))
                                        .withBody((card, body) -> body.addCss(dui_blue))
                                        .withHeader((card, header) -> {
                                            header
                                                    .addCss(dui_bg_blue_d_2, dui_fg_white)
                                                    .appendChild(PostfixAddOn.of(Icons.dots_vertical()
                                                            .clickable()
                                                            .addClickListener(evt -> Notification.create("More action selected").show())
                                                    ));
                                        })
                                )
                        )
                        .appendChild(Column.span4()
                                .appendChild(Card.create("Card Title", "Description text here...")
                                        .appendChild(text(SAMPLE_CONTENT))
                                        .withBody((card, body) -> body.addCss(dui_teal))
                                        .withHeader((card, header) -> {
                                            header
                                                    .addCss(dui_bg_teal_d_2, dui_fg_white)
                                                    .appendChild(PostfixAddOn.of(Icons.dots_vertical()
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
                                        .withBody((card, body) -> body.addCss(dui_accent))
                                        .withHeader((card, header) -> {
                                            header
                                                    .addCss(dui_bg_accent_d_2, dui_fg_white)
                                                    .appendChild(PostfixAddOn.of(Icons.dots_vertical()
                                                            .clickable()
                                                            .addClickListener(evt -> Notification.create("More action selected").show())
                                                    ));
                                        })
                                )
                        )
                        .appendChild(Column.span4()
                                .appendChild(Card.create("Card Title", "Description text here...")
                                        .setHeaderPosition(HeaderPosition.BOTTOM)
                                        .appendChild(text(SAMPLE_CONTENT))
                                        .withBody((card, body) -> body.addCss(dui_blue))
                                        .withHeader((card, header) -> {
                                            header
                                                    .addCss(dui_bg_blue_d_2, dui_fg_white)
                                                    .appendChild(PostfixAddOn.of(Icons.dots_vertical()
                                                            .clickable()
                                                            .addClickListener(evt -> Notification.create("More action selected").show())
                                                    ));
                                        })
                                )
                        )
                        .appendChild(Column.span4()
                                .appendChild(Card.create("Card Title", "Description text here...")
                                        .setHeaderPosition(HeaderPosition.BOTTOM)
                                        .appendChild(text(SAMPLE_CONTENT))
                                        .withBody((card, body) -> body.addCss(dui_teal))
                                        .withHeader((card, header) -> {
                                            header
                                                    .addCss(dui_bg_teal_d_2, dui_fg_white)
                                                    .appendChild(PostfixAddOn.of(Icons.dots_vertical()
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

package org.dominokit.pages.client.views.ui.samples.components.cards;

import elemental2.core.JsDate;
import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.badges.Badge;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.cards.HeaderPosition;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.notifications.Notification;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.PostfixAddOn;
import org.dominokit.domino.ui.utils.PrefixAddOn;

public class CardSubHeaderSample extends BaseDominoElement<HTMLDivElement, CardSubHeaderSample> {

    private static final String SAMPLE_CONTENT = "Quis pharetra a pharetra fames blandit. Risus faucibus velit Risus imperdiet mattis neque volutpat, etiam lacinia netus dictum magnis per facilisi sociosqu. Volutpat. Ridiculus nostra.";

    private DivElement element;

    public static CardSubHeaderSample create() {
        return new CardSubHeaderSample();
    }

    public CardSubHeaderSample() {
        this.element = div().addCss(dui_p_2)
                .appendChild(Row.create()
                        .appendChild(Column.span6()
                                .appendChild(Card.create("Card Title", "Description text here...")
                                        .setCollapsible(true)
                                        .appendChild(text(SAMPLE_CONTENT))
                                        .withHeader((card, header) -> {
                                            header
                                                    .setLogo(img("http://placehold.jp/36x36.png"))
                                                    .appendChild(PostfixAddOn.of(Badge.create("25+")))
                                                    .appendChild(PostfixAddOn.of(Icons.dots_horizontal()
                                                            .clickable()
                                                            .addClickListener(evt -> Notification.create("More action selected").show())
                                                    ))
                                                    .appendChild(PrefixAddOn.of(Icons.dots_vertical().clickable()))
                                                    .withSubHeader((mainHeader, subHeader) -> {
                                                        subHeader
                                                                .appendChild(small().textContent(new JsDate().toLocaleDateString()).addCss(dui_grow_1))
                                                                .appendChild(PostfixAddOn.of(Badge.create("important").addCss(dui_red)));
                                                    });
                                        })
                                )
                        )
                        .appendChild(Column.span6()
                                .appendChild(Card.create("Card Title", "Description text here...")
                                        .setCollapsible(true)
                                        .setHeaderPosition(HeaderPosition.BOTTOM)
                                        .addCss(dui_teal)
                                        .appendChild(text(SAMPLE_CONTENT))
                                        .withHeader((card, header) -> {
                                            header
                                                    .setLogo(img("http://placehold.jp/36x36.png"))
                                                    .appendChild(PostfixAddOn.of(Badge.create("25+").addCss(dui_bg_teal_d_2, dui_fg_white)))
                                                    .appendChild(PostfixAddOn.of(Icons.dots_horizontal()
                                                            .clickable()
                                                            .addClickListener(evt -> Notification.create("More action selected").show())
                                                    ))
                                                    .appendChild(PrefixAddOn.of(Icons.dots_vertical().clickable()))
                                                    .withSubHeader((mainHeader, subHeader) -> {
                                                        subHeader
                                                                .appendChild(small().textContent(new JsDate().toLocaleDateString()).addCss(dui_grow_1))
                                                                .appendChild(PostfixAddOn.of(Badge.create("important").addCss(dui_red)));
                                                    });
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

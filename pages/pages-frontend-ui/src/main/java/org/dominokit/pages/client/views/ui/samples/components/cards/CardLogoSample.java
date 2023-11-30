package org.dominokit.pages.client.views.ui.samples.components.cards;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.cards.HeaderPosition;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.notifications.Notification;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.PostfixAddOn;
import org.dominokit.domino.ui.utils.PrefixAddOn;

import static org.dominokit.domino.ui.utils.Domino.*;

public class CardLogoSample extends BaseDominoElement<HTMLDivElement, CardLogoSample> {

    private static final String SAMPLE_CONTENT = "Quis pharetra a pharetra fames blandit. Risus faucibus velit Risus imperdiet mattis neque volutpat, etiam lacinia netus dictum magnis per facilisi sociosqu. Volutpat. Ridiculus nostra.";

    private DivElement element;

    public static CardLogoSample create() {
        return new CardLogoSample();
    }

    public CardLogoSample() {
        this.element = div().addCss(dui_p_2)
                .appendChild(Row.create()
                        .span4(Card.create("Card Title", "Description text here...")
                                .setCollapsible(true)
                                .appendChild(text(SAMPLE_CONTENT))
                                .withHeader((card, header) -> {
                                    header
                                            .setLogo(img("http://placehold.jp/3d4070/ffffff/36x36.png"))
                                            .appendChild(PostfixAddOn.of(Icons.dots_horizontal()
                                                    .clickable()
                                                    .addClickListener(evt -> Notification.create("More action selected").show())
                                            ))
                                            .appendChild(PrefixAddOn.of(Icons.dots_vertical().clickable()));
                                })
                        )
                        .span4(Card.create("Card Title", "Description text here...")
                                .setCollapsible(true)
                                .setHeaderPosition(HeaderPosition.BOTTOM)
                                .addCss(dui_accent)
                                .appendChild(text(SAMPLE_CONTENT))
                                .withHeader((card, header) -> {
                                    header
                                            .setLogo(img("http://placehold.jp/3d4070/ffffff/36x36.png").addCss(dui_rounded_full))
                                            .appendChild(PostfixAddOn.of(Icons.dots_horizontal()
                                                    .clickable()
                                                    .addClickListener(evt -> Notification.create("More action selected").show())
                                            ))
                                            .appendChild(PrefixAddOn.of(Icons.dots_vertical().clickable()));
                                })

                        )
                        .span4(Card.create("Card Title", "Description text here...")
                                        .setCollapsible(true)
                                        .setHeaderPosition(HeaderPosition.BOTTOM)
                                        .addCss(dui_teal)
                                        .appendChild(text(SAMPLE_CONTENT))
                                        .withHeader((card, header) -> {
                                            header
                                                    .setLogo(img("http://placehold.jp/3d4070/ffffff/36x36.png"))
                                                    .appendChild(PostfixAddOn.of(Icons.dots_horizontal()
                                                            .clickable()
                                                            .addClickListener(evt -> Notification.create("More action selected").show())
                                                    ))
                                                    .appendChild(PrefixAddOn.of(Icons.dots_vertical().clickable()));
                                        })
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

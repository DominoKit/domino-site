package org.dominokit.pages.client.views.ui.samples.components.popover;

import static org.dominokit.domino.ui.utils.Domino.div;
import static org.dominokit.domino.ui.utils.Domino.dui_bg_accent;
import static org.dominokit.domino.ui.utils.Domino.dui_elevation_0;
import static org.dominokit.domino.ui.utils.Domino.dui_fg;
import static org.dominokit.domino.ui.utils.Domino.dui_m_2px;
import static org.dominokit.domino.ui.utils.Domino.dui_m_t_0;
import static org.dominokit.domino.ui.utils.Domino.dui_p_2;
import static org.dominokit.domino.ui.utils.Domino.dui_rounded_sm;
import static org.dominokit.domino.ui.utils.Domino.h;
import static org.dominokit.domino.ui.utils.Domino.p;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.menu.direction.DropDirection;
import org.dominokit.domino.ui.popover.Popover;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.PostfixAddOn;

public class PopoverSample extends BaseDominoElement<HTMLDivElement, PopoverSample> {

    private DivElement element;

    public static PopoverSample create() {
        return new PopoverSample();
    }

    public PopoverSample() {
        this.element = div().addCss(dui_p_2)
                .appendChild(Row.create()
                        .span3(Button.create("RIGHT MIDDLE")
                                .apply(button -> {
                                    Popover.create(button)
                                            .addCss(dui_bg_accent, dui_rounded_sm)
                                            .setPosition(DropDirection.RIGHT_MIDDLE)
                                            .appendChild(Card.create("Popover")
                                                    .setIcon(Icons.message_settings_outline())
                                                    .addCss(dui_bg_accent, dui_fg, dui_elevation_0, dui_m_2px, dui_rounded_sm)
                                                    .appendChild(PostfixAddOn.of(Icons.dots_vertical().clickable()))
                                                    .appendChild(h(4).addCss(dui_m_t_0).appendChild("Headline here"))
                                                    .appendChild(p("Vivamus sagittis lacus vel augue laoreet rutrum faucibus."))
                                            );
                                })
                        )
                        .span3(Button.create("TOP MIDDLE")
                                .apply(button -> {
                                    Popover.create(button)
                                            .addCss(dui_bg_accent, dui_rounded_sm)
                                            .setPosition(DropDirection.TOP_MIDDLE)
                                            .appendChild(Card.create("Popover")
                                                    .setIcon(Icons.message_settings_outline())
                                                    .addCss(dui_bg_accent, dui_fg, dui_elevation_0, dui_m_2px, dui_rounded_sm)
                                                    .appendChild(PostfixAddOn.of(Icons.dots_vertical().clickable()))
                                                    .appendChild(h(4).addCss(dui_m_t_0).appendChild("Headline here"))
                                                    .appendChild(p("Vivamus sagittis lacus vel augue laoreet rutrum faucibus."))
                                            );
                                })
                        )
                        .span3(Button.create("BOTTOM MIDDLE")
                                .apply(button -> {
                                    Popover.create(button)
                                            .addCss(dui_bg_accent, dui_rounded_sm)
                                            .setPosition(DropDirection.BOTTOM_MIDDLE)
                                            .appendChild(Card.create("Popover")
                                                    .setIcon(Icons.message_settings_outline())
                                                    .addCss(dui_bg_accent, dui_fg, dui_elevation_0, dui_m_2px, dui_rounded_sm)
                                                    .appendChild(PostfixAddOn.of(Icons.dots_vertical().clickable()))
                                                    .appendChild(h(4).addCss(dui_m_t_0).appendChild("Headline here"))
                                                    .appendChild(p("Vivamus sagittis lacus vel augue laoreet rutrum faucibus."))
                                            );
                                })
                        )
                        .span3(Button.create("LEFT MIDDLE")
                                .apply(button -> {
                                    Popover.create(button)
                                            .addCss(dui_bg_accent, dui_rounded_sm)
                                            .setPosition(DropDirection.LEFT_MIDDLE)
                                            .appendChild(Card.create("Popover")
                                                    .setIcon(Icons.message_settings_outline())
                                                    .addCss(dui_bg_accent, dui_fg, dui_elevation_0, dui_m_2px, dui_rounded_sm)
                                                    .appendChild(PostfixAddOn.of(Icons.dots_vertical().clickable()))
                                                    .appendChild(h(4).addCss(dui_m_t_0).appendChild("Headline here"))
                                                    .appendChild(p("Vivamus sagittis lacus vel augue laoreet rutrum faucibus."))
                                            );
                                })
                        )
                )
                .appendChild(Row.create()
                        .span3(Button.create("BOTTOM LEFT")
                                .apply(button -> {
                                    Popover.create(button)
                                            .addCss(dui_bg_accent, dui_rounded_sm)
                                            .setPosition(DropDirection.BOTTOM_LEFT)
                                            .appendChild(Card.create("Popover")
                                                    .setIcon(Icons.message_settings_outline())
                                                    .addCss(dui_bg_accent, dui_fg, dui_elevation_0, dui_m_2px, dui_rounded_sm)
                                                    .appendChild(PostfixAddOn.of(Icons.dots_vertical().clickable()))
                                                    .appendChild(h(4).addCss(dui_m_t_0).appendChild("Headline here"))
                                                    .appendChild(p("Vivamus sagittis lacus vel augue laoreet rutrum faucibus."))
                                            );
                                })
                        )
                        .span3(Button.create("BOTTOM MIDDLE")
                                .apply(button -> {
                                    Popover.create(button)
                                            .addCss(dui_bg_accent, dui_rounded_sm)
                                            .setPosition(DropDirection.BOTTOM_MIDDLE)
                                            .appendChild(Card.create("Popover")
                                                    .setIcon(Icons.message_settings_outline())
                                                    .addCss(dui_bg_accent, dui_fg, dui_elevation_0, dui_m_2px, dui_rounded_sm)
                                                    .appendChild(PostfixAddOn.of(Icons.dots_vertical().clickable()))
                                                    .appendChild(h(4).addCss(dui_m_t_0).appendChild("Headline here"))
                                                    .appendChild(p("Vivamus sagittis lacus vel augue laoreet rutrum faucibus."))
                                            );
                                })
                        )
                        .span3(Button.create("BOTTOM RIGHT")
                                .apply(button -> {
                                    Popover.create(button)
                                            .addCss(dui_bg_accent, dui_rounded_sm)
                                            .setPosition(DropDirection.BOTTOM_RIGHT)
                                            .appendChild(Card.create("Popover")
                                                    .setIcon(Icons.message_settings_outline())
                                                    .addCss(dui_bg_accent, dui_fg, dui_elevation_0, dui_m_2px, dui_rounded_sm)
                                                    .appendChild(PostfixAddOn.of(Icons.dots_vertical().clickable()))
                                                    .appendChild(h(4).addCss(dui_m_t_0).appendChild("Headline here"))
                                                    .appendChild(p("Vivamus sagittis lacus vel augue laoreet rutrum faucibus."))
                                            );
                                })
                        )
                        .span3(Button.create("LEFT DOWN")
                                .apply(button -> {
                                    Popover.create(button)
                                            .addCss(dui_bg_accent, dui_rounded_sm)
                                            .setPosition(DropDirection.LEFT_DOWN)
                                            .appendChild(Card.create("Popover")
                                                    .setIcon(Icons.message_settings_outline())
                                                    .addCss(dui_bg_accent, dui_fg, dui_elevation_0, dui_m_2px, dui_rounded_sm)
                                                    .appendChild(PostfixAddOn.of(Icons.dots_vertical().clickable()))
                                                    .appendChild(h(4).addCss(dui_m_t_0).appendChild("Headline here"))
                                                    .appendChild(p("Vivamus sagittis lacus vel augue laoreet rutrum faucibus."))
                                            );
                                })
                        )
                )
                .appendChild(Row.create()
                        .span3(Button.create("LEFT MIDDLE")
                                .apply(button -> {
                                    Popover.create(button)
                                            .addCss(dui_bg_accent, dui_rounded_sm)
                                            .setPosition(DropDirection.LEFT_MIDDLE)
                                            .appendChild(Card.create("Popover")
                                                    .setIcon(Icons.message_settings_outline())
                                                    .addCss(dui_bg_accent, dui_fg, dui_elevation_0, dui_m_2px, dui_rounded_sm)
                                                    .appendChild(PostfixAddOn.of(Icons.dots_vertical().clickable()))
                                                    .appendChild(h(4).addCss(dui_m_t_0).appendChild("Headline here"))
                                                    .appendChild(p("Vivamus sagittis lacus vel augue laoreet rutrum faucibus."))
                                            );
                                })
                        )
                        .span3(Button.create("LEFT UP")
                                .apply(button -> {
                                    Popover.create(button)
                                            .addCss(dui_bg_accent, dui_rounded_sm)
                                            .setPosition(DropDirection.LEFT_UP)
                                            .appendChild(Card.create("Popover")
                                                    .setIcon(Icons.message_settings_outline())
                                                    .addCss(dui_bg_accent, dui_fg, dui_elevation_0, dui_m_2px, dui_rounded_sm)
                                                    .appendChild(PostfixAddOn.of(Icons.dots_vertical().clickable()))
                                                    .appendChild(h(4).addCss(dui_m_t_0).appendChild("Headline here"))
                                                    .appendChild(p("Vivamus sagittis lacus vel augue laoreet rutrum faucibus."))
                                            );
                                })
                        )
                        .span3(Button.create("RIGHT DOWN")
                                .apply(button -> {
                                    Popover.create(button)
                                            .addCss(dui_bg_accent, dui_rounded_sm)
                                            .setPosition(DropDirection.RIGHT_DOWN)
                                            .appendChild(Card.create("Popover")
                                                    .setIcon(Icons.message_settings_outline())
                                                    .addCss(dui_bg_accent, dui_fg, dui_elevation_0, dui_m_2px, dui_rounded_sm)
                                                    .appendChild(PostfixAddOn.of(Icons.dots_vertical().clickable()))
                                                    .appendChild(h(4).addCss(dui_m_t_0).appendChild("Headline here"))
                                                    .appendChild(p("Vivamus sagittis lacus vel augue laoreet rutrum faucibus."))
                                            );
                                })
                        )
                        .span3(Button.create("RIGHT MIDDLE")
                                .apply(button -> {
                                    Popover.create(button)
                                            .addCss(dui_bg_accent, dui_rounded_sm)
                                            .setPosition(DropDirection.RIGHT_MIDDLE)
                                            .appendChild(Card.create("Popover")
                                                    .setIcon(Icons.message_settings_outline())
                                                    .addCss(dui_bg_accent, dui_fg, dui_elevation_0, dui_m_2px, dui_rounded_sm)
                                                    .appendChild(PostfixAddOn.of(Icons.dots_vertical().clickable()))
                                                    .appendChild(h(4).addCss(dui_m_t_0).appendChild("Headline here"))
                                                    .appendChild(p("Vivamus sagittis lacus vel augue laoreet rutrum faucibus."))
                                            );
                                })
                        )
                )
                .appendChild(Row.create()
                        .span3(Button.create("RIGHT UP")
                                .apply(button -> {
                                    Popover.create(button)
                                            .addCss(dui_bg_accent, dui_rounded_sm)
                                            .setPosition(DropDirection.RIGHT_UP)
                                            .appendChild(Card.create("Popover")
                                                    .setIcon(Icons.message_settings_outline())
                                                    .addCss(dui_bg_accent, dui_fg, dui_elevation_0, dui_m_2px, dui_rounded_sm)
                                                    .appendChild(PostfixAddOn.of(Icons.dots_vertical().clickable()))
                                                    .appendChild(h(4).addCss(dui_m_t_0).appendChild("Headline here"))
                                                    .appendChild(p("Vivamus sagittis lacus vel augue laoreet rutrum faucibus."))
                                            );
                                })
                        )
                        .span3(Button.create("TOP LEFT")
                                .apply(button -> {
                                    Popover.create(button)
                                            .addCss(dui_bg_accent, dui_rounded_sm)
                                            .setPosition(DropDirection.TOP_LEFT)
                                            .appendChild(Card.create("Popover")
                                                    .setIcon(Icons.message_settings_outline())
                                                    .addCss(dui_bg_accent, dui_fg, dui_elevation_0, dui_m_2px, dui_rounded_sm)
                                                    .appendChild(PostfixAddOn.of(Icons.dots_vertical().clickable()))
                                                    .appendChild(h(4).addCss(dui_m_t_0).appendChild("Headline here"))
                                                    .appendChild(p("Vivamus sagittis lacus vel augue laoreet rutrum faucibus."))
                                            );
                                })
                        )
                        .span3(Button.create("TOP MIDDLE")
                                .apply(button -> {
                                    Popover.create(button)
                                            .addCss(dui_bg_accent, dui_rounded_sm)
                                            .setPosition(DropDirection.TOP_MIDDLE)
                                            .appendChild(Card.create("Popover")
                                                    .setIcon(Icons.message_settings_outline())
                                                    .addCss(dui_bg_accent, dui_fg, dui_elevation_0, dui_m_2px, dui_rounded_sm)
                                                    .appendChild(PostfixAddOn.of(Icons.dots_vertical().clickable()))
                                                    .appendChild(h(4).addCss(dui_m_t_0).appendChild("Headline here"))
                                                    .appendChild(p("Vivamus sagittis lacus vel augue laoreet rutrum faucibus."))
                                            );
                                })
                        )
                        .span3(Button.create("TOP RIGHT")
                                .apply(button -> {
                                    Popover.create(button)
                                            .addCss(dui_bg_accent, dui_rounded_sm)
                                            .setPosition(DropDirection.TOP_RIGHT)
                                            .appendChild(Card.create("Popover")
                                                    .setIcon(Icons.message_settings_outline())
                                                    .addCss(dui_bg_accent, dui_fg, dui_elevation_0, dui_m_2px, dui_rounded_sm)
                                                    .appendChild(PostfixAddOn.of(Icons.dots_vertical().clickable()))
                                                    .appendChild(h(4).addCss(dui_m_t_0).appendChild("Headline here"))
                                                    .appendChild(p("Vivamus sagittis lacus vel augue laoreet rutrum faucibus."))
                                            );
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

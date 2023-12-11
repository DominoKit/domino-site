package org.dominokit.pages.client.views.ui.samples.components.modals;

import static org.dominokit.domino.ui.utils.Domino.div;
import static org.dominokit.domino.ui.utils.Domino.dui_accent;
import static org.dominokit.domino.ui.utils.Domino.dui_bg;
import static org.dominokit.domino.ui.utils.Domino.dui_bg_d_2;
import static org.dominokit.domino.ui.utils.Domino.dui_blue;
import static org.dominokit.domino.ui.utils.Domino.dui_deep_purple;
import static org.dominokit.domino.ui.utils.Domino.dui_fg;
import static org.dominokit.domino.ui.utils.Domino.dui_flex;
import static org.dominokit.domino.ui.utils.Domino.dui_flex_wrap;
import static org.dominokit.domino.ui.utils.Domino.dui_gap_1;
import static org.dominokit.domino.ui.utils.Domino.dui_green;
import static org.dominokit.domino.ui.utils.Domino.dui_h_8;
import static org.dominokit.domino.ui.utils.Domino.dui_indigo;
import static org.dominokit.domino.ui.utils.Domino.dui_justify_between;
import static org.dominokit.domino.ui.utils.Domino.dui_justify_end;
import static org.dominokit.domino.ui.utils.Domino.dui_m_b_4;
import static org.dominokit.domino.ui.utils.Domino.dui_orange;
import static org.dominokit.domino.ui.utils.Domino.dui_p_0;
import static org.dominokit.domino.ui.utils.Domino.dui_p_2;
import static org.dominokit.domino.ui.utils.Domino.dui_pink;
import static org.dominokit.domino.ui.utils.Domino.dui_purple;
import static org.dominokit.domino.ui.utils.Domino.dui_red;
import static org.dominokit.domino.ui.utils.Domino.dui_rounded_full;
import static org.dominokit.domino.ui.utils.Domino.dui_teal;
import static org.dominokit.domino.ui.utils.Domino.dui_w_32;
import static org.dominokit.domino.ui.utils.Domino.text;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.badges.Badge;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.dialogs.Dialog;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.layout.NavBar;
import org.dominokit.domino.ui.menu.Menu;
import org.dominokit.domino.ui.menu.MenuItem;
import org.dominokit.domino.ui.style.SwapCssClass;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.FooterContent;
import org.dominokit.domino.ui.utils.PostfixAddOn;
import org.dominokit.domino.ui.utils.PrefixAddOn;

public class ColoredModalsSample extends BaseDominoElement<HTMLDivElement, ColoredModalsSample> {

    private static final String SAMPLE_CONTENT = "Quis pharetra a pharetra fames blandit. Risus faucibus velit Risus imperdiet mattis neque volutpat, etiam lacinia netus dictum magnis per facilisi sociosqu. Volutpat. Ridiculus nostra.";

    private DivElement element;

    public static ColoredModalsSample create() {
        return new ColoredModalsSample();
    }

    public ColoredModalsSample() {
        Dialog coloredDialog = Dialog.create()
                .setModal(true)
                .setAutoClose(false)
                .withHeader((dialog, header) ->
                        header.appendChild(NavBar.create("COLORED DIALOG")
                                .addCss(dui_h_8, dui_p_0)
                                .appendChild(PrefixAddOn.of(Icons.dots_vertical()
                                                .clickable()
                                                .setDropMenu(Menu.<String>create()
                                                        .appendChild(MenuItem.create("ACTION 1"))
                                                        .appendChild(MenuItem.create("ACTION 2"))
                                                        .appendChild(MenuItem.create("ACTION 3"))
                                                )
                                        )
                                )
                                .appendChild(PostfixAddOn.of(Badge.create("15+").addCss(dui_bg_d_2, dui_fg, dui_rounded_full)))
                                .appendChild(PostfixAddOn.of(Icons.close()
                                                .addCss(dui_fg)
                                                .clickable()
                                                .addClickListener(evt -> dialog.close())
                                        )
                                )
                        )
                )
                .appendChild(text(SAMPLE_CONTENT))
                .withContentFooter((dialog, footer) -> {
                    footer.addCss(dui_flex, dui_gap_1, dui_justify_end, dui_bg_d_2);
                    dialog
                            .appendChild(FooterContent.of(Button.create("CLOSE")
                                    .addCss(dui_bg)
                                    .addClickListener(evt -> dialog.close()))
                            )
                            .appendChild(FooterContent.of(Button.create(Icons.cursor_default_click(), "CLICK ME")
                                    .addCss(dui_bg)
                            ));
                });

        SwapCssClass dialogColor = SwapCssClass.of();

        this.element = div().addCss(dui_p_2)
                .appendChild(div()
                        .addCss(dui_flex, dui_justify_between, dui_flex_wrap)
                        .appendChild(Button.create("RED")
                                .addCss(dialogColor.replaceWith(dui_red), dui_w_32, dui_m_b_4)
                                .addClickListener(evt -> coloredDialog
                                        .addCss(dialogColor.replaceWith(dui_red))
                                        .open()
                                )
                        )
                        .appendChild(Button.create("PINK")
                                .addCss(dialogColor.replaceWith(dui_pink), dui_w_32, dui_m_b_4)
                                .addClickListener(evt -> coloredDialog
                                        .addCss(dialogColor.replaceWith(dui_pink))
                                        .open()
                                )
                        )
                        .appendChild(Button.create("PURPLE")
                                .addCss(dialogColor.replaceWith(dui_purple), dui_w_32, dui_m_b_4)
                                .addClickListener(evt -> coloredDialog
                                        .addCss(dialogColor.replaceWith(dui_purple))
                                        .open()
                                )
                        )
                        .appendChild(Button.create("DEEP PURPLE")
                                .addCss(dialogColor.replaceWith(dui_deep_purple), dui_w_32, dui_m_b_4)
                                .addClickListener(evt -> coloredDialog
                                        .addCss(dialogColor.replaceWith(dui_deep_purple))
                                        .open()
                                )
                        )
                        .appendChild(Button.create("INDIGO")
                                .addCss(dialogColor.replaceWith(dui_indigo), dui_w_32, dui_m_b_4)
                                .addClickListener(evt -> coloredDialog
                                        .addCss(dialogColor.replaceWith(dui_indigo))
                                        .open()
                                )
                        )
                        .appendChild(Button.create("BLUE")
                                .addCss(dialogColor.replaceWith(dui_blue), dui_w_32, dui_m_b_4)
                                .addClickListener(evt -> coloredDialog
                                        .addCss(dialogColor.replaceWith(dui_blue))
                                        .open()
                                )
                        )
                        .appendChild(Button.create("ORANGE")
                                .addCss(dialogColor.replaceWith(dui_orange), dui_w_32, dui_m_b_4)
                                .addClickListener(evt -> coloredDialog
                                        .addCss(dialogColor.replaceWith(dui_orange))
                                        .open()
                                )
                        )
                        .appendChild(Button.create("GREEN")
                                .addCss(dialogColor.replaceWith(dui_green), dui_w_32, dui_m_b_4)
                                .addClickListener(evt -> coloredDialog
                                        .addCss(dialogColor.replaceWith(dui_green))
                                        .open()
                                )
                        )
                        .appendChild(Button.create("TEAL")
                                .addCss(dialogColor.replaceWith(dui_teal), dui_w_32, dui_m_b_4)
                                .addClickListener(evt -> coloredDialog
                                        .addCss(dialogColor.replaceWith(dui_teal))
                                        .open()
                                )
                        )
                        .appendChild(Button.create("ACCENT")
                                .addCss(dialogColor.replaceWith(dui_accent), dui_w_32, dui_m_b_4)
                                .addClickListener(evt -> coloredDialog
                                        .addCss(dialogColor.replaceWith(dui_accent))
                                        .open()
                                )
                        )
                );
        init(this);
    }

    @Override
    public HTMLDivElement element() {
        return this.element.element();
    }
}

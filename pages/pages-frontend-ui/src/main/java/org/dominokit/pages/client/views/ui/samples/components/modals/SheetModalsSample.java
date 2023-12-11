package org.dominokit.pages.client.views.ui.samples.components.modals;

import static org.dominokit.domino.ui.dialogs.DialogStyles.dui_bottom_sheet;
import static org.dominokit.domino.ui.dialogs.DialogStyles.dui_right_sheet;
import static org.dominokit.domino.ui.dialogs.DialogStyles.dui_top_sheet;
import static org.dominokit.domino.ui.utils.Domino.div;
import static org.dominokit.domino.ui.utils.Domino.dui_accent;
import static org.dominokit.domino.ui.utils.Domino.dui_fg_red;
import static org.dominokit.domino.ui.utils.Domino.dui_flex;
import static org.dominokit.domino.ui.utils.Domino.dui_flex_wrap;
import static org.dominokit.domino.ui.utils.Domino.dui_gap_1;
import static org.dominokit.domino.ui.utils.Domino.dui_h_8;
import static org.dominokit.domino.ui.utils.Domino.dui_justify_end;
import static org.dominokit.domino.ui.utils.Domino.dui_p_0;
import static org.dominokit.domino.ui.utils.Domino.dui_p_2;
import static org.dominokit.domino.ui.utils.Domino.dui_rounded_full;
import static org.dominokit.domino.ui.utils.Domino.text;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.badges.Badge;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.dialogs.Dialog;
import org.dominokit.domino.ui.dialogs.DialogSize;
import org.dominokit.domino.ui.dialogs.DialogStyles;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.layout.NavBar;
import org.dominokit.domino.ui.menu.Menu;
import org.dominokit.domino.ui.menu.MenuItem;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.FooterContent;
import org.dominokit.domino.ui.utils.PostfixAddOn;
import org.dominokit.domino.ui.utils.PrefixAddOn;

public class SheetModalsSample extends BaseDominoElement<HTMLDivElement, SheetModalsSample> {

    private static final String SAMPLE_CONTENT = "Quis pharetra a pharetra fames blandit. Risus faucibus velit Risus imperdiet mattis neque volutpat, etiam lacinia netus dictum magnis per facilisi sociosqu. Volutpat. Ridiculus nostra.";

    private DivElement element;

    public static SheetModalsSample create() {
        return new SheetModalsSample();
    }

    public SheetModalsSample() {
        Dialog leftSheetDialog = Dialog.create()
                .addCss(DialogStyles.dui_left_sheet)
                .withHeader((dialog, header) ->
                        header.appendChild(NavBar.create("SHEET DIALOG")
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
                                .appendChild(PostfixAddOn.of(Badge.create("15+").addCss(dui_accent, dui_rounded_full)))
                                .appendChild(PostfixAddOn.of(Icons.close()
                                                .addCss(dui_fg_red)
                                                .clickable()
                                                .addClickListener(evt -> dialog.close())
                                        )
                                )
                        )
                )
                .apply(dialog -> {
                    dialog
                            .appendChild(div().addCss(dui_flex, dui_gap_1, dui_flex_wrap)
                                    .appendChild(Button.create("VERY LARGE").addClickListener(evt -> dialog.setStretchWidth(DialogSize.VERY_LARGE)))
                                    .appendChild(Button.create("LARGE").addClickListener(evt -> dialog.setStretchWidth(DialogSize.LARGE)))
                                    .appendChild(Button.create("MEDIUM").addClickListener(evt -> dialog.setStretchWidth(DialogSize.MEDIUM)))
                                    .appendChild(Button.create("SMALL").addClickListener(evt -> dialog.setStretchWidth(DialogSize.SMALL)))
                                    .appendChild(Button.create("VERY SMALL").addClickListener(evt -> dialog.setStretchWidth(DialogSize.VERY_SMALL)))
                            );
                })
                .appendChild(text(SAMPLE_CONTENT))
                .withContentFooter((dialog, footer) -> {
                    footer.addCss(dui_flex, dui_gap_1, dui_justify_end);
                    dialog
                            .appendChild(FooterContent.of(Button.create("CLOSE")
                                    .addClickListener(evt -> dialog.close()))
                            )
                            .appendChild(FooterContent.of(Button.create(Icons.cursor_default_click(), "CLICK ME")));
                });

        Dialog rightSheetDialog = Dialog.create()
                .addCss(dui_right_sheet)
                .withHeader((dialog, header) ->
                        header.appendChild(NavBar.create("SHEET DIALOG")
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
                                .appendChild(PostfixAddOn.of(Badge.create("15+").addCss(dui_accent, dui_rounded_full)))
                                .appendChild(PostfixAddOn.of(Icons.close()
                                                .addCss(dui_fg_red)
                                                .clickable()
                                                .addClickListener(evt -> dialog.close())
                                        )
                                )
                        )
                )
                .apply(dialog -> {
                    dialog
                            .appendChild(div().addCss(dui_flex, dui_gap_1, dui_flex_wrap)
                                    .appendChild(Button.create("VERY LARGE").addClickListener(evt -> dialog.setStretchWidth(DialogSize.VERY_LARGE)))
                                    .appendChild(Button.create("LARGE").addClickListener(evt -> dialog.setStretchWidth(DialogSize.LARGE)))
                                    .appendChild(Button.create("MEDIUM").addClickListener(evt -> dialog.setStretchWidth(DialogSize.MEDIUM)))
                                    .appendChild(Button.create("SMALL").addClickListener(evt -> dialog.setStretchWidth(DialogSize.SMALL)))
                                    .appendChild(Button.create("VERY SMALL").addClickListener(evt -> dialog.setStretchWidth(DialogSize.VERY_SMALL)))
                            );
                })
                .appendChild(text(SAMPLE_CONTENT))
                .withContentFooter((dialog, footer) -> {
                    footer.addCss(dui_flex, dui_gap_1, dui_justify_end);
                    dialog
                            .appendChild(FooterContent.of(Button.create("CLOSE")
                                    .addClickListener(evt -> dialog.close()))
                            )
                            .appendChild(FooterContent.of(Button.create(Icons.cursor_default_click(), "CLICK ME")));
                });

        Dialog topSheetDialog = Dialog.create()
                .addCss(dui_top_sheet)
                .withHeader((dialog, header) ->
                        header.appendChild(NavBar.create("SHEET DIALOG")
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
                                .appendChild(PostfixAddOn.of(Badge.create("15+").addCss(dui_accent, dui_rounded_full)))
                                .appendChild(PostfixAddOn.of(Icons.close()
                                                .addCss(dui_fg_red)
                                                .clickable()
                                                .addClickListener(evt -> dialog.close())
                                        )
                                )
                        )
                )
                .apply(dialog -> {
                    dialog
                            .appendChild(div().addCss(dui_flex, dui_gap_1, dui_flex_wrap)
                                    .appendChild(Button.create("VERY LARGE").addClickListener(evt -> dialog.setStretchHeight(DialogSize.VERY_LARGE)))
                                    .appendChild(Button.create("LARGE").addClickListener(evt -> dialog.setStretchHeight(DialogSize.LARGE)))
                                    .appendChild(Button.create("MEDIUM").addClickListener(evt -> dialog.setStretchHeight(DialogSize.MEDIUM)))
                                    .appendChild(Button.create("SMALL").addClickListener(evt -> dialog.setStretchHeight(DialogSize.SMALL)))
                                    .appendChild(Button.create("VERY SMALL").addClickListener(evt -> dialog.setStretchHeight(DialogSize.VERY_SMALL)))
                            );
                })
                .appendChild(text(SAMPLE_CONTENT))
                .withContentFooter((dialog, footer) -> {
                    footer.addCss(dui_flex, dui_gap_1, dui_justify_end);
                    dialog
                            .appendChild(FooterContent.of(Button.create("CLOSE")
                                    .addClickListener(evt -> dialog.close()))
                            )
                            .appendChild(FooterContent.of(Button.create(Icons.cursor_default_click(), "CLICK ME")));
                });

        Dialog bottomSheetDialog = Dialog.create()
                .addCss(dui_bottom_sheet)
                .withHeader((dialog, header) ->
                        header.appendChild(NavBar.create("SHEET DIALOG")
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
                                .appendChild(PostfixAddOn.of(Badge.create("15+").addCss(dui_accent, dui_rounded_full)))
                                .appendChild(PostfixAddOn.of(Icons.close()
                                                .addCss(dui_fg_red)
                                                .clickable()
                                                .addClickListener(evt -> dialog.close())
                                        )
                                )
                        )
                )
                .apply(dialog -> {
                    dialog
                            .appendChild(div().addCss(dui_flex, dui_gap_1, dui_flex_wrap)
                                    .appendChild(Button.create("VERY LARGE").addClickListener(evt -> dialog.setStretchHeight(DialogSize.VERY_LARGE)))
                                    .appendChild(Button.create("LARGE").addClickListener(evt -> dialog.setStretchHeight(DialogSize.LARGE)))
                                    .appendChild(Button.create("MEDIUM").addClickListener(evt -> dialog.setStretchHeight(DialogSize.MEDIUM)))
                                    .appendChild(Button.create("SMALL").addClickListener(evt -> dialog.setStretchHeight(DialogSize.SMALL)))
                                    .appendChild(Button.create("VERY SMALL").addClickListener(evt -> dialog.setStretchHeight(DialogSize.VERY_SMALL)))
                            );
                })
                .appendChild(text(SAMPLE_CONTENT))
                .withContentFooter((dialog, footer) -> {
                    footer.addCss(dui_flex, dui_gap_1, dui_justify_end);
                    dialog
                            .appendChild(FooterContent.of(Button.create("CLOSE")
                                    .addClickListener(evt -> dialog.close()))
                            )
                            .appendChild(FooterContent.of(Button.create(Icons.cursor_default_click(), "CLICK ME")));
                });

        this.element = div().addCss(dui_p_2)
                .appendChild(Row.create()
                        .span3(Button.create("LEFT SHEET")
                                .addClickListener(evt -> leftSheetDialog.open())
                        )
                        .span3(Button.create("TOP SHEET")
                                .addClickListener(evt -> topSheetDialog.open())
                        )
                        .span3(Button.create("BOTTOM SHEET")
                                .addClickListener(evt -> bottomSheetDialog.open())
                        )
                        .span3(Button.create("RIGHT SHEET")
                                .addClickListener(evt -> rightSheetDialog.open())
                        )
                );

        init(this);
    }

    @Override
    public HTMLDivElement element() {
        return this.element.element();
    }
}

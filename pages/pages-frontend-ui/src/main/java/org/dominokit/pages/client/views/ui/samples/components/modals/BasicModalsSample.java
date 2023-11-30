package org.dominokit.pages.client.views.ui.samples.components.modals;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.badges.Badge;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.dialogs.Dialog;
import org.dominokit.domino.ui.dialogs.DialogSize;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.forms.suggest.Select;
import org.dominokit.domino.ui.forms.suggest.SelectOption;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.layout.NavBar;
import org.dominokit.domino.ui.menu.Menu;
import org.dominokit.domino.ui.menu.MenuItem;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.FooterContent;
import org.dominokit.domino.ui.utils.PostfixAddOn;
import org.dominokit.domino.ui.utils.PrefixAddOn;

import static org.dominokit.domino.ui.utils.Domino.*;

public class BasicModalsSample extends BaseDominoElement<HTMLDivElement, BasicModalsSample> {

    private static final String SAMPLE_CONTENT = "Quis pharetra a pharetra fames blandit. Risus faucibus velit Risus imperdiet mattis neque volutpat, etiam lacinia netus dictum magnis per facilisi sociosqu. Volutpat. Ridiculus nostra.";

    private DivElement element;

    public static BasicModalsSample create() {
        return new BasicModalsSample();
    }

    public BasicModalsSample() {
        Dialog defaultSizeDialog = Dialog.create()
                .withHeader((dialog, header) ->
                        header.appendChild(NavBar.create("DEFAULT SIZE")
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
                .appendChild(text(SAMPLE_CONTENT))
                .appendChild(Select.<Integer>create("Sample")
                        .appendItems(item -> SelectOption.create(String.valueOf(item), item, String.valueOf(item)), 1, 2, 3)
                )
                .withContentFooter((dialog, footer) -> {
                    footer.addCss(dui_flex, dui_gap_1, dui_justify_end);
                    dialog
                            .appendChild(FooterContent.of(Button.create("CLOSE")
                                    .addClickListener(evt -> dialog.close()))
                            )
                            .appendChild(FooterContent.of(Button.create(Icons.cursor_default_click(), "CLICK ME")));
                });

        Dialog largeSizeDialog = Dialog.create()
                .setStretchWidth(DialogSize.LARGE)
                .setStretchHeight(DialogSize.LARGE)
                .withHeader((dialog, header) ->
                        header.appendChild(NavBar.create("LARGE SIZE")
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
                .appendChild(text(SAMPLE_CONTENT))
                .withContentFooter((dialog, footer) -> {
                    footer.addCss(dui_flex, dui_gap_1, dui_justify_end);
                    dialog
                            .appendChild(FooterContent.of(Button.create("CLOSE")
                                    .addClickListener(evt -> dialog.close()))
                            )
                            .appendChild(FooterContent.of(Button.create(Icons.cursor_default_click(), "CLICK ME")));
                });

        Dialog smallSizeDialog = Dialog.create()
                .setStretchWidth(DialogSize.SMALL)
                .setStretchHeight(DialogSize.SMALL)
                .withHeader((dialog, header) ->
                        header.appendChild(NavBar.create("SMALL SIZE")
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
                        .span4(Button.create("MODAL - DEFAULT SIZE")
                                .addClickListener(evt -> defaultSizeDialog.open())
                        )
                        .span4(Button.create("MODAL - LARGE SIZE")
                                .addClickListener(evt -> largeSizeDialog.open())
                        )
                        .span4(Button.create("MODAL - SMALL SIZE")
                                .addClickListener(evt -> smallSizeDialog.open())
                        )
                );
        init(this);
    }

    @Override
    public HTMLDivElement element() {
        return this.element.element();
    }
}

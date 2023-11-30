package org.dominokit.pages.client.views.ui.samples.components.menu;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.menu.CustomMenuItem;
import org.dominokit.domino.ui.menu.Menu;
import org.dominokit.domino.ui.menu.MenuItem;
import org.dominokit.domino.ui.notifications.Notification;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.PostfixAddOn;
import org.dominokit.domino.ui.utils.PrefixAddOn;
import org.dominokit.domino.ui.utils.Separator;

import static org.dominokit.domino.ui.utils.Domino.*;

public class CustomItemSample extends BaseDominoElement<HTMLDivElement, CustomItemSample> {

    private DivElement element;

    public static CustomItemSample create() {
        return new CustomItemSample();
    }

    public CustomItemSample() {
        this.element = div().addCss(dui_p_2)
                .appendChild(Row.create()
                        .appendChild(Column
                                .span4()
                                .appendChild(Menu.<String>create()
                                        .addCss(dui_w_full)
                                        .appendChild(MenuItem.<String>create("New ...")
                                                .setKey("new-key")
                                                .withValue("new-value")
                                        )
                                        .appendChild(MenuItem.<String>create("Open")
                                                .setKey("open-key")
                                                .withValue("open-value")
                                                .appendChild(PrefixAddOn.of(Icons.folder_open().addCss(dui_font_size_5)))
                                        )
                                        .appendChild(MenuItem.<String>create("Close")
                                                .setKey("close-key")
                                                .withValue("close-value")
                                                .appendChild(PrefixAddOn.of(Icons.close_box().addCss(dui_font_size_5)))
                                        )
                                        .appendChild(MenuItem.<String>create("Close all")
                                                .setKey("close-all-key")
                                                .withValue("close-all-value")
                                                .appendChild(PrefixAddOn.of(Icons.close_box_multiple().addCss(dui_font_size_5)))
                                        )

                                        .appendChild(Separator.create())
                                        .appendChild(CustomMenuItem.<String>create()
                                                .addCss(dui_hover_disabled)
                                                .setKey("custom-key")
                                                .withValue("custom-value")
                                                .setSelectable(false)
                                                .appendChild(div().addCss(dui_flex, dui_justify_center, dui_gap_6)
                                                        .appendChild(Icons.content_cut().addCss(dui_font_size_5).setTooltip("Cut").clickable())
                                                        .appendChild(Icons.content_copy().addCss(dui_font_size_5).setTooltip("Copy").clickable())
                                                        .appendChild(Icons.content_paste().addCss(dui_font_size_5).setTooltip("Paste").clickable())
                                                )
                                        )
                                        .appendChild(Separator.create())
                                        .appendChild(MenuItem.<String>create("Project structure")
                                                .setKey("structure-key")
                                                .withValue("structure-value")
                                                .appendChild(PrefixAddOn.of(Icons.folder_cog().addCss(dui_font_size_5)))
                                        )
                                        .appendChild(MenuItem.<String>create("Settings")
                                                .setKey("settings-key")
                                                .withValue("settings-value")
                                                .appendChild(PrefixAddOn.of(Icons.cog().addCss(dui_font_size_5)))
                                        )
                                        .appendChild(Separator.create())
                                        .appendChild(MenuItem.<String>create("Invalidate cache", "Takes effect after restart")
                                                .setKey("cache-key")
                                                .withValue("cache-value")
                                        )
                                        .appendChild(MenuItem.<String>create("Restart")
                                                .setKey("restart-key")
                                                .withValue("restart-value")
                                                .appendChild(PostfixAddOn.of(Icons.information()
                                                                .addCss(dui_font_size_5)
                                                                .setTooltip("Just a tool tip!")
                                                        )
                                                )
                                        )
                                        .addSelectionListener((source, selectedItems) -> {
                                            source.ifPresent(menuItem -> {
                                                Notification.create("Key : " + menuItem + ", value : " + menuItem.getValue()).show();
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

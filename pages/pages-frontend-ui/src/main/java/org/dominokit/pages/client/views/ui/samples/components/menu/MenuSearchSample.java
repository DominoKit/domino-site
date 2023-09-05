package org.dominokit.pages.client.views.ui.samples.components.menu;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.menu.Menu;
import org.dominokit.domino.ui.menu.MenuItem;
import org.dominokit.domino.ui.notifications.Notification;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.PostfixAddOn;
import org.dominokit.domino.ui.utils.PrefixAddOn;
import org.dominokit.domino.ui.utils.Separator;

public class MenuSearchSample extends BaseDominoElement<HTMLDivElement, MenuSearchSample> {

    private DivElement element;

    public static MenuSearchSample create() {
        return new MenuSearchSample();
    }

    public MenuSearchSample() {
        this.element = div().addCss(dui_p_2)
                .appendChild(Menu.<String>create()
                        .addCss(dui_w_96)
                        .setIcon(Icons.file())
                        .setTitle("Files")
                        .withHeader((menu, header) -> header
                                .appendChild(PostfixAddOn.of(Icons.folder_key_outline()
                                                .addCss(dui_font_size_5)
                                                .clickable()
                                                .addClickListener(evt -> {
                                                    Notification.create("Action clicked").show();
                                                })
                                        )
                                )
                                .appendChild(PostfixAddOn.of(Icons.folder_heart_outline()
                                                .addCss(dui_font_size_5)
                                                .clickable()
                                                .addClickListener(evt -> {
                                                    Notification.create("Action clicked").show();
                                                })
                                        )
                                )
                        )
                        .setSearchable(true)
                        .setMissingItemHandler((token, menu) -> menu.appendChild(MenuItem.create(token, "The item was initially missing")))
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
        ;
        init(this);
    }

    @Override
    public HTMLDivElement element() {
        return this.element.element();
    }
}

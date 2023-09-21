package org.dominokit.pages.client.views.ui.samples.components.tabs;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.badges.Badge;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.tabs.Tab;
import org.dominokit.domino.ui.tabs.TabsPanel;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.PostfixAddOn;

public class ColoredTabsSample extends BaseDominoElement<HTMLDivElement, ColoredTabsSample> {

    private DivElement element;

    public static ColoredTabsSample create() {
        return new ColoredTabsSample();
    }

    public ColoredTabsSample() {
        this.element = div().addCss(dui_p_2)
                .appendChild(Row.create()
                        .appendChild(Column.span6()
                                .appendChild(TabsPanel.create()
                                        .appendChild(Tab.create("HOME"))
                                        .appendChild(Tab.create("PROFILE"))
                                        .appendChild(Tab.create("MESSAGES").activate())
                                        .appendChild(Tab.create("SETTINGS"))
                                        .addCss(dui_accent_pink)
                                )
                                .appendChild(TabsPanel.create()
                                        .appendChild(Tab.create("HOME"))
                                        .appendChild(Tab.create("PROFILE"))
                                        .appendChild(Tab.create("MESSAGES").activate())
                                        .appendChild(Tab.create("SETTINGS"))
                                        .addCss(dui_accent_teal)
                                )
                                .appendChild(TabsPanel.create()
                                        .appendChild(Tab.create("HOME"))
                                        .appendChild(Tab.create("PROFILE"))
                                        .appendChild(Tab.create("MESSAGES").activate())
                                        .appendChild(Tab.create("SETTINGS"))
                                        .addCss(dui_accent_purple)
                                )
                        )
                        .appendChild(Column.span6()
                                .appendChild(TabsPanel.create()
                                        .appendChild(Tab.create("HOME"))
                                        .appendChild(Tab.create("PROFILE"))
                                        .appendChild(Tab.create("MESSAGES").activate())
                                        .appendChild(Tab.create("SETTINGS"))
                                        .addCss(dui_accent_red)
                                )
                                .appendChild(TabsPanel.create()
                                        .appendChild(Tab.create("HOME"))
                                        .appendChild(Tab.create("PROFILE"))
                                        .appendChild(Tab.create("MESSAGES").activate())
                                        .appendChild(Tab.create("SETTINGS"))
                                        .addCss(dui_accent_orange)
                                )
                                .appendChild(TabsPanel.create()
                                        .appendChild(Tab.create("HOME"))
                                        .appendChild(Tab.create("PROFILE"))
                                        .appendChild(Tab.create("MESSAGES").activate())
                                        .appendChild(Tab.create("SETTINGS"))
                                        .addCss(dui_accent_blue_grey)
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

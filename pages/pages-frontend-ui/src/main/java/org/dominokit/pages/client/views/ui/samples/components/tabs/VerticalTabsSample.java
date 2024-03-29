package org.dominokit.pages.client.views.ui.samples.components.tabs;

import static org.dominokit.domino.ui.utils.Domino.b;
import static org.dominokit.domino.ui.utils.Domino.div;
import static org.dominokit.domino.ui.utils.Domino.dui_h_96;
import static org.dominokit.domino.ui.utils.Domino.dui_p_2;
import static org.dominokit.domino.ui.utils.Domino.hr;
import static org.dominokit.domino.ui.utils.Domino.p;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.animations.Transition;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.tabs.FillItem;
import org.dominokit.domino.ui.tabs.HeaderDirection;
import org.dominokit.domino.ui.tabs.Tab;
import org.dominokit.domino.ui.tabs.TabsAlign;
import org.dominokit.domino.ui.tabs.TabsDirection;
import org.dominokit.domino.ui.tabs.TabsHeaderAlign;
import org.dominokit.domino.ui.tabs.TabsPanel;
import org.dominokit.domino.ui.typography.BlockHeader;
import org.dominokit.domino.ui.utils.BaseDominoElement;

public class VerticalTabsSample extends BaseDominoElement<HTMLDivElement, VerticalTabsSample> {

    private static final String SAMPLE_TEXT = "Lorem ipsum dolor sit amet, ut duo atqui exerci dicunt, ius impedit mediocritatem an. Pri ut tation electram moderatius. Per te suavitate democritum. Duis nemore probatus ne quo, ad liber essent aliquid pro. Et eos nusquam accumsan, vide mentitum fabellas ne est, eu munere gubergren sadipscing mel.";

    private DivElement element;

    public static VerticalTabsSample create() {
        return new VerticalTabsSample();
    }

    public VerticalTabsSample() {
        this.element = div().addCss(dui_p_2)
                .appendChild(BlockHeader.create("TABS ALIGNMENT"))
                .appendChild(Row.create()
                        .appendChild(Column.span4()
                                .appendChild(TabsPanel.create()
                                        .setTabsDirection(TabsDirection.VERTICAL)
                                        .setTabsAlign(TabsAlign.START)
                                        .appendChild(Tab.create("HOME")
                                                .appendChild(b().textContent("Home Content"))
                                                .appendChild(p(SAMPLE_TEXT)))
                                        .appendChild(Tab.create("PROFILE")
                                                .appendChild(b().textContent("Profile Content"))
                                                .appendChild(p(SAMPLE_TEXT)))
                                        .appendChild(Tab.create("MESSAGES")
                                                .appendChild(b().textContent("Messages Content"))
                                                .appendChild(p(SAMPLE_TEXT))
                                                .activate())
                                        .appendChild(Tab.create("SETTINGS")
                                                .appendChild(b().textContent("Settings Content"))
                                                .appendChild(p(SAMPLE_TEXT)))
                                )
                        )
                        .appendChild(Column.span4()
                                .appendChild(TabsPanel.create()
                                        .setTabsDirection(TabsDirection.VERTICAL)
                                        .setTabsAlign(TabsAlign.CENTER)
                                        .appendChild(Tab.create("HOME")
                                                .appendChild(b().textContent("Home Content"))
                                                .appendChild(p(SAMPLE_TEXT)))
                                        .appendChild(Tab.create("PROFILE")
                                                .appendChild(b().textContent("Profile Content"))
                                                .appendChild(p(SAMPLE_TEXT)))
                                        .appendChild(Tab.create("MESSAGES")
                                                .appendChild(b().textContent("Messages Content"))
                                                .appendChild(p(SAMPLE_TEXT))
                                                .activate())
                                        .appendChild(Tab.create("SETTINGS")
                                                .appendChild(b().textContent("Settings Content"))
                                                .appendChild(p(SAMPLE_TEXT)))
                                )
                        )
                        .appendChild(Column.span4()
                                .appendChild(TabsPanel.create()
                                        .setTabsDirection(TabsDirection.VERTICAL)
                                        .setTabsAlign(TabsAlign.END)
                                        .appendChild(Tab.create("HOME")
                                                .appendChild(b().textContent("Home Content"))
                                                .appendChild(p(SAMPLE_TEXT)))
                                        .appendChild(Tab.create("PROFILE")
                                                .appendChild(b().textContent("Profile Content"))
                                                .appendChild(p(SAMPLE_TEXT)))
                                        .appendChild(Tab.create("MESSAGES")
                                                .appendChild(b().textContent("Messages Content"))
                                                .appendChild(p(SAMPLE_TEXT))
                                                .activate())
                                        .appendChild(Tab.create("SETTINGS")
                                                .appendChild(b().textContent("Settings Content"))
                                                .appendChild(p(SAMPLE_TEXT)))
                                )
                        )
                )
                .appendChild(hr())
                .appendChild(BlockHeader.create("TABS HEADER ALIGNMENT"))
                .appendChild(Row.create()
                        .appendChild(Column.span4()
                                .appendChild(TabsPanel.create()
                                        .setTabsDirection(TabsDirection.VERTICAL)
                                        .setTabHeaderAlign(TabsHeaderAlign.LEFT)
                                        .appendChild(Tab.create("HOME")
                                                .appendChild(b().textContent("Home Content"))
                                                .appendChild(p(SAMPLE_TEXT)))
                                        .appendChild(Tab.create("PROFILE")
                                                .appendChild(b().textContent("Profile Content"))
                                                .appendChild(p(SAMPLE_TEXT)))
                                        .appendChild(Tab.create("MESSAGES")
                                                .appendChild(b().textContent("Messages Content"))
                                                .appendChild(p(SAMPLE_TEXT))
                                                .activate())
                                        .appendChild(Tab.create("SETTINGS")
                                                .appendChild(b().textContent("Settings Content"))
                                                .appendChild(p(SAMPLE_TEXT)))
                                )
                        )
                        .appendChild(Column.span4()
                                .appendChild(TabsPanel.create()
                                        .setTabsDirection(TabsDirection.VERTICAL)
                                        .setTabHeaderAlign(TabsHeaderAlign.CENTER)
                                        .appendChild(Tab.create("HOME")
                                                .appendChild(b().textContent("Home Content"))
                                                .appendChild(p(SAMPLE_TEXT)))
                                        .appendChild(Tab.create("PROFILE")
                                                .appendChild(b().textContent("Profile Content"))
                                                .appendChild(p(SAMPLE_TEXT)))
                                        .appendChild(Tab.create("MESSAGES")
                                                .appendChild(b().textContent("Messages Content"))
                                                .appendChild(p(SAMPLE_TEXT))
                                                .activate())
                                        .appendChild(Tab.create("SETTINGS")
                                                .appendChild(b().textContent("Settings Content"))
                                                .appendChild(p(SAMPLE_TEXT)))
                                )
                        )
                        .appendChild(Column.span4()
                                .appendChild(TabsPanel.create()
                                        .setTabsDirection(TabsDirection.VERTICAL)
                                        .setTabHeaderAlign(TabsHeaderAlign.RIGHT)
                                        .appendChild(Tab.create("HOME")
                                                .appendChild(b().textContent("Home Content"))
                                                .appendChild(p(SAMPLE_TEXT)))
                                        .appendChild(Tab.create("PROFILE")
                                                .appendChild(b().textContent("Profile Content"))
                                                .appendChild(p(SAMPLE_TEXT)))
                                        .appendChild(Tab.create("MESSAGES")
                                                .appendChild(b().textContent("Messages Content"))
                                                .appendChild(p(SAMPLE_TEXT))
                                                .activate())
                                        .appendChild(Tab.create("SETTINGS")
                                                .appendChild(b().textContent("Settings Content"))
                                                .appendChild(p(SAMPLE_TEXT)))
                                )
                        )
                )
                .appendChild(hr())
                .appendChild(BlockHeader.create("HEADER DIRECTION"))
                .appendChild(Row.create()
                        .appendChild(Column.span4()
                                .appendChild(TabsPanel.create()
                                        .setTabsDirection(TabsDirection.VERTICAL)
                                        .appendChild(Tab.create(Icons.home(), "HOME")
                                                .appendChild(b().textContent("Home Content"))
                                                .appendChild(p(SAMPLE_TEXT)))
                                        .appendChild(Tab.create(Icons.face_man(), "PROFILE")
                                                .appendChild(b().textContent("Profile Content"))
                                                .appendChild(p(SAMPLE_TEXT)))
                                        .appendChild(Tab.create(Icons.email(), "MESSAGES")
                                                .appendChild(b().textContent("Messages Content"))
                                                .appendChild(p(SAMPLE_TEXT))
                                                .activate())
                                        .appendChild(Tab.create(Icons.cog(), "SETTINGS")
                                                .appendChild(b().textContent("Settings Content"))
                                                .appendChild(p(SAMPLE_TEXT)))
                                )
                        )
                        .appendChild(Column.span4()
                                .appendChild(TabsPanel.create()
                                        .setTabsDirection(TabsDirection.VERTICAL)
                                        .setHeaderDirection(HeaderDirection.VERTICAL)
                                        .appendChild(Tab.create(Icons.home(), "HOME")
                                                .appendChild(b().textContent("Home Content"))
                                                .appendChild(p(SAMPLE_TEXT)))
                                        .appendChild(Tab.create(Icons.face_man(), "PROFILE")
                                                .appendChild(b().textContent("Profile Content"))
                                                .appendChild(p(SAMPLE_TEXT)))
                                        .appendChild(Tab.create(Icons.email(), "MESSAGES")
                                                .appendChild(b().textContent("Messages Content"))
                                                .appendChild(p(SAMPLE_TEXT))
                                                .activate())
                                        .appendChild(Tab.create(Icons.cog(), "SETTINGS")
                                                .appendChild(b().textContent("Settings Content"))
                                                .appendChild(p(SAMPLE_TEXT)))
                                )
                        )
                        .appendChild(Column.span4()
                                .appendChild(TabsPanel.create()
                                        .setTabsDirection(TabsDirection.VERTICAL)
                                        .setHeaderDirection(HeaderDirection.VERTICAL_REVERSED)
                                        .appendChild(Tab.create(Icons.home(), "HOME")
                                                .appendChild(b().textContent("Home Content"))
                                                .appendChild(p(SAMPLE_TEXT)))
                                        .appendChild(Tab.create(Icons.face_man(), "PROFILE")
                                                .appendChild(b().textContent("Profile Content"))
                                                .appendChild(p(SAMPLE_TEXT)))
                                        .appendChild(Tab.create(Icons.email(), "MESSAGES")
                                                .appendChild(b().textContent("Messages Content"))
                                                .appendChild(p(SAMPLE_TEXT))
                                                .activate())
                                        .appendChild(Tab.create(Icons.cog(), "SETTINGS")
                                                .appendChild(b().textContent("Settings Content"))
                                                .appendChild(p(SAMPLE_TEXT)))
                                )
                        )
                )
                .appendChild(hr())
                .appendChild(Row.create()
                        .appendChild(Column.span12()
                                .appendChild(TabsPanel.create()
                                        .addCss(dui_h_96)
                                        .setTabsDirection(TabsDirection.VERTICAL)
                                        .setTabsAlign(TabsAlign.START)
                                        .setTransition(Transition.FADE_IN)
                                        .appendChild(Tab.create(Icons.home(), "HOME")
                                                .appendChild(b().textContent("Home Content"))
                                                .appendChild(p(SAMPLE_TEXT)))
                                        .appendChild(Tab.create(Icons.face_man(), "PROFILE")
                                                .appendChild(b().textContent("Profile Content"))
                                                .appendChild(p(SAMPLE_TEXT)))
                                        .appendChild(Tab.create(Icons.email(), "MESSAGES")
                                                .appendChild(b().textContent("Messages Content"))
                                                .appendChild(p(SAMPLE_TEXT))
                                                .activate())
                                        .appendChild(FillItem.create())
                                        .appendChild(Tab.create(Icons.cog(), "SETTINGS")
                                                .appendChild(b().textContent("Settings Content"))
                                                .appendChild(p(SAMPLE_TEXT)))
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

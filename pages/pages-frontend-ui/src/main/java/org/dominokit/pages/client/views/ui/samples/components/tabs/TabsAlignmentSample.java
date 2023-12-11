package org.dominokit.pages.client.views.ui.samples.components.tabs;

import static org.dominokit.domino.ui.utils.Domino.b;
import static org.dominokit.domino.ui.utils.Domino.div;
import static org.dominokit.domino.ui.utils.Domino.dui_p_2;
import static org.dominokit.domino.ui.utils.Domino.p;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.tabs.Tab;
import org.dominokit.domino.ui.tabs.TabsAlign;
import org.dominokit.domino.ui.tabs.TabsPanel;
import org.dominokit.domino.ui.utils.BaseDominoElement;

public class TabsAlignmentSample extends BaseDominoElement<HTMLDivElement, TabsAlignmentSample> {

    private static final String SAMPLE_TEXT = "Lorem ipsum dolor sit amet, ut duo atqui exerci dicunt, ius impedit mediocritatem an. Pri ut tation electram moderatius. Per te suavitate democritum. Duis nemore probatus ne quo, ad liber essent aliquid pro. Et eos nusquam accumsan, vide mentitum fabellas ne est, eu munere gubergren sadipscing mel.";

    private DivElement element;

    public static TabsAlignmentSample create() {
        return new TabsAlignmentSample();
    }

    public TabsAlignmentSample() {
        this.element = div().addCss(dui_p_2)
                .appendChild(TabsPanel.create()
                        .setTabsAlign(TabsAlign.START)
                        .appendChild(Tab.create(Icons.home(), " HOME")
                                .appendChild(b().textContent("Home Content"))
                                .appendChild(p(SAMPLE_TEXT)))
                        .appendChild(Tab.create(Icons.face_man(), " PROFILE")
                                .appendChild(b().textContent("Profile Content"))
                                .appendChild(p(SAMPLE_TEXT)))
                        .appendChild(Tab.create(Icons.email(), " MESSAGES")
                                .appendChild(b().textContent("Messages Content"))
                                .appendChild(p(SAMPLE_TEXT))
                                .activate())
                        .appendChild(Tab.create(Icons.cog(), " SETTINGS")
                                .appendChild(b().textContent("Settings Content"))
                                .appendChild(p(SAMPLE_TEXT)))
                )
                .appendChild(TabsPanel.create()
                        .setTabsAlign(TabsAlign.CENTER)
                        .appendChild(Tab.create(Icons.home(), " HOME")
                                .appendChild(b().textContent("Home Content"))
                                .appendChild(p(SAMPLE_TEXT)))
                        .appendChild(Tab.create(Icons.face_man(), " PROFILE")
                                .appendChild(b().textContent("Profile Content"))
                                .appendChild(p(SAMPLE_TEXT)))
                        .appendChild(Tab.create(Icons.email(), " MESSAGES")
                                .appendChild(b().textContent("Messages Content"))
                                .appendChild(p(SAMPLE_TEXT))
                                .activate())
                        .appendChild(Tab.create(Icons.cog(), " SETTINGS")
                                .appendChild(b().textContent("Settings Content"))
                                .appendChild(p(SAMPLE_TEXT)))
                )
                .appendChild(TabsPanel.create()
                        .setTabsAlign(TabsAlign.END)
                        .appendChild(Tab.create(Icons.home(), " HOME")
                                .appendChild(b().textContent("Home Content"))
                                .appendChild(p(SAMPLE_TEXT)))
                        .appendChild(Tab.create(Icons.face_man(), " PROFILE")
                                .appendChild(b().textContent("Profile Content"))
                                .appendChild(p(SAMPLE_TEXT)))
                        .appendChild(Tab.create(Icons.email(), " MESSAGES")
                                .appendChild(b().textContent("Messages Content"))
                                .appendChild(p(SAMPLE_TEXT))
                                .activate())
                        .appendChild(Tab.create(Icons.cog(), " SETTINGS")
                                .appendChild(b().textContent("Settings Content"))
                                .appendChild(p(SAMPLE_TEXT)))
                )
        ;
        init(this);
    }

    @Override
    public HTMLDivElement element() {
        return this.element.element();
    }
}

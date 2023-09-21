package org.dominokit.pages.client.views.ui.samples.components.tabs;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.badges.Badge;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.tabs.Tab;
import org.dominokit.domino.ui.tabs.TabsPanel;
import org.dominokit.domino.ui.typography.BlockHeader;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.PostfixAddOn;

public class TabsContentSample extends BaseDominoElement<HTMLDivElement, TabsContentSample> {

    private static final String SAMPLE_TEXT = "Lorem ipsum dolor sit amet, ut duo atqui exerci dicunt, ius impedit mediocritatem an. Pri ut tation electram moderatius. Per te suavitate democritum. Duis nemore probatus ne quo, ad liber essent aliquid pro. Et eos nusquam accumsan, vide mentitum fabellas ne est, eu munere gubergren sadipscing mel.";

    private DivElement element;

    public static TabsContentSample create() {
        return new TabsContentSample();
    }

    public TabsContentSample() {

        DivElement contentContainer = div()
                .appendChild(BlockHeader.create("TAB CONTENT"))
                .addCss(dui_m_12, dui_p_6)
                .addCss(dui_elevation_1);

        this.element = div().addCss(dui_p_2)
                .appendChild(TabsPanel.create()
                        .setContentContainer(contentContainer)
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
                .appendChild(contentContainer)
        ;
        init(this);
    }

    @Override
    public HTMLDivElement element() {
        return this.element.element();
    }
}

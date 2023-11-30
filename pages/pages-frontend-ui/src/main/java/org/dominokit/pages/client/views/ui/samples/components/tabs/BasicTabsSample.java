package org.dominokit.pages.client.views.ui.samples.components.tabs;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.tabs.FillItem;
import org.dominokit.domino.ui.tabs.Tab;
import org.dominokit.domino.ui.tabs.TabsPanel;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.PostfixAddOn;
import org.dominokit.domino.ui.utils.PrefixAddOn;

import static org.dominokit.domino.ui.utils.Domino.*;

public class BasicTabsSample extends BaseDominoElement<HTMLDivElement, BasicTabsSample> {

    private static final String SAMPLE_TEXT = "Lorem ipsum dolor sit amet, ut duo atqui exerci dicunt, ius impedit mediocritatem an. Pri ut tation electram moderatius. Per te suavitate democritum. Duis nemore probatus ne quo, ad liber essent aliquid pro. Et eos nusquam accumsan, vide mentitum fabellas ne est, eu munere gubergren sadipscing mel.";

    private DivElement element;

    public static BasicTabsSample create() {
        return new BasicTabsSample();
    }

    public BasicTabsSample() {
        this.element = div().addCss(dui_p_2)
                .appendChild(TabsPanel.create()
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
                .appendChild(TabsPanel.create()
                        .appendChild(Tab.create(Icons.home())
                                .appendChild(b().textContent("Home Content"))
                                .appendChild(p(SAMPLE_TEXT)))
                        .appendChild(Tab.create(Icons.face_man())
                                .appendChild(b().textContent("Profile Content"))
                                .appendChild(p(SAMPLE_TEXT)))
                        .appendChild(Tab.create(Icons.email())
                                .appendChild(b().textContent("Messages Content"))
                                .appendChild(p(SAMPLE_TEXT))
                                .activate())
                        .appendChild(Tab.create(Icons.cog())
                                .appendChild(b().textContent("Settings Content"))
                                .appendChild(p(SAMPLE_TEXT)))
                )
                .appendChild(TabsPanel.create()
                        .appendChild(PrefixAddOn.of(Icons.menu().clickable()))
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
                        .appendChild(FillItem.create())
                        .appendChild(PostfixAddOn.of(Icons.dots_vertical().clickable()))
                )
        ;
        init(this);
    }

    @Override
    public HTMLDivElement element() {
        return this.element.element();
    }
}

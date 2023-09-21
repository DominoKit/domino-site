package org.dominokit.pages.client.views.ui.samples.components.tabs;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.badges.Badge;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.tabs.FillItem;
import org.dominokit.domino.ui.tabs.Tab;
import org.dominokit.domino.ui.tabs.TabsPanel;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.PostfixAddOn;
import org.dominokit.domino.ui.utils.PrefixAddOn;

public class ClosableTabsSample extends BaseDominoElement<HTMLDivElement, ClosableTabsSample> {

    private static final String SAMPLE_TEXT = "Lorem ipsum dolor sit amet, ut duo atqui exerci dicunt, ius impedit mediocritatem an. Pri ut tation electram moderatius. Per te suavitate democritum. Duis nemore probatus ne quo, ad liber essent aliquid pro. Et eos nusquam accumsan, vide mentitum fabellas ne est, eu munere gubergren sadipscing mel.";

    private DivElement element;

    public static ClosableTabsSample create() {
        return new ClosableTabsSample();
    }

    public ClosableTabsSample() {
        this.element = div().addCss(dui_p_2)
                .appendChild(TabsPanel.create()
                        .appendChild(Tab.create(Icons.home(), " HOME")
                                .withHeader((parent, header) -> header.appendChild(PostfixAddOn.of(Badge.create("15+").addCss(dui_rounded_full))))
                                .appendChild(b().textContent("Home Content"))
                                .appendChild(p(SAMPLE_TEXT))
                                .setClosable(true)
                        )
                        .appendChild(Tab.create(Icons.face_man(), " PROFILE")
                                .appendChild(b().textContent("Profile Content"))
                                .appendChild(p(SAMPLE_TEXT))
                                .setClosable(true)
                        )
                        .appendChild(Tab.create(Icons.email(), " MESSAGES")
                                .appendChild(b().textContent("Messages Content"))
                                .appendChild(p(SAMPLE_TEXT))
                                .activate()
                                .setClosable(true)
                        )
                        .appendChild(Tab.create(Icons.cog(), " SETTINGS")
                                .withHeader((parent, header) -> header.appendChild(PostfixAddOn.of(Badge.create("new").addCss(dui_rounded_full))))
                                .appendChild(b().textContent("Settings Content"))
                                .appendChild(p(SAMPLE_TEXT))
                                .setClosable(true)
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

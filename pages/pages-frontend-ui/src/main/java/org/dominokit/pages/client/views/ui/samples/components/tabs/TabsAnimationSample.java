package org.dominokit.pages.client.views.ui.samples.components.tabs;

import static org.dominokit.domino.ui.utils.Domino.b;
import static org.dominokit.domino.ui.utils.Domino.div;
import static org.dominokit.domino.ui.utils.Domino.dui_p_2;
import static org.dominokit.domino.ui.utils.Domino.p;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.animations.Transition;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.tabs.Tab;
import org.dominokit.domino.ui.tabs.TabsPanel;
import org.dominokit.domino.ui.utils.BaseDominoElement;

public class TabsAnimationSample extends BaseDominoElement<HTMLDivElement, TabsAnimationSample> {

    private static final String SAMPLE_TEXT = "Lorem ipsum dolor sit amet, ut duo atqui exerci dicunt, ius impedit mediocritatem an. Pri ut tation electram moderatius. Per te suavitate democritum. Duis nemore probatus ne quo, ad liber essent aliquid pro. Et eos nusquam accumsan, vide mentitum fabellas ne est, eu munere gubergren sadipscing mel.";

    private DivElement element;

    public static TabsAnimationSample create() {
        return new TabsAnimationSample();
    }

    public TabsAnimationSample() {
        this.element = div().addCss(dui_p_2)
                .appendChild(Row.create()
                        .span6(TabsPanel.create()
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
                                .setTransition(Transition.ROTATE_IN_UP_LEFT)
                        )
                        .span6(TabsPanel.create()
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
                                .setTransition(Transition.FADE_IN_RIGHT)
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

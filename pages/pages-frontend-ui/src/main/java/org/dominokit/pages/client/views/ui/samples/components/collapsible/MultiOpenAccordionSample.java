package org.dominokit.pages.client.views.ui.samples.components.collapsible;

import static org.dominokit.domino.ui.utils.Domino.div;
import static org.dominokit.domino.ui.utils.Domino.dui_accent;
import static org.dominokit.domino.ui.utils.Domino.dui_bg_accent_d_3;
import static org.dominokit.domino.ui.utils.Domino.dui_bg_orange_d_3;
import static org.dominokit.domino.ui.utils.Domino.dui_bg_primary_d_3;
import static org.dominokit.domino.ui.utils.Domino.dui_bg_teal_d_3;
import static org.dominokit.domino.ui.utils.Domino.dui_fg_accent;
import static org.dominokit.domino.ui.utils.Domino.dui_orange;
import static org.dominokit.domino.ui.utils.Domino.dui_p_2;
import static org.dominokit.domino.ui.utils.Domino.dui_primary;
import static org.dominokit.domino.ui.utils.Domino.dui_rounded_full;
import static org.dominokit.domino.ui.utils.Domino.dui_success;
import static org.dominokit.domino.ui.utils.Domino.dui_teal;
import static org.dominokit.domino.ui.utils.Domino.dui_w_28;
import static org.dominokit.domino.ui.utils.Domino.dui_warning;
import static org.dominokit.domino.ui.utils.Domino.text;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.badges.Badge;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.button.LinkButton;
import org.dominokit.domino.ui.collapsible.Accordion;
import org.dominokit.domino.ui.collapsible.AccordionPanel;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.PostfixAddOn;
import org.dominokit.domino.ui.utils.PrefixAddOn;

public class MultiOpenAccordionSample extends BaseDominoElement<HTMLDivElement, MultiOpenAccordionSample> {

    private static final String SAMPLE_CONTENT = "Quis pharetra a pharetra fames blandit. Risus faucibus velit Risus imperdiet mattis neque volutpat, etiam lacinia netus dictum magnis per facilisi sociosqu. Volutpat. Ridiculus nostra.";

    private DivElement element;

    public static MultiOpenAccordionSample create() {
        return new MultiOpenAccordionSample();
    }

    public MultiOpenAccordionSample() {
        this.element = div().addCss(dui_p_2)
                .appendChild(Accordion.create()
                        .setMultiOpen(true)
                        .appendChild(AccordionPanel.create("Collapsible item 1")
                                .withHeader((parent, header) -> header
                                        .addCss(dui_accent)
                                        .appendChild(PrefixAddOn.of(Icons.bus_clock()))
                                        .appendChild(PostfixAddOn.of(Badge.create("15").addCss(dui_rounded_full, dui_bg_accent_d_3)))
                                        .appendChild(PostfixAddOn.of(Icons.clock_end()))
                                )
                                .withContentHeader((parent, contentHeader) -> contentHeader
                                        .setTitle("Content header")
                                        .appendChild(PrefixAddOn.of(Icons.clock_alert_outline()))
                                        .appendChild(PostfixAddOn.of(Badge.create("On time").addCss(dui_rounded_full, dui_warning)))
                                        .appendChild(PostfixAddOn.of(Icons.clock_in().addCss(dui_fg_accent)))
                                )
                                .withContentFooter((parent, footer) -> footer
                                        .appendChild(PrefixAddOn.of(Icons.dots_vertical().clickable()))
                                        .appendChild(PostfixAddOn.of(LinkButton.create("Remove")))
                                        .appendChild(PostfixAddOn.of(Button.create("Accept").addCss(dui_success, dui_w_28)))
                                )
                                .appendChild(text(SAMPLE_CONTENT))
                                .expand()
                        )
                        .appendChild(AccordionPanel.create("Collapsible item 2")
                                .withHeader((parent, header) -> header
                                        .addCss(dui_primary)
                                        .appendChild(PrefixAddOn.of(Icons.bus_clock()))
                                        .appendChild(PostfixAddOn.of(Badge.create("15").addCss(dui_rounded_full, dui_bg_primary_d_3)))
                                        .appendChild(PostfixAddOn.of(Icons.clock_end()))
                                )
                                .withContentHeader((parent, contentHeader) -> contentHeader
                                        .setTitle("Content header")
                                        .appendChild(PrefixAddOn.of(Icons.clock_alert_outline()))
                                        .appendChild(PostfixAddOn.of(Badge.create("On time").addCss(dui_rounded_full, dui_warning)))
                                        .appendChild(PostfixAddOn.of(Icons.clock_in().addCss(dui_fg_accent)))
                                )
                                .withContentFooter((parent, footer) -> footer
                                        .appendChild(PrefixAddOn.of(Icons.dots_vertical().clickable()))
                                        .appendChild(PostfixAddOn.of(LinkButton.create("Remove")))
                                        .appendChild(PostfixAddOn.of(Button.create("Accept").addCss(dui_success, dui_w_28)))
                                )
                                .appendChild(text(SAMPLE_CONTENT))
                        )
                        .appendChild(AccordionPanel.create("Collapsible item 3")
                                .withHeader((parent, header) -> header
                                        .addCss(dui_teal)
                                        .appendChild(PrefixAddOn.of(Icons.bus_clock()))
                                        .appendChild(PostfixAddOn.of(Badge.create("15").addCss(dui_rounded_full, dui_bg_teal_d_3)))
                                        .appendChild(PostfixAddOn.of(Icons.clock_end()))
                                )
                                .withContentHeader((parent, contentHeader) -> contentHeader
                                        .setTitle("Content header")
                                        .appendChild(PrefixAddOn.of(Icons.clock_alert_outline()))
                                        .appendChild(PostfixAddOn.of(Badge.create("On time").addCss(dui_rounded_full, dui_warning)))
                                        .appendChild(PostfixAddOn.of(Icons.clock_in().addCss(dui_fg_accent)))
                                )
                                .withContentFooter((parent, footer) -> footer
                                        .appendChild(PrefixAddOn.of(Icons.dots_vertical().clickable()))
                                        .appendChild(PostfixAddOn.of(LinkButton.create("Remove")))
                                        .appendChild(PostfixAddOn.of(Button.create("Accept").addCss(dui_success, dui_w_28)))
                                )
                                .appendChild(text(SAMPLE_CONTENT))
                        )
                        .appendChild(AccordionPanel.create("Collapsible item 4")
                                .withHeader((parent, header) -> header
                                        .addCss(dui_orange)
                                        .appendChild(PrefixAddOn.of(Icons.bus_clock()))
                                        .appendChild(PostfixAddOn.of(Badge.create("15").addCss(dui_rounded_full, dui_bg_orange_d_3)))
                                        .appendChild(PostfixAddOn.of(Icons.clock_end()))
                                )
                                .withContentHeader((parent, contentHeader) -> contentHeader
                                        .setTitle("Content header")
                                        .appendChild(PrefixAddOn.of(Icons.clock_alert_outline()))
                                        .appendChild(PostfixAddOn.of(Badge.create("On time").addCss(dui_rounded_full, dui_warning)))
                                        .appendChild(PostfixAddOn.of(Icons.clock_in().addCss(dui_fg_accent)))
                                )
                                .withContentFooter((parent, footer) -> footer
                                        .appendChild(PrefixAddOn.of(Icons.dots_vertical().clickable()))
                                        .appendChild(PostfixAddOn.of(LinkButton.create("Remove")))
                                        .appendChild(PostfixAddOn.of(Button.create("Accept").addCss(dui_success, dui_w_28)))
                                )
                                .appendChild(text(SAMPLE_CONTENT))
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

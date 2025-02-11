package org.dominokit.pages.client.views.ui.samples.components.navbar;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.layout.NavBar;
import org.dominokit.domino.ui.utils.BaseDominoElement;

import static org.dominokit.domino.ui.utils.Domino.*;

public class SimpleNavBarSample extends BaseDominoElement<HTMLDivElement, SimpleNavBarSample> {

    private DivElement element;

    public static SimpleNavBarSample create() {
        return new SimpleNavBarSample();
    }

    public SimpleNavBarSample() {
        this.element = div()
                .addCss(dui_p_2)
                .appendChild(div()
                        .addCss(dui_flex, dui_flex_col, dui_gap_4)
                        .appendChild(NavBar.create("Section title")
                                .addCss(dui_accent, dui_h_12, dui_p_x_4)
                        )
                        .appendChild(NavBar.create("Section title")
                                .addCss(dui_accent, dui_h_12, dui_p_x_4)
                                .setDescription("description goes here")
                        )
                );
        init(this);


    }

    @Override
    public HTMLDivElement element() {
        return this.element.element();
    }
}

package org.dominokit.pages.client.views.ui.samples.components.navbar;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.layout.NavBar;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.PostfixAddOn;
import org.dominokit.domino.ui.utils.PrefixAddOn;

import static org.dominokit.domino.ui.utils.Domino.*;

public class NavBarAddonsSample extends BaseDominoElement<HTMLDivElement, NavBarAddonsSample> {

    private DivElement element;

    public static NavBarAddonsSample create() {
        return new NavBarAddonsSample();
    }

    public NavBarAddonsSample() {
        this.element = div()
                .addCss(dui_p_2)
                .appendChild(div().addCss(dui_flex, dui_flex_col, dui_gap_4)
                        .appendChild(NavBar.create("Section title")
                                .addCss(dui_accent, dui_h_12, dui_p_x_4)
                                .appendChild(PrefixAddOn.of(Icons.view_headline().clickable()))
                                .appendChild(PostfixAddOn.of(Icons.bell().clickable()))
                                .appendChild(PostfixAddOn.of(Icons.cog().clickable()))
                        )
                        .appendChild(NavBar.create("Section title")
                                .addCss(dui_accent, dui_h_12, dui_p_x_4)
                                .setDescription("description goes here")
                                .withPrefixElement((parent, self) ->
                                        self.appendChild(Icons.view_headline().clickable())
                                )
                                .withPostfixElement((parent, self) -> self
                                        .appendChild(Icons.bell().clickable())
                                        .appendChild(Icons.cog().clickable())
                                )
                        )
                );
        init(this);


    }

    @Override
    public HTMLDivElement element() {
        return this.element.element();
    }
}

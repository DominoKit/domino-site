package org.dominokit.pages.client.views.ui.samples.components.buttons;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.button.DropdownButton;
import org.dominokit.domino.ui.button.LinkButton;
import org.dominokit.domino.ui.button.group.ButtonsGroup;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.menu.Menu;
import org.dominokit.domino.ui.menu.MenuItem;
import org.dominokit.domino.ui.typography.BlockHeader;
import org.dominokit.domino.ui.utils.BaseDominoElement;

import static org.dominokit.domino.ui.menu.direction.DropDirection.*;
import static org.dominokit.domino.ui.utils.Domino.*;

public class ButtonsDropDownSample extends BaseDominoElement<HTMLDivElement, ButtonsDropDownSample> {

    private DivElement element;

    public static ButtonsDropDownSample create() {
        return new ButtonsDropDownSample();
    }

    public ButtonsDropDownSample() {
        this.element = div().addCss(dui_p_2, dui_flex, dui_flex_col, dui_gap_4, dui_justify_center)
                .appendChild(BlockHeader.create("DROPDOWN BUTTONS").addCss(dui_text_center))
                .appendChild(Row.create()
                        .span3(ButtonsGroup.create()
                                .appendChild(Button.create("1"))
                                .appendChild(Button.create("2"))
                                .appendChild(DropdownButton.create(
                                                Button.create("DROPDOWN"),
                                                Menu.create()
                                                        .appendChild(MenuItem.create("Action"))
                                                        .appendChild(MenuItem.create("Another action"))
                                                        .setDropDirection(BOTTOM_RIGHT)
                                        )
                                ).addCss(dui_m_1)
                        )
                        .span3(ButtonsGroup.create()
                                .appendChild(Button.create("1"))
                                .appendChild(Button.create("2"))
                                .appendChild(DropdownButton.create(
                                                Button.create("DROPDOWN"),
                                                Menu.create()
                                                        .appendChild(MenuItem.create("Action"))
                                                        .appendChild(MenuItem.create("Another action"))
                                                        .setDropDirection(BOTTOM_RIGHT)
                                        )
                                ).addCss(dui_primary, dui_m_1)
                        )
                        .span3(ButtonsGroup.create()
                                .appendChild(Button.create("1"))
                                .appendChild(Button.create("2"))
                                .appendChild(DropdownButton.create(
                                                Button.create("DROPDOWN"),
                                                Menu.create()
                                                        .appendChild(MenuItem.create("Action"))
                                                        .appendChild(MenuItem.create("Another action"))
                                                        .setDropDirection(BOTTOM_RIGHT)
                                        )
                                ).addCss(dui_accent, dui_m_1)
                        )
                        .span3(ButtonsGroup.create()
                                .appendChild(Button.create("1"))
                                .appendChild(Button.create("2"))
                                .appendChild(DropdownButton.create(
                                                Button.create("DROPDOWN"),
                                                Menu.create()
                                                        .appendChild(MenuItem.create("Action"))
                                                        .appendChild(MenuItem.create("Another action"))
                                                        .setDropDirection(BOTTOM_RIGHT)
                                        )
                                ).addCss(dui_warning, dui_m_1)
                        )
                )
                .appendChild(BlockHeader.create("DROPDOWN DIRECTION").addCss(dui_text_center))
                .appendChild(Row.create()
                        .span2(DropdownButton.create(
                                        LinkButton.create("TOP MIDDLE").addCss(dui_m_1),
                                        Menu.create()
                                                .appendChild(MenuItem.create("Action"))
                                                .appendChild(MenuItem.create("Another action"))
                                                .setDropDirection(TOP_MIDDLE)
                                )
                        )
                        .span2(DropdownButton.create(
                                        LinkButton.create("BOTTOM MIDDLE").addCss(dui_m_1),
                                        Menu.create()
                                                .appendChild(MenuItem.create("Action"))
                                                .appendChild(MenuItem.create("Another action"))
                                                .setDropDirection(BOTTOM_MIDDLE)
                                )
                        )
                        .span2(DropdownButton.create(
                                        LinkButton.create("TOP LEFT").addCss(dui_m_1),
                                        Menu.create()
                                                .appendChild(MenuItem.create("Action"))
                                                .appendChild(MenuItem.create("Another action"))
                                                .setDropDirection(TOP_LEFT)
                                )
                        )
                        .span2(DropdownButton.create(
                                        LinkButton.create("TOP RIGHT").addCss(dui_m_1),
                                        Menu.create()
                                                .appendChild(MenuItem.create("Action"))
                                                .appendChild(MenuItem.create("Another action"))
                                                .setDropDirection(TOP_RIGHT)
                                )
                        )
                        .span2(DropdownButton.create(
                                        LinkButton.create("BOTTOM LEFT").addCss(dui_m_1),
                                        Menu.create()
                                                .appendChild(MenuItem.create("Action"))
                                                .appendChild(MenuItem.create("Another action"))
                                                .setDropDirection(BOTTOM_LEFT)
                                )
                        )
                        .span2(DropdownButton.create(
                                        LinkButton.create("BOTTOM RIGHT").addCss(dui_m_1),
                                        Menu.create()
                                                .appendChild(MenuItem.create("Action"))
                                                .appendChild(MenuItem.create("Another action"))
                                                .setDropDirection(BOTTOM_RIGHT)
                                )
                        )
                )
                .appendChild(BlockHeader.create("SPLIT BUTTONS").addCss(dui_text_center))
                .appendChild(Row.create()
                        .span3(ButtonsGroup.create(
                                        Button.create("DEFAULT").addCss(dui_w_28),
                                        DropdownButton.create(
                                                Button.create(Icons.chevron_down()),
                                                Menu.create()
                                                        .appendChild(MenuItem.create("Action"))
                                                        .appendChild(MenuItem.create("Another action"))
                                                        .setDropDirection(BOTTOM_RIGHT)
                                        )
                                ).addCss(dui_m_1)
                        )
                        .span3(ButtonsGroup.create(
                                        Button.create(Icons.home()),
                                        DropdownButton.create(
                                                Button.create(Icons.chevron_down()),
                                                Menu.create()
                                                        .appendChild(MenuItem.create("Action"))
                                                        .appendChild(MenuItem.create("Another action"))
                                                        .setDropDirection(BOTTOM_RIGHT)
                                        )
                                ).addCss(dui_m_1)
                        )
                        .span3(ButtonsGroup.create(
                                        Button.create("DEFAULT"),
                                        DropdownButton.create(
                                                Button.create(Icons.chevron_down()),
                                                Menu.create()
                                                        .appendChild(MenuItem.create("Action"))
                                                        .appendChild(MenuItem.create("Another action"))
                                                        .setDropDirection(BOTTOM_RIGHT)
                                        )
                                ).addCss(dui_m_1, dui_primary)
                        )
                        .span3(ButtonsGroup.create(
                                        Button.create("DEFAULT"),
                                        DropdownButton.create(
                                                Button.create(Icons.chevron_down()),
                                                Menu.create()
                                                        .appendChild(MenuItem.create("Action"))
                                                        .appendChild(MenuItem.create("Another action"))
                                                        .setDropDirection(BOTTOM_RIGHT)
                                        )
                                ).addCss(dui_m_1, dui_accent)
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

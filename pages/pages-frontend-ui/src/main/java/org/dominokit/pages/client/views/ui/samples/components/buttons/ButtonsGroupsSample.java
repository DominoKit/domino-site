package org.dominokit.pages.client.views.ui.samples.components.buttons;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.button.ButtonsToolbar;
import org.dominokit.domino.ui.button.DropdownButton;
import org.dominokit.domino.ui.button.LinkButton;
import org.dominokit.domino.ui.button.group.ButtonsGroup;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.forms.CheckBox;
import org.dominokit.domino.ui.forms.TextBox;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.menu.Menu;
import org.dominokit.domino.ui.menu.MenuItem;
import org.dominokit.domino.ui.typography.BlockHeader;
import org.dominokit.domino.ui.utils.BaseDominoElement;

import static org.dominokit.domino.ui.menu.direction.DropDirection.BOTTOM_RIGHT;

public class ButtonsGroupsSample extends BaseDominoElement<HTMLDivElement, ButtonsGroupsSample> {

    private DivElement element;

    public static ButtonsGroupsSample create() {
        return new ButtonsGroupsSample();
    }

    public ButtonsGroupsSample() {
        this.element = div().addCss(dui_p_2, dui_flex, dui_flex_col, dui_gap_4, dui_justify_center)
                .appendChild(BlockHeader.create("GROUPS").addCss(dui_text_center))
                .appendChild(Row.create()
                        .span3(ButtonsGroup.create()
                                .addCss(dui_m_4)
                                .appendChild(Button.create("LEFT"))
                                .appendChild(Button.create("MIDDLE"))
                                .appendChild(Button.create("RIGHT"))
                        )
                        .span3(ButtonsGroup.create().addCss(dui_primary)
                                .addCss(dui_m_4)
                                .appendChild(Button.create("LEFT"))
                                .appendChild(Button.create("MIDDLE"))
                                .appendChild(Button.create("RIGHT"))
                        )
                        .span3(ButtonsGroup.create().addCss(dui_success)
                                .addCss(dui_m_4)
                                .appendChild(Button.create("LEFT"))
                                .appendChild(Button.create("MIDDLE"))
                                .appendChild(Button.create("RIGHT"))
                        )
                        .span3(ButtonsGroup.create().addCss(dui_accent)
                                .addCss(dui_m_4)
                                .appendChild(Button.create("LEFT"))
                                .appendChild(Button.create("MIDDLE"))
                                .appendChild(Button.create("RIGHT"))
                        )
                )
                .appendChild(BlockHeader.create("Vertical group").addCss(dui_text_center))
                .appendChild(div().addCss(dui_flex, dui_justify_center, dui_gap_2)
                        .appendChild(ButtonsGroup.create()
                                .addCss(dui_vertical, dui_m_1)
                                .appendChild(Button.create("Button"))
                                .appendChild(Button.create("Button").addCss(dui_primary))
                                .appendChild(DropdownButton.create(
                                                Button.create("DROPDOWN"),
                                                Menu.create()
                                                        .appendChild(MenuItem.create("Action"))
                                                        .appendChild(MenuItem.create("Another action"))
                                                        .setDropDirection(BOTTOM_RIGHT)
                                        )
                                )
                                .appendChild(Button.create("Button").addCss(dui_error))
                        )
                )
                .appendChild(BlockHeader.create("TOOLBARS").addCss(dui_text_center))
                .appendChild(Row.create()
                        .span6(ButtonsToolbar.create()
                                .appendChild(ButtonsGroup.create()
                                        .addCss(dui_m_1)
                                        .appendChild(Button.create("1"))
                                        .appendChild(Button.create("2"))
                                        .appendChild(Button.create("3"))
                                )
                                .appendChild(ButtonsGroup.create()
                                        .addCss(dui_m_1)
                                        .appendChild(Button.create("4"))
                                        .appendChild(Button.create("5"))
                                        .appendChild(Button.create("6"))
                                )
                                .appendChild(ButtonsGroup.create()
                                        .addCss(dui_m_1)
                                        .appendChild(Button.create("7"))
                                )
                        )
                        .span6(ButtonsToolbar.create()
                                .appendChild(ButtonsGroup.create()
                                        .addCss(dui_m_1)
                                        .appendChild(Button.create("8"))
                                        .appendChild(Button.create("9"))
                                        .appendChild(Button.create("10"))
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

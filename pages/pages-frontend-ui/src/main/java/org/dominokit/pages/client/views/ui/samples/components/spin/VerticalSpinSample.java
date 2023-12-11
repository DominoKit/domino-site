package org.dominokit.pages.client.views.ui.samples.components.spin;

import static org.dominokit.domino.ui.utils.Domino.div;
import static org.dominokit.domino.ui.utils.Domino.dui_blue;
import static org.dominokit.domino.ui.utils.Domino.dui_blue_grey;
import static org.dominokit.domino.ui.utils.Domino.dui_brown;
import static org.dominokit.domino.ui.utils.Domino.dui_cyan;
import static org.dominokit.domino.ui.utils.Domino.dui_flex;
import static org.dominokit.domino.ui.utils.Domino.dui_gap_4;
import static org.dominokit.domino.ui.utils.Domino.dui_green;
import static org.dominokit.domino.ui.utils.Domino.dui_h_12;
import static org.dominokit.domino.ui.utils.Domino.dui_items_center;
import static org.dominokit.domino.ui.utils.Domino.dui_justify_center;
import static org.dominokit.domino.ui.utils.Domino.dui_min_h_12;
import static org.dominokit.domino.ui.utils.Domino.dui_orange;
import static org.dominokit.domino.ui.utils.Domino.dui_p_2;
import static org.dominokit.domino.ui.utils.Domino.dui_pink;
import static org.dominokit.domino.ui.utils.Domino.dui_purple;
import static org.dominokit.domino.ui.utils.Domino.dui_red;
import static org.dominokit.domino.ui.utils.Domino.dui_teal;
import static org.dominokit.domino.ui.utils.Domino.dui_w_12;
import static org.dominokit.domino.ui.utils.Domino.img;
import static org.dominokit.domino.ui.utils.Domino.text;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.spin.SpinItem;
import org.dominokit.domino.ui.spin.VSpinSelect;
import org.dominokit.domino.ui.utils.BaseDominoElement;

public class VerticalSpinSample extends BaseDominoElement<HTMLDivElement, VerticalSpinSample> {

    private DivElement element;

    public static VerticalSpinSample create() {
        return new VerticalSpinSample();
    }

    public VerticalSpinSample() {
        this.element = div().addCss(dui_p_2)
                .appendChild(Row.create()
                        .span2(VSpinSelect.<String>create()
                                .addCss(dui_gap_4, dui_min_h_12)
                                .appendChild(SpinItem.create("item 1")
                                        .appendChild(div()
                                                .addCss(dui_min_h_12, dui_blue)
                                        )
                                )
                                .appendChild(SpinItem.create("item 2")
                                        .appendChild(div()
                                                .addCss(dui_min_h_12, dui_red)
                                        )
                                )
                                .appendChild(SpinItem.create("item 3")
                                        .appendChild(div()
                                                .addCss(dui_min_h_12, dui_blue_grey)
                                        )
                                )
                                .appendChild(SpinItem.create("item 4")
                                        .appendChild(div()
                                                .addCss(dui_min_h_12, dui_orange)
                                        )
                                )
                                .appendChild(SpinItem.create("item 5")
                                        .appendChild(div()
                                                .addCss(dui_min_h_12, dui_brown)
                                        )
                                )
                                .appendChild(SpinItem.create("item 6")
                                        .appendChild(div()
                                                .addCss(dui_min_h_12, dui_green)
                                        )
                                )
                                .appendChild(SpinItem.create("item 7")
                                        .appendChild(div()
                                                .addCss(dui_min_h_12, dui_pink)
                                        )
                                )
                                .appendChild(SpinItem.create("item 8")
                                        .appendChild(div()
                                                .addCss(dui_min_h_12, dui_teal)
                                        )
                                )
                                .appendChild(SpinItem.create("item 9")
                                        .appendChild(div()
                                                .addCss(dui_min_h_12, dui_cyan)
                                        )
                                )
                                .appendChild(SpinItem.create("item 10")
                                        .appendChild(div()
                                                .addCss(dui_min_h_12, dui_purple)
                                        )
                                )
                        )
                        .span2(VSpinSelect.<String>create()
                                .addCss(dui_min_h_12)
                                .appendChild(SpinItem.create("item 1")
                                        .appendChild(div()
                                                .addCss(dui_min_h_12, dui_flex, dui_items_center, dui_justify_center)
                                                .appendChild(Icons.battery_charging_100())
                                        )
                                )
                                .appendChild(SpinItem.create("item 2")
                                        .appendChild(div()
                                                .addCss(dui_min_h_12, dui_flex, dui_items_center, dui_justify_center)
                                                .appendChild(Icons.bluetooth())
                                        )
                                )
                                .appendChild(SpinItem.create("item 2")
                                        .appendChild(div()
                                                .addCss(dui_min_h_12, dui_flex, dui_items_center, dui_justify_center)
                                                .appendChild(Icons.database())
                                        )
                                )
                                .appendChild(SpinItem.create("item 2")
                                        .appendChild(div()
                                                .addCss(dui_min_h_12, dui_flex, dui_items_center, dui_justify_center)
                                                .appendChild(Icons.brightness_4())
                                        )
                                )
                                .appendChild(SpinItem.create("item 2")
                                        .appendChild(div()
                                                .addCss(dui_min_h_12, dui_flex, dui_items_center, dui_justify_center)
                                                .appendChild(Icons.devices())
                                        )
                                )
                                .appendChild(SpinItem.create("item 2")
                                        .appendChild(div()
                                                .addCss(dui_min_h_12, dui_flex, dui_items_center, dui_justify_center)
                                                .appendChild(Icons.crosshairs_gps())
                                        )
                                )
                                .appendChild(SpinItem.create("item 2")
                                        .appendChild(div()
                                                .addCss(dui_min_h_12, dui_flex, dui_items_center, dui_justify_center)
                                                .appendChild(Icons.graph())
                                        )
                                )
                                .appendChild(SpinItem.create("item 2")
                                        .appendChild(div()
                                                .addCss(dui_min_h_12, dui_flex, dui_items_center, dui_justify_center)
                                                .appendChild(Icons.search_web())
                                        )
                                )
                                .appendChild(SpinItem.create("item 2")
                                        .appendChild(div()
                                                .addCss(dui_min_h_12, dui_flex, dui_items_center, dui_justify_center)
                                                .appendChild(Icons.alarm())
                                        )
                                )
                                .appendChild(SpinItem.create("item 2")
                                        .appendChild(div()
                                                .addCss(dui_min_h_12, dui_flex, dui_items_center, dui_justify_center)
                                                .appendChild(Icons.cast_variant())
                                        )
                                )
                        )
                        .span2(VSpinSelect.<String>create()
                                .addCss(dui_min_h_12)
                                .appendChild(SpinItem.create("item 1")
                                        .appendChild(div()
                                                .addCss(dui_min_h_12, dui_flex, dui_items_center, dui_justify_center)
                                                .appendChild(img("/assets/flags/jordan.png")
                                                        .addCss(dui_h_12, dui_w_12)
                                                )
                                        )
                                )
                                .appendChild(SpinItem.create("item 2").appendChild(div()
                                                .addCss(dui_min_h_12, dui_flex, dui_items_center, dui_justify_center)
                                                .appendChild(img("/assets/flags/oman.png")
                                                        .addCss(dui_h_12, dui_w_12)
                                                )
                                        )
                                )
                                .appendChild(SpinItem.create("item 3")
                                        .appendChild(div()
                                                .addCss(dui_min_h_12, dui_flex, dui_items_center, dui_justify_center)
                                                .appendChild(img("/assets/flags/palestine.png")
                                                        .addCss(dui_h_12, dui_w_12)
                                                )
                                        )
                                )
                                .appendChild(SpinItem.create("item 4")
                                        .appendChild(div()
                                                .addCss(dui_min_h_12, dui_flex, dui_items_center, dui_justify_center)
                                                .appendChild(img("/assets/flags/brazil.png")
                                                        .addCss(dui_h_12, dui_w_12)
                                                )
                                        )
                                )
                                .appendChild(SpinItem.create("item 5")
                                        .appendChild(div()
                                                .addCss(dui_min_h_12, dui_flex, dui_items_center, dui_justify_center)
                                                .appendChild(img("/assets/flags/european-union.png")
                                                        .addCss(dui_h_12, dui_w_12)
                                                )
                                        )
                                )
                        )
                        .span6(VSpinSelect.<String>create(Icons.menu_up(), Icons.menu_down())
                                .addCss(dui_min_h_12)
                                .appendChild(SpinItem.create("item 1")
                                        .appendChild(div()
                                                .addCss(dui_min_h_12, dui_flex, dui_items_center, dui_justify_center)
                                                .setCssProperty("line-height", "3rem")
                                                .appendChild(text("Cras justo odio"))
                                        )
                                )
                                .appendChild(SpinItem.create("item 2")
                                        .appendChild(div()
                                                .addCss(dui_min_h_12, dui_flex, dui_items_center, dui_justify_center)
                                                .setCssProperty("line-height", "3rem")
                                                .appendChild(text("Dapibus ac facilisis in"))
                                        )
                                )
                                .appendChild(SpinItem.create("item 3")
                                        .appendChild(div()
                                                .addCss(dui_min_h_12, dui_flex, dui_items_center, dui_justify_center)
                                                .setCssProperty("line-height", "3rem")
                                                .appendChild(text("Morbi leo risus"))
                                        )
                                )
                                .appendChild(SpinItem.create("item 4")
                                        .appendChild(div()
                                                .addCss(dui_min_h_12, dui_flex, dui_items_center, dui_justify_center)
                                                .setCssProperty("line-height", "3rem")
                                                .appendChild(text("Porta ac consectetur ac"))
                                        )
                                )
                                .appendChild(SpinItem.create("item 5")
                                        .appendChild(div()
                                                .addCss(dui_min_h_12, dui_flex, dui_items_center, dui_justify_center)
                                                .setCssProperty("line-height", "3rem")
                                                .appendChild(text("Vestibulum at eros"))
                                        )
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

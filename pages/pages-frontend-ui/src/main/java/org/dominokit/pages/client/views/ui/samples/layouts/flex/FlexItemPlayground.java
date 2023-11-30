package org.dominokit.pages.client.views.ui.samples.layouts.flex;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.forms.Radio;
import org.dominokit.domino.ui.forms.RadioGroup;
import org.dominokit.domino.ui.forms.TextBox;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.sliders.Slider;
import org.dominokit.domino.ui.style.CssClass;
import org.dominokit.domino.ui.style.LimitOneOfCssClass;
import org.dominokit.domino.ui.utils.BaseDominoElement;

import java.util.HashMap;
import java.util.Map;

import static org.dominokit.domino.ui.utils.Domino.*;

public class FlexItemPlayground extends BaseDominoElement<HTMLDivElement, FlexItemPlayground> {

    private final DivElement element;
    private final CssClass demo_split_div = () -> "demo-split-div";

    public static FlexItemPlayground create() {
        return new FlexItemPlayground();
    }

    public FlexItemPlayground() {
        this.element = div().addCss(dui_p_4);
        Slider orderSlider = Slider.create(7);
        Slider flexGrowSlider = Slider.create(10);
        Slider flexShrinkSlider = Slider.create(10);
        TextBox flexBasisTextBox = TextBox.create("Flex Basis").setHelperText("Default size of an element before the remaining space is distributed");
        RadioGroup<String> targetBlockRadioGroup = RadioGroup.create("target-block", "Target block # to play with");
        RadioGroup<CssClass> alignSelfRadioGroup = RadioGroup.create("align-self", "Align self");

        LimitOneOfCssClass alignSelfCss = LimitOneOfCssClass.of(
                dui_self_start,
                dui_self_end,
                dui_self_center,
                dui_self_stretch,
                dui_self_baseline
        );

        this.element
                .appendChild(Row.create()
                        .appendChild(Column.span4()
                                .appendChild(targetBlockRadioGroup
                                        .appendChild(Radio.create("0", "1"))
                                        .appendChild(Radio.create("1", "2"))
                                        .appendChild(Radio.create("2", "3"))
                                        .appendChild(Radio.create("3", "4"))
                                        .appendChild(Radio.create("4", "5"))
                                        .horizontal()
                                )
                        )
                )
                .appendChild(Row.create()
                        .appendChild(Column.span4()
                                .appendChild(orderSlider.withThumb())
                                .appendChild(h(5).textContent("Order"))
                        )
                        .appendChild(Column.span4()
                                .appendChild(flexGrowSlider.withThumb())
                                .appendChild(h(5).textContent("Flex Grow"))
                        )
                        .appendChild(Column.span4()
                                .appendChild(flexShrinkSlider.withThumb())
                                .appendChild(h(5).textContent("Flex Shrink"))
                        )
                )
                .appendChild(Row.create()
                        .appendChild(Column.span6()
                                .appendChild(flexBasisTextBox)
                        )
                        .appendChild(Column.span6()
                                .appendChild(alignSelfRadioGroup
                                        .appendChild(Radio.create(dui_self_start, "Start"))
                                        .appendChild(Radio.create(dui_self_end, "End"))
                                        .appendChild(Radio.create(dui_self_center, "Center"))
                                        .appendChild(Radio.create(dui_self_stretch, "Stretch"))
                                        .appendChild(Radio.create(dui_self_baseline, "Base line"))
                                        .horizontal()
                                )
                        )
                );

        DivElement flexLayout = div()
                .addCss(dui_flex, dui_flex_row, dui_h_full, dui_items_start, dui_gap_4)
                .setCssProperty("counter-reset", "section");

        Map<String, DivElement> items = new HashMap<>();
        for (int i = 0; i < 5; i++) {
            DivElement item = div()
                    .addCss(dui_self_start, () -> "demo-flex-layout-block", background(i + 1), order(i))
                    .appendChild(h(4));
            items.put(String.valueOf(i), item);
            flexLayout.appendChild(item);
        }

        this.element.appendChild(div()
                .addCss(()->"demo-flex-layout-result-container", dui_bg_accent_d_4)
                .appendChild(flexLayout)
                .element());

        LimitOneOfCssClass orderCss = LimitOneOfCssClass.of(
                dui_order_1,
                dui_order_10,
                dui_order_20,
                dui_order_30,
                dui_order_40,
                dui_order_50,
                dui_order_60,
                dui_order_70
        );

        LimitOneOfCssClass growCss = LimitOneOfCssClass.of(
                dui_grow_0,
                dui_grow_1,
                dui_grow_2,
                dui_grow_3,
                dui_grow_4,
                dui_grow_5,
                dui_grow_6,
                dui_grow_7,
                dui_grow_8,
                dui_grow_9,
                dui_grow_10,
                dui_grow_11,
                dui_grow_12
        );

        LimitOneOfCssClass shrinkCss = LimitOneOfCssClass.of(
                dui_shrink_0,
                dui_shrink_1,
                dui_shrink_2,
                dui_shrink_3,
                dui_shrink_4,
                dui_shrink_5,
                dui_shrink_6,
                dui_shrink_7,
                dui_shrink_8,
                dui_shrink_9,
                dui_shrink_10,
                dui_shrink_11,
                dui_shrink_12
        );
        orderSlider.addChangeListener((old, value) -> items
                .get(targetBlockRadioGroup.getValue())
                .addCss(orderCss.use(order(value.intValue())))
                .setAttribute("dui-demo-order", value.intValue())
        );

        flexGrowSlider.addChangeListener((old, value) -> items.get(targetBlockRadioGroup.getValue())
                .addCss(growCss.use(grow(value.intValue())))
                .setAttribute("dui-demo-grow", value.intValue())
        );

        flexShrinkSlider.addChangeListener((old, value) -> items.get(targetBlockRadioGroup.getValue())
                .addCss(shrinkCss.use(shrink(value.intValue())))
                .setAttribute("dui-demo-shrink", value.intValue())
        );

        alignSelfRadioGroup.addChangeListener((old, value) -> items.get(targetBlockRadioGroup.getValue())
                .addCss(alignSelfCss.use(value))
        );

        flexBasisTextBox.addChangeListener((old, value) -> items.get(targetBlockRadioGroup.getValue())
                .setCssProperty("flex-basis", value)
                .setAttribute("dui-demo-basis", value)
        );

        targetBlockRadioGroup.addChangeListener((old, value) -> {
            DivElement flexItem = items.get(targetBlockRadioGroup.getValue());
            flexGrowSlider.setValue( Double.parseDouble(flexItem.getAttribute("dui-demo-grow", "0")));
            orderSlider.setValue(Double.parseDouble(flexItem.getAttribute("dui-demo-order", value)));
            flexShrinkSlider.setValue(Double.parseDouble(flexItem.getAttribute("dui-demo-shrink", "0")));
            flexBasisTextBox.setValue(flexItem.getAttribute("dui-demo-basis", "auto"));
            alignSelfCss.getActive(flexItem.element())
                    .ifPresent(alignSelfRadioGroup::setValue);

        });

        targetBlockRadioGroup.setValue("2");

        init(this);
    }


    private CssClass background(int i) {
        switch (i) {
            case 1:
                return dui_bg_accent;
            case 2:
                return dui_bg_accent_l_1;
            case 3:
                return dui_bg_accent_l_2;
            case 4:
                return dui_bg_accent_l_3;
            case 5:
                return dui_bg_accent_l_4;
            default:
                return dui_bg_accent_l_5;
        }
    }

    private CssClass order(int i) {
        switch (i) {
            case 0:
                return dui_order_10;
            case 1:
                return dui_order_20;
            case 2:
                return dui_order_30;
            case 3:
                return dui_order_40;
            case 4:
                return dui_order_50;
            case 5:
                return dui_order_60;
            default:
                return dui_order_70;
        }
    }

    private CssClass grow(int i) {
        switch (i) {
            case 0:
                return dui_grow_0;
            case 1:
                return dui_grow_1;
            case 2:
                return dui_grow_2;
            case 3:
                return dui_grow_3;
            case 4:
                return dui_grow_4;
            case 5:
                return dui_grow_5;
            case 6:
                return dui_grow_6;
            case 7:
                return dui_grow_7;
            case 8:
                return dui_grow_8;
            case 9:
                return dui_grow_9;
            case 10:
                return dui_grow_10;
            default:
                return dui_grow_12;
        }
    }

    private CssClass shrink(int i) {
        switch (i) {
            case 0:
                return dui_shrink_0;
            case 1:
                return dui_shrink_1;
            case 2:
                return dui_shrink_2;
            case 3:
                return dui_shrink_3;
            case 4:
                return dui_shrink_4;
            case 5:
                return dui_shrink_5;
            case 6:
                return dui_shrink_6;
            case 7:
                return dui_shrink_7;
            case 8:
                return dui_shrink_8;
            case 9:
                return dui_shrink_9;
            case 10:
                return dui_shrink_10;
            default:
                return dui_shrink_12;
        }
    }

    @Override
    public HTMLDivElement element() {
        return element.element();
    }
}

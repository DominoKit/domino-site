package org.dominokit.pages.client.views.ui.samples.layouts.flex;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.forms.Radio;
import org.dominokit.domino.ui.forms.RadioGroup;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.style.CssClass;
import org.dominokit.domino.ui.style.LimitOneOfCssClass;
import org.dominokit.domino.ui.utils.BaseDominoElement;

import java.util.ArrayList;
import java.util.List;

import static org.dominokit.domino.ui.utils.Domino.*;

public class FlexLayoutPlayground extends BaseDominoElement<HTMLDivElement, FlexLayoutPlayground> {

    private final DivElement element;

    public static FlexLayoutPlayground create() {
        return new FlexLayoutPlayground();
    }

    public FlexLayoutPlayground() {

        this.element = div().addCss(dui_p_4);
        RadioGroup<CssClass> alignItemsRadioGroup = RadioGroup.create("align-items");
        RadioGroup<CssClass> directionsRadioGroup = RadioGroup.create("direction");
        RadioGroup<CssClass> justifyContentRadioGroup = RadioGroup.create("justify-content");

        // ********* settings part ********* //
        Button addBlockButton = Button.create("ADD BLOCK").addCss(dui_m_r_4);
        Button resetButton = Button.create("RESET");
        RadioGroup<CssClass> wrapRadioGroup = RadioGroup.create("wrap", "Wrap");
        LimitOneOfCssClass directionCss = LimitOneOfCssClass.of(
                dui_flex_row,
                dui_flex_row_reverse,
                dui_flex_col,
                dui_flex_col_reverse
        );

        LimitOneOfCssClass wrapCss = LimitOneOfCssClass.of(
                dui_flex_wrap,
                dui_flex_wrap_reverse,
                dui_flex_nowrap
        );

        LimitOneOfCssClass justifyContentCss = LimitOneOfCssClass.of(
                dui_justify_start,
                dui_justify_end,
                dui_justify_center,
                dui_justify_around,
                dui_justify_evenly,
                dui_justify_between
        );

        LimitOneOfCssClass alignItemsCss = LimitOneOfCssClass.of(
                dui_items_start,
                dui_items_end,
                dui_items_center,
                dui_items_stretch,
                dui_items_baseline
        );
        this.element
                .appendChild(Row.create()
                        .appendChild(Column.span6()
                                .appendChild(directionsRadioGroup
                                        .setHelperText("Containers inside Flex Layout can have different directions")
                                        .setLabel("Directions")
                                        .appendChild(Radio.create(dui_flex_row, "Left to right").check())
                                        .appendChild(Radio.create(dui_flex_row_reverse, "Right to left"))
                                        .appendChild(Radio.create(dui_flex_col, "Top to bottom"))
                                        .appendChild(Radio.create(dui_flex_col_reverse, "Bottom to top"))
                                        .horizontal()
                                ))
                        .appendChild(Column.span6()
                                .appendChild(wrapRadioGroup
                                        .appendChild(Radio.create(dui_flex_nowrap, "No wrap").check())
                                        .appendChild(Radio.create(dui_flex_wrap, "Wrap top to bottom"))
                                        .appendChild(Radio.create(dui_flex_wrap_reverse, "Wrap bottom to top"))
                                        .horizontal())
                        )
                )
                .appendChild(Row.create()
                        .appendChild(Column.span6()
                                .appendChild(justifyContentRadioGroup
                                        .setHelperText("Containers inside Flex Layout can be placed in different ways")
                                        .setLabel("Justify Content")
                                        .appendChild(Radio.create(dui_justify_start, "Start").check())
                                        .appendChild(Radio.create(dui_justify_end, "End"))
                                        .appendChild(Radio.create(dui_justify_center, "Center"))
                                        .appendChild(Radio.create(dui_justify_between, "Space between"))
                                        .appendChild(Radio.create(dui_justify_around, "Space around"))
                                        .appendChild(Radio.create(dui_justify_evenly, "Space evenly"))
                                        .horizontal()
                                ))
                        .appendChild(Column.span6()
                                .appendChild(alignItemsRadioGroup
                                        .setHelperText("Containers inside Flex Layout can be aligned in different ways")
                                        .setLabel("Align items")
                                        .appendChild(Radio.create(dui_items_start, "Start").check())
                                        .appendChild(Radio.create(dui_items_end, "End"))
                                        .appendChild(Radio.create(dui_items_center, "Center"))
                                        .appendChild(Radio.create(dui_items_stretch, "Stretch"))
                                        .appendChild(Radio.create(dui_items_baseline, "Base line"))
                                        .horizontal()
                                )
                        )
                )
                .appendChild(Row.create()
                        .appendChild(Column.span12()
                                .appendChild(resetButton.addCss(dui_float_right))
                                .appendChild(addBlockButton.addCss(dui_float_right)))
                );
        // ********* flex layout part ********* //
        DivElement flexLayout = div().addCss(dui_flex, dui_flex_row, dui_h_full, dui_items_start, dui_gap_4)
                .setCssProperty("counter-reset", "section")
                .appendChild(div()
                        .addCss(() -> "demo-flex-layout-block")
                        .appendChild(h(4)))
                .appendChild(div().addCss(() -> "demo-flex-layout-block")
                        .appendChild(h(4)))
                .appendChild(div().addCss(() -> "demo-flex-layout-block")
                        .appendChild(h(4)));

        this.element.appendChild(div()
                .addCss(dui_h_96, dui_bg_accent)
                .appendChild(flexLayout)
                .element());

        // ********* listeners part ********* //
        directionsRadioGroup.addChangeListener((old, direction) -> flexLayout.addCss(directionCss.use(direction)));


        justifyContentRadioGroup.addChangeListener((old, justify) -> flexLayout.addCss(justifyContentCss.use(justify)));

        alignItemsRadioGroup.addChangeListener((old, align) -> flexLayout.addCss(alignItemsCss.use(align)));

        wrapRadioGroup.addChangeListener((old, wrap) -> flexLayout.addCss(wrapCss.use(wrap)));

        List<DivElement> dynamicAddedItems = new ArrayList<>();

        addBlockButton.addClickListener(evt -> {
            DivElement item = div()
                    .addCss("demo-flex-layout-block")
                    .appendChild(h(4));
            flexLayout.appendChild(item);
            dynamicAddedItems.add(item);
        });

        resetButton.addClickListener(evt -> {
            for (DivElement dynamicAddedItem : dynamicAddedItems) {
                dynamicAddedItem.remove();
            }
            dynamicAddedItems.clear();
        });

        init(this);
    }

    @Override
    public HTMLDivElement element() {
        return element.element();
    }
}

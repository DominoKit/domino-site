package org.dominokit.pages.client.views.ui.samples.components.counters;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.forms.IntegerBox;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.pro.domino.ui.colorpicker.ColorPicker;
import org.dominokit.pro.domino.ui.counter.CountCircle;

import static org.dominokit.domino.ui.style.DisplayCss.dui_flex;
import static org.dominokit.domino.ui.style.SpacingCss.*;
import static org.dominokit.domino.ui.utils.Domino.div;
import static org.dominokit.domino.ui.utils.Domino.dui_p_2;

public class SimpleCountersSample extends BaseDominoElement<HTMLDivElement, SimpleCountersSample> {

    private DivElement element;

    public static SimpleCountersSample create() {
        return new SimpleCountersSample();
    }

    public SimpleCountersSample() {
        this.element = div().addCss(dui_p_2)
                .appendChild(div()
                        .addCss(dui_flex, dui_gap_4, dui_items_center)
                        .appendChild(CountCircle.create(0, 100).withValue(65))
                        .appendChild(CountCircle.create(0, 100)
                                .withValue(80)
                                .setTextExpression("items: ${value}")
                                .setSize(200.0, 40.0)
                                .setCounterColors("var(--dui-clr-blue)", "var(--dui-clr-indigo)")
                                .withTextElement((parent, self) -> self.addCss(dui_font_size_6))
                        )
                        .appendChild(div().addCss(dui_flex, dui_gap_4, dui_items_center)
                                .apply(div -> {
                                    CountCircle counter = CountCircle.create(0, 100);
                                    IntegerBox interval = IntegerBox.create("Interval")
                                            .withValue(5)
                                            .setMinValue(1)
                                            .setMaxValue(100);
                                    div
                                            .appendChild(counter)
                                            .appendChild(interval)
                                            .appendChild(Button.create("Count up", Icons.arrow_up())
                                                    .addClickListener(evt -> counter.countUp(interval.getValue()))
                                            )
                                            .appendChild(Button.create("Count down", Icons.arrow_down())
                                                    .addClickListener(evt -> counter.countDown(interval.getValue()))
                                            )
                                    ;

                                })

                        )
                );
        init(this);
    }

    @Override
    public HTMLDivElement element() {
        return this.element.element();
    }
}

package org.dominokit.pages.client.views.ui.samples.components.counters;

import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.counter.Counter;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.forms.IntegerBox;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.pro.domino.ui.counter.CountCircle;

import static org.dominokit.domino.ui.style.DisplayCss.dui_flex;
import static org.dominokit.domino.ui.style.GenericCss.dui_blue;
import static org.dominokit.domino.ui.style.SpacingCss.*;
import static org.dominokit.domino.ui.utils.Domino.div;
import static org.dominokit.domino.ui.utils.Domino.dui_p_2;

public class AutoCountersSample extends BaseDominoElement<HTMLDivElement, AutoCountersSample> {

    private DivElement element;

    public static AutoCountersSample create() {
        return new AutoCountersSample();
    }

    public AutoCountersSample() {
        this.element = div().addCss(dui_p_2)
                .appendChild(div()
                        .addCss(dui_flex, dui_gap_4, dui_items_center)
                        .appendChild(CountCircle.create(0, 100)
                                .withValue(0)
                                .apply(self -> {
                                    Counter counter = Counter.countFrom(1)
                                            .countTo(100)
                                            .every(200)
                                            .incrementBy(1)
                                            .onCount(self::setValue)
                                            .startCounting();
                                    self.withInnerContainer((parent, container) -> {
                                        container
                                                .addCss(dui_flex_col)
                                                .appendChild(Button.create(Icons.restart()).circle().addClickListener(evt -> {
                                                    counter.stopCounting();
                                                    self.setValue(0);
                                                    DomGlobal.setTimeout(p0 -> {
                                                        counter.startCounting();
                                                    }, 1000);

                                                }));
                                    });
                                })
                        )
                        .appendChild(CountCircle.create(0, 100)
                                .withValue(80)
                                .setTextExpression("items: ${value}")
                                .setSize(200.0, 40.0)
                                .setCounterColors("var(--dui-clr-blue)", "var(--dui-clr-indigo)")
                                .withTextElement((parent, self) -> self.addCss(dui_font_size_6))
                                .apply(self -> {
                                    Counter counter = Counter.countFrom(1)
                                            .countTo(100)
                                            .every(100)
                                            .incrementBy(1)
                                            .onCount(self::setValue)
                                            .startCounting();
                                    self.withInnerContainer((parent, container) -> {
                                        container
                                                .addCss(dui_flex_col)
                                                .appendChild(Button.create(Icons.restart())
                                                        .addCss(dui_blue)
                                                        .circle()
                                                        .addClickListener(evt -> {
                                                            counter.stopCounting();
                                                            self.setValue(0);
                                                            DomGlobal.setTimeout(p0 -> {
                                                                counter.startCounting();
                                                            }, 1000);

                                                        }));
                                    });
                                })
                        )
                        .appendChild(CountCircle.create(0, 100)
                                .withValue(80)
                                .setTextExpression("items: ${value}")
                                .setSize(200.0, 40.0)
                                .setCounterColors("var(--dui-clr-blue)", "var(--dui-clr-indigo)")
                                .withTextElement((parent, self) -> self.addCss(dui_font_size_6))
                                .apply(self -> {
                                    Counter counter = Counter.countFrom(100)
                                            .countTo(1)
                                            .every(100)
                                            .incrementBy(1)
                                            .onCount(self::setValue)
                                            .startCounting();
                                    self.withInnerContainer((parent, container) -> {
                                        container
                                                .addCss(dui_flex_col)
                                                .appendChild(Button.create(Icons.restart())
                                                        .addCss(dui_blue)
                                                        .circle()
                                                        .addClickListener(evt -> {
                                                            counter.stopCounting();
                                                            self.setValue(100);
                                                            DomGlobal.setTimeout(p0 -> {
                                                                counter.startCounting();
                                                            }, 1000);

                                                        }));
                                    });
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

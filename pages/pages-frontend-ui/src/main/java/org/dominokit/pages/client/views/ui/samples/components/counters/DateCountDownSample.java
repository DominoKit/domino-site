package org.dominokit.pages.client.views.ui.samples.components.counters;

import com.google.gwt.i18n.client.DateTimeFormat;
import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.counter.Counter;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.pro.domino.ui.counter.CountCircle;
import org.dominokit.pro.domino.ui.counter.DateCountDown;

import static org.dominokit.domino.ui.style.DisplayCss.dui_flex;
import static org.dominokit.domino.ui.style.GenericCss.dui_blue;
import static org.dominokit.domino.ui.style.SpacingCss.*;
import static org.dominokit.domino.ui.utils.Domino.div;
import static org.dominokit.domino.ui.utils.Domino.dui_p_2;

public class DateCountDownSample extends BaseDominoElement<HTMLDivElement, DateCountDownSample> {

    private DivElement element;

    public static DateCountDownSample create() {
        return new DateCountDownSample();
    }

    public DateCountDownSample() {
        this.element = div().addCss(dui_p_2)
                .appendChild(div()
                        .addCss(dui_flex, dui_gap_4, dui_items_center, dui_flex_col)
                        .appendChild(DateCountDown.create()
                                .showCounters(DateCountDown.CounterUnits.MINUTES, DateCountDown.CounterUnits.SECONDS)
                                .start(30, 0)
                        )
                        .appendChild(DateCountDown.create()
                                .showCounters(DateCountDown.CounterUnits.HOURS,
                                        DateCountDown.CounterUnits.MINUTES,
                                        DateCountDown.CounterUnits.SECONDS)
                                .start(1, 30, 0)
                        )
                        .appendChild(DateCountDown.create()
                                .showCounters(DateCountDown.CounterUnits.DAYS,
                                        DateCountDown.CounterUnits.HOURS,
                                        DateCountDown.CounterUnits.MINUTES,
                                        DateCountDown.CounterUnits.SECONDS)
                                .start(4, 1, 30, 0)
                        )
                        .appendChild(DateCountDown.create()
                                .start(DateTimeFormat.getFormat("yyyy-MM-dd").parse("2030-07-01"))
                        )

                );
        init(this);
    }

    @Override
    public HTMLDivElement element() {
        return this.element.element();
    }
}

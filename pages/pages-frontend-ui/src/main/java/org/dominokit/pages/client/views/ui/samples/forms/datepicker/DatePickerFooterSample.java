package org.dominokit.pages.client.views.ui.samples.forms.datepicker;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.datepicker.Calendar;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.gwtproject.i18n.shared.cldr.impl.DateTimeFormatInfoImpl_ar;
import org.gwtproject.i18n.shared.cldr.impl.DateTimeFormatInfoImpl_es;

import java.util.Date;

import static org.dominokit.domino.ui.utils.Domino.*;

public class DatePickerFooterSample extends BaseDominoElement<HTMLDivElement, DatePickerFooterSample> {

    private DivElement element;

    public static DatePickerFooterSample create() {
        return new DatePickerFooterSample();
    }

    public DatePickerFooterSample() {
        this.element = div().addCss(dui_p_2)
                .appendChild(Row.create()
                        .span6(Calendar.create()
                                .withHeader()
                                .withFooter((calendar, footer) -> footer
                                        .addCss(dui_flex, dui_justify_center)
                                        .appendChild(Button.create(Icons.calendar_today(), "TODAY")
                                                .addClickListener(evt -> calendar.setDate(new Date()))
                                        )
                                )
                        )
                        .span6(Calendar.create(new DateTimeFormatInfoImpl_ar())
                                .addCss(dui_accent_blue)
                                .withHeader()
                                .withFooter((calendar, footer) -> footer
                                        .addCss(dui_flex, dui_justify_center)
                                        .appendChild(Button.create(Icons.calendar_today(), "TODAY")
                                                .addClickListener(evt -> calendar.setDate(new Date()))
                                        )
                                )
                        )
                )
                .appendChild(Row.create()
                        .span6(Calendar.create(new DateTimeFormatInfoImpl_es())
                                .addCss(dui_accent_teal)
                                .withHeader()
                                .withFooter((calendar, footer) -> footer
                                        .addCss(dui_flex, dui_justify_center)
                                        .appendChild(Button.create(Icons.calendar_today(), "TODAY")
                                                .addClickListener(evt -> calendar.setDate(new Date()))
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

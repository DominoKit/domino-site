package org.dominokit.pages.client.views.ui.samples.forms.datepicker;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.datepicker.Calendar;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.gwtproject.i18n.shared.cldr.impl.DateTimeFormatInfoImpl_ar;
import org.gwtproject.i18n.shared.cldr.impl.DateTimeFormatInfoImpl_es;

public class DatePickerHeaderSample extends BaseDominoElement<HTMLDivElement, DatePickerHeaderSample> {

    private DivElement element;

    public static DatePickerHeaderSample create() {
        return new DatePickerHeaderSample();
    }

    public DatePickerHeaderSample() {
        this.element = div().addCss(dui_p_2)
                .appendChild(Row.create()
                        .span6(Calendar.create()
                                .withHeader()
                        )
                        .span6(Calendar.create(new DateTimeFormatInfoImpl_ar())
                                .addCss(dui_accent_blue)
                                .withHeader()
                        )
                )
                .appendChild(Row.create()
                        .span6(Calendar.create(new DateTimeFormatInfoImpl_es())
                                .addCss(dui_accent_teal)
                                .withHeader()
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

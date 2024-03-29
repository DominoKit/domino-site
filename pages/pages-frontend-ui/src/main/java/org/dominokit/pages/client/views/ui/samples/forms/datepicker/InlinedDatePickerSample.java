package org.dominokit.pages.client.views.ui.samples.forms.datepicker;

import static org.dominokit.domino.ui.utils.Domino.div;
import static org.dominokit.domino.ui.utils.Domino.dui_p_2;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.datepicker.Calendar;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.gwtproject.i18n.shared.cldr.impl.DateTimeFormatInfoImpl_ar;
import org.gwtproject.i18n.shared.cldr.impl.DateTimeFormatInfoImpl_en_CA;
import org.gwtproject.i18n.shared.cldr.impl.DateTimeFormatInfoImpl_es;

public class InlinedDatePickerSample extends BaseDominoElement<HTMLDivElement, InlinedDatePickerSample> {

    private DivElement element;

    public static InlinedDatePickerSample create() {
        return new InlinedDatePickerSample();
    }

    public InlinedDatePickerSample() {
        this.element = div().addCss(dui_p_2)
                .appendChild(Row.create()
                        .span6(Calendar.create())
                        .span6(Calendar.create(new DateTimeFormatInfoImpl_en_CA()))
                )
                .appendChild(Row.create()
                        .span6(Calendar.create(new DateTimeFormatInfoImpl_ar()))
                        .span6(Calendar.create(new DateTimeFormatInfoImpl_es()))
                )
        ;
        init(this);
    }

    @Override
    public HTMLDivElement element() {
        return this.element.element();
    }
}

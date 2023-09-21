package org.dominokit.pages.client.views.ui.samples.forms.datepicker;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.datepicker.Calendar;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.forms.TextAreaBox;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.typography.BlockHeader;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.gwtproject.i18n.shared.cldr.impl.DateTimeFormatInfoImpl_ar;
import org.gwtproject.i18n.shared.cldr.impl.DateTimeFormatInfoImpl_es;

public class InlinedDatePickerSample extends BaseDominoElement<HTMLDivElement, InlinedDatePickerSample> {

    private DivElement element;

    public static InlinedDatePickerSample create() {
        return new InlinedDatePickerSample();
    }

    public InlinedDatePickerSample() {
        this.element = div().addCss(dui_p_2)
                .appendChild(Row.create()
                        .span4(Calendar.create())
                        .span4(Calendar.create(new DateTimeFormatInfoImpl_ar()))
                        .span4(Calendar.create(new DateTimeFormatInfoImpl_es()))
                )
        ;
        init(this);
    }

    @Override
    public HTMLDivElement element() {
        return this.element.element();
    }
}

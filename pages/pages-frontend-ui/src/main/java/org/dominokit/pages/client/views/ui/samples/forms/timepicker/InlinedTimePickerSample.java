package org.dominokit.pages.client.views.ui.samples.forms.timepicker;

import static org.dominokit.domino.ui.utils.Domino.div;
import static org.dominokit.domino.ui.utils.Domino.dui_p_2;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.timepicker.TimePicker;
import org.dominokit.domino.ui.timepicker.TimeStyle;
import org.dominokit.domino.ui.typography.BlockHeader;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.gwtproject.i18n.shared.cldr.impl.DateTimeFormatInfoImpl_ar;
import org.gwtproject.i18n.shared.cldr.impl.DateTimeFormatInfoImpl_es;

public class InlinedTimePickerSample extends BaseDominoElement<HTMLDivElement, InlinedTimePickerSample> {

    private DivElement element;

    public static InlinedTimePickerSample create() {
        return new InlinedTimePickerSample();
    }

    public InlinedTimePickerSample() {
        this.element = div().addCss(dui_p_2)
                .appendChild(BlockHeader.create("Different locales"))
                .appendChild(Row.create()
                        .span4(TimePicker.create())
                        .span4(TimePicker.create(new DateTimeFormatInfoImpl_ar()))
                        .span4(TimePicker.create(new DateTimeFormatInfoImpl_es()))
                )
                .appendChild(BlockHeader.create("With seconds"))
                .appendChild(Row.create()
                        .span4(TimePicker.create()
                                .setShowSeconds(true)
                        )
                        .span4(TimePicker.create(new DateTimeFormatInfoImpl_ar())
                                .setShowSeconds(true)
                        )
                        .span4(TimePicker.create(new DateTimeFormatInfoImpl_es())
                                .setShowSeconds(true)
                        )
                )
                .appendChild(BlockHeader.create("24 hours style"))
                .appendChild(Row.create()
                        .span4(TimePicker.create()
                                .setTimeStyle(TimeStyle._24)
                        )
                        .span4(TimePicker.create(new DateTimeFormatInfoImpl_ar())
                                .setTimeStyle(TimeStyle._24)
                        )
                        .span4(TimePicker.create(new DateTimeFormatInfoImpl_es())
                                .setTimeStyle(TimeStyle._24)
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

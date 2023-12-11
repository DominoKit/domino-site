package org.dominokit.pages.client.views.ui.samples.forms.timepicker;

import static org.dominokit.domino.ui.utils.Domino.div;
import static org.dominokit.domino.ui.utils.Domino.dui_accent_blue;
import static org.dominokit.domino.ui.utils.Domino.dui_accent_teal;
import static org.dominokit.domino.ui.utils.Domino.dui_p_2;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.forms.TimeBox;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.gwtproject.i18n.shared.cldr.impl.DateTimeFormatInfoImpl_ar;
import org.gwtproject.i18n.shared.cldr.impl.DateTimeFormatInfoImpl_es;

public class TimeBoxSample extends BaseDominoElement<HTMLDivElement, TimeBoxSample> {

    private DivElement element;

    public static TimeBoxSample create() {
        return new TimeBoxSample();
    }

    public TimeBoxSample() {
        this.element = div().addCss(dui_p_2)
                .appendChild(Row.create()
                        .span4(TimeBox.create("Default"))
                        .span4(TimeBox.create("With pattern", new DateTimeFormatInfoImpl_ar())
                                .setPattern("HH:mm:ss")
                                .withPopover((parent, popover) -> popover.addCss(dui_accent_blue))
                                .withTimePicker((parent, timePicker) -> timePicker
                                        .withHeader())
                        )
                        .span4(TimeBox.create("With parse strict", new DateTimeFormatInfoImpl_es())
                                .setPattern("HH-mm-ss")
                                .setParseStrict(true)
                                .withPopover((parent, popover) -> popover.addCss(dui_accent_teal))
                                .withTimePicker((parent, timePicker) -> timePicker
                                        .withHeader())
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

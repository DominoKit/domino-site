package org.dominokit.pages.client.views.ui.samples.forms.datepicker;

import static org.dominokit.domino.ui.utils.Domino.div;
import static org.dominokit.domino.ui.utils.Domino.dui_accent_blue;
import static org.dominokit.domino.ui.utils.Domino.dui_accent_teal;
import static org.dominokit.domino.ui.utils.Domino.dui_p_2;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.forms.DateBox;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.gwtproject.i18n.shared.cldr.impl.DateTimeFormatInfoImpl_ar;
import org.gwtproject.i18n.shared.cldr.impl.DateTimeFormatInfoImpl_es;

public class DateBoxSample extends BaseDominoElement<HTMLDivElement, DateBoxSample> {

    private DivElement element;

    public static DateBoxSample create() {
        return new DateBoxSample();
    }

    public DateBoxSample() {
        this.element = div().addCss(dui_p_2)
                .appendChild(Row.create()
                        .span4(DateBox.create("myDateBox")
                                .setPattern("dd.MM.yyyy")
                                .setParseStrict(true)
                                .withPopover((parent, popover) -> popover.addCss(dui_accent_blue)))
                        .span4(DateBox.create("With pattern", new DateTimeFormatInfoImpl_ar())
                                .setPattern("dd-MM-yyyy")
                                .withPopover((parent, popover) -> popover.addCss(dui_accent_blue))
                                .withCalendar((parent, calendar) -> calendar
                                        .withHeader())
                        )
                        .span4(DateBox.create("With parse strict", new DateTimeFormatInfoImpl_es())
                                .setPattern("dd-MM-yyyy")
                                .setParseStrict(true)
                                .withPopover((parent, popover) -> popover.addCss(dui_accent_teal))
                                .withCalendar((parent, calendar) -> calendar
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

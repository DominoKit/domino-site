package org.dominokit.pages.client.views.ui.samples.forms.timepicker;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.timepicker.TimePicker;
import org.dominokit.domino.ui.timepicker.TimeStyle;
import org.dominokit.domino.ui.typography.BlockHeader;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.gwtproject.i18n.shared.cldr.impl.DateTimeFormatInfoImpl_ar;
import org.gwtproject.i18n.shared.cldr.impl.DateTimeFormatInfoImpl_es;

import java.util.Date;

import static org.dominokit.domino.ui.utils.Domino.*;

public class TimePickerFooterSample extends BaseDominoElement<HTMLDivElement, TimePickerFooterSample> {

    private DivElement element;

    public static TimePickerFooterSample create() {
        return new TimePickerFooterSample();
    }

    public TimePickerFooterSample() {
        this.element = div().addCss(dui_p_2)
                .appendChild(BlockHeader.create("Different locales"))
                .appendChild(Row.create()
                        .span4(TimePicker.create()
                                .withHeader()
                                .withFooter((timePicker, footer) -> footer
                                        .addCss(dui_flex, dui_justify_center)
                                        .appendChild(Button.create(Icons.clock_outline(), "NOW")
                                                .addClickListener(evt -> timePicker.setDate(new Date()))
                                        )
                                )
                        )
                        .span4(TimePicker.create(new DateTimeFormatInfoImpl_ar())
                                .withHeader()
                                .addCss(dui_accent_blue)
                                .withFooter((timePicker, footer) -> footer
                                        .addCss(dui_flex, dui_justify_center)
                                        .appendChild(Button.create(Icons.clock_outline(), "NOW")
                                                .addClickListener(evt -> timePicker.setDate(new Date()))
                                        )
                                )
                        )
                        .span4(TimePicker.create(new DateTimeFormatInfoImpl_es())
                                .withHeader()
                                .addCss(dui_accent_teal)
                                .withFooter((timePicker, footer) -> footer
                                        .addCss(dui_flex, dui_justify_center)
                                        .appendChild(Button.create(Icons.clock_outline(), "NOW")
                                                .addClickListener(evt -> timePicker.setDate(new Date()))
                                        )
                                )
                        )
                )
                .appendChild(BlockHeader.create("With seconds"))
                .appendChild(Row.create()
                        .span4(TimePicker.create()
                                .setShowSeconds(true)
                                .withHeader()
                                .withFooter((timePicker, footer) -> footer
                                        .addCss(dui_flex, dui_justify_center)
                                        .appendChild(Button.create(Icons.clock_outline(), "NOW")
                                                .addClickListener(evt -> timePicker.setDate(new Date()))
                                        )
                                )
                        )
                        .span4(TimePicker.create(new DateTimeFormatInfoImpl_ar())
                                .setShowSeconds(true)
                                .withHeader()
                                .addCss(dui_accent_blue)
                                .withFooter((timePicker, footer) -> footer
                                        .addCss(dui_flex, dui_justify_center)
                                        .appendChild(Button.create(Icons.clock_outline(), "NOW")
                                                .addClickListener(evt -> timePicker.setDate(new Date()))
                                        )
                                )
                        )
                        .span4(TimePicker.create(new DateTimeFormatInfoImpl_es())
                                .setShowSeconds(true)
                                .withHeader()
                                .addCss(dui_accent_teal)
                                .withFooter((timePicker, footer) -> footer
                                        .addCss(dui_flex, dui_justify_center)
                                        .appendChild(Button.create(Icons.clock_outline(), "NOW")
                                                .addClickListener(evt -> timePicker.setDate(new Date()))
                                        )
                                )
                        )
                )
                .appendChild(BlockHeader.create("24 hours style"))
                .appendChild(Row.create()
                        .span4(TimePicker.create()
                                .setTimeStyle(TimeStyle._24)
                                .withHeader()
                                .withFooter((timePicker, footer) -> footer
                                        .addCss(dui_flex, dui_justify_center)
                                        .appendChild(Button.create(Icons.clock_outline(), "NOW")
                                                .addClickListener(evt -> timePicker.setDate(new Date()))
                                        )
                                )
                        )
                        .span4(TimePicker.create(new DateTimeFormatInfoImpl_ar())
                                .setTimeStyle(TimeStyle._24)
                                .withHeader()
                                .addCss(dui_accent_blue)
                                .withFooter((timePicker, footer) -> footer
                                        .addCss(dui_flex, dui_justify_center)
                                        .appendChild(Button.create(Icons.clock_outline(), "NOW")
                                                .addClickListener(evt -> timePicker.setDate(new Date()))
                                        )
                                )
                        )
                        .span4(TimePicker.create(new DateTimeFormatInfoImpl_es())
                                .setTimeStyle(TimeStyle._24)
                                .withHeader()
                                .addCss(dui_accent_teal)
                                .withFooter((timePicker, footer) -> footer
                                        .addCss(dui_flex, dui_justify_center)
                                        .appendChild(Button.create(Icons.clock_outline(), "NOW")
                                                .addClickListener(evt -> timePicker.setDate(new Date()))
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

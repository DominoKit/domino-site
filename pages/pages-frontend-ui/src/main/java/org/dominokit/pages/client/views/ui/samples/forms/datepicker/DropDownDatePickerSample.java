package org.dominokit.pages.client.views.ui.samples.forms.datepicker;

import static org.dominokit.domino.ui.utils.Domino.div;
import static org.dominokit.domino.ui.utils.Domino.dui_p_2;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.datepicker.Calendar;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.menu.direction.DropDirection;
import org.dominokit.domino.ui.popover.Popover;
import org.dominokit.domino.ui.utils.BaseDominoElement;

public class DropDownDatePickerSample extends BaseDominoElement<HTMLDivElement, DropDownDatePickerSample> {

    private DivElement element;

    public static DropDownDatePickerSample create() {
        return new DropDownDatePickerSample();
    }

    public DropDownDatePickerSample() {
        this.element = div().addCss(dui_p_2)
                .appendChild(Row.create()
                        .span2(Button.create(Icons.calendar(), "Pick date")
                                .apply(button -> {
                                    Popover.create(button)
                                            .setPosition(DropDirection.BEST_MIDDLE_UP_DOWN)
                                            .appendChild(Calendar.create()
                                                    .withHeader()
                                            );
                                })
                        )
                        .span2(Button.create(Icons.calendar(), "Pick date")
                                .apply(button -> {
                                    Popover.create(button)
                                            .setPosition(DropDirection.BEST_SIDE_UP_DOWN)
                                            .appendChild(Calendar.create()
                                                    .withHeader()
                                            );
                                })
                        )
                        .span2(Button.create(Icons.calendar(), "Pick date")
                                .apply(button -> {
                                    Popover.create(button)
                                            .setPosition(DropDirection.BEST_MIDDLE_SIDE)
                                            .appendChild(Calendar.create()
                                                    .withHeader()
                                            );
                                })
                        )
                        .span2(Button.create(Icons.calendar(), "Pick date")
                                .apply(button -> {
                                    Popover.create(button)
                                            .setPosition(DropDirection.MIDDLE_SCREEN)
                                            .appendChild(Calendar.create()
                                                    .withHeader()
                                            );
                                })
                        )
                        .span2(Button.create(Icons.calendar(), "Pick date")
                                .apply(button -> {
                                    Popover.create(button)
                                            .setModal(true)
                                            .setPosition(DropDirection.MIDDLE_SCREEN)
                                            .appendChild(Calendar.create()
                                                    .withHeader()
                                            );
                                })
                        )
                        .span2(Button.create(Icons.calendar(), "Pick date")
                                .apply(button -> {
                                    Popover.create(button)
                                            .setPosition(DropDirection.BEST_FIT_SIDE)
                                            .appendChild(Calendar.create()
                                                    .withHeader()
                                            );
                                })
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

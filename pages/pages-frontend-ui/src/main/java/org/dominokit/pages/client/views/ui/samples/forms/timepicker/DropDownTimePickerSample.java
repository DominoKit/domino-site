package org.dominokit.pages.client.views.ui.samples.forms.timepicker;

import static org.dominokit.domino.ui.utils.Domino.div;
import static org.dominokit.domino.ui.utils.Domino.dui_p_2;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.menu.direction.DropDirection;
import org.dominokit.domino.ui.popover.Popover;
import org.dominokit.domino.ui.timepicker.TimePicker;
import org.dominokit.domino.ui.utils.BaseDominoElement;

public class DropDownTimePickerSample extends BaseDominoElement<HTMLDivElement, DropDownTimePickerSample> {

    private DivElement element;

    public static DropDownTimePickerSample create() {
        return new DropDownTimePickerSample();
    }

    public DropDownTimePickerSample() {
        this.element = div().addCss(dui_p_2)
                .appendChild(Row.create()
                        .span2(Button.create(Icons.calendar(), "Pick time")
                                .apply(button -> {
                                    Popover.create(button)
                                            .setPosition(DropDirection.BEST_MIDDLE_UP_DOWN)
                                            .appendChild(TimePicker.create()
                                                    .withHeader()
                                            );
                                })
                        )
                        .span2(Button.create(Icons.calendar(), "Pick time")
                                .apply(button -> {
                                    Popover.create(button)
                                            .setPosition(DropDirection.BEST_SIDE_UP_DOWN)
                                            .appendChild(TimePicker.create()
                                                    .withHeader()
                                            );
                                })
                        )
                        .span2(Button.create(Icons.calendar(), "Pick time")
                                .apply(button -> {
                                    Popover.create(button)
                                            .setPosition(DropDirection.BEST_MIDDLE_SIDE)
                                            .appendChild(TimePicker.create()
                                                    .withHeader()
                                            );
                                })
                        )
                        .span2(Button.create(Icons.calendar(), "Pick time")
                                .apply(button -> {
                                    Popover.create(button)
                                            .setPosition(DropDirection.MIDDLE_SCREEN)
                                            .appendChild(TimePicker.create()
                                                    .withHeader()
                                            );
                                })
                        )
                        .span2(Button.create(Icons.calendar(), "Pick time")
                                .apply(button -> {
                                    Popover.create(button)
                                            .setModal(true)
                                            .setPosition(DropDirection.MIDDLE_SCREEN)
                                            .appendChild(TimePicker.create()
                                                    .withHeader()
                                            );
                                })
                        )
                        .span2(Button.create(Icons.calendar(), "Pick time")
                                .apply(button -> {
                                    Popover.create(button)
                                            .setPosition(DropDirection.BEST_FIT_SIDE)
                                            .appendChild(TimePicker.create()
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

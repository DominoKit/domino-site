package org.dominokit.pages.client.views.ui.samples.forms.basic;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.forms.Radio;
import org.dominokit.domino.ui.forms.RadioGroup;
import org.dominokit.domino.ui.forms.TextAreaBox;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.typography.BlockHeader;
import org.dominokit.domino.ui.utils.BaseDominoElement;

public class BasicFormsRadioSample extends BaseDominoElement<HTMLDivElement, BasicFormsRadioSample> {

    private DivElement element;

    public static BasicFormsRadioSample create() {
        return new BasicFormsRadioSample();
    }

    public BasicFormsRadioSample() {
        this.element = div().addCss(dui_p_2)
                .appendChild(h(5).textContent("Basic Examples"))
                .appendChild(Row.create()
                        .appendChild(Column.span12()
                                .appendChild(BlockHeader.create("Horizontal group"))
                                .appendChild(RadioGroup.<String>create("test").setReadOnly(true)
                                        .appendChild(Radio.create("radio1", "Radio - 1").check())
                                        .appendChild(Radio.create("radio2", "Radio - 2"))
                                        .appendChild(Radio.create("radio2", "Radio - 3"))
                                        .horizontal())
                        )
                        .appendChild(Column.span12()
                                .appendChild(BlockHeader.create("Horizontal group", "With gap"))
                                .appendChild(RadioGroup.<String>create("test")
                                        .appendChild(Radio.create("radio1_gap", "Radio 1 - With Gap").setReadOnly(true))
                                        .appendChild(Radio.create("radio2_gap", "Radio 2 - With Gap"))
                                        .appendChild(Radio.create("radio2_gap", "Radio 2 - With Gap"))
                                        .horizontal())
                        )
                        .appendChild(Column.span12()
                                .appendChild(BlockHeader.create("Horizontal group", "Disabled"))
                                .appendChild(RadioGroup.<String>create("test").disable()
                                        .appendChild(Radio.create("radio1_disabled", "Radio 1 - Disabled").disable().check())
                                        .appendChild(Radio.create("radio2_disabled", "Radio 2 - Disabled").disable())
                                        .appendChild(Radio.create("radio3_disabled", "Radio 3 - Disabled").disable())
                                        .horizontal())
                        )
                        .appendChild(Column.span12()
                                .appendChild(BlockHeader.create("Horizontal group", "Disabled"))
                                .appendChild(RadioGroup.<String>create("test")
                                        .appendChild(Radio.create("radio1_disabled", "Radio 1").check())
                                        .appendChild(Radio.create("radio2_disabled", "Radio 2"))
                                        .appendChild(Radio.create("radio3_disabled", "Radio 3 - Disabled").disable())
                                        .horizontal())
                        )
                        .appendChild(Column.span12()
                                .appendChild(BlockHeader.create("Horizontal group", "Disabled"))
                                .appendChild(RadioGroup.<String>create("test")
                                        .appendChild(Radio.create("radio1_disabled", "Radio 1 - Disabled").disable().check())
                                        .appendChild(Radio.create("radio2_disabled", "Radio 2"))
                                        .appendChild(Radio.create("radio3_disabled", "Radio 3"))
                                        .horizontal())
                        )
                )
                .appendChild(br())
                .appendChild(BlockHeader.create("With Material Design Colors"))
                .appendChild(Row.create()
                        .appendChild(Column.span3()
                                .appendChild(RadioGroup.<String>create("RED")
                                        .addCss(dui_accent_red)
                                        .appendChild(Radio.create("Radio 1", "Radio 1"))
                                        .appendChild(Radio.create("Radio 2", "Radio 2"))
                                        .appendChild(Radio.create("Radio 3", "Radio 3"))
                                )
                        )
                        .appendChild(Column.span3()
                                .appendChild(RadioGroup.<String>create("AMBER")
                                        .addCss(dui_accent_amber)
                                        .appendChild(Radio.create("Radio 1", "Radio 1"))
                                        .appendChild(Radio.create("Radio 2", "Radio 2"))
                                        .appendChild(Radio.create("Radio 3", "Radio 3"))
                                )
                        )
                        .appendChild(Column.span3()
                                .appendChild(RadioGroup.<String>create("ACCENT")
                                        .appendChild(Radio.create("Radio 1", "Radio 1"))
                                        .appendChild(Radio.create("Radio 2", "Radio 2"))
                                        .appendChild(Radio.create("Radio 3", "Radio 3"))
                                )
                        )
                        .appendChild(Column.span3()
                                .appendChild(RadioGroup.<String>create("TEAL")
                                        .addCss(dui_accent_teal)
                                        .appendChild(Radio.create("Radio 1", "Radio 1"))
                                        .appendChild(Radio.create("Radio 2", "Radio 2"))
                                        .appendChild(Radio.create("Radio 3", "Radio 3"))
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

package org.dominokit.pages.client.views.ui.samples.forms.basic;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.forms.CheckBox;
import org.dominokit.domino.ui.forms.TextAreaBox;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.typography.BlockHeader;
import org.dominokit.domino.ui.utils.BaseDominoElement;

import static org.dominokit.domino.ui.grid.Column.Span._2;
import static org.dominokit.domino.ui.grid.Column.Span._6;

public class BasicFormsCheckboxSample extends BaseDominoElement<HTMLDivElement, BasicFormsCheckboxSample> {

    private DivElement element;

    public static BasicFormsCheckboxSample create() {
        return new BasicFormsCheckboxSample();
    }

    public BasicFormsCheckboxSample() {
        this.element = div().addCss(dui_p_2)
                .appendChild(h(5).textContent("Basic Examples"))
                .appendChild(Row.create()
                        .appendChild(Column.colspan(_2, _6)
                                .appendChild(CheckBox.create("Default")))
                        .appendChild(Column.colspan(_2, _6)
                                .appendChild(CheckBox.create("Filled In").filledIn()))
                        .appendChild(Column.colspan(_2, _6)
                                .appendChild(CheckBox.create("Default - Disabled").check().disable()))
                        .appendChild(Column.colspan(_2, _6)
                                .appendChild(CheckBox.create("Filled In - Disabled").check().filledIn().disable())))
                .appendChild(Row.create()
                        .appendChild(Column.colspan(_2, _6)
                                .appendChild(CheckBox.create("Default").setReadOnly(true)))
                        .appendChild(Column.colspan(_2, _6)
                                .appendChild(CheckBox.create("Filled In").filledIn().setReadOnly(true)))
                        .appendChild(Column.colspan(_2, _6)
                                .appendChild(CheckBox.create("Default - Disabled").check().disable()))
                        .appendChild(Column.colspan(_2, _6)
                                .appendChild(CheckBox.create("Filled In - Disabled").check().filledIn().disable())))

                .appendChild(h(5).textContent("With Material Design Colors"))
                .appendChild(Row.create()
                        .appendChild(Column.colspan(_2, _6)
                                .appendChild(CheckBox.create("ACCENT").check()))
                        .appendChild(Column.colspan(_2, _6)
                                .appendChild(CheckBox.create("RED").addCss(dui_accent_red).check()))
                        .appendChild(Column.colspan(_2, _6)
                                .appendChild(CheckBox.create("AMBER").addCss(dui_accent_amber).check()))
                        .appendChild(Column.colspan(_2, _6)
                                .appendChild(CheckBox.create("DEEP PURPLE").addCss(dui_accent_deep_purple).check()))
                        .appendChild(Column.colspan(_2, _6)
                                .appendChild(CheckBox.create("INDIGO").addCss(dui_accent_indigo).check()))
                        .appendChild(Column.colspan(_2, _6)
                                .appendChild(CheckBox.create("BLUE").addCss(dui_accent_blue).check()))
                )
                .appendChild(h(5).textContent("With Material Design Colors - Filled In"))
                .appendChild(Row.create()
                        .appendChild(Column.colspan(_2, _6)
                                .appendChild(CheckBox.create("ACCENT")
                                        .check()
                                        .setFilled(true)
                                ))
                        .appendChild(Column.colspan(_2, _6)
                                .appendChild(CheckBox.create("RED").addCss(dui_accent_red)
                                        .check()
                                        .setFilled(true)
                                ))
                        .appendChild(Column.colspan(_2, _6)
                                .appendChild(CheckBox.create("AMBER").addCss(dui_accent_amber)
                                        .check()
                                        .setFilled(true)
                                ))
                        .appendChild(Column.colspan(_2, _6)
                                .appendChild(CheckBox.create("DEEP PURPLE").addCss(dui_accent_deep_purple)
                                        .check()
                                        .setFilled(true)
                                ))
                        .appendChild(Column.colspan(_2, _6)
                                .appendChild(CheckBox.create("INDIGO").addCss(dui_accent_indigo)
                                        .check()
                                        .setFilled(true)
                                ))
                        .appendChild(Column.colspan(_2, _6)
                                .appendChild(CheckBox.create("BLUE").addCss(dui_accent_blue)
                                        .check()
                                        .setFilled(true)
                                ))
                )
        ;
        init(this);
    }

    @Override
    public HTMLDivElement element() {
        return this.element.element();
    }
}

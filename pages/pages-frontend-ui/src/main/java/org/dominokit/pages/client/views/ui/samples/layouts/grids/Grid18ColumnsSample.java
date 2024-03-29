package org.dominokit.pages.client.views.ui.samples.layouts.grids;

import static org.dominokit.domino.ui.utils.Domino.div;
import static org.dominokit.domino.ui.utils.Domino.dui_accent;
import static org.dominokit.domino.ui.utils.Domino.dui_h_12;
import static org.dominokit.domino.ui.utils.Domino.dui_leading_10;
import static org.dominokit.domino.ui.utils.Domino.dui_p_2;
import static org.dominokit.domino.ui.utils.Domino.dui_text_center;
import static org.dominokit.domino.ui.utils.Domino.span;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.style.CompositeCssClass;
import org.dominokit.domino.ui.utils.BaseDominoElement;

public class Grid18ColumnsSample extends BaseDominoElement<HTMLDivElement, Grid18ColumnsSample> {

    private final DivElement element;

    private CompositeCssClass dui_sample_column = CompositeCssClass.of(dui_text_center, dui_h_12, dui_accent, dui_leading_10);

    public static Grid18ColumnsSample create() {
        return new Grid18ColumnsSample();
    }

    public Grid18ColumnsSample() {
        this.element = div()
                .addCss(dui_p_2)
                .appendChild(Row.of18Columns().addCss("count-reset")
                        .appendChild(Column.span1()
                                .appendChild(div().addCss(dui_sample_column).appendChild(span().addCss("counter"))))
                        .appendChild(Column.span1()
                                .appendChild(div().addCss(dui_sample_column).appendChild(span().addCss("counter"))))
                        .appendChild(Column.span1()
                                .appendChild(div().addCss(dui_sample_column).appendChild(span().addCss("counter"))))
                        .appendChild(Column.span1()
                                .appendChild(div().addCss(dui_sample_column).appendChild(span().addCss("counter"))))
                        .appendChild(Column.span1()
                                .appendChild(div().addCss(dui_sample_column).appendChild(span().addCss("counter"))))
                        .appendChild(Column.span1()
                                .appendChild(div().addCss(dui_sample_column).appendChild(span().addCss("counter"))))
                        .appendChild(Column.span1()
                                .appendChild(div().addCss(dui_sample_column).appendChild(span().addCss("counter"))))
                        .appendChild(Column.span1()
                                .appendChild(div().addCss(dui_sample_column).appendChild(span().addCss("counter"))))
                        .appendChild(Column.span1()
                                .appendChild(div().addCss(dui_sample_column).appendChild(span().addCss("counter"))))
                        .appendChild(Column.span1()
                                .appendChild(div().addCss(dui_sample_column).appendChild(span().addCss("counter"))))
                        .appendChild(Column.span1()
                                .appendChild(div().addCss(dui_sample_column).appendChild(span().addCss("counter"))))
                        .appendChild(Column.span1()
                                .appendChild(div().addCss(dui_sample_column).appendChild(span().addCss("counter"))))
                        .appendChild(Column.span1()
                                .appendChild(div().addCss(dui_sample_column).appendChild(span().addCss("counter"))))
                        .appendChild(Column.span1()
                                .appendChild(div().addCss(dui_sample_column).appendChild(span().addCss("counter"))))
                        .appendChild(Column.span1()
                                .appendChild(div().addCss(dui_sample_column).appendChild(span().addCss("counter"))))
                        .appendChild(Column.span1()
                                .appendChild(div().addCss(dui_sample_column).appendChild(span().addCss("counter"))))
                        .appendChild(Column.span1()
                                .appendChild(div().addCss(dui_sample_column).appendChild(span().addCss("counter"))))
                        .appendChild(Column.span1()
                                .appendChild(div().addCss(dui_sample_column).appendChild(span().addCss("counter"))))
                )
                .appendChild(Row.of18Columns().addCss("count-reset")
                        .appendChild(Column.span2()
                                .appendChild(div().addCss(dui_sample_column).appendChild(span().addCss("counter"))))
                        .appendChild(Column.span2()
                                .appendChild(div().addCss(dui_sample_column).appendChild(span().addCss("counter"))))
                        .appendChild(Column.span2()
                                .appendChild(div().addCss(dui_sample_column).appendChild(span().addCss("counter"))))
                        .appendChild(Column.span2()
                                .appendChild(div().addCss(dui_sample_column).appendChild(span().addCss("counter"))))
                        .appendChild(Column.span2()
                                .appendChild(div().addCss(dui_sample_column).appendChild(span().addCss("counter"))))
                        .appendChild(Column.span2()
                                .appendChild(div().addCss(dui_sample_column).appendChild(span().addCss("counter"))))
                        .appendChild(Column.span2()
                                .appendChild(div().addCss(dui_sample_column).appendChild(span().addCss("counter"))))
                        .appendChild(Column.span2()
                                .appendChild(div().addCss(dui_sample_column).appendChild(span().addCss("counter"))))
                        .appendChild(Column.span2()
                                .appendChild(div().addCss(dui_sample_column).appendChild(span().addCss("counter"))))
                )
                .appendChild(Row.of18Columns().addCss("count-reset")
                        .appendChild(Column.span3()
                                .appendChild(div().addCss(dui_sample_column).appendChild(span().addCss("counter"))))
                        .appendChild(Column.span3()
                                .appendChild(div().addCss(dui_sample_column).appendChild(span().addCss("counter"))))
                        .appendChild(Column.span3()
                                .appendChild(div().addCss(dui_sample_column).appendChild(span().addCss("counter"))))
                        .appendChild(Column.span3()
                                .appendChild(div().addCss(dui_sample_column).appendChild(span().addCss("counter"))))
                        .appendChild(Column.span3()
                                .appendChild(div().addCss(dui_sample_column).appendChild(span().addCss("counter"))))
                        .appendChild(Column.span3()
                                .appendChild(div().addCss(dui_sample_column).appendChild(span().addCss("counter"))))
                )
                .appendChild(Row.of18Columns().addCss("count-reset")
                        .appendChild(Column.span6()
                                .appendChild(div().addCss(dui_sample_column).appendChild(span().addCss("counter"))))
                        .appendChild(Column.span6()
                                .appendChild(div().addCss(dui_sample_column).appendChild(span().addCss("counter"))))
                        .appendChild(Column.span6()
                                .appendChild(div().addCss(dui_sample_column).appendChild(span().addCss("counter"))))
                )
                .appendChild(Row.of18Columns().addCss("count-reset")
                        .appendChild(Column.span9()
                                .appendChild(div().addCss(dui_sample_column).appendChild(span().addCss("counter"))))
                        .appendChild(Column.span9()
                                .appendChild(div().addCss(dui_sample_column).appendChild(span().addCss("counter"))))
                )
                .appendChild(Row.of18Columns().addCss("count-reset")
                        .appendChild(Column.span18()
                                .appendChild(div().addCss(dui_sample_column).appendChild(span().addCss("counter"))))
                )
                .appendChild(Row.of18Columns().addCss("count-reset")
                        .appendChild(Column.span17()
                                .appendChild(div().addCss(dui_sample_column).appendChild(span().addCss("counter"))))
                        .appendChild(Column.span1()
                                .appendChild(div().addCss(dui_sample_column).appendChild(span().addCss("counter"))))
                )
                .appendChild(Row.of18Columns().addCss("count-reset")
                        .appendChild(Column.span16()
                                .appendChild(div().addCss(dui_sample_column).appendChild(span().addCss("counter"))))
                        .appendChild(Column.span2()
                                .appendChild(div().addCss(dui_sample_column).appendChild(span().addCss("counter"))))
                )
                .appendChild(Row.of18Columns().addCss("count-reset")
                        .appendChild(Column.span15()
                                .appendChild(div().addCss(dui_sample_column).appendChild(span().addCss("counter"))))
                        .appendChild(Column.span3()
                                .appendChild(div().addCss(dui_sample_column).appendChild(span().addCss("counter"))))
                )
                .appendChild(Row.of18Columns().addCss("count-reset")
                        .appendChild(Column.span14()
                                .appendChild(div().addCss(dui_sample_column).appendChild(span().addCss("counter"))))
                        .appendChild(Column.span4()
                                .appendChild(div().addCss(dui_sample_column).appendChild(span().addCss("counter"))))
                )
                .appendChild(Row.of18Columns().addCss("count-reset")
                        .appendChild(Column.span13()
                                .appendChild(div().addCss(dui_sample_column).appendChild(span().addCss("counter"))))
                        .appendChild(Column.span5()
                                .appendChild(div().addCss(dui_sample_column).appendChild(span().addCss("counter"))))
                )
                .appendChild(Row.of18Columns().addCss("count-reset")
                        .appendChild(Column.span12()
                                .appendChild(div().addCss(dui_sample_column).appendChild(span().addCss("counter"))))
                        .appendChild(Column.span6()
                                .appendChild(div().addCss(dui_sample_column).appendChild(span().addCss("counter"))))
                )
                .appendChild(Row.of18Columns().addCss("count-reset")
                        .appendChild(Column.span11()
                                .appendChild(div().addCss(dui_sample_column).appendChild(span().addCss("counter"))))
                        .appendChild(Column.span7()
                                .appendChild(div().addCss(dui_sample_column).appendChild(span().addCss("counter"))))
                )
                .appendChild(Row.of18Columns().addCss("count-reset")
                        .appendChild(Column.span10()
                                .appendChild(div().addCss(dui_sample_column).appendChild(span().addCss("counter"))))
                        .appendChild(Column.span8()
                                .appendChild(div().addCss(dui_sample_column).appendChild(span().addCss("counter"))))
                )
                .appendChild(Row.of18Columns().addCss("count-reset")
                        .appendChild(Column.span9()
                                .appendChild(div().addCss(dui_sample_column).appendChild(span().addCss("counter"))))
                        .appendChild(Column.span9()
                                .appendChild(div().addCss(dui_sample_column).appendChild(span().addCss("counter"))))
                )
                .appendChild(Row.of18Columns().addCss("count-reset")
                        .appendChild(Column.span8()
                                .appendChild(div().addCss(dui_sample_column).appendChild(span().addCss("counter"))))
                        .appendChild(Column.span10()
                                .appendChild(div().addCss(dui_sample_column).appendChild(span().addCss("counter"))))
                )
                .appendChild(Row.of18Columns().addCss("count-reset")
                        .appendChild(Column.span7()
                                .appendChild(div().addCss(dui_sample_column).appendChild(span().addCss("counter"))))
                        .appendChild(Column.span11()
                                .appendChild(div().addCss(dui_sample_column).appendChild(span().addCss("counter"))))
                )
                .appendChild(Row.of18Columns().addCss("count-reset")
                        .appendChild(Column.span6()
                                .appendChild(div().addCss(dui_sample_column).appendChild(span().addCss("counter"))))
                        .appendChild(Column.span12()
                                .appendChild(div().addCss(dui_sample_column).appendChild(span().addCss("counter"))))
                )
                .appendChild(Row.of18Columns().addCss("count-reset")
                        .appendChild(Column.span5()
                                .appendChild(div().addCss(dui_sample_column).appendChild(span().addCss("counter"))))
                        .appendChild(Column.span13()
                                .appendChild(div().addCss(dui_sample_column).appendChild(span().addCss("counter"))))
                )
                .appendChild(Row.of18Columns().addCss("count-reset")
                        .appendChild(Column.span4()
                                .appendChild(div().addCss(dui_sample_column).appendChild(span().addCss("counter"))))
                        .appendChild(Column.span14()
                                .appendChild(div().addCss(dui_sample_column).appendChild(span().addCss("counter"))))
                )
                .appendChild(Row.of18Columns().addCss("count-reset")
                        .appendChild(Column.span3()
                                .appendChild(div().addCss(dui_sample_column).appendChild(span().addCss("counter"))))
                        .appendChild(Column.span15()
                                .appendChild(div().addCss(dui_sample_column).appendChild(span().addCss("counter"))))
                )
                .appendChild(Row.of18Columns().addCss("count-reset")
                        .appendChild(Column.span2()
                                .appendChild(div().addCss(dui_sample_column).appendChild(span().addCss("counter"))))
                        .appendChild(Column.span16()
                                .appendChild(div().addCss(dui_sample_column).appendChild(span().addCss("counter"))))
                )
                .appendChild(Row.of18Columns().addCss("count-reset")
                        .appendChild(Column.span1()
                                .appendChild(div().addCss(dui_sample_column).appendChild(span().addCss("counter"))))
                        .appendChild(Column.span17()
                                .appendChild(div().addCss(dui_sample_column).appendChild(span().addCss("counter"))))
                )
                .appendChild(Row.of18Columns().addCss("count-reset")
                        .appendChild(Column
                                .span1()
                                .appendChild(div().addCss(dui_sample_column).appendChild(span().addCss("counter"))))
                )
                .appendChild(Row.of18Columns().addCss("count-reset")
                        .appendChild(Column
                                .span1()
                                .offset0()
                                .appendChild(div().addCss(dui_sample_column).appendChild(span().addCss("counter"))))
                )
                .appendChild(Row.of18Columns().addCss("count-reset")
                        .appendChild(Column
                                .span1()
                                .offset1()
                                .appendChild(div().addCss(dui_sample_column).appendChild(span().addCss("counter"))))
                )
                .appendChild(Row.of18Columns().addCss("count-reset")
                        .appendChild(Column
                                .span1()
                                .offset2()
                                .appendChild(div().addCss(dui_sample_column).appendChild(span().addCss("counter"))))
                )
                .appendChild(Row.of18Columns().addCss("count-reset")
                        .appendChild(Column
                                .span1()
                                .offset3()
                                .appendChild(div().addCss(dui_sample_column).appendChild(span().addCss("counter"))))
                )
                .appendChild(Row.of18Columns().addCss("count-reset")
                        .appendChild(Column
                                .span1()
                                .offset4()
                                .appendChild(div().addCss(dui_sample_column).appendChild(span().addCss("counter"))))
                )
                .appendChild(Row.of18Columns().addCss("count-reset")
                        .appendChild(Column
                                .span1()
                                .offset5()
                                .appendChild(div().addCss(dui_sample_column).appendChild(span().addCss("counter"))))
                )
                .appendChild(Row.of18Columns().addCss("count-reset")
                        .appendChild(Column
                                .span1()
                                .offset6()
                                .appendChild(div().addCss(dui_sample_column).appendChild(span().addCss("counter"))))
                )
                .appendChild(Row.of18Columns().addCss("count-reset")
                        .appendChild(Column
                                .span1()
                                .offset7()
                                .appendChild(div().addCss(dui_sample_column).appendChild(span().addCss("counter"))))
                )
                .appendChild(Row.of18Columns().addCss("count-reset")
                        .appendChild(Column
                                .span1()
                                .offset8()
                                .appendChild(div().addCss(dui_sample_column).appendChild(span().addCss("counter"))))
                )
                .appendChild(Row.of18Columns().addCss("count-reset")
                        .appendChild(Column
                                .span1()
                                .offset9()
                                .appendChild(div().addCss(dui_sample_column).appendChild(span().addCss("counter"))))
                )
                .appendChild(Row.of18Columns().addCss("count-reset")
                        .appendChild(Column
                                .span1()
                                .offset10()
                                .appendChild(div().addCss(dui_sample_column).appendChild(span().addCss("counter"))))
                )
                .appendChild(Row.of18Columns().addCss("count-reset")
                        .appendChild(Column
                                .span1()
                                .offset11()
                                .appendChild(div().addCss(dui_sample_column).appendChild(span().addCss("counter"))))
                )
                .appendChild(Row.of18Columns().addCss("count-reset")
                        .appendChild(Column
                                .span1()
                                .offset12()
                                .appendChild(div().addCss(dui_sample_column).appendChild(span().addCss("counter"))))
                )
                .appendChild(Row.of18Columns().addCss("count-reset")
                        .appendChild(Column
                                .span1()
                                .offset13()
                                .appendChild(div().addCss(dui_sample_column).appendChild(span().addCss("counter"))))
                )
                .appendChild(Row.of18Columns().addCss("count-reset")
                        .appendChild(Column
                                .span1()
                                .offset14()
                                .appendChild(div().addCss(dui_sample_column).appendChild(span().addCss("counter"))))
                )
                .appendChild(Row.of18Columns().addCss("count-reset")
                        .appendChild(Column
                                .span1()
                                .offset15()
                                .appendChild(div().addCss(dui_sample_column).appendChild(span().addCss("counter"))))
                )
                .appendChild(Row.of18Columns().addCss("count-reset")
                        .appendChild(Column
                                .span1()
                                .offset16()
                                .appendChild(div().addCss(dui_sample_column).appendChild(span().addCss("counter"))))
                )
                .appendChild(Row.of18Columns().addCss("count-reset")
                        .appendChild(Column
                                .span1()
                                .offset17()
                                .appendChild(div().addCss(dui_sample_column).appendChild(span().addCss("counter"))))
                )
                .appendChild(Row.of18Columns().addCss("count-reset")
                        .appendChild(Column
                                .span6()
                                .offset6()
                                .appendChild(div().addCss(dui_sample_column).appendChild(span().addCss("counter"))))
                );

        init(this);
    }

    @Override
    public HTMLDivElement element() {
        return element.element();
    }
}

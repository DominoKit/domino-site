package org.dominokit.pages.client.views.ui.samples.layouts.grids;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.style.CompositeCssClass;
import org.dominokit.domino.ui.utils.BaseDominoElement;

public class Grid12ColumnsSample extends BaseDominoElement<HTMLDivElement, Grid12ColumnsSample> {

    private final DivElement element;

    private CompositeCssClass dui_sample_column = CompositeCssClass.of(dui_text_center, dui_h_12, dui_accent, dui_leading_10);

    public static Grid12ColumnsSample create() {
        return new Grid12ColumnsSample();
    }

    public Grid12ColumnsSample() {
        this.element = div()
                .addCss(dui_p_2)
                .appendChild(Row.create().addCss("count-reset")
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
                .appendChild(Row.create().addCss("count-reset")
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
                .appendChild(Row.create().addCss("count-reset")
                        .appendChild(Column.span3()
                                .appendChild(div().addCss(dui_sample_column).appendChild(span().addCss("counter"))))
                        .appendChild(Column.span3()
                                .appendChild(div().addCss(dui_sample_column).appendChild(span().addCss("counter"))))
                        .appendChild(Column.span3()
                                .appendChild(div().addCss(dui_sample_column).appendChild(span().addCss("counter"))))
                        .appendChild(Column.span3()
                                .appendChild(div().addCss(dui_sample_column).appendChild(span().addCss("counter"))))
                )
                .appendChild(Row.create().addCss("count-reset")
                        .appendChild(Column.span4()
                                .appendChild(div().addCss(dui_sample_column).appendChild(span().addCss("counter"))))
                        .appendChild(Column.span4()
                                .appendChild(div().addCss(dui_sample_column).appendChild(span().addCss("counter"))))
                        .appendChild(Column.span4()
                                .appendChild(div().addCss(dui_sample_column).appendChild(span().addCss("counter"))))
                )
                .appendChild(Row.create().addCss("count-reset")
                        .appendChild(Column.span6()
                                .appendChild(div().addCss(dui_sample_column).appendChild(span().addCss("counter"))))
                        .appendChild(Column.span6()
                                .appendChild(div().addCss(dui_sample_column).appendChild(span().addCss("counter"))))
                )
                .appendChild(Row.create().addCss("count-reset")
                        .appendChild(Column.span12()
                                .appendChild(div().addCss(dui_sample_column).appendChild(span().addCss("counter"))))
                )
                .appendChild(Row.create().addCss("count-reset")
                        .appendChild(Column.span11()
                                .appendChild(div().addCss(dui_sample_column).appendChild(span().addCss("counter"))))
                        .appendChild(Column.span1()
                                .appendChild(div().addCss(dui_sample_column).appendChild(span().addCss("counter"))))
                )
                .appendChild(Row.create().addCss("count-reset")
                        .appendChild(Column.span10()
                                .appendChild(div().addCss(dui_sample_column).appendChild(span().addCss("counter"))))
                        .appendChild(Column.span2()
                                .appendChild(div().addCss(dui_sample_column).appendChild(span().addCss("counter"))))
                )
                .appendChild(Row.create().addCss("count-reset")
                        .appendChild(Column.span9()
                                .appendChild(div().addCss(dui_sample_column).appendChild(span().addCss("counter"))))
                        .appendChild(Column.span3()
                                .appendChild(div().addCss(dui_sample_column).appendChild(span().addCss("counter"))))
                )
                .appendChild(Row.create().addCss("count-reset")
                        .appendChild(Column.span8()
                                .appendChild(div().addCss(dui_sample_column).appendChild(span().addCss("counter"))))
                        .appendChild(Column.span4()
                                .appendChild(div().addCss(dui_sample_column).appendChild(span().addCss("counter"))))
                )
                .appendChild(Row.create().addCss("count-reset")
                        .appendChild(Column.span7()
                                .appendChild(div().addCss(dui_sample_column).appendChild(span().addCss("counter"))))
                        .appendChild(Column.span5()
                                .appendChild(div().addCss(dui_sample_column).appendChild(span().addCss("counter"))))
                )
                .appendChild(Row.create().addCss("count-reset")
                        .appendChild(Column.span6()
                                .appendChild(div().addCss(dui_sample_column).appendChild(span().addCss("counter"))))
                        .appendChild(Column.span6()
                                .appendChild(div().addCss(dui_sample_column).appendChild(span().addCss("counter"))))
                )
                .appendChild(Row.create().addCss("count-reset")
                        .appendChild(Column.span5()
                                .appendChild(div().addCss(dui_sample_column).appendChild(span().addCss("counter"))))
                        .appendChild(Column.span7()
                                .appendChild(div().addCss(dui_sample_column).appendChild(span().addCss("counter"))))
                )
                .appendChild(Row.create().addCss("count-reset")
                        .appendChild(Column.span4()
                                .appendChild(div().addCss(dui_sample_column).appendChild(span().addCss("counter"))))
                        .appendChild(Column.span8()
                                .appendChild(div().addCss(dui_sample_column).appendChild(span().addCss("counter"))))
                )
                .appendChild(Row.create().addCss("count-reset")
                        .appendChild(Column.span3()
                                .appendChild(div().addCss(dui_sample_column).appendChild(span().addCss("counter"))))
                        .appendChild(Column.span9()
                                .appendChild(div().addCss(dui_sample_column).appendChild(span().addCss("counter"))))
                )
                .appendChild(Row.create().addCss("count-reset")
                        .appendChild(Column.span2()
                                .appendChild(div().addCss(dui_sample_column).appendChild(span().addCss("counter"))))
                        .appendChild(Column.span10()
                                .appendChild(div().addCss(dui_sample_column).appendChild(span().addCss("counter"))))
                )
                .appendChild(Row.create().addCss("count-reset")
                        .appendChild(Column.span1()
                                .appendChild(div().addCss(dui_sample_column).appendChild(span().addCss("counter"))))
                        .appendChild(Column.span11()
                                .appendChild(div().addCss(dui_sample_column).appendChild(span().addCss("counter"))))
                )
                .appendChild(Row.create().addCss("count-reset")
                        .appendChild(Column
                                .span1()
                                .appendChild(div().addCss(dui_sample_column).appendChild(span().addCss("counter"))))
                )
                .appendChild(Row.create().addCss("count-reset")
                        .appendChild(Column
                                .span1()
                                .offset0()
                                .appendChild(div().addCss(dui_sample_column).appendChild(span().addCss("counter"))))
                )
                .appendChild(Row.create().addCss("count-reset")
                        .appendChild(Column
                                .span1()
                                .offset1()
                                .appendChild(div().addCss(dui_sample_column).appendChild(span().addCss("counter"))))
                )
                .appendChild(Row.create().addCss("count-reset")
                        .appendChild(Column
                                .span1()
                                .offset2()
                                .appendChild(div().addCss(dui_sample_column).appendChild(span().addCss("counter"))))
                )
                .appendChild(Row.create().addCss("count-reset")
                        .appendChild(Column
                                .span1()
                                .offset3()
                                .appendChild(div().addCss(dui_sample_column).appendChild(span().addCss("counter"))))
                )
                .appendChild(Row.create().addCss("count-reset")
                        .appendChild(Column
                                .span1()
                                .offset4()
                                .appendChild(div().addCss(dui_sample_column).appendChild(span().addCss("counter"))))
                )
                .appendChild(Row.create().addCss("count-reset")
                        .appendChild(Column
                                .span1()
                                .offset5()
                                .appendChild(div().addCss(dui_sample_column).appendChild(span().addCss("counter"))))
                )
                .appendChild(Row.create().addCss("count-reset")
                        .appendChild(Column
                                .span1()
                                .offset6()
                                .appendChild(div().addCss(dui_sample_column).appendChild(span().addCss("counter"))))
                )
                .appendChild(Row.create().addCss("count-reset")
                        .appendChild(Column
                                .span1()
                                .offset7()
                                .appendChild(div().addCss(dui_sample_column).appendChild(span().addCss("counter"))))
                )
                .appendChild(Row.create().addCss("count-reset")
                        .appendChild(Column
                                .span1()
                                .offset8()
                                .appendChild(div().addCss(dui_sample_column).appendChild(span().addCss("counter"))))
                )
                .appendChild(Row.create().addCss("count-reset")
                        .appendChild(Column
                                .span1()
                                .offset9()
                                .appendChild(div().addCss(dui_sample_column).appendChild(span().addCss("counter"))))
                )
                .appendChild(Row.create().addCss("count-reset")
                        .appendChild(Column
                                .span1()
                                .offset10()
                                .appendChild(div().addCss(dui_sample_column).appendChild(span().addCss("counter"))))
                )
                .appendChild(Row.create().addCss("count-reset")
                        .appendChild(Column
                                .span1()
                                .offset11()
                                .appendChild(div().addCss(dui_sample_column).appendChild(span().addCss("counter"))))
                )
                .appendChild(Row.create().addCss("count-reset")
                        .appendChild(Column
                                .span6()
                                .offset3()
                                .appendChild(div().addCss(dui_sample_column).appendChild(span().addCss("counter"))))
                );

        init(this);
    }

    @Override
    public HTMLDivElement element() {
        return element.element();
    }
}
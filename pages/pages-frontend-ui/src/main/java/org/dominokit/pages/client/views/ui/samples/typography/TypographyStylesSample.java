package org.dominokit.pages.client.views.ui.samples.typography;

import static org.dominokit.domino.ui.utils.Domino.b;
import static org.dominokit.domino.ui.utils.Domino.div;
import static org.dominokit.domino.ui.utils.Domino.dui_fg_blue_grey;
import static org.dominokit.domino.ui.utils.Domino.dui_fg_cyan;
import static org.dominokit.domino.ui.utils.Domino.dui_fg_orange;
import static org.dominokit.domino.ui.utils.Domino.dui_fg_pink;
import static org.dominokit.domino.ui.utils.Domino.dui_fg_teal;
import static org.dominokit.domino.ui.utils.Domino.dui_font_bold;
import static org.dominokit.domino.ui.utils.Domino.dui_italic;
import static org.dominokit.domino.ui.utils.Domino.dui_line_through;
import static org.dominokit.domino.ui.utils.Domino.dui_overline;
import static org.dominokit.domino.ui.utils.Domino.dui_p_2;
import static org.dominokit.domino.ui.utils.Domino.dui_underline;
import static org.dominokit.domino.ui.utils.Domino.p;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.utils.BaseDominoElement;

public class TypographyStylesSample extends BaseDominoElement<HTMLDivElement, TypographyStylesSample> {

    private DivElement element;

    public static TypographyStylesSample create() {
        return new TypographyStylesSample();
    }

    public TypographyStylesSample() {
        this.element = div().addCss(dui_p_2)
                .appendChild(Row.create()
                        .appendChild(Column.span2()
                                .appendChild(p().appendChild(b().textContent("Normal")))
                                .appendChild(p("Default text"))
                                .appendChild(p("Text pink color").addCss(dui_fg_pink))
                                .appendChild(p("Text cyan color").addCss(dui_fg_cyan))
                                .appendChild(p("Text teal color").addCss(dui_fg_teal))
                                .appendChild(p("Text orange color").addCss(dui_fg_orange))
                                .appendChild(p("Text blue grey color").addCss(dui_fg_blue_grey))
                        )
                        .appendChild(Column.span2()
                                .appendChild(p().appendChild(b().textContent("Bold")))
                                .appendChild(p("Default text").addCss(dui_font_bold))
                                .appendChild(p("Text pink color").addCss(dui_font_bold, dui_fg_pink))
                                .appendChild(p("Text cyan color").addCss(dui_font_bold, dui_fg_cyan))
                                .appendChild(p("Text teal color").addCss(dui_font_bold, dui_fg_teal))
                                .appendChild(p("Text orange color").addCss(dui_font_bold, dui_fg_orange))
                                .appendChild(p("Text blue grey color").addCss(dui_font_bold, dui_fg_blue_grey))
                        )
                        .appendChild(Column.span2()
                                .appendChild(p().appendChild(b().textContent("Italic")))
                                .appendChild(p("Default text").addCss(dui_italic))
                                .appendChild(p("Text pink color").addCss(dui_italic, dui_fg_pink))
                                .appendChild(p("Text cyan color").addCss(dui_italic, dui_fg_cyan))
                                .appendChild(p("Text teal color").addCss(dui_italic, dui_fg_teal))
                                .appendChild(p("Text orange color").addCss(dui_italic, dui_fg_orange))
                                .appendChild(p("Text blue grey color").addCss(dui_italic, dui_fg_blue_grey))
                        )
                        .appendChild(Column.span2()
                                .appendChild(p().appendChild(b().textContent("Under line")))
                                .appendChild(p("Default text").addCss(dui_underline))
                                .appendChild(p("Text pink color").addCss(dui_underline, dui_fg_pink))
                                .appendChild(p("Text cyan color").addCss(dui_underline, dui_fg_cyan))
                                .appendChild(p("Text teal color").addCss(dui_underline, dui_fg_teal))
                                .appendChild(p("Text orange color").addCss(dui_underline, dui_fg_orange))
                                .appendChild(p("Text blue grey color").addCss(dui_underline, dui_fg_blue_grey))
                        )
                        .appendChild(Column.span2()
                                .appendChild(p().appendChild(b().textContent("Line through")))
                                .appendChild(p("Default text").addCss(dui_line_through))
                                .appendChild(p("Text pink color").addCss(dui_line_through, dui_fg_pink))
                                .appendChild(p("Text cyan color").addCss(dui_line_through, dui_fg_cyan))
                                .appendChild(p("Text teal color").addCss(dui_line_through, dui_fg_teal))
                                .appendChild(p("Text orange color").addCss(dui_line_through, dui_fg_orange))
                                .appendChild(p("Text blue grey color").addCss(dui_line_through, dui_fg_blue_grey))
                        )
                        .appendChild(Column.span2()
                                .appendChild(p().appendChild(b().textContent("Over line")))
                                .appendChild(p("Default text").addCss(dui_overline))
                                .appendChild(p("Text pink color").addCss(dui_overline, dui_fg_pink))
                                .appendChild(p("Text cyan color").addCss(dui_overline, dui_fg_cyan))
                                .appendChild(p("Text teal color").addCss(dui_overline, dui_fg_teal))
                                .appendChild(p("Text orange color").addCss(dui_overline, dui_fg_orange))
                                .appendChild(p("Text blue grey color").addCss(dui_overline, dui_fg_blue_grey))
                        )
                );
        init(this);
    }

    @Override
    public HTMLDivElement element() {
        return this.element.element();
    }
}

package org.dominokit.pages.client.views.ui.samples.layouts.gridlayout;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.forms.CheckBox;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.GridLayout;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.grid.SectionSpan;
import org.dominokit.domino.ui.sliders.Slider;
import org.dominokit.domino.ui.style.CompositeCssClass;
import org.dominokit.domino.ui.utils.BaseDominoElement;

import static org.dominokit.domino.ui.utils.Domino.*;

public class GridLayoutSample extends BaseDominoElement<HTMLDivElement, GridLayoutSample> {

    private final DivElement element;
    private GridLayout gridLayout;
    private CompositeCssClass dui_grid_section =CompositeCssClass.of(dui_bg_accent_l_2, dui_border, dui_border_solid, dui_border_accent_d_2, dui_text_center, dui_fg_white);

    public static GridLayoutSample create(){
        return new GridLayoutSample();
    }

    public GridLayoutSample() {
        gridLayout = GridLayout.create()
                .setHeight("500px");
        this.element = div();

        gridLayout
                .withContent((parent, content) -> content
                        .addCss(dui_grid_section)
                        .appendChild(span().textContent("Content"))
                )
                .withHeader((parent, header) -> header
                        .addCss(dui_grid_section)
                        .appendChild(span().textContent("Header"))
                )
                .withFooter((parent, footer) -> footer
                        .addCss(dui_grid_section)
                        .appendChild(span().textContent("Footer"))
                )
                .withLeftPanel((parent, leftPanel) -> leftPanel
                        .addCss(dui_grid_section)
                        .appendChild(span().textContent("Left"))
                )
                .withRightPanel((parent, rightPanel) -> rightPanel
                        .addCss(dui_grid_section)
                        .appendChild(span().textContent("Right"))
                );

        Slider headerSlider = Slider.create(6, 0, 1)
                .withThumb()
                .setStep(1);
        headerSlider.addChangeListener((oldValue, newValue) -> {
            gridLayout.setHeaderSpan(SectionSpan.valueOf("_" + newValue));
        });

        Slider leftSlider = Slider.create(6, 0, 3)
                .withThumb()
                .setStep(1);
        CheckBox leftSpanUpCheck = CheckBox.create("Span Up");
        CheckBox leftSpanDownCheck = CheckBox.create("Span Down");
        leftSpanUpCheck
                .addChangeListener((oldValue, newValue) -> {
                    gridLayout.setLeftSpan(SectionSpan.valueOf("_" + leftSlider.getValue()), newValue, leftSpanDownCheck.getValue());
                });

        leftSpanDownCheck
                .addChangeListener((oldValue, newValue) -> {
                    gridLayout.setLeftSpan(SectionSpan.valueOf("_" + leftSlider.getValue()), leftSpanUpCheck.getValue(), newValue);
                });
        leftSlider.addChangeListener((oldValue, newValue) -> {
            gridLayout.setLeftSpan(SectionSpan.valueOf("_" + newValue), leftSpanUpCheck.getValue(), leftSpanDownCheck.getValue());
        });


        Slider rightSlider = Slider.create(6, 0, 3)
                .withThumb()
                .setStep(1);
        CheckBox rightSpanUpCheck = CheckBox.create("Span Up");
        CheckBox rightSpanDownCheck = CheckBox.create("Span Down");
        rightSpanUpCheck
                .addChangeListener((oldValue, newValue) -> {
                    gridLayout.setRightSpan(SectionSpan.valueOf("_" + rightSlider.getValue()), newValue, rightSpanDownCheck.getValue());
                });

        rightSpanDownCheck
                .addChangeListener((oldValue, newValue) -> {
                    gridLayout.setRightSpan(SectionSpan.valueOf("_" + rightSlider.getValue()), rightSpanUpCheck.getValue(), newValue);
                });
        rightSlider.addChangeListener((oldValue, newValue) -> {
            gridLayout.setRightSpan(SectionSpan.valueOf("_" + newValue), rightSpanUpCheck.getValue(), rightSpanDownCheck.getValue());
        });


        Slider footerSlider = Slider.create(6, 0, 1)
                .withThumb()
                .setStep(1);
        footerSlider.addChangeListener((oldValue, newValue) -> {
            gridLayout.setFooterSpan(SectionSpan.valueOf("_" + newValue));
        });

        Slider gapSlider = Slider.create(10, 0, 0)
                .withThumb()
                .setStep(1)
                .addChangeListener((oldValue, newValue) -> gridLayout.setGap(newValue + "px"));

        element.appendChild(Card.create()
                        .addCss(dui_elevation_0)
                .appendChild(Row.create()
                        .appendChild(Column.span2()
                                .offset(Column.Offset._1_)
                                .appendChild(headerSlider)
                                .appendChild(h(5).textContent("Header")))
                        .appendChild(Column.span2()
                                .appendChild(leftSlider)
                                .appendChild(h(5).textContent("Left"))
                                .appendChild(leftSpanUpCheck)
                                .appendChild(leftSpanDownCheck)
                        )
                        .appendChild(Column.span2()
                                .appendChild(rightSlider)
                                .appendChild(h(5).textContent("Right"))
                                .appendChild(rightSpanUpCheck)
                                .appendChild(rightSpanDownCheck)
                        )
                        .appendChild(Column.span2()
                                .appendChild(footerSlider)
                                .appendChild(h(5).textContent("Footer"))
                        )
                        .appendChild(Column.span2()
                                .appendChild(gapSlider)
                                .appendChild(h(5).textContent("Gap"))
                        )
                )
                .appendChild(gridLayout));
        init(this);

    }

    @Override
    public HTMLDivElement element() {
        return element.element();
    }
}

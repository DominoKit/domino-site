package org.dominokit.pages.client.views.ui.samples.components.sliders;

import static org.dominokit.domino.ui.utils.Domino.div;
import static org.dominokit.domino.ui.utils.Domino.dui_accent_blue;
import static org.dominokit.domino.ui.utils.Domino.dui_accent_green;
import static org.dominokit.domino.ui.utils.Domino.dui_accent_red;
import static org.dominokit.domino.ui.utils.Domino.dui_flex;
import static org.dominokit.domino.ui.utils.Domino.dui_flex_col;
import static org.dominokit.domino.ui.utils.Domino.dui_gap_4;
import static org.dominokit.domino.ui.utils.Domino.dui_grow_1;
import static org.dominokit.domino.ui.utils.Domino.dui_h_full;
import static org.dominokit.domino.ui.utils.Domino.dui_items_center;
import static org.dominokit.domino.ui.utils.Domino.dui_p_2;
import static org.dominokit.domino.ui.utils.Domino.dui_w_full;
import static org.dominokit.domino.ui.utils.Domino.h;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.forms.SwitchButton;
import org.dominokit.domino.ui.forms.TextBox;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.sliders.Slider;
import org.dominokit.domino.ui.utils.BaseDominoElement;

public class SlidersPickerSample extends BaseDominoElement<HTMLDivElement, SlidersPickerSample> {

    private DivElement element;

    public static SlidersPickerSample create() {
        return new SlidersPickerSample();
    }

    public SlidersPickerSample() {
        this.element = div().addCss(dui_p_2);
        DivElement rgbColorsDiv = div()
                .addCss(dui_h_full, dui_w_full);

        Slider redSlider = Slider.create(255, 0)
                .addCss(dui_accent_red)
                .anyStep()
                .setShowThumb(false);
        Slider greenSlider = Slider.create(255, 0)
                .addCss(dui_accent_green)
                .anyStep()
                .setShowThumb(false);
        ;
        Slider blueSlider = Slider.create(255, 0)
                .addCss(dui_accent_blue)
                .anyStep()
                .setShowThumb(false);
        ;

        TextBox redTextBox = TextBox.create()
                .addChangeListener((oldValue, value) -> {
                    redSlider.setValue(Double.parseDouble(value), true);
                    updateBackgroundColor(rgbColorsDiv, redSlider, greenSlider, blueSlider);
                });
        TextBox greenTextBox = TextBox.create()
                .addChangeListener((oldValue, value) -> {
                    greenSlider.setValue(Double.parseDouble(value), true);
                    updateBackgroundColor(rgbColorsDiv, redSlider, greenSlider, blueSlider);
                });
        TextBox blueTextBox = TextBox.create()
                .addChangeListener((oldValue, value) -> {
                    blueSlider.setValue(Double.parseDouble(value), true);
                    updateBackgroundColor(rgbColorsDiv, redSlider, greenSlider, blueSlider);
                });


        redSlider.addChangeListener((oldValue, value) -> {
            updateColorAndTextBoxes(rgbColorsDiv, redSlider, greenSlider, blueSlider, redTextBox, greenTextBox, blueTextBox);
        });
        redSlider.addChangeListener((oldValue, value) -> {
            updateColorAndTextBoxes(rgbColorsDiv, redSlider, greenSlider, blueSlider, redTextBox, greenTextBox, blueTextBox);
        });

        greenSlider.addChangeListener((oldValue, value) -> {
            updateColorAndTextBoxes(rgbColorsDiv, redSlider, greenSlider, blueSlider, redTextBox, greenTextBox, blueTextBox);
        });
        greenSlider.addChangeListener((oldValue, value) -> {
            updateColorAndTextBoxes(rgbColorsDiv, redSlider, greenSlider, blueSlider, redTextBox, greenTextBox, blueTextBox);
        });

        blueSlider.addChangeListener((oldValue, value) -> {
            updateColorAndTextBoxes(rgbColorsDiv, redSlider, greenSlider, blueSlider, redTextBox, greenTextBox, blueTextBox);
        });
        blueSlider.addChangeListener((oldValue, value) -> {
            updateColorAndTextBoxes(rgbColorsDiv, redSlider, greenSlider, blueSlider, redTextBox, greenTextBox, blueTextBox);
        });

        redSlider.setValue(0);
        greenSlider.setValue(128);
        blueSlider.setValue(128);

        TextBox stepTextBox = TextBox.create("Step")
                .withValue("any")
                .addChangeListener((oldValue, value) -> {
                    if ("any".equalsIgnoreCase(value)) {
                        redSlider.anyStep();
                        greenSlider.anyStep();
                        blueSlider.anyStep();
                    } else {
                        redSlider.setStep(Double.parseDouble(value));
                        greenSlider.setStep(Double.parseDouble(value));
                        blueSlider.setStep(Double.parseDouble(value));
                    }
                });
        SwitchButton thumbSwitch = SwitchButton.create()
                .setLabel("Show thumb")
                .setOffTitle("No")
                .setOnTitle("Yes")
                .addChangeListener((oldValue, value) -> {
                    redSlider.setShowThumb(value);
                    greenSlider.setShowThumb(value);
                    blueSlider.setShowThumb(value);
                });

        this.element
                .appendChild(Row.create()
                        .addCss(dui_gap_4)
                        .span6(rgbColorsDiv)
                        .span6(div().addCss(dui_flex, dui_flex_col)
                                .appendChild(div()
                                        .addCss(dui_flex, dui_gap_4, dui_items_center)
                                        .appendChild(stepTextBox)
                                        .appendChild(thumbSwitch)
                                )
                                .appendChild(div()
                                        .addCss(dui_flex, dui_gap_4, dui_items_center)
                                        .appendChild(h(4).textContent("R"))
                                        .appendChild(redSlider.addCss(dui_grow_1))
                                )
                                .appendChild(div()
                                        .addCss(dui_flex, dui_gap_4, dui_items_center)
                                        .appendChild(h(4).textContent("G"))
                                        .appendChild(greenSlider.addCss(dui_grow_1))
                                )
                                .appendChild(div()
                                        .addCss(dui_flex, dui_gap_4, dui_items_center)
                                        .appendChild(h(4).textContent("B"))
                                        .appendChild(blueSlider.addCss(dui_grow_1))
                                )
                                .appendChild(div()
                                        .addCss(dui_flex, dui_gap_4, dui_items_center)
                                        .appendChild(h(4).textContent("R"))
                                        .appendChild(redTextBox)
                                )
                                .appendChild(div()
                                        .addCss(dui_flex, dui_gap_4, dui_items_center)
                                        .appendChild(h(4).textContent("G"))
                                        .appendChild(greenTextBox)
                                )
                                .appendChild(div()
                                        .addCss(dui_flex, dui_gap_4, dui_items_center)
                                        .appendChild(h(4).textContent("B"))
                                        .appendChild(blueTextBox)
                                )
                        )

                )
        ;
        init(this);
    }

    private void updateBackgroundColor(DivElement rgbColorsDiv, Slider redSlider, Slider greenSlider, Slider blueSlider) {
        rgbColorsDiv.setBackgroundColor("rgb(" + redSlider.getValue() + ", " + greenSlider.getValue() + ", " + blueSlider.getValue() + ")");
    }

    private void updateColorAndTextBoxes(DivElement rgbColorsDiv, Slider redSlider, Slider greenSlider, Slider blueSlider, TextBox redTextBox, TextBox greenTextBox, TextBox blueTextBox) {
        updateBackgroundColor(rgbColorsDiv, redSlider, greenSlider, blueSlider);
        redTextBox.setValue(String.valueOf(redSlider.getValue()));
        greenTextBox.setValue(String.valueOf(greenSlider.getValue()));
        blueTextBox.setValue(String.valueOf(blueSlider.getValue()));
    }


    @Override
    public HTMLDivElement element() {
        return this.element.element();
    }
}

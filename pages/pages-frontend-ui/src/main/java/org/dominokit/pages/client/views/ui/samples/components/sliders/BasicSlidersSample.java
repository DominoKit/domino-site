package org.dominokit.pages.client.views.ui.samples.components.sliders;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.notifications.Notification;
import org.dominokit.domino.ui.sliders.Slider;
import org.dominokit.domino.ui.typography.BlockHeader;
import org.dominokit.domino.ui.utils.BaseDominoElement;

import static org.dominokit.domino.ui.utils.Domino.*;

public class BasicSlidersSample extends BaseDominoElement<HTMLDivElement, BasicSlidersSample> {

    private DivElement element;

    public static BasicSlidersSample create() {
        return new BasicSlidersSample();
    }

    public BasicSlidersSample() {
        this.element = div().addCss(dui_p_2)
                .appendChild(Row.create()
                        .span12(BlockHeader.create("SIMPLE SLIDERS"))
                )
                .appendChild(Row.create()
                        .span12(
                                Slider.create(200)
                                        .setShowThumb(true)
                                        .addChangeListener((oldValue, newValue) -> showNotification(newValue))
                        )
                )
                .appendChild(Row.create().span12(hr()))
                .appendChild(Row.create().span12(BlockHeader.create("SLIDERS WITH THUMB")))
                .appendChild(Row.create()
                                .span12(Slider.create(200, 20)
                                        .setValue(50)
                                        .setReadOnly(true)
                                        .withThumb()
                                        .addChangeListener((oldValue, newValue) -> showNotification(newValue))
                                )
                )
                .appendChild(Row.create().span12(hr()))
                .appendChild(Row.create()
                        .span12(BlockHeader.create("SLIDERS CAN HAVE MIN AND MAX VALUES")
                                        .appendChild(span().textContent("Min: 100").element())
                                        .appendChild(br().element())
                                        .appendChild(span().textContent("Max: 200").element())
                                )
                )
                .appendChild(Row.create()
                                .span12(Slider.create(200, 100)
                                        .setValue(150)
                                        .withThumb()
                                        .addChangeListener((oldValue, newValue) -> showNotification(newValue))
                                )
                )
                .appendChild(Row.create().span12(hr()))
                .appendChild(Row.create()
                        .span12(BlockHeader.create("SLIDERS WITH STEP")
                                        .appendChild(span().textContent("MIN: 100").element())
                                        .appendChild(br().element())
                                        .appendChild(span().textContent("MAX: 200").element())
                                        .appendChild(br().element())
                                        .appendChild(span().textContent("STEP: 10").element())
                                )
                )
                .appendChild(Row.create()
                                .span12(Slider.create(200, 100)
                                        .setStep(10)
                                        .withThumb()
                                        .addChangeListener((oldValue, newValue) -> showNotification(newValue))
                                )
                )
                .appendChild(Row.create().span12(hr()))
                .appendChild(Row.create()
                        .span12(BlockHeader.create("SLIDERS WITH ANY STEP")
                                        .appendChild(span().textContent("MIN: 100").element())
                                        .appendChild(br().element())
                                        .appendChild(span().textContent("MAX: 200").element())
                                        .appendChild(br().element())
                                        .appendChild(span().textContent("STEP: ANY").element())
                                )
                )
                .appendChild(Row.create()
                                .span12(Slider.create(200, 100)
                                        .anyStep()
                                        .setShowThumb(true)
                                        .addChangeListener((oldValue, newValue) -> showNotification(newValue))
                                )
                )
        ;
        init(this);
    }

    private void showNotification(Double value) {
        Notification.create("Value " + value + " out of 200").addCss(dui_info).show();
    }

    @Override
    public HTMLDivElement element() {
        return this.element.element();
    }
}

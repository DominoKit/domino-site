package org.dominokit.pages.client.views.ui.samples.components.carousel;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.carousel.Carousel;
import org.dominokit.domino.ui.carousel.Slide;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.utils.BaseDominoElement;

public class CarouselBasicSample extends BaseDominoElement<HTMLDivElement, CarouselBasicSample> {

    private DivElement element;

    public static CarouselBasicSample create() {
        return new CarouselBasicSample();
    }

    public CarouselBasicSample() {
        this.element = div().addCss(dui_p_2)
                .appendChild(Carousel.create()
                        .appendChild(Slide.create("/assets/image-gallery/11.jpg"))
                        .appendChild(Slide.create("/assets/image-gallery/12.jpg"))
                        .appendChild(Slide.create("/assets/image-gallery/19.jpg"))
                        .appendChild(Slide.create("/assets/image-gallery/9.jpg"))
                        .appendChild(Slide.create("/assets/images/image-gallery/6.jpg"))
                )
        ;
        init(this);
    }

    @Override
    public HTMLDivElement element() {
        return this.element.element();
    }
}

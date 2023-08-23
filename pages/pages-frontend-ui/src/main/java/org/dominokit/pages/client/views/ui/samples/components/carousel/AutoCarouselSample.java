package org.dominokit.pages.client.views.ui.samples.components.carousel;

import com.google.gwt.core.client.GWT;
import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.carousel.Carousel;
import org.dominokit.domino.ui.carousel.Slide;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.utils.BaseDominoElement;

public class AutoCarouselSample extends BaseDominoElement<HTMLDivElement, AutoCarouselSample> {

    private DivElement element;

    public static AutoCarouselSample create() {
        return new AutoCarouselSample();
    }

    public AutoCarouselSample() {
        this.element = div().addCss(dui_p_2)
                .appendChild(Carousel.create()
                        .appendChild(Slide.create(img("/assets/image-gallery/11.jpg"))
                                .setLabel("Slide 1")
                                .setDescription("First slide description")
                        )
                        .appendChild(Slide.create(img("/assets/image-gallery/12.jpg"))
                                .setLabel("Slide 2")
                                .setDescription("Second slide description")
                        )
                        .appendChild(Slide.create(img("/assets/image-gallery/19.jpg"))
                                .setLabel("Slide 3")
                                .setDescription("Third slide description")
                        )
                        .appendChild(Slide.create(img("/assets/image-gallery/9.jpg"))
                                .setLabel("Slide 4")
                                .setDescription("Fourth slide description")
                        )
                        .appendChild(Slide.create(img("/assets/image-gallery/6.jpg"))
                                .setLabel("Slide 5")
                                .setDescription("Fifth slide description")
                        )
                        .startAutoSlide(3000)
                )
        ;
        init(this);
    }

    @Override
    public HTMLDivElement element() {
        return this.element.element();
    }
}

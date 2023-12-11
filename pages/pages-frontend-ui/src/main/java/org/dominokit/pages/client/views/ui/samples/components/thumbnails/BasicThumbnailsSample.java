package org.dominokit.pages.client.views.ui.samples.components.thumbnails;

import static org.dominokit.domino.ui.utils.Domino.div;
import static org.dominokit.domino.ui.utils.Domino.dui_image_responsive;
import static org.dominokit.domino.ui.utils.Domino.dui_p_2;
import static org.dominokit.domino.ui.utils.Domino.img;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.thumbnails.Thumbnail;
import org.dominokit.domino.ui.utils.BaseDominoElement;

public class BasicThumbnailsSample extends BaseDominoElement<HTMLDivElement, BasicThumbnailsSample> {

    private DivElement element;

    public static BasicThumbnailsSample create() {
        return new BasicThumbnailsSample();
    }

    public BasicThumbnailsSample() {
        this.element = div().addCss(dui_p_2)
                .appendChild(Row.create()
                        .span3(Thumbnail.create()
                                .appendChild(img("/assets/image-gallery/5.jpg")
                                        .addCss(dui_image_responsive)
                                )
                        )
                        .span3(Thumbnail.create()
                                .appendChild(img("/assets/image-gallery/6.jpg")
                                        .addCss(dui_image_responsive)
                                )
                        )
                        .span3(Thumbnail.create()
                                .appendChild(img("/assets/image-gallery/7.jpg")
                                        .addCss(dui_image_responsive)
                                )
                        )
                        .span3(Thumbnail.create()
                                .appendChild(img("/assets/image-gallery/8.jpg")
                                        .addCss(dui_image_responsive)
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

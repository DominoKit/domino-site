package org.dominokit.pages.client.views.ui.samples.components.thumbnails;

import com.google.gwt.core.client.GWT;
import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.thumbnails.Thumbnail;
import org.dominokit.domino.ui.thumbnails.ThumbnailDirection;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.FooterContent;
import org.dominokit.domino.ui.utils.HeaderContent;

public class DetailedThumbnailsSample extends BaseDominoElement<HTMLDivElement, DetailedThumbnailsSample> {

    private static final String SAMPLE_TEXT = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s";
    private DivElement element;

    public static DetailedThumbnailsSample create() {
        return new DetailedThumbnailsSample();
    }

    public DetailedThumbnailsSample() {
        this.element = div().addCss(dui_p_2)
                .appendChild(Row.create()
                        .span6(Thumbnail.create()
                                .setDirection(ThumbnailDirection.COLUMN)
                                .appendChild(HeaderContent.of(h(5).textContent("Thumbnail title")))
                                .appendChild(a().appendChild(img("/assets/image-gallery/1.jpg")
                                        .addCss(dui_image_responsive)))
                                .appendChild(FooterContent.of(h(4).textContent("Thumbnail label")))
                                .appendChild(FooterContent.of(p(SAMPLE_TEXT)))
                                .appendChild(FooterContent.of(Button.create("BUTTON").addCss(dui_primary)))
                        )
                        .span6(Thumbnail.create()
                                .setDirection(ThumbnailDirection.COLUMN_REVERSE)
                                .appendChild(HeaderContent.of(h(5).textContent("Thumbnail title")))
                                .appendChild(a().appendChild(img("/assets/image-gallery/2.jpg")
                                        .addCss(dui_image_responsive)))
                                .appendChild(FooterContent.of(h(4).textContent("Thumbnail label")))
                                .appendChild(FooterContent.of(p(SAMPLE_TEXT)))
                                .appendChild(FooterContent.of(Button.create("BUTTON").addCss(dui_primary)))
                        )
                )
                .appendChild(Row.create()
                        .span6(Thumbnail.create()
                                .setDirection(ThumbnailDirection.ROW)
                                .appendChild(HeaderContent.of(h(5).textContent("Thumbnail title")))
                                .appendChild(a().appendChild(img("/assets/image-gallery/3.jpg")
                                        .addCss(dui_image_responsive)))
                                .appendChild(FooterContent.of(h(4).textContent("Thumbnail label")))
                                .appendChild(FooterContent.of(p(SAMPLE_TEXT)))
                                .appendChild(FooterContent.of(Button.create("BUTTON").addCss(dui_primary)))
                        )
                        .span6(Thumbnail.create()
                                .setDirection(ThumbnailDirection.ROW_REVERSE)
                                .appendChild(HeaderContent.of(h(5).textContent("Thumbnail title")))
                                .appendChild(a().appendChild(img("/assets/image-gallery/4.jpg")
                                        .addCss(dui_image_responsive)))
                                .appendChild(FooterContent.of(h(4).textContent("Thumbnail label")))
                                .appendChild(FooterContent.of(p(SAMPLE_TEXT)))
                                .appendChild(FooterContent.of(Button.create("BUTTON").addCss(dui_primary)))
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

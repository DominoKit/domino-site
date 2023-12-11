package org.dominokit.pages.client.views.ui.samples.components.media;

import static org.dominokit.domino.ui.utils.Domino.a;
import static org.dominokit.domino.ui.utils.Domino.div;
import static org.dominokit.domino.ui.utils.Domino.dui_h_16;
import static org.dominokit.domino.ui.utils.Domino.dui_p_2;
import static org.dominokit.domino.ui.utils.Domino.dui_w_16;
import static org.dominokit.domino.ui.utils.Domino.img;
import static org.dominokit.domino.ui.utils.Domino.text;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.media.MediaObject;
import org.dominokit.domino.ui.utils.BaseDominoElement;

public class MediaObjectsBasicSample extends BaseDominoElement<HTMLDivElement, MediaObjectsBasicSample> {

    private static final String SAMPLE_TEXT = "Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin commodo. Cras purus odio, vestibulum in vulputate at, tempus viverra turpis. Fusce condimentum nunc ac nisi vulputate fringilla. Donec lacinia congue felis in faucibus.";

    private DivElement element;

    public static MediaObjectsBasicSample create() {
        return new MediaObjectsBasicSample();
    }

    public MediaObjectsBasicSample() {
        this.element = div().addCss(dui_p_2)
                .appendChild(MediaObject.create()
                        .setHeader("Media heading")
                        .setLeftMedia(a()
                                .appendChild(img("http://placehold.it/64x64")
                                        .addCss(dui_w_16, dui_h_16)))
                        .appendChild(text(SAMPLE_TEXT)))
                .appendChild(MediaObject.create()
                        .setHeader("Media heading")
                        .setLeftMedia(a()
                                .appendChild(img("http://placehold.it/64x64")
                                        .addCss(dui_w_16, dui_h_16)))
                        .appendChild(text(SAMPLE_TEXT))
                        .appendChild(MediaObject.create()
                                .setHeader("Media heading")
                                .setLeftMedia(a()
                                        .appendChild(img("http://placehold.it/64x64")
                                                .addCss(dui_w_16, dui_h_16)))
                                .appendChild(text(SAMPLE_TEXT))))
                .appendChild(MediaObject.create()
                        .setHeader("Media heading")
                        .setRightMedia(a()
                                .appendChild(img("http://placehold.it/64x64")
                                        .addCss(dui_w_16, dui_h_16)))
                        .appendChild(text(SAMPLE_TEXT)))
                .appendChild(MediaObject.create()
                        .setHeader("Media heading")
                        .setRightMedia(a()
                                .appendChild(img("http://placehold.it/64x64")
                                        .addCss(dui_w_16, dui_h_16)))
                        .setLeftMedia(a()
                                .appendChild(img("http://placehold.it/64x64")
                                        .addCss(dui_w_16, dui_h_16)))
                        .appendChild(text(SAMPLE_TEXT))
                )
        ;
        init(this);
    }

    @Override
    public HTMLDivElement element() {
        return this.element.element();
    }
}

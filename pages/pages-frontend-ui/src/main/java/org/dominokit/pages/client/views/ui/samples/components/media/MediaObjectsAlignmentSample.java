package org.dominokit.pages.client.views.ui.samples.components.media;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.media.MediaObject;
import org.dominokit.domino.ui.utils.BaseDominoElement;

import static org.dominokit.domino.ui.utils.Domino.*;

public class MediaObjectsAlignmentSample extends BaseDominoElement<HTMLDivElement, MediaObjectsAlignmentSample> {

    private static final String SAMPLE_TEXT = "Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin commodo. Cras purus odio, vestibulum in vulputate at, tempus viverra turpis. Fusce condimentum nunc ac nisi vulputate fringilla. Donec lacinia congue felis in faucibus.";

    private DivElement element;

    public static MediaObjectsAlignmentSample create() {
        return new MediaObjectsAlignmentSample();
    }

    public MediaObjectsAlignmentSample() {
        this.element = div().addCss(dui_p_2)
                .appendChild(MediaObject.create()
                        .setHeader("Media heading")
                        .setLeftMedia(a()
                                .appendChild(img("http://placehold.it/64x64")
                                        .addCss(dui_w_16, dui_h_16, dui_rounded_full)))
                        .appendChild(p(SAMPLE_TEXT))
                        .appendChild(p(SAMPLE_TEXT)))
                .appendChild(MediaObject.create()
                        .setHeader("Media heading")
                        .setLeftMedia(a()
                                .appendChild(img("http://placehold.it/64x64")
                                        .addCss(dui_w_16, dui_h_16, dui_rounded_full)))
                        .withLeftMedia((parent, leftMedia) -> leftMedia.addCss(dui_self_center))
                        .appendChild(p(SAMPLE_TEXT))
                        .appendChild(p(SAMPLE_TEXT)))
                .appendChild(MediaObject.create()
                        .setHeader("Media heading")
                        .setLeftMedia(a()
                                .appendChild(img("http://placehold.it/64x64")
                                        .addCss(dui_w_16, dui_h_16, dui_rounded_full)))
                        .withLeftMedia((parent, leftMedia) -> leftMedia.addCss(dui_self_end))
                        .appendChild(p(SAMPLE_TEXT))
                        .appendChild(p(SAMPLE_TEXT)))
        ;
        init(this);
    }

    @Override
    public HTMLDivElement element() {
        return this.element.element();
    }
}

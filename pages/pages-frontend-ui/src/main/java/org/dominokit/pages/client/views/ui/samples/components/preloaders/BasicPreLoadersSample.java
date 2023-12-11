package org.dominokit.pages.client.views.ui.samples.components.preloaders;

import static org.dominokit.domino.ui.utils.Domino.div;
import static org.dominokit.domino.ui.utils.Domino.dui_flex;
import static org.dominokit.domino.ui.utils.Domino.dui_gap_4;
import static org.dominokit.domino.ui.utils.Domino.dui_items_center;
import static org.dominokit.domino.ui.utils.Domino.dui_large;
import static org.dominokit.domino.ui.utils.Domino.dui_medium;
import static org.dominokit.domino.ui.utils.Domino.dui_p_4;
import static org.dominokit.domino.ui.utils.Domino.dui_small;
import static org.dominokit.domino.ui.utils.Domino.dui_xlarge;
import static org.dominokit.domino.ui.utils.Domino.dui_xsmall;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.preloaders.Preloader;
import org.dominokit.domino.ui.utils.BaseDominoElement;

public class BasicPreLoadersSample extends BaseDominoElement<HTMLDivElement, BasicPreLoadersSample> {

    private DivElement element;

    public static BasicPreLoadersSample create() {
        return new BasicPreLoadersSample();
    }

    public BasicPreLoadersSample() {
        this.element = div().addCss(dui_p_4)
                .appendChild(div().addCss(dui_flex, dui_gap_4, dui_items_center)
                        .appendChild(Preloader.create()
                                .addCss(dui_xlarge))
                        .appendChild(Preloader.create()
                                .addCss(dui_large))
                        .appendChild(Preloader.create()
                                .addCss(dui_medium))
                        .appendChild(Preloader.create()
                                .addCss(dui_small))
                        .appendChild(Preloader.create()
                                .addCss(dui_xsmall))
                )
        ;
        init(this);
    }

    @Override
    public HTMLDivElement element() {
        return this.element.element();
    }
}

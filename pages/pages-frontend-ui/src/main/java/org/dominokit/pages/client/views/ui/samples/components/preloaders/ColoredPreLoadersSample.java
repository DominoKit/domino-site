package org.dominokit.pages.client.views.ui.samples.components.preloaders;

import static org.dominokit.domino.ui.utils.Domino.div;
import static org.dominokit.domino.ui.utils.Domino.dui_fg_black;
import static org.dominokit.domino.ui.utils.Domino.dui_fg_blue;
import static org.dominokit.domino.ui.utils.Domino.dui_fg_blue_grey;
import static org.dominokit.domino.ui.utils.Domino.dui_fg_brown;
import static org.dominokit.domino.ui.utils.Domino.dui_fg_deep_orange;
import static org.dominokit.domino.ui.utils.Domino.dui_fg_grey;
import static org.dominokit.domino.ui.utils.Domino.dui_fg_indigo;
import static org.dominokit.domino.ui.utils.Domino.dui_fg_light_green;
import static org.dominokit.domino.ui.utils.Domino.dui_fg_lime;
import static org.dominokit.domino.ui.utils.Domino.dui_fg_orange;
import static org.dominokit.domino.ui.utils.Domino.dui_fg_red;
import static org.dominokit.domino.ui.utils.Domino.dui_fg_teal;
import static org.dominokit.domino.ui.utils.Domino.dui_flex;
import static org.dominokit.domino.ui.utils.Domino.dui_gap_4;
import static org.dominokit.domino.ui.utils.Domino.dui_p_4;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.preloaders.Preloader;
import org.dominokit.domino.ui.utils.BaseDominoElement;

public class ColoredPreLoadersSample extends BaseDominoElement<HTMLDivElement, ColoredPreLoadersSample> {

    private DivElement element;

    public static ColoredPreLoadersSample create() {
        return new ColoredPreLoadersSample();
    }

    public ColoredPreLoadersSample() {
        this.element = div().addCss(dui_p_4)
                .appendChild(div().addCss(dui_flex, dui_gap_4)
                        .appendChild(Preloader.create()
                                .addCss(dui_fg_red))
                        .appendChild(Preloader.create()
                                .addCss(dui_fg_black))
                        .appendChild(Preloader.create()
                                .addCss(dui_fg_blue_grey))
                        .appendChild(Preloader.create()
                                .addCss(dui_fg_blue))
                        .appendChild(Preloader.create()
                                .addCss(dui_fg_grey))
                        .appendChild(Preloader.create()
                                .addCss(dui_fg_brown))
                        .appendChild(Preloader.create()
                                .addCss(dui_fg_deep_orange))
                        .appendChild(Preloader.create()
                                .addCss(dui_fg_orange))
                        .appendChild(Preloader.create()
                                .addCss(dui_fg_lime))
                        .appendChild(Preloader.create()
                                .addCss(dui_fg_light_green))
                        .appendChild(Preloader.create()
                                .addCss(dui_fg_teal))
                        .appendChild(Preloader.create()
                                .addCss(dui_fg_indigo)))
        ;
        init(this);
    }

    @Override
    public HTMLDivElement element() {
        return this.element.element();
    }
}

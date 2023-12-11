package org.dominokit.pages.client.views.ui.samples.components.sliders;

import static org.dominokit.domino.ui.utils.Domino.div;
import static org.dominokit.domino.ui.utils.Domino.dui_accent_blue;
import static org.dominokit.domino.ui.utils.Domino.dui_accent_cyan;
import static org.dominokit.domino.ui.utils.Domino.dui_accent_green;
import static org.dominokit.domino.ui.utils.Domino.dui_accent_orange;
import static org.dominokit.domino.ui.utils.Domino.dui_accent_purple;
import static org.dominokit.domino.ui.utils.Domino.dui_accent_red;
import static org.dominokit.domino.ui.utils.Domino.dui_bg_blue_d_2;
import static org.dominokit.domino.ui.utils.Domino.dui_bg_cyan_d_2;
import static org.dominokit.domino.ui.utils.Domino.dui_bg_green_d_2;
import static org.dominokit.domino.ui.utils.Domino.dui_bg_orange_d_2;
import static org.dominokit.domino.ui.utils.Domino.dui_bg_purple_d_2;
import static org.dominokit.domino.ui.utils.Domino.dui_bg_red_d_2;
import static org.dominokit.domino.ui.utils.Domino.dui_fg;
import static org.dominokit.domino.ui.utils.Domino.dui_p_2;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.sliders.Slider;
import org.dominokit.domino.ui.utils.BaseDominoElement;

public class ColoredSlidersSample extends BaseDominoElement<HTMLDivElement, ColoredSlidersSample> {

    private DivElement element;

    public static ColoredSlidersSample create() {
        return new ColoredSlidersSample();
    }

    public ColoredSlidersSample() {
        this.element = div().addCss(dui_p_2)
                .appendChild(Row.create()
                        .span4(Slider.create(100).addCss(dui_accent_red))
                        .span4(Slider.create(100)
                                .addCss(dui_accent_red)
                                .withThumb((parent, thumb) -> thumb.addCss(dui_bg_red_d_2, dui_fg))
                        )
                        .span4(Slider.create(100)
                                .withThumb((parent, thumb) -> thumb.addCss(dui_bg_red_d_2, dui_fg))
                        )
                )
                .appendChild(Row.create()
                        .span4(Slider.create(100).addCss(dui_accent_green))
                        .span4(Slider.create(100)
                                .addCss(dui_accent_green)
                                .withThumb((parent, thumb) -> thumb.addCss(dui_bg_green_d_2, dui_fg))
                        )
                        .span4(Slider.create(100)
                                .withThumb((parent, thumb) -> thumb.addCss(dui_bg_green_d_2, dui_fg))
                        )
                )
                .appendChild(Row.create()
                        .span4(Slider.create(100).addCss(dui_accent_blue))
                        .span4(Slider.create(100)
                                .addCss(dui_accent_blue)
                                .withThumb((parent, thumb) -> thumb.addCss(dui_bg_blue_d_2, dui_fg))
                        )
                        .span4(Slider.create(100)
                                .withThumb((parent, thumb) -> thumb.addCss(dui_bg_blue_d_2, dui_fg))
                        )
                )
                .appendChild(Row.create()
                        .span4(Slider.create(100).addCss(dui_accent_purple))
                        .span4(Slider.create(100)
                                .addCss(dui_accent_purple)
                                .withThumb((parent, thumb) -> thumb.addCss(dui_bg_purple_d_2, dui_fg))
                        )
                        .span4(Slider.create(100)
                                .withThumb((parent, thumb) -> thumb.addCss(dui_bg_purple_d_2, dui_fg))
                        )
                )
                .appendChild(Row.create()
                        .span4(Slider.create(100).addCss(dui_accent_orange))
                        .span4(Slider.create(100)
                                .addCss(dui_accent_orange)
                                .withThumb((parent, thumb) -> thumb.addCss(dui_bg_orange_d_2, dui_fg))
                        )
                        .span4(Slider.create(100)
                                .withThumb((parent, thumb) -> thumb.addCss(dui_bg_orange_d_2, dui_fg))
                        )
                )

                .appendChild(Row.create()
                        .span4(Slider.create(100).addCss(dui_accent_cyan))
                        .span4(Slider.create(100)
                                .addCss(dui_accent_cyan)
                                .withThumb((parent, thumb) -> thumb.addCss(dui_bg_cyan_d_2, dui_fg))
                        )
                        .span4(Slider.create(100)
                                .withThumb((parent, thumb) -> thumb.addCss(dui_bg_cyan_d_2, dui_fg))
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

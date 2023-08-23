package org.dominokit.pages.client.views.ui.samples.components.chips;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.chips.Chip;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.style.CompositeCssClass;
import org.dominokit.domino.ui.utils.BaseDominoElement;

public class ChipsWithLettersSample extends BaseDominoElement<HTMLDivElement, ChipsWithLettersSample> {

    private CompositeCssClass border_solid = CompositeCssClass.of(dui_border, dui_border_solid);
    private DivElement element;

    public static ChipsWithLettersSample create() {
        return new ChipsWithLettersSample();
    }

    public ChipsWithLettersSample() {
        this.element = div().addCss(dui_p_2, dui_flex, dui_gap_4, dui_flex_wrap)
                .appendChild(Chip.create("Schroeder Coleman")
                        .addCss(dui_transparent, border_solid, dui_border_indigo)
                        .withAddon((chip, addon) -> addon.addCss(dui_indigo))
                        .setLetters("SC")
                )
                .appendChild(Chip.create("Renee Mcintyre")
                        .addCss(dui_transparent, border_solid, dui_border_grey)
                        .withAddon((chip, addon) -> addon.addCss(dui_grey))
                        .setLetters("RM")
                )
                .appendChild(Chip.create("Casey Garza")
                        .addCss(dui_transparent, border_solid, dui_border_blue)
                        .withAddon((chip, addon) -> addon.addCss(dui_blue))
                        .setLetters("CG")
                )
                .appendChild(Chip.create("Ferguson Hudson")
                        .addCss(dui_transparent, border_solid, dui_border_black)
                        .withAddon((chip, addon) -> addon.addCss(dui_black))
                        .setLetters("FH")
                )
                .appendChild(Chip.create("Serrano Green")
                        .addCss(dui_transparent, border_solid, dui_border_cyan)
                        .withAddon((chip, addon) -> addon.addCss(dui_cyan))
                        .setLetters("SG")
                )
                .appendChild(Chip.create("Camacho Solis")
                        .addCss(dui_transparent, border_solid, dui_border_blue_grey)
                        .withAddon((chip, addon) -> addon.addCss(dui_blue_grey))
                        .setLetters("CS")
                )
        ;
        init(this);
    }

    @Override
    public HTMLDivElement element() {
        return this.element.element();
    }
}

package org.dominokit.pages.client.views.ui.samples.components.chips;

import static org.dominokit.domino.ui.utils.Domino.div;
import static org.dominokit.domino.ui.utils.Domino.dui_brown;
import static org.dominokit.domino.ui.utils.Domino.dui_flex;
import static org.dominokit.domino.ui.utils.Domino.dui_flex_wrap;
import static org.dominokit.domino.ui.utils.Domino.dui_gap_4;
import static org.dominokit.domino.ui.utils.Domino.dui_grey;
import static org.dominokit.domino.ui.utils.Domino.dui_info;
import static org.dominokit.domino.ui.utils.Domino.dui_p_2;
import static org.dominokit.domino.ui.utils.Domino.dui_teal;
import static org.dominokit.domino.ui.utils.Domino.dui_warning;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.chips.Chip;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.utils.BaseDominoElement;

public class RemovableChipsSample extends BaseDominoElement<HTMLDivElement, RemovableChipsSample> {

    private DivElement element;

    public static RemovableChipsSample create() {
        return new RemovableChipsSample();
    }

    public RemovableChipsSample() {
        this.element = div().addCss(dui_p_2, dui_flex, dui_gap_4, dui_flex_wrap)
                .appendChild(Chip.create("Restaurants")
                        .addCss(dui_grey)
                        .setRemovable(true)
                )
                .appendChild(Chip.create("Coffee shops")
                        .addCss(dui_info)
                        .setRemovable(true)
                )
                .appendChild(Chip.create("Libraries")
                        .addCss(dui_warning)
                        .setRemovable(true)
                )
                .appendChild(Chip.create("Entertainment")
                        .addCss(dui_brown)
                        .setRemovable(true)
                )
                .appendChild(Chip.create("Universities")
                        .addCss(dui_teal)
                        .setRemovable(true)
                )
        ;
        init(this);
    }

    @Override
    public HTMLDivElement element() {
        return this.element.element();
    }
}

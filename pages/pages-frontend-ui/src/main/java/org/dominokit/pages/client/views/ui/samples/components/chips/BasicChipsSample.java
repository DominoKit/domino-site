package org.dominokit.pages.client.views.ui.samples.components.chips;

import static org.dominokit.domino.ui.utils.Domino.div;
import static org.dominokit.domino.ui.utils.Domino.dui_accent;
import static org.dominokit.domino.ui.utils.Domino.dui_flex;
import static org.dominokit.domino.ui.utils.Domino.dui_flex_wrap;
import static org.dominokit.domino.ui.utils.Domino.dui_gap_4;
import static org.dominokit.domino.ui.utils.Domino.dui_orange;
import static org.dominokit.domino.ui.utils.Domino.dui_p_2;
import static org.dominokit.domino.ui.utils.Domino.dui_purple;
import static org.dominokit.domino.ui.utils.Domino.dui_success;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.chips.Chip;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.utils.BaseDominoElement;

public class BasicChipsSample extends BaseDominoElement<HTMLDivElement, BasicChipsSample> {

    private DivElement element;

    public static BasicChipsSample create() {
        return new BasicChipsSample();
    }

    public BasicChipsSample() {
        this.element = div().addCss(dui_p_2, dui_flex, dui_gap_4, dui_flex_wrap)
                .appendChild(Chip.create("Sounds good, let's do that!"))
                .appendChild(Chip.create("Yay! I'll be there").addCss(dui_accent))
                .appendChild(Chip.create("Hey, how are you?").addCss(dui_orange))
                .appendChild(Chip.create("You look handsome today <3").addCss(dui_purple))
                .appendChild(Chip.create("I like the weather today!").addCss(dui_success))
        ;
        init(this);
    }

    @Override
    public HTMLDivElement element() {
        return this.element.element();
    }
}

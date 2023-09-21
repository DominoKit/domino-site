package org.dominokit.pages.client.views.ui.samples.components.popover;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.menu.direction.DropDirection;
import org.dominokit.domino.ui.utils.BaseDominoElement;

public class TooltipSample extends BaseDominoElement<HTMLDivElement, TooltipSample> {

    private DivElement element;

    public static TooltipSample create() {
        return new TooltipSample();
    }

    public TooltipSample() {
        this.element = div().addCss(dui_p_2)
                .appendChild(Row.create()
                        .span3(Button.create("TOOLTIP ON RIGHT")
                                .addCss(dui_bg_accent)
                                .setTooltip("Tooltip on right", DropDirection.RIGHT_MIDDLE)
                        )
                        .span3(Button.create("TOOLTIP ON TOP")
                                .addCss(dui_bg_accent)
                                .setTooltip("Tooltip on top", DropDirection.TOP_MIDDLE)
                        )
                        .span3(Button.create("TOOLTIP ON BOTTOM")
                                .addCss(dui_bg_accent)
                                .setTooltip("Tooltip on bottom", DropDirection.BOTTOM_MIDDLE)
                        )
                        .span3(Button.create("TOOLTIP ON LEFT")
                                .addCss(dui_bg_accent)
                                .setTooltip("Tooltip on bottom", DropDirection.LEFT_MIDDLE)
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

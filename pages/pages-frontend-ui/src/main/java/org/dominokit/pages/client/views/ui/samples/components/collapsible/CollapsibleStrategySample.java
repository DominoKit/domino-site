package org.dominokit.pages.client.views.ui.samples.components.collapsible;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.animations.Transition;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.collapsible.*;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.typography.BlockHeader;
import org.dominokit.domino.ui.utils.BaseDominoElement;

public class CollapsibleStrategySample extends BaseDominoElement<HTMLDivElement, CollapsibleStrategySample> {

    private static final String SAMPLE_CONTENT = "Quis pharetra a pharetra fames blandit. Risus faucibus velit Risus imperdiet mattis neque volutpat, etiam lacinia netus dictum magnis per facilisi sociosqu. Volutpat. Ridiculus nostra.";
    private DivElement element;

    public static CollapsibleStrategySample create() {
        return new CollapsibleStrategySample();
    }

    public CollapsibleStrategySample() {
        this.element = div().addCss(dui_p_2);
        DivElement heightDiv = div()
                .addCss(dui_h_24, dui_m_y_4)
                .appendChild(div()
                        .addCss(dui_accent, dui_p_4)
                        .textContent(SAMPLE_CONTENT));

        DivElement displayDiv = div()
                .addCss(dui_h_24, dui_m_y_4)
                .appendChild(div()
                        .addCss(dui_accent, dui_p_4)
                        .textContent(SAMPLE_CONTENT));

        DivElement animationDiv = div()
                .addCss(dui_h_24, dui_m_y_4)
                .appendChild(div()
                        .addCss(dui_accent, dui_p_4)
                        .textContent(SAMPLE_CONTENT));

        Collapsible heightCollapsible = Collapsible.create(heightDiv)
                .setStrategy(new HeightCollapseStrategy(CollapsibleDuration._300ms));

        Collapsible displayCollapsible = Collapsible.create(displayDiv)
                .setStrategy(new DisplayCollapseStrategy());

        Collapsible animationCollapsible = Collapsible.create(animationDiv)
                .setStrategy(new AnimationCollapseStrategy(Transition.FADE_IN, Transition.FADE_OUT, CollapsibleDuration._500ms));

        Button heightCollapseButton = Button.create("Height collapse");
        heightCollapseButton.getClickableElement().addEventListener("click", evt -> heightCollapsible.toggleCollapse());

        Button displayCollapseButton = Button.create("Display collapse");
        displayCollapseButton.getClickableElement().addEventListener("click", evt -> displayCollapsible.toggleCollapse());

        Button animationCollapseButton = Button.create("Animation collapse");
        animationCollapseButton.getClickableElement().addEventListener("click", evt -> animationCollapsible.toggleCollapse());

        element
                .appendChild(Row.create()
                        .appendChild(Column.span12()
                                .appendChild(heightCollapseButton
                                        .addCss(dui_accent)
                                )
                                .appendChild(heightDiv)
                        )
                )
                .appendChild(Row.create()
                        .appendChild(Column.span12()
                                .appendChild(displayCollapseButton
                                        .addCss(dui_accent)
                                )
                                .appendChild(displayDiv)
                        )
                )
                .appendChild(Row.create()
                        .appendChild(Column.span12()
                                .appendChild(animationCollapseButton
                                        .addCss(dui_accent)
                                )
                                .appendChild(animationDiv)
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

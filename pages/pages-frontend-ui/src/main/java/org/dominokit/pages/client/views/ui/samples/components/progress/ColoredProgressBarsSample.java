package org.dominokit.pages.client.views.ui.samples.components.progress;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.progress.Progress;
import org.dominokit.domino.ui.progress.ProgressBar;
import org.dominokit.domino.ui.utils.BaseDominoElement;

public class ColoredProgressBarsSample extends BaseDominoElement<HTMLDivElement, ColoredProgressBarsSample> {

    private DivElement element;

    public static ColoredProgressBarsSample create() {
        return new ColoredProgressBarsSample();
    }

    public ColoredProgressBarsSample() {
        this.element = div().addCss(dui_p_2)
                .appendChild(Progress.create()
                        .appendChild(ProgressBar.create(100)
                                .showText()
                                .addCss(dui_success)
                                .setValue(80))
                )
                .appendChild(Progress.create()
                        .appendChild(ProgressBar.create(100)
                                .showText()
                                .addCss(dui_warning)
                                .setValue(60))
                )
                .appendChild(Progress.create()
                        .appendChild(ProgressBar.create(100)
                                .showText()
                                .addCss(dui_info)
                                .setValue(70))
                )
                .appendChild(Progress.create()
                        .appendChild(ProgressBar.create(100)
                                .showText()
                                .addCss(dui_error)
                                .setValue(30))
                )
                .appendChild(Progress.create()
                        .appendChild(ProgressBar.create(100)
                                .addCss(dui_pink)
                                .setValue(90))
                )
                .appendChild(Progress.create()
                        .appendChild(ProgressBar.create(100)
                                .showText()
                                .addCss(dui_purple)
                                .setValue(60))
                )
                .appendChild(Progress.create()
                        .appendChild(ProgressBar.create(100)
                                .addCss(dui_teal)
                                .setValue(75))
                )
                .appendChild(Progress.create()
                        .appendChild(ProgressBar.create(100)
                                .addCss(dui_brown)
                                .setValue(40))
                )
        ;
        init(this);
    }

    @Override
    public HTMLDivElement element() {
        return this.element.element();
    }
}

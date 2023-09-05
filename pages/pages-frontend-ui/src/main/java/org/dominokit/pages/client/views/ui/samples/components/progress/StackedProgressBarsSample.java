package org.dominokit.pages.client.views.ui.samples.components.progress;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.progress.Progress;
import org.dominokit.domino.ui.progress.ProgressBar;
import org.dominokit.domino.ui.utils.BaseDominoElement;

public class StackedProgressBarsSample extends BaseDominoElement<HTMLDivElement, StackedProgressBarsSample> {

    private DivElement element;

    public static StackedProgressBarsSample create() {
        return new StackedProgressBarsSample();
    }

    public StackedProgressBarsSample() {
        this.element = div().addCss(dui_p_2)
                .appendChild(Progress.create()
                        .appendChild(ProgressBar.create(100)
                                .animate()
                                .addCss(dui_success)
                                .setValue(40))
                        .appendChild(ProgressBar.create(100)
                                .addCss(dui_warning)
                                .setValue(30))
                        .appendChild(ProgressBar.create(100)
                                .striped()
                                .addCss(dui_error)
                                .setValue(20))
                )
        ;
        init(this);
    }

    @Override
    public HTMLDivElement element() {
        return this.element.element();
    }
}

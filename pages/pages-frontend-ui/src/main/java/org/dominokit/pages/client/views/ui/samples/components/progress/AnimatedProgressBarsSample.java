package org.dominokit.pages.client.views.ui.samples.components.progress;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.progress.Progress;
import org.dominokit.domino.ui.progress.ProgressBar;
import org.dominokit.domino.ui.utils.BaseDominoElement;

public class AnimatedProgressBarsSample extends BaseDominoElement<HTMLDivElement, AnimatedProgressBarsSample> {

    private DivElement element;

    public static AnimatedProgressBarsSample create() {
        return new AnimatedProgressBarsSample();
    }

    public AnimatedProgressBarsSample() {
        this.element = div().addCss(dui_p_2)
                .appendChild(Progress.create()
                        .appendChild(ProgressBar.create(100)
                                .animate()
                                .addCss(dui_success)
                                .setValue(80)))
                .appendChild(Progress.create()
                        .appendChild(ProgressBar.create(100)
                                .animate()
                                .addCss(dui_warning)
                                .setValue(60)))
                .appendChild(Progress.create()
                        .appendChild(ProgressBar.create(100)
                                .animate()
                                .addCss(dui_info)
                                .setValue(70)))
                .appendChild(Progress.create()
                        .appendChild(ProgressBar.create(100)
                                .animate()
                                .addCss(dui_error)
                                .setValue(30)))
        ;
        init(this);
    }

    @Override
    public HTMLDivElement element() {
        return this.element.element();
    }
}

package org.dominokit.pages.client.views.ui.samples.components.progress;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.progress.Progress;
import org.dominokit.domino.ui.progress.ProgressBar;
import org.dominokit.domino.ui.utils.BaseDominoElement;

import static org.dominokit.domino.ui.utils.Domino.*;

public class StripedProgressBarsSample extends BaseDominoElement<HTMLDivElement, StripedProgressBarsSample> {

    private DivElement element;

    public static StripedProgressBarsSample create() {
        return new StripedProgressBarsSample();
    }

    public StripedProgressBarsSample() {
        this.element = div().addCss(dui_p_2)
                .appendChild(Progress.create()
                        .appendChild(ProgressBar.create(100)
                                .striped()
                                .addCss(dui_success)
                                .setValue(80)))
                .appendChild(Progress.create()
                        .appendChild(ProgressBar.create(100)
                                .striped()
                                .addCss(dui_warning)
                                .setValue(60)))
                .appendChild(Progress.create()
                        .appendChild(ProgressBar.create(100)
                                .striped()
                                .addCss(dui_info)
                                .setValue(70)))
                .appendChild(Progress.create()
                        .appendChild(ProgressBar.create(100)
                                .striped()
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

package org.dominokit.pages.client.views.ui.samples.components.progress;

import static org.dominokit.domino.ui.utils.Domino.div;
import static org.dominokit.domino.ui.utils.Domino.dui_p_2;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.progress.Progress;
import org.dominokit.domino.ui.progress.ProgressBar;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.gwtproject.timer.client.Timer;

public class BasicProgressBarsSample extends BaseDominoElement<HTMLDivElement, BasicProgressBarsSample> {

    private DivElement element;
    private ProgressBar movingBar;

    public static BasicProgressBarsSample create() {
        return new BasicProgressBarsSample();
    }

    public BasicProgressBarsSample() {
        this.element = div().addCss(dui_p_2)
                .appendChild(Progress.create()
                        .appendChild(ProgressBar.create(100)
                                .setValue(90)))
                .appendChild(Progress.create()
                        .appendChild(ProgressBar.create(100)
                                .showText()
                                .setValue(60)))
                .appendChild(Progress.create()
                        .appendChild(ProgressBar.create(100)
                                .showText()
                                .textExpression("{value} out of {maxValue} completed")
                                .setValue(75)))
                .appendChild(Progress.create()
                        .appendChild(ProgressBar.create(100)
                                .showText()
                                .textExpression("{value} out of {maxValue} completed")
                                .setValue(40)))
                .appendChild(Progress.create()
                        .appendChild(movingBar = ProgressBar.create(1000)))
        ;
        init(this);
        restartProgress();
    }

    private void restartProgress() {
        movingBar.setValue(0);
        movingBar.textExpression("{percent}%");
        new Timer() {
            @Override
            public void run() {
                if (movingBar.getValue() >= movingBar.getMaxValue()) {
                    movingBar.textExpression("Done");
                } else {
                    movingBar.setValue(movingBar.getValue() + 1);
                }
            }
        }.scheduleRepeating(10);
    }

    @Override
    public HTMLDivElement element() {
        return this.element.element();
    }
}

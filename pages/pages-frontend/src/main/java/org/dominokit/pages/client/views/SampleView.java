package org.dominokit.pages.client.views;

import org.dominokit.domino.api.client.mvp.view.HasUiHandlers;
import org.dominokit.domino.api.client.mvp.view.UiHandlers;
import org.dominokit.domino.api.client.mvp.view.View;

public interface SampleView extends View, HasUiHandlers<SampleView.SampleUiHandlers> {

    void renderSamples();

    interface SampleUiHandlers extends UiHandlers {
    }
}
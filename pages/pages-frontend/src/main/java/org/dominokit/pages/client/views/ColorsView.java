package org.dominokit.pages.client.views;

import org.dominokit.domino.api.client.mvp.view.HasUiHandlers;
import org.dominokit.domino.api.client.mvp.view.UiHandlers;
import org.dominokit.domino.api.client.mvp.view.View;

public interface ColorsView extends View, HasUiHandlers<ColorsView.ColorsUiHandlers> {

        interface ColorsUiHandlers extends UiHandlers {
        }
}
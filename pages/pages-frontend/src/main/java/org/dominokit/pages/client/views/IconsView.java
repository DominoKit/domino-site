package org.dominokit.pages.client.views;

import org.dominokit.domino.api.client.mvp.view.HasUiHandlers;
import org.dominokit.domino.api.client.mvp.view.UiHandlers;
import org.dominokit.domino.api.client.mvp.view.View;

public interface IconsView  extends View, HasUiHandlers<IconsView.IconsUiHandlers> {

        interface IconsUiHandlers extends UiHandlers {
        }
        void setTag(String tag);
}
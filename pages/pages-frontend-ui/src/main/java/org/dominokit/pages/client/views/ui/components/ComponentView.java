package org.dominokit.pages.client.views.ui.components;

import org.dominokit.domino.api.client.mvp.presenter.Presentable;

public @interface ComponentView {
    Class<? extends Presentable>[] presentable();
}

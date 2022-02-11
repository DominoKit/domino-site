package org.dominokit.pages.client.views.ui.components;

import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.pages.client.presenters.components.NoComponentContentProxy;
import org.dominokit.pages.client.views.components.NoComponentContentView;

@UiView(presentable = NoComponentContentProxy.class)
public class NoComponentContentViewImpl extends BaseComponentViewImpl implements NoComponentContentView {

}

package org.dominokit.pages.client.views.ui;

import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.pages.client.presenters.SolutionsProxy;
import org.dominokit.pages.client.views.SolutionsView;

import static java.util.Objects.isNull;

@UiView(presentable = SolutionsProxy.class)
public class SolutionsViewImpl extends SiteViewImpl implements SolutionsView {

    @Override
    protected boolean emptyContent() {
        return isNull(getElement(".solution-main"));
    }
}

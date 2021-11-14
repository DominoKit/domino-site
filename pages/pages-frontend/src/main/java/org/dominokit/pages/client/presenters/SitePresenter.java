package org.dominokit.pages.client.presenters;

import org.dominokit.domino.api.client.annotations.presenter.*;
import org.dominokit.domino.api.client.mvp.presenter.ViewBaseClientPresenter;
import org.dominokit.domino.api.shared.extension.MainDominoEvent;
import org.dominokit.pages.client.views.SiteView;
import org.dominokit.pages.shared.events.PageEnhancedEvent;
import org.dominokit.pages.shared.service.ContentServiceFactory;

@Slot("enhance-slot")
@AutoReveal
@DependsOn(@EventsGroup(MainDominoEvent.class))
public abstract class SitePresenter<V extends SiteView> extends ViewBaseClientPresenter<V> implements SiteView.SiteUiHandlers {

    @OnReveal
    public void load() {
        view.setPageTitle(getPageTitle());
        enhance();
    }

    protected abstract String getPageTitle();

    @Override
    public void onLinkClick(String href) {
        String path = "main/content/" + href;
        ContentServiceFactory.INSTANCE
                .getPageContent(path)
                .onSuccess(content -> {
                    view.updateContent(content);
                    enhance();
                    history().fireState(href);
                })
                .send();
    }

    private void enhance() {
        view.enhance(() -> fireEvent(PageEnhancedEvent.class, new PageEnhancedEvent(true)));
    }
}

package org.dominokit.pages.client.presenters;

import org.dominokit.domino.api.client.annotations.presenter.AutoReveal;
import org.dominokit.domino.api.client.annotations.presenter.OnReveal;
import org.dominokit.domino.api.client.annotations.presenter.RoutingState;
import org.dominokit.domino.api.client.annotations.presenter.Slot;
import org.dominokit.domino.history.DominoHistory;
import org.dominokit.pages.client.views.SiteView;
import org.dominokit.pages.shared.service.ContentServiceFactory;

import java.util.function.Consumer;

@Slot("enhance-slot")
@AutoReveal
public abstract class SitePresenter<V extends SiteView> extends NavigableProxy<V> {

    @RoutingState
    protected DominoHistory.State state;

    @OnReveal
    public void load() {
        view.setPageTitle(getPageTitle());
        if(!state.isDirect()) {
            updateContent(content -> {
                view.updateRootContent(content);
                view.enhance();
                onReveal();
            });
        } else {
            view.enhance();
            onReveal();
        }
    }

    protected void updateContent(Consumer<String> contentConsumer) {
        String path = "fragments/pages/" + getPath();
        ContentServiceFactory.INSTANCE
                .getPageContent(path)
                .onSuccess(contentConsumer::accept)
                .send();
    }

    protected void onReveal() {
    }

    protected abstract String getPageTitle();

    protected abstract String getPath();
}

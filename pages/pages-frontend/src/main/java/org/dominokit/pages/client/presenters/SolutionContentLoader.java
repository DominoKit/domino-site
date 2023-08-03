package org.dominokit.pages.client.presenters;

import org.dominokit.domino.api.client.ClientApp;
import org.dominokit.domino.api.client.extension.DominoEvents;
import org.dominokit.domino.history.HistoryToken;
import org.dominokit.pages.client.views.PagesView;
import org.dominokit.pages.shared.events.ContentState;

public class SolutionContentLoader implements ContentLoader {

    @Override
    public boolean canLoad(HistoryToken token) {
        return token.paths().size() > 1 && "solutions".equalsIgnoreCase(token.paths().get(0));
    }

    @Override
    public void loadContent(HistoryToken token, PagesView view) {
        String page = token.paths().get(token.paths().size() - 1);
        getContent(token.path(), page, content -> {
            view.replaceContent(content, "dui-content-container");
            view.enhancePadding();
            view.registerSlots();
            DominoEvents.fire(ContentState.class, new ContentState(true));
        });
    }
}

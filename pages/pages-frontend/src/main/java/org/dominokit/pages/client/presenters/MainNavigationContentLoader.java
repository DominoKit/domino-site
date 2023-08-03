package org.dominokit.pages.client.presenters;

import org.dominokit.domino.api.client.extension.DominoEvents;
import org.dominokit.domino.history.HistoryToken;
import org.dominokit.pages.client.views.PagesView;
import org.dominokit.pages.shared.events.ContentState;

public class MainNavigationContentLoader implements ContentLoader {

    @Override
    public boolean canLoad(HistoryToken token) {
        return token.endsWithPath("home")
         || token.endsWithPath("services")
         || token.endsWithPath("solutions")
         || token.endsWithPath("solutions/domino-ui")
         || token.endsWithPath("solutions/domino-mvp")
         || token.endsWithPath("solutions/domino-jackson")
         || token.endsWithPath("solutions/domino-rest")
         || token.endsWithPath("solutions/domino-history")
         || token.endsWithPath("resources")
         || token.endsWithPath("news")
         || token.endsWithPath("about-us")
                ;
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

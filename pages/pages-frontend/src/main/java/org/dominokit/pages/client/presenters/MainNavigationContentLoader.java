package org.dominokit.pages.client.presenters;

import elemental2.dom.DomGlobal;
import org.dominokit.domino.api.client.ClientApp;
import org.dominokit.domino.api.client.extension.DominoEvents;
import org.dominokit.domino.history.HistoryToken;
import org.dominokit.domino.history.StateToken;
import org.dominokit.pages.client.presenters.samples.SiteEvents;
import org.dominokit.pages.client.views.PagesView;
import org.dominokit.pages.shared.events.ContentState;

public class MainNavigationContentLoader implements ContentLoader {

    @Override
    public boolean canLoad(HistoryToken token) {
        return token.endsWithPath("home")
         || token.endsWithPath("services")
         || token.endsWithPath("solutions")
         || token.endsWithPath("solutions/domino-ui/v2")
         || token.endsWithPath("solutions/domino-mvp")
         || token.endsWithPath("solutions/domino-jackson/v1")
         || token.endsWithPath("solutions/domino-rest/v1")
         || token.endsWithPath("solutions/domino-history/v1")
         || token.endsWithPath("support/donation")
         || token.endsWithPath("resources")
         || token.endsWithPath("news")
         || token.endsWithPath("about-us")
                ;
    }

    @Override
    public void loadContent(HistoryToken token, PagesView view) {
        DomGlobal.console.info("MainNavigationContentLoader : Loading direct url --- > ");
        String page = token.paths().get(token.paths().size() - 1);
        getContent(token.path(), page, false , content -> {
            view.replaceContent(content, "dui-content-container");
            view.enhancePadding();
            view.registerSlots();
            SiteEvents.fireContentEvent();
            ClientApp.make().getHistory().fireState(StateToken.of(ClientApp.make().getHistory().currentToken()));
        });
    }
}

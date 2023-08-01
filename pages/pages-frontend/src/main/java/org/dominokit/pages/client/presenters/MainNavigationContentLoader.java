package org.dominokit.pages.client.presenters;

import org.dominokit.domino.history.HistoryToken;
import org.dominokit.pages.client.views.PagesView;

public class MainNavigationContentLoader implements ContentLoader {

    @Override
    public boolean canLoad(HistoryToken token) {
        return token.paths().size() == 1 && (
                token.paths().contains("home")
                        || token.paths().contains("solutions")
                        || token.paths().contains("services")
                        || token.paths().contains("resources")
                        || token.paths().contains("news")
                        || token.paths().contains("about-us"))
                ;
    }

    @Override
    public void loadContent(HistoryToken token, PagesView view) {
        String page = token.paths().get(token.paths().size() - 1);
        getContent(token.path(), page, content -> {
            view.replaceContent(content, "dui-content-container");
            view.enhancePadding();
        });
    }
}

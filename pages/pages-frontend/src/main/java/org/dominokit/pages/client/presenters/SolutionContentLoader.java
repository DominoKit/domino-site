package org.dominokit.pages.client.presenters;

import static java.util.Objects.nonNull;

import elemental2.dom.DomGlobal;
import org.dominokit.domino.history.HistoryToken;
import org.dominokit.pages.client.presenters.samples.SiteEvents;
import org.dominokit.pages.client.views.PagesView;

public class SolutionContentLoader implements ContentLoader {

    @Override
    public boolean canLoad(HistoryToken token) {
        return token.paths().size() > 1 && "solutions".equalsIgnoreCase(token.paths().get(0));
    }

    @Override
    public void loadContent(HistoryToken token, PagesView view) {
        String page = token.paths().get(token.paths().size() - 1);
        boolean docsContent = token.paths().contains("docs") && nonNull(DomGlobal.document.getElementById("dui-site-left-menu"));
        getContent(token.path(), page, docsContent, content -> {
            String container = docsContent?"dui-docs-content":"dui-content-container";
            view.replaceContent(content, container);
            view.enhancePadding();
            view.registerSlots();
            SiteEvents.fireContentEvent();

        });
    }
}

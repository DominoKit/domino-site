package org.dominokit.pages.client.presenters;

import org.dominokit.domino.api.client.annotations.presenter.*;
import org.dominokit.domino.history.TokenFilter;
import org.dominokit.pages.client.views.DocsView;
import org.dominokit.pages.shared.events.DocsActivationEvent;
import org.dominokit.pages.shared.events.PageEnhancedEvent;
import org.dominokit.pages.shared.events.SlotRegisteredEvent;
import org.dominokit.pages.shared.service.ContentServiceFactory;

import static org.dominokit.domino.history.TokenFilter.startsWith;

@PresenterProxy(name = DocsProxy.NAME)
@AutoRoute(token = DocsProxy.PATH)
@OnStateChanged(DocsActivationEvent.class)
public class DocsProxy extends SitePresenter<DocsView> {

    public static final String PATH = "solutions/:solution/docs";
    public static final String NAME = "DOCS_PROXY";

    @PathParameter
    String solution;

    @RoutingTokenFilter
    public static TokenFilter onRoute(String token) {
        return startsWith(token);
    }

    @StartupTokenFilter
    public static TokenFilter onDirectRoute(String token) {
        return startsWith(token);
    }

    @Override
    protected void onReveal() {
        view.enhanceTree();
        view.selectMenu(getPage());
        history().listen(startsWith(getPath()), state -> {
            view.selectMenu(getPage());
        });
        fireEvent(SlotRegisteredEvent.class, new SlotRegisteredEvent(true));
    }

    @OnRemove
    public void onRemove(){
        fireEvent(SlotRegisteredEvent.class, new SlotRegisteredEvent(false));
    }

    private void updateDocsContent() {
        fireEvent(PageEnhancedEvent.class, new PageEnhancedEvent(false));
        String path = "main/content/" + history().currentToken().path();
        ContentServiceFactory.INSTANCE
                .getPageContent(path)
                .onSuccess(content -> {
                    view.updateDocsContent(content);
                    view.selectMenu(getPage());
                    fireEvent(PageEnhancedEvent.class, new PageEnhancedEvent(true));
                })
                .send();
    }

    private String getPage() {
        String page = history().currentToken().noRootValue().replace("solutions/" + solution + "/docs/getting-started", "").replaceFirst("/", "");
        if (page.contains("#")) {
            page = page.substring(0, page.lastIndexOf("#"));
        }
        if (page.trim().isEmpty()) {
            page = "/";
        }
        return page;
    }

    @Override
    protected String getPageTitle() {
        return solution;
    }

    @Override
    protected String getPath() {
        return PATH.replace(":solution", solution);
    }
}

package org.dominokit.pages.client.presenters;

import org.dominokit.domino.api.client.annotations.presenter.*;
import org.dominokit.domino.history.TokenFilter;
import org.dominokit.pages.client.views.DocsView;
import org.dominokit.pages.shared.events.DocsActivationEvent;
import org.dominokit.pages.shared.events.SlotRegisteredEvent;

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

    private String getPage() {
        String page = history().currentToken().noRootValue().replace("solutions/" + solution + "/docs", "")
                               .replaceFirst("/", "");
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
        return PATH.replace(":solution", solution) + "/main";
    }
}

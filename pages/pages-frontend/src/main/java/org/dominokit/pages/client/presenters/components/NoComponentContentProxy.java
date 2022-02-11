package org.dominokit.pages.client.presenters.components;

import org.dominokit.domino.api.client.annotations.presenter.*;
import org.dominokit.domino.history.TokenFilter;
import org.dominokit.pages.client.presenters.BaseComponentProxy;
import org.dominokit.pages.client.presenters.DocsProxy;
import org.dominokit.pages.client.views.components.NoComponentContentView;
import org.dominokit.pages.shared.events.DocsActivationEvent;
import org.dominokit.pages.shared.events.SlotRegisteredEvent;

@PresenterProxy(parent = DocsProxy.NAME)
@AutoRoute(token = NoComponentContentProxy.PATH, reRouteActivated = true)
@AutoReveal
@Slot("docs-content")
@DependsOn(@EventsGroup({DocsActivationEvent.class, SlotRegisteredEvent.class}))
public class NoComponentContentProxy extends BaseComponentProxy<NoComponentContentView> {

    public static final String PATH = "solutions/dominoui/docs/getting-started/create-project";

    @PathParameter
    protected String method;

    @RoutingTokenFilter
    public static TokenFilter onRoute(String token) {
        return TokenFilter.startsWith(token);
    }

    @StartupTokenFilter
    public static TokenFilter onDirectRoute(String token) {
        return TokenFilter.startsWith(token);
    }
}

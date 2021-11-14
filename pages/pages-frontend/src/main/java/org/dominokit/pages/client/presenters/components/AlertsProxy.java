package org.dominokit.pages.client.presenters.components;

import org.dominokit.domino.api.client.annotations.presenter.*;
import org.dominokit.domino.api.client.mvp.presenter.ViewBaseClientPresenter;
import org.dominokit.pages.client.presenters.DocsProxy;
import org.dominokit.pages.client.views.components.AlertsView;
import org.dominokit.pages.shared.events.PageEnhancedEvent;

@PresenterProxy(parent = DocsProxy.NAME)
@AutoRoute(token = "solutions/dominoui/docs/getting-started/alerts")
@AutoReveal
@Slot("alerts")
@DependsOn(@EventsGroup(PageEnhancedEvent.class))
public class AlertsProxy extends ViewBaseClientPresenter<AlertsView> {
}

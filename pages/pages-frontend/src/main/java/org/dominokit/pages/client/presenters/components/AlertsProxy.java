package org.dominokit.pages.client.presenters.components;

import org.dominokit.domino.api.client.annotations.presenter.*;
import org.dominokit.pages.client.presenters.BaseComponentProxy;
import org.dominokit.pages.client.presenters.DocsProxy;
import org.dominokit.pages.client.views.components.AlertsView;
import org.dominokit.pages.shared.events.DocsActivationEvent;
import org.dominokit.pages.shared.events.SlotRegisteredEvent;

@PresenterProxy(parent = DocsProxy.NAME)
@AutoRoute(token = "solutions/dominoui/docs/getting-started/alerts")
@AutoReveal
@Slot("docs-content")
@DependsOn(@EventsGroup({DocsActivationEvent.class, SlotRegisteredEvent.class}))
public class AlertsProxy extends BaseComponentProxy<AlertsView> {

}

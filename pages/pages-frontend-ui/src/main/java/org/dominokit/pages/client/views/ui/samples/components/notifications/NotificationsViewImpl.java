package org.dominokit.pages.client.views.ui.samples.components.notifications;

import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.pages.client.presenters.samples.components.NotificationsProxy;
import org.dominokit.pages.client.views.ui.DemoSample;
import org.dominokit.pages.client.views.ui.LazyProvider;
import org.dominokit.pages.client.views.ui.SampleViewImpl;

@UiView(presentable = NotificationsProxy.class)
public class NotificationsViewImpl extends SampleViewImpl {

    public NotificationsViewImpl() {
        register(DemoSample.of("notifications-basic", BasicNotificationsSample.class, LazyProvider.of(BasicNotificationsSample::create)));
        register(DemoSample.of("notifications-context", ContextNotificationsSample.class, LazyProvider.of(ContextNotificationsSample::create)));
        register(DemoSample.of("notifications-colored", ColoredNotificationsSample.class, LazyProvider.of(ColoredNotificationsSample::create)));
        register(DemoSample.of("notifications-animation", NotificationsAnimationSample.class, LazyProvider.of(NotificationsAnimationSample::create)));
    }
}
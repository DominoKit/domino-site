package org.dominokit.pages.client.presenters.samples.icons;

import org.dominokit.domino.api.client.annotations.presenter.*;
import org.dominokit.domino.api.client.mvp.presenter.ViewablePresenter;
import org.dominokit.pages.client.presenters.SampleProxy;
import org.dominokit.pages.client.views.IconsView;
import org.dominokit.pages.client.views.SampleView;
import org.dominokit.pages.shared.events.ContentState;

import javax.annotation.PostConstruct;
import java.util.List;

@PresenterProxy(name = "IconsDemo")
@AutoRoute(token = "solutions/domino-ui/v2/docs/mdi-icons", reRouteActivated = true)
@Slot("dui-demo-sample-slot")
public class IconsProxy extends ViewablePresenter<IconsView> implements IconsView.IconsUiHandlers {

    @QueryParameter
    List<String> tag;
    @PostConstruct
    public void onPostConstruct() {
        activate();
    }

    @ListenTo(event = ContentState.class)
    public void onContentReady(ContentState event) {
        reveal();
    }

    @OnReveal
    public void renderSamples() {
        view.setTag(tag.get(0));
    }
}
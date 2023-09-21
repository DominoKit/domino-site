package org.dominokit.pages.client.presenters.samples.colors;

import org.dominokit.domino.api.client.annotations.presenter.*;
import org.dominokit.domino.api.client.mvp.presenter.ViewablePresenter;
import org.dominokit.pages.client.presenters.SampleProxy;
import org.dominokit.pages.client.views.ColorsView;
import org.dominokit.pages.client.views.IconsView;
import org.dominokit.pages.shared.events.ContentState;

import javax.annotation.PostConstruct;
import java.util.List;

@PresenterProxy(name = "ColorsDemo")
@AutoRoute(token = "solutions/domino-ui/docs/colors", reRouteActivated = true)
@Slot("dui-demo-sample-slot")
public class ColorsProxy  extends ViewablePresenter<ColorsView> implements ColorsView.ColorsUiHandlers {

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

}
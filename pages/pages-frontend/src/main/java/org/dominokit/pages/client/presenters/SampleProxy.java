package org.dominokit.pages.client.presenters;

import elemental2.dom.DomGlobal;
import org.dominokit.domino.api.client.annotations.presenter.ListenTo;
import org.dominokit.domino.api.client.annotations.presenter.OnReveal;
import org.dominokit.domino.api.client.annotations.presenter.Slot;
import org.dominokit.domino.api.client.mvp.presenter.ViewablePresenter;
import org.dominokit.pages.client.views.SampleView;
import org.dominokit.pages.shared.events.ContentState;

import javax.annotation.PostConstruct;

@Slot("dui-demo-sample-slot")
public abstract class SampleProxy extends ViewablePresenter<SampleView> implements SampleView.SampleUiHandlers {

    @PostConstruct
    public void onPostConstruct() {
        activate();
    }

    @ListenTo(event = ContentState.class)
    public void onContentReady(ContentState event){
        reveal();
    }

    @OnReveal
    public void renderSamples(){
        view.renderSamples();
    }
}
package org.dominokit.pages.client.presenters;

import dominoaggregate.shaded.com.apache.commons.lang3.concurrent.LazyInitializer;
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

    public static boolean ready = false;
    public static boolean listen = true;

    @PostConstruct
    public void onPostConstruct() {
        DomGlobal.console.info(">Activating sample view.");
        activate();
        if(ready){
            reveal();
            listen= false;
            ready= false;
        }
    }

    @ListenTo(event = ContentState.class)
    public void onContentReady(ContentState event){
        DomGlobal.console.info(">Revealing sample view.");
        reveal();
    }

    @OnReveal
    public void renderSamples(){
        DomGlobal.console.info("On reveal render samples -->");
        view.renderSamples();
    }
}
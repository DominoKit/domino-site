package org.dominokit.pages.client.views.ui.samples.components.dialogs;

import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.pages.client.presenters.samples.components.CardsProxy;
import org.dominokit.pages.client.presenters.samples.components.DialogsProxy;
import org.dominokit.pages.client.views.ui.DemoSample;
import org.dominokit.pages.client.views.ui.LazyProvider;
import org.dominokit.pages.client.views.ui.SampleViewImpl;
import org.dominokit.pages.client.views.ui.samples.components.cards.*;

@UiView(presentable = DialogsProxy.class)
public class DialogsViewImpl extends SampleViewImpl {

    public DialogsViewImpl() {
        register(DemoSample.of("dialogs-basic", BasicDialogsSample.class, LazyProvider.of(BasicDialogsSample::create)));
    }
}
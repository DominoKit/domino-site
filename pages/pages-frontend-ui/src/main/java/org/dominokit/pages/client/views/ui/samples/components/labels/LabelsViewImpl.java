package org.dominokit.pages.client.views.ui.samples.components.labels;

import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.pages.client.presenters.samples.components.CardsProxy;
import org.dominokit.pages.client.presenters.samples.components.LabelsProxy;
import org.dominokit.pages.client.views.ui.DemoSample;
import org.dominokit.pages.client.views.ui.LazyProvider;
import org.dominokit.pages.client.views.ui.SampleViewImpl;
import org.dominokit.pages.client.views.ui.samples.components.cards.*;

@UiView(presentable = LabelsProxy.class)
public class LabelsViewImpl extends SampleViewImpl {

    public LabelsViewImpl() {
        register(DemoSample.of("labels-basic", LabelsBasicSample.class, LazyProvider.of(LabelsBasicSample::create)));
    }
}
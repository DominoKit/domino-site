package org.dominokit.pages.client.views.ui.samples.forms.steppers;

import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.pages.client.presenters.samples.forms.SteppersProxy;
import org.dominokit.pages.client.views.ui.DemoSample;
import org.dominokit.pages.client.views.ui.LazyProvider;
import org.dominokit.pages.client.views.ui.SampleViewImpl;

@UiView(presentable = SteppersProxy.class)
public class SteppersViewImpl extends SampleViewImpl {

    public SteppersViewImpl() {
        register(DemoSample.of("stepper-track-horizontal", HorizontalTrackSample.class, LazyProvider.of(HorizontalTrackSample::create)));
//        register(DemoSample.of("stepper-track-vertical", VerticalTrackSample.class, LazyProvider.of(VerticalTrackSample::create)));
//        register(DemoSample.of("stepper-horizontal", HorizontalStepperSample.class, LazyProvider.of(HorizontalStepperSample::create)));
//        register(DemoSample.of("stepper-vertical", VerticalStepperSample.class, LazyProvider.of(VerticalStepperSample::create)));
    }
}
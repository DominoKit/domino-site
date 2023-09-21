package org.dominokit.pages.client.views.ui.samples.animations;

import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.pages.client.presenters.samples.animations.AnimationsProxy;
import org.dominokit.pages.client.presenters.samples.typography.TypographyProxy;
import org.dominokit.pages.client.views.ui.DemoSample;
import org.dominokit.pages.client.views.ui.LazyProvider;
import org.dominokit.pages.client.views.ui.SampleViewImpl;
import org.dominokit.pages.client.views.ui.samples.typography.*;

@UiView(presentable = AnimationsProxy.class)
public class AnimationsViewImpl extends SampleViewImpl {

    public AnimationsViewImpl() {
        register(DemoSample.of("animations-basic", AnimationsBasicSample.class, LazyProvider.of(AnimationsBasicSample::create)));
    }
}
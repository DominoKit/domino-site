package org.dominokit.pages.client.views.ui.samples.components.media;

import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.pages.client.presenters.samples.components.MediaObjectsProxy;
import org.dominokit.pages.client.views.ui.DemoSample;
import org.dominokit.pages.client.views.ui.LazyProvider;
import org.dominokit.pages.client.views.ui.SampleViewImpl;

@UiView(presentable = MediaObjectsProxy.class)
public class MediaObjectsViewImpl extends SampleViewImpl {

    public MediaObjectsViewImpl() {
        register(DemoSample.of("media-object-basic", MediaObjectsBasicSample.class, LazyProvider.of(MediaObjectsBasicSample::create)));
        register(DemoSample.of("media-object-alignment", MediaObjectsAlignmentSample.class, LazyProvider.of(MediaObjectsAlignmentSample::create)));
    }
}
package org.dominokit.pages.client.views.ui.samples.components.thumbnails;

import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.pages.client.presenters.samples.components.CardsProxy;
import org.dominokit.pages.client.presenters.samples.components.ThumbnailsProxy;
import org.dominokit.pages.client.views.ui.DemoSample;
import org.dominokit.pages.client.views.ui.LazyProvider;
import org.dominokit.pages.client.views.ui.SampleViewImpl;
import org.dominokit.pages.client.views.ui.samples.components.cards.*;

@UiView(presentable = ThumbnailsProxy.class)
public class ThumbnailsViewImpl extends SampleViewImpl {

    public ThumbnailsViewImpl() {
        register(DemoSample.of("thumbnails-basic", BasicThumbnailsSample.class, LazyProvider.of(BasicThumbnailsSample::create)));
        register(DemoSample.of("thumbnails-content", ThumbnailsContentSample.class, LazyProvider.of(ThumbnailsContentSample::create)));
        register(DemoSample.of("thumbnails-title", ThumbnailsTitleSample.class, LazyProvider.of(ThumbnailsTitleSample::create)));
        register(DemoSample.of("thumbnails-detailed", DetailedThumbnailsSample.class, LazyProvider.of(DetailedThumbnailsSample::create)));
    }
}
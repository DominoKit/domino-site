package org.dominokit.pages.client.views.ui.samples.components.infobox;

import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.pages.client.presenters.samples.components.InfoBoxProxy;
import org.dominokit.pages.client.views.ui.DemoSample;
import org.dominokit.pages.client.views.ui.LazyProvider;
import org.dominokit.pages.client.views.ui.SampleViewImpl;

@UiView(presentable = InfoBoxProxy.class)
public class InfoBoxViewImpl extends SampleViewImpl {

    public InfoBoxViewImpl() {
        register(DemoSample.of("infobox-basic", BasicInfoBoxSample.class, LazyProvider.of(BasicInfoBoxSample::create)));
        register(DemoSample.of("infobox-hover", HoverInfoBoxSample.class, LazyProvider.of(HoverInfoBoxSample::create)));
        register(DemoSample.of("infobox-alignment", RightAlignedInfoBoxSample.class, LazyProvider.of(RightAlignedInfoBoxSample::create)));
    }
}
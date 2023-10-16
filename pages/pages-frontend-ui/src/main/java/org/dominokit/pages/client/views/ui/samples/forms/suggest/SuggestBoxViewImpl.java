package org.dominokit.pages.client.views.ui.samples.forms.suggest;

import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.pages.client.presenters.samples.forms.SuggestBoxProxy;
import org.dominokit.pages.client.views.ui.DemoSample;
import org.dominokit.pages.client.views.ui.LazyProvider;
import org.dominokit.pages.client.views.ui.SampleViewImpl;

@UiView(presentable = SuggestBoxProxy.class)
public class SuggestBoxViewImpl extends SampleViewImpl {

    public SuggestBoxViewImpl() {
        register(DemoSample.of("suggest-box-sample", SuggestBoxSample.class, LazyProvider.of(SuggestBoxSample::create)));
        register(DemoSample.of("tag-box-sample", TagsInputSample.class, LazyProvider.of(TagsInputSample::create)));
    }
}
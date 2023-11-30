package org.dominokit.pages.client.views.ui.samples.forms.select;

import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.pages.client.presenters.samples.forms.SelectProxy;
import org.dominokit.pages.client.views.ui.DemoSample;
import org.dominokit.pages.client.views.ui.LazyProvider;
import org.dominokit.pages.client.views.ui.SampleViewImpl;

@UiView(presentable = SelectProxy.class)
public class SelectViewImpl extends SampleViewImpl {

    public SelectViewImpl() {
        register(DemoSample.of("select-sample", BasicFormsSelectSample.class, LazyProvider.of(BasicFormsSelectSample::create)));
    }
}
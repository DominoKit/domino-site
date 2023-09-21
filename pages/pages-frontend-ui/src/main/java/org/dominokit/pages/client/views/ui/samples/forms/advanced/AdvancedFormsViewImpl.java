package org.dominokit.pages.client.views.ui.samples.forms.advanced;

import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.pages.client.presenters.samples.forms.AdvancedFormsProxy;
import org.dominokit.pages.client.presenters.samples.forms.BasicFormsProxy;
import org.dominokit.pages.client.views.ui.DemoSample;
import org.dominokit.pages.client.views.ui.LazyProvider;
import org.dominokit.pages.client.views.ui.SampleViewImpl;
import org.dominokit.pages.client.views.ui.samples.forms.basic.*;

@UiView(presentable = AdvancedFormsProxy.class)
public class AdvancedFormsViewImpl extends SampleViewImpl {

    public AdvancedFormsViewImpl() {
        register(DemoSample.of("forms-advanced-upload", FileUploadSample.class, LazyProvider.of(FileUploadSample::create)));
        register(DemoSample.of("forms-advanced-tags", TagsInputSample.class, LazyProvider.of(TagsInputSample::create)));
        register(DemoSample.of("forms-advanced-suggest", SuggestBoxSample.class, LazyProvider.of(SuggestBoxSample::create)));
    }
}
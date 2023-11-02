package org.dominokit.pages.client.views.ui.samples.components.richtext;

import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.pages.client.presenters.samples.components.RichTextEditorProxy;
import org.dominokit.pages.client.views.ui.DemoSample;
import org.dominokit.pages.client.views.ui.LazyProvider;
import org.dominokit.pages.client.views.ui.SampleViewImpl;

@UiView(presentable = RichTextEditorProxy.class)
public class RichTextEditorViewImpl extends SampleViewImpl {

    public RichTextEditorViewImpl() {
        register(DemoSample.of("rich-text-editor-basic", RichTextEditorSample.class, LazyProvider.of(RichTextEditorSample::create)));
    }
}
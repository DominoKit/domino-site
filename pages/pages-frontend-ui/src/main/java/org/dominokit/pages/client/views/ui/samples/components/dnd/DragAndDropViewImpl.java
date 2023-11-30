package org.dominokit.pages.client.views.ui.samples.components.dnd;

import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.pages.client.presenters.samples.components.DragAndDropProxy;
import org.dominokit.pages.client.views.ui.DemoSample;
import org.dominokit.pages.client.views.ui.LazyProvider;
import org.dominokit.pages.client.views.ui.SampleViewImpl;

@UiView(presentable = DragAndDropProxy.class)
public class DragAndDropViewImpl extends SampleViewImpl {

    public DragAndDropViewImpl() {
        register(DemoSample.of("drag-and-drop-basic", DragAndDropBasicSample.class, LazyProvider.of(DragAndDropBasicSample::create)));
    }
}
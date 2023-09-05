package org.dominokit.pages.client.views.ui.samples.components.lists;

import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.pages.client.presenters.samples.components.CardsProxy;
import org.dominokit.pages.client.presenters.samples.components.ListsProxy;
import org.dominokit.pages.client.views.ui.DemoSample;
import org.dominokit.pages.client.views.ui.LazyProvider;
import org.dominokit.pages.client.views.ui.SampleViewImpl;
import org.dominokit.pages.client.views.ui.samples.components.cards.*;

@UiView(presentable = ListsProxy.class)
public class ListsViewImpl extends SampleViewImpl {

    public ListsViewImpl() {
        register(DemoSample.of("lists-single-select", SingleSelectListsSample.class, LazyProvider.of(SingleSelectListsSample::create)));
        register(DemoSample.of("lists-multi-select", MultiSelectListsSample.class, LazyProvider.of(MultiSelectListsSample::create)));
    }
}
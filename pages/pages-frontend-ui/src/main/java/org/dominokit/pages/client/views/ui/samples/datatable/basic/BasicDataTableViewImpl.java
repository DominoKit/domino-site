package org.dominokit.pages.client.views.ui.samples.datatable.basic;

import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.pages.client.presenters.samples.datatable.BasicDataTableProxy;
import org.dominokit.pages.client.views.ui.DemoSample;
import org.dominokit.pages.client.views.ui.LazyProvider;
import org.dominokit.pages.client.views.ui.SampleViewImpl;

@UiView(presentable = BasicDataTableProxy.class)
public class BasicDataTableViewImpl extends SampleViewImpl {

    public BasicDataTableViewImpl() {
        register(DemoSample.of("datatable-basic", BasicDataTableSample.class, LazyProvider.of(BasicDataTableSample::create)));
    }
}
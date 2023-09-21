package org.dominokit.pages.client.views.ui.samples.datatable.editable;

import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.pages.client.presenters.samples.datatable.BasicDataTableProxy;
import org.dominokit.pages.client.presenters.samples.datatable.EditableTableProxy;
import org.dominokit.pages.client.views.ui.DemoSample;
import org.dominokit.pages.client.views.ui.LazyProvider;
import org.dominokit.pages.client.views.ui.SampleViewImpl;
import org.dominokit.pages.client.views.ui.samples.datatable.basic.BasicDataTableSample;

@UiView(presentable = EditableTableProxy.class)
public class EditableTableViewImpl extends SampleViewImpl {

    public EditableTableViewImpl() {
        register(DemoSample.of("datatable-editable", EditableTableSample.class, LazyProvider.of(EditableTableSample::create)));
    }
}
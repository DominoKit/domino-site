package org.dominokit.pages.client.views.ui.samples.components.boards;

import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.pages.client.presenters.samples.components.AlertsProxy;
import org.dominokit.pages.client.presenters.samples.components.BoardsProxy;
import org.dominokit.pages.client.views.ui.DemoSample;
import org.dominokit.pages.client.views.ui.LazyProvider;
import org.dominokit.pages.client.views.ui.SampleViewImpl;
import org.dominokit.pages.client.views.ui.samples.components.alerts.BasicAlertsSample;
import org.dominokit.pages.client.views.ui.samples.components.alerts.ContextAlertsSample;
import org.dominokit.pages.client.views.ui.samples.components.alerts.DismissibleAlertsSample;
import org.dominokit.pages.client.views.ui.samples.components.alerts.LinksAlertsSample;

@UiView(presentable = BoardsProxy.class)
public class BoardsViewImpl extends SampleViewImpl {

    public BoardsViewImpl() {
        register(DemoSample.of("boards-column", ColumnBoardsSample.class, LazyProvider.of(ColumnBoardsSample::create)));
        register(DemoSample.of("boards-list", ListsBoardsSample.class, LazyProvider.of(ListsBoardsSample::create)));
    }
}
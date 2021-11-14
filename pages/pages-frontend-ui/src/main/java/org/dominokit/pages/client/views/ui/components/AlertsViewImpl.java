package org.dominokit.pages.client.views.ui.components;

import elemental2.dom.HTMLElement;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.api.client.mvp.view.BaseDominoView;
import org.dominokit.domino.ui.Typography.Paragraph;
import org.dominokit.domino.ui.Typography.Strong;
import org.dominokit.domino.ui.alerts.Alert;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.pages.client.presenters.components.AlertsProxy;
import org.dominokit.pages.client.views.components.AlertsView;

import static org.jboss.elemento.Elements.h;

@UiView(presentable = AlertsProxy.class)
public class AlertsViewImpl extends BaseDominoView<HTMLElement> implements AlertsView {

    @Override
    protected void initRoot(HTMLElement root) {
        ComponentPreview componentPreview = ComponentPreview.create();
        ComponentPreview componentPreview1 = ComponentPreview.create();
        DominoElement.of(root)
                .appendChild(h(1).textContent("Alerts"))
                .appendChild(Paragraph.create("Provide contextual feedback messages for typical user actions."))
                .appendChild(h(2).textContent("Basic Alerts"))
                .appendChild(componentPreview
                        .appendChild(Alert.success()
                                .appendChild(Strong.of("Well done!"))
                                .appendChild(" You successfully read this important alert message.")
                        )
                        .appendChild(Alert.info()
                                .appendChild(Strong.of("Heads up!"))
                                .appendChild(" This alert needs your attention, but it’s not super important.")
                        )
                        .appendChild(Alert.warning()
                                .appendChild(Strong.of("Warning!"))
                                .appendChild(" Better check yourself, you’re not looking too good.")
                        )
                        .appendChild(Alert.error()
                                .appendChild(Strong.of("Oh snap!"))
                                .appendChild(" Change a few things up and try submitting again.")
                        )
                )
                .appendChild(h(2).textContent("Dismissible Alerts"))
                .appendChild(componentPreview1
                        .appendChild(Alert.success().dismissible()
                                .appendChild(Strong.of("Well done!"))
                                .appendChild(" You successfully read this important alert message.")
                        )
                        .appendChild(Alert.info().dismissible()
                                .appendChild(Strong.of("Heads up!"))
                                .appendChild(" This alert needs your attention, but it’s not super important.")
                        )
                        .appendChild(Alert.warning().dismissible()
                                .appendChild(Strong.of("Warning!"))
                                .appendChild(" Better check yourself, you’re not looking too good.")
                        )
                        .appendChild(Alert.error().dismissible()
                                .appendChild(Strong.of("Oh snap!"))
                                .appendChild(" Change a few things up and try submitting again.")
                        )
                )
                .appendChild(CodePreview.create("https://raw.githubusercontent.com/DominoKit/domino-ui-demo/master/alerts/src/main/java/org/dominokit/domino/alerts/client/views/ui/AlertsViewImpl.java"));
    }

    @Override
    protected HTMLElement init() {
        return DominoElement.div().element();
    }
}

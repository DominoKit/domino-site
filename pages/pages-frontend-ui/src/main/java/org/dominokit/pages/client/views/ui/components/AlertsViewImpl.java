package org.dominokit.pages.client.views.ui.components;

import elemental2.dom.HTMLElement;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.ui.Typography.Strong;
import org.dominokit.domino.ui.alerts.Alert;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.pages.client.presenters.components.AlertsProxy;
import org.dominokit.pages.client.views.components.AlertsView;
import org.dominokit.samples.annotations.ComponentClass;
import org.dominokit.samples.annotations.ComponentSample;

@UiView(presentable = AlertsProxy.class)
@ComponentClass
public class AlertsViewImpl extends BaseComponentViewImpl implements AlertsView {

    @Override
    public void enhance() {
        getElementBySection("basic-alerts")
                .ifPresent(element -> {
                    DominoElement.of((HTMLElement) element).clearElement()
                            .appendChild(ComponentPreview.of("Success", CodeResource.INSTANCE.success(), success()))
                            .appendChild(ComponentPreview.of("Info", CodeResource.INSTANCE.info(), info()))
                            .appendChild(ComponentPreview.of("Warning", CodeResource.INSTANCE.warning(), warning()))
                            .appendChild(ComponentPreview.of("Error", CodeResource.INSTANCE.error(), error()));
                });
        getElementBySection("dismissible-alerts")
                .ifPresent(element -> {
                    DominoElement.of((HTMLElement) element).clearElement()
                            .appendChild(ComponentPreview.of("Dismissible Success", CodeResource.INSTANCE.successDismissible(), successDismissible()))
                            .appendChild(ComponentPreview.of("Dismissible Success", CodeResource.INSTANCE.infoDismissible(), infoDismissible()))
                            .appendChild(ComponentPreview.of("Dismissible Success", CodeResource.INSTANCE.warningDismissible(), warningDismissible()))
                            .appendChild(ComponentPreview.of("Dismissible Success", CodeResource.INSTANCE.errorDismissible(), errorDismissible()));
                });
    }

    @ComponentSample
    public Alert success() {
        return Alert.success()
                .appendChild(Strong.of("Well done!"))
                .appendChild(" You successfully read this important alert message.");
    }

    @ComponentSample
    public Alert info() {
        return Alert.info()
                .appendChild(Strong.of("Heads up!"))
                .appendChild(" This alert needs your attention, but it’s not super important.");
    }

    @ComponentSample
    public Alert warning() {
        return Alert.warning()
                .appendChild(Strong.of("Warning!"))
                .appendChild(" Better check yourself, you’re not looking too good.");
    }

    @ComponentSample
    public Alert error() {
        return Alert.error()
                .appendChild(Strong.of("Oh snap!"))
                .appendChild(" Change a few things up and try submitting again.");
    }

    @ComponentSample
    public Alert successDismissible() {
        return Alert.success().dismissible()
                .appendChild(Strong.of("Well done!"))
                .appendChild(" You successfully read this important alert message.");
    }

    @ComponentSample
    public Alert infoDismissible() {
        return Alert.info().dismissible()
                .appendChild(Strong.of("Heads up!"))
                .appendChild(" This alert needs your attention, but it’s not super important.");
    }

    @ComponentSample
    public Alert warningDismissible() {
        return Alert.warning().dismissible()
                .appendChild(Strong.of("Warning!"))
                .appendChild(" Better check yourself, you’re not looking too good.");
    }

    @ComponentSample
    public Alert errorDismissible() {
        return Alert.error().dismissible()
                .appendChild(Strong.of("Oh snap!"))
                .appendChild(" Change a few things up and try submitting again.");
    }
}

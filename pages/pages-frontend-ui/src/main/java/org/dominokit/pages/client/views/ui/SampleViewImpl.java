package org.dominokit.pages.client.views.ui;

import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.view.BaseElementView;
import org.dominokit.pages.client.presenters.components.AppLayoutProxy;
import org.dominokit.pages.client.views.SampleView;

import java.util.HashMap;
import java.util.Map;

public abstract class SampleViewImpl extends BaseElementView<HTMLDivElement> implements SampleView {

    protected SampleUiHandlers uiHandlers;
    private final Map<String, DemoSample> samples = new HashMap<>();

    @Override
    public void renderSamples() {
        DomGlobal.document.querySelectorAll("[dui-site-data='dui-sample-container']")
                .asList()
                .stream()
                .map(this::elementOf)
                .forEach(element -> {
                    if (element.hasAttribute("dui-sample-id")) {
                        String sampleId = element.getAttribute("dui-sample-id");
                        if (samples.containsKey(sampleId)) {
                            element.clearElement()
                                    .appendChild(DemoComponent.create(samples.get(sampleId)));
                        }
                    }
                });
    }

    protected void register(DemoSample demoSample) {
        samples.put(demoSample.getSlot(), demoSample);
    }

    @Override
    public void setUiHandlers(SampleUiHandlers uiHandlers) {
        this.uiHandlers = uiHandlers;
    }

    @Override
    protected HTMLDivElement init() {
        return div().element();
    }
}
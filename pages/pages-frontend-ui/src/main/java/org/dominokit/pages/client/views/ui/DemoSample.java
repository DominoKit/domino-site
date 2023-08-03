package org.dominokit.pages.client.views.ui;

import org.dominokit.domino.ui.IsElement;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class DemoSample {

    private final String slot;
    private final Class<?> sampleClass;
    private final Supplier<IsElement<?>> component;
    private Consumer<DemoComponent> onRender = demoComponent -> {};

    public static DemoSample of(String slot, Class<?> sampleClass, Supplier<IsElement<?>> component){
        return new DemoSample(slot, sampleClass, component);
    }

    public DemoSample(String slot, Class<?> sampleClass, Supplier<IsElement<?>> component) {
        this.slot = slot;
        this.sampleClass = sampleClass;
        this.component = component;
    }

    public String getSlot() {
        return slot;
    }

    public DemoSample onRender(Consumer<DemoComponent> onRender){
        this.onRender = onRender;
        return this;
    }

    void onRender(DemoComponent demoComponent) {
        onRender.accept(demoComponent);
    }

    public Class<?> getSampleClass() {
        return sampleClass;
    }

    public Supplier<IsElement<?>> getComponent() {
        return component;
    }
}

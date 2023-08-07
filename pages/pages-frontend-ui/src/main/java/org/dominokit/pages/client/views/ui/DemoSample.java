package org.dominokit.pages.client.views.ui;

import org.dominokit.domino.ui.IsElement;

import java.util.function.Consumer;

public class DemoSample<T extends IsElement<?>> {

    private final String slot;
    private final Class<?> sampleClass;
    private final LazyProvider<T> component;
    private Consumer<DemoComponent<T>> onRender = demoComponent -> {};

    public static <T extends IsElement<?>> DemoSample<T> of(String slot, Class<T> sampleClass, LazyProvider<T> component){
        return new DemoSample<>(slot, sampleClass, component);
    }

    public DemoSample(String slot, Class<?> sampleClass, LazyProvider<T> component) {
        this.slot = slot;
        this.sampleClass = sampleClass;
        this.component = component;
    }

    public String getSlot() {
        return slot;
    }

    public DemoSample<T> onRender(Consumer<DemoComponent<T>> onRender){
        this.onRender = onRender;
        return this;
    }

    void onRender(DemoComponent<T> demoComponent) {
        onRender.accept(demoComponent);
    }

    public Class<?> getSampleClass() {
        return sampleClass;
    }

    public LazyProvider<T> getComponent() {
        return component;
    }
}

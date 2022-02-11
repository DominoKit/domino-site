package org.dominokit.pages.client.views.ui;

import java.util.function.Consumer;

public class FakeElement {
    private final Consumer<Boolean> attachConsumer;
    private final String name;

    public FakeElement(Consumer<Boolean> attachConsumer, String name) {
        this.attachConsumer = attachConsumer;
        this.name = name;
    }

    public void append() {
        this.attachConsumer.accept(true);
    }

    public void remove() {
        this.attachConsumer.accept(false);
    }

    @Override
    public String toString() {
        return "FakeElement{" +
                "name='" + name + '\'' +
                '}';
    }
}

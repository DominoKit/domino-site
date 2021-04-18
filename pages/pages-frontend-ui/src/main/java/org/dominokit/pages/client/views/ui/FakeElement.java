package org.dominokit.pages.client.views.ui;

import java.util.function.Consumer;

public class FakeElement {
    private final Consumer<Boolean> attachConsumer;

    public FakeElement(Consumer<Boolean> attachConsumer) {
        this.attachConsumer = attachConsumer;
    }

    public void append() {
        this.attachConsumer.accept(true);
    }

    public void remove() {
        this.attachConsumer.accept(false);
    }
}
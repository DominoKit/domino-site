package org.dominokit.pages.client.views.ui;

import org.dominokit.domino.api.client.mvp.view.BaseDominoView;

public abstract class FakeView extends BaseDominoView<FakeElement> {
    private boolean revealed = false;

    public FakeView() {
    }

    protected void initRoot(FakeElement root) {
    }

    protected FakeElement init() {
        return new FakeElement((attached) -> {
            if (attached) {
                this.revealHandler.onRevealed();
                this.revealed = true;
            } else {
                this.removeHandler.onRemoved();
                this.revealed = false;
            }

        });
    }

    public boolean isRevealed() {
        return this.revealed;
    }
}
package org.dominokit;

import org.dominokit.domino.api.client.mvp.slots.ContentSlot;
import org.dominokit.domino.api.client.mvp.view.HasContent;
import org.dominokit.domino.api.shared.extension.Content;
import org.dominokit.pages.client.views.ui.FakeElement;

import static java.util.Objects.nonNull;

public class FakeSlot implements ContentSlot {

  private boolean revealed;
  private Content<FakeElement> old;

  @Override
  public void updateContent(HasContent view, HasContent.CreateHandler createHandler) {
    updateContent(view.getContent(createHandler));
  }

  @Override
  public void updateContent(Content view) {
    if (view.get() instanceof FakeElement) {
      if (nonNull(old)) {
        old.get().remove();
      }
      this.old = view;
      ((FakeElement) view.get()).append();
    }
    revealed = true;
  }

  public boolean isRevealed() {
    return revealed;
  }
}
package org.dominokit.pages.client.presenters.samples;

import org.dominokit.domino.api.client.extension.DominoEvents;
import org.dominokit.pages.shared.events.ContentState;

public class SiteEvents {
  public static void fireContentEvent(){
    DominoEvents.fire(ContentState.class, new ContentState(true));
  }
}

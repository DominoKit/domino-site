package org.dominokit.pages.client.presenters.samples;

import elemental2.dom.DomGlobal;
import org.dominokit.domino.api.client.extension.DominoEvents;
import org.dominokit.pages.shared.events.ContentState;

public class SiteEvents {
  public static void fireContentEvent(){
    DomGlobal.console.info("= [:] FIRING CONTENT EVENT [:] =");
    DominoEvents.fire(ContentState.class, new ContentState(true));
  }
}

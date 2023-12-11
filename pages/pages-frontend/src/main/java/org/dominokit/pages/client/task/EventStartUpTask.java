package org.dominokit.pages.client.task;

import org.dominokit.domino.api.client.ClientApp;
import org.dominokit.domino.api.client.annotations.StartupTask;
import org.dominokit.domino.api.client.startup.ClientStartupTask;
import org.dominokit.pages.client.presenters.SampleProxy;
import org.dominokit.pages.shared.events.ContentState;

@StartupTask
public class EventStartUpTask implements ClientStartupTask {
  @Override
  public void execute() {
    ClientApp.make().addListener(ContentState.class,dominoEvent -> {
      if(SampleProxy.listen) {
        SampleProxy.listen = false;
        SampleProxy.ready = true;
      }
    });
  }
}

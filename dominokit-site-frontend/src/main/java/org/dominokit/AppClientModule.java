package org.dominokit;

import com.google.gwt.core.client.EntryPoint;
import elemental2.dom.DomGlobal;
import org.dominokit.domino.api.client.ClientApp;
import org.dominokit.domino.gwt.client.app.DominoGWT;
import org.dominokit.domino.view.GwtView;
import org.dominokit.rest.DominoRestConfig;

import java.util.logging.Logger;

public class AppClientModule implements EntryPoint {

    private static final Logger LOGGER = Logger.getLogger(AppClientModule.class.getName());

    public void onModuleLoad() {
        DominoRestConfig.initDefaults();
        DominoGWT.init();
        GwtView.init();
        ClientApp.make()
                .slotsManager()
                .registerSlot("enhance-slot", new FakeSlot());
        ClientApp.make().run();
        LOGGER.info("dominokit-site Application frontend have been initialized.");
        if (ClientApp.make().getHistory().currentToken().isEmpty()) {
            ClientApp.make().getHistory().fireState("home");
        }
    }
}

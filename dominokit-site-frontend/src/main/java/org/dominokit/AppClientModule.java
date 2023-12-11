package org.dominokit;

import com.google.gwt.core.client.EntryPoint;
import org.dominokit.domino.api.client.ClientApp;
import org.dominokit.domino.gwt.client.app.DominoGWT;
import org.dominokit.domino.history.StateToken;
import org.dominokit.domino.history.TokenFilter;
import org.dominokit.domino.ui.themes.DominoThemeManager;
import org.dominokit.domino.ui.utils.ElementsFactory;
import org.dominokit.domino.view.DominoViewOptions;
import org.dominokit.domino.view.slots.ElementIdSlot;
import org.dominokit.rest.DominoRestConfig;

import java.util.logging.Logger;

public class AppClientModule implements EntryPoint {

    private static final Logger LOGGER = Logger.getLogger(AppClientModule.class.getName());

    public void onModuleLoad() {
        DominoRestConfig.initDefaults();
        DominoGWT.init(DominoViewOptions.getInstance());
        DominoThemeManager.INSTANCE.applyUserThemes();

        ClientApp.make().run();
        LOGGER.info("dominokit-site Application frontend have been initialized.");
        if (ClientApp.make().getHistory().currentToken().isEmpty()) {
            ClientApp.make().getHistory().fireState(StateToken.of("home"));
        }

        ClientApp.make().getHistory()
                .listen(TokenFilter.startsWithPathFilter("solutions/:solution/:version/docs"), state -> {
                    ElementsFactory.elements.body().removeCss("dui-hide-left-menu");
                })
                .onDirectUrl();
        ClientApp.make().getHistory()
                .listen(TokenFilter.not(TokenFilter.startsWithPathFilter("solutions/:solution/:version/docs")), state -> {
                    ElementsFactory.elements.body().addCss("dui-hide-left-menu");
                }).onDirectUrl();
    }
}

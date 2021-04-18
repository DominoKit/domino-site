package org.dominokit.pages.client;

import com.google.gwt.core.client.EntryPoint;
import org.dominokit.domino.api.client.ModuleConfigurator;
import org.dominokit.domino.api.client.annotations.ClientModule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ClientModule(name="PagesUI")
public class PagesUIClientModule implements EntryPoint {

	private static final Logger LOGGER = LoggerFactory.getLogger(PagesUIClientModule.class);

	public void onModuleLoad() {
		LOGGER.info("Initializing Pages frontend UI module ...");
		new ModuleConfigurator().configureModule(new PagesUIModuleConfiguration());
	}
}

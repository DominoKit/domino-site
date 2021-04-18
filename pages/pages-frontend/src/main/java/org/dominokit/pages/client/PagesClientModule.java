package org.dominokit.pages.client;

import com.google.gwt.core.client.EntryPoint;
import org.dominokit.domino.api.client.ModuleConfigurator;
import org.dominokit.domino.api.client.annotations.ClientModule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ClientModule(name="Pages")
public class PagesClientModule implements EntryPoint {

	private static final Logger LOGGER = LoggerFactory.getLogger(PagesClientModule.class);

	public void onModuleLoad() {
		LOGGER.info("Initializing Pages frontend module ...");
		new ModuleConfigurator().configureModule(new PagesModuleConfiguration());
	}
}

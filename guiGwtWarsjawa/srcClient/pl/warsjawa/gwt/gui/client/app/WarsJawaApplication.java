package pl.warsjawa.gwt.gui.client.app;

import com.google.gwt.core.client.GWT;

import eu.caimandesign.gwt.lib.presenter.client.place.PlaceManager;

public class WarsJawaApplication {

	private WarsJawaGuiInjector injector = GWT.create(WarsJawaGuiInjector.class);

	public WarsJawaApplication() {
		final PlaceManager placeManager = injector.getPlaceManager();
		placeManager.fireCurrentPlace();
	}

	
	
}

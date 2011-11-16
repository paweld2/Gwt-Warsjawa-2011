package pl.warsjawa.gwt.gui.client.app;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;

import eu.caimandesign.gwt.lib.presenter.client.place.PlaceManager;

public class WarsJawaApplication {

	private WarsJawaGuiInjector injector = GWT.create(WarsJawaGuiInjector.class);

	public WarsJawaApplication() {
		final PlaceManager placeManager = injector.getPlaceManager();
		placeManager.fireCurrentPlace();
		Element startView = DOM.getElementById("contentWrapper");
		DOM.removeChild(DOM.getParent(startView), startView); 
		GWT.log("application start up finish");
	}

	
	
}

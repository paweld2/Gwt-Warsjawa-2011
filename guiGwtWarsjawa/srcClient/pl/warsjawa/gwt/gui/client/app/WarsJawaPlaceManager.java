package pl.warsjawa.gwt.gui.client.app;

import com.google.inject.Inject;

import pl.warsjawa.gwt.gui.client.app.place.MainPlace;
import eu.caimandesign.gwt.lib.presenter.client.EventBus;
import eu.caimandesign.gwt.lib.presenter.client.place.DefaultPlaceManager;
import eu.caimandesign.gwt.lib.presenter.client.place.TokenFormatter;

public class WarsJawaPlaceManager extends DefaultPlaceManager {

	@Inject
	public WarsJawaPlaceManager(EventBus eventBus, TokenFormatter tokenFormatter,MainPlace mainPlace) {
		super(eventBus, tokenFormatter,mainPlace);
	}

}

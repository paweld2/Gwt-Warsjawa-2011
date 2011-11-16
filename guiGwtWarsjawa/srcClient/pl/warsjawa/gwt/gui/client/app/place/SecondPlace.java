package pl.warsjawa.gwt.gui.client.app.place;

import pl.warsjawa.gwt.gui.client.app.presenter.SecondPresenter;

import com.google.inject.Inject;
import com.google.inject.Provider;

import eu.caimandesign.gwt.lib.presenter.client.place.PlaceRequest;
import eu.caimandesign.gwt.lib.presenter.client.place.PresenterPlace;

public class SecondPlace extends PresenterPlace<SecondPresenter> {

	@Inject
	private Provider<SecondPresenter> presenterProvider;
	
	private final static String placeName = "secondplace";
	
	@Override
	public SecondPresenter getPresenter() {
		return presenterProvider.get();
	}

	@Override
	protected void preparePresenter(PlaceRequest request,
			SecondPresenter presenter) {
		// tutaj ustawiamy status dla presentera.
	}

	@Override
	protected PlaceRequest prepareRequest(PlaceRequest request,
			SecondPresenter presenter) {
		// podczas zmian w historii, tutaj pobieramy informacji o statusie presentera
		return request;
	}

	@Override
	public String getName() {
		return placeName;
	}

}

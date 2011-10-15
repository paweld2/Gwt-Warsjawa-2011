package pl.warsjawa.gwt.gui.client.app.place;

import pl.warsjawa.gwt.gui.client.app.presenter.MainPresenter;

import com.google.inject.Inject;
import com.google.inject.Provider;

import eu.caimandesign.gwt.lib.presenter.client.place.PlaceRequest;
import eu.caimandesign.gwt.lib.presenter.client.place.PresenterPlace;

public class MainPlace extends PresenterPlace<MainPresenter> {

	@Inject
	private Provider<MainPresenter> presenterProvider;
	
	private final static String placeName = "mainplace";
	
	@Override
	public MainPresenter getPresenter() {
		return presenterProvider.get();
	}

	@Override
	protected void preparePresenter(PlaceRequest request,
			MainPresenter presenter) {
		// tutaj ustawiamy status dla presentera.
	}

	@Override
	protected PlaceRequest prepareRequest(PlaceRequest request,
			MainPresenter presenter) {
		// podczas zmian w historii, tutaj pobieramy informacji o statusie presentera
		return request;
	}

	@Override
	public String getName() {
		return placeName;
	}

}

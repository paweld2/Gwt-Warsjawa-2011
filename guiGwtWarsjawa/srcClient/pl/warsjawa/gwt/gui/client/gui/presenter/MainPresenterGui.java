package pl.warsjawa.gwt.gui.client.gui.presenter;

import pl.warsjawa.gwt.gui.client.app.display.MainDisplay;
import pl.warsjawa.gwt.gui.client.app.place.SecondPlace;
import pl.warsjawa.gwt.gui.client.app.presenter.MainPresenter;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.inject.Inject;

import eu.caimandesign.gwt.lib.presenter.client.EventBus;
import eu.caimandesign.gwt.lib.presenter.client.gxtdisplay.DisplayEvent;
import eu.caimandesign.gwt.lib.presenter.client.gxtdisplay.DisplayHandler;
import eu.caimandesign.gwt.lib.presenter.client.place.PlaceRequestEvent;
import eu.caimandesign.gwt.lib.presenter.client.widget.WidgetPresenter;

public class MainPresenterGui extends WidgetPresenter<MainDisplay> implements MainPresenter {

	@Inject
	private SecondPlace secondPlace;
	
	private class LocalBisnessLogicHandler implements DisplayHandler {

		@Override
		public void onDisplayEvent(DisplayEvent event) {
			PlaceRequestEvent.fire(eventBus, secondPlace.createRequest());
		}
		
	}
	
	@Inject
	public MainPresenterGui(MainDisplay display, EventBus eventBus) {
		super(display, eventBus);
	}

	@Override
	protected void onBind() {
		// 1. wlaczenie do akcji presentera
		GWT.log("wlaczenie do akcji presentera");
		// 2. bind to display events using command abstraction. On unbind handlers are unregistered
		registerDisplayHandler(display.getDisplayAbstractionControl(), new LocalBisnessLogicHandler());
	}

	@Override
	protected void onRevealDisplay() {
		// 2. wyswietl sie
		GWT.log("onRevealDisplay");
		RootPanel.get().clear();
		RootPanel.get().add(getDisplay().asWidget());
	}

	
	@Override
	protected void onUnBind() {
		// 3. wylaczenie presentera
		GWT.log("wylaczenie presentera");
	}


}

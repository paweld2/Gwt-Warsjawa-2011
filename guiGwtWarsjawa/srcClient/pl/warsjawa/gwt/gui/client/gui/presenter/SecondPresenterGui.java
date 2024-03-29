package pl.warsjawa.gwt.gui.client.gui.presenter;

import pl.warsjawa.gwt.gui.client.app.display.SecondDisplay;
import pl.warsjawa.gwt.gui.client.app.presenter.SecondPresenter;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.inject.Inject;

import eu.caimandesign.gwt.lib.presenter.client.EventBus;
import eu.caimandesign.gwt.lib.presenter.client.widget.WidgetPresenter;

public class SecondPresenterGui extends WidgetPresenter<SecondDisplay> implements SecondPresenter {

	@Inject
	public SecondPresenterGui(SecondDisplay display, EventBus eventBus) {
		super(display, eventBus);
	}

	@Override
	protected void onBind() {
		// 1. wlaczenie do akcji presentera
		GWT.log("wlaczenie do akcji presentera");
	}

	@Override
	protected void onRevealDisplay() {
		// 2. wyswietl sie
		GWT.log("wyswietl sie");
		RootPanel.get().clear();
		RootPanel.get().add(getDisplay().asWidget());
	}

	
	@Override
	protected void onUnBind() {
		// 3. wylaczenie presentera
		GWT.log("wylaczenie presentera");
	}


}

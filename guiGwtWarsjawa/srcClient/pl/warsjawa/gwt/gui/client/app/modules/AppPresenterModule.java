package pl.warsjawa.gwt.gui.client.app.modules;

import pl.warsjawa.gwt.gui.client.app.display.MainDisplay;
import pl.warsjawa.gwt.gui.client.app.presenter.MainPresenter;
import pl.warsjawa.gwt.gui.client.gui.display.MainDisplayGui;
import pl.warsjawa.gwt.gui.client.gui.presenter.MainPresenterGui;
import eu.caimandesign.gwt.lib.presenter.client.gin.AbstractPresenterModule;

public class AppPresenterModule extends AbstractPresenterModule {

	@Override
	protected void configure() {
		bindPresenter(MainPresenter.class, MainPresenterGui.class, MainDisplay.class, MainDisplayGui.class);
	}

}

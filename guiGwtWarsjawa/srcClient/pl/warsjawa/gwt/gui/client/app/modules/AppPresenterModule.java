package pl.warsjawa.gwt.gui.client.app.modules;

import pl.warsjawa.gwt.gui.client.app.display.MainDisplay;
import pl.warsjawa.gwt.gui.client.app.display.SecondDisplay;
import pl.warsjawa.gwt.gui.client.app.presenter.MainPresenter;
import pl.warsjawa.gwt.gui.client.app.presenter.SecondPresenter;
import pl.warsjawa.gwt.gui.client.gui.display.MainDisplayGui;
import pl.warsjawa.gwt.gui.client.gui.display.SecondDisplayUiBinderWidget;
import pl.warsjawa.gwt.gui.client.gui.presenter.MainPresenterGui;
import pl.warsjawa.gwt.gui.client.gui.presenter.SecondPresenterGui;
import eu.caimandesign.gwt.lib.presenter.client.gin.AbstractPresenterModule;

public class AppPresenterModule extends AbstractPresenterModule {

	@Override
	protected void configure() {
		bindPresenter(MainPresenter.class, MainPresenterGui.class, MainDisplay.class, MainDisplayGui.class);
		bindPresenter(SecondPresenter.class, SecondPresenterGui.class, SecondDisplay.class, SecondDisplayUiBinderWidget.class);
		
	}

}

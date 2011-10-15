package pl.warsjawa.gwt.gui.client.app;

import net.customware.gwt.dispatch.client.DispatchAsync;
import pl.warsjawa.gwt.gui.client.app.modules.AppPresenterModule;
import pl.warsjawa.gwt.gui.client.app.modules.AppSetupModule;

import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;

import eu.caimandesign.gwt.lib.presenter.client.place.PlaceManager;

@GinModules({AppSetupModule.class, AppPresenterModule.class})
public interface WarsJawaGuiInjector extends Ginjector {
	public PlaceManager getPlaceManager();
	public DispatchAsync getDispatcher();
}

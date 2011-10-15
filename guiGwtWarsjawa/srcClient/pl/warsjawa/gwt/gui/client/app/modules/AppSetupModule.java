package pl.warsjawa.gwt.gui.client.app.modules;

import net.customware.gwt.dispatch.client.gin.StandardDispatchModule;
import pl.warsjawa.gwt.gui.client.app.WarsJawaPlaceManager;

import com.google.gwt.inject.client.AbstractGinModule;
import com.google.inject.Singleton;

import eu.caimandesign.gwt.lib.presenter.client.DefaultEventBus;
import eu.caimandesign.gwt.lib.presenter.client.EventBus;
import eu.caimandesign.gwt.lib.presenter.client.place.ParameterTokenFormatter;
import eu.caimandesign.gwt.lib.presenter.client.place.PlaceManager;
import eu.caimandesign.gwt.lib.presenter.client.place.TokenFormatter;

public class AppSetupModule extends AbstractGinModule {

	@Override
	protected void configure() {
		bind(PlaceManager.class).to(WarsJawaPlaceManager.class).in(Singleton.class);
		bind(EventBus.class).to(DefaultEventBus.class).in(Singleton.class);
		bind(TokenFormatter.class).to(ParameterTokenFormatter.class);
		install(new StandardDispatchModule());
		
		//TODO dodac sprawdzenie sesji
//		bind(SecureSessionAccessor.class).to(TODOCreateSessionAccessor.class).asEagerSingleton();

	}

}

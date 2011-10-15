package eu.caimandesign.gwt.lib.presenter.client;

public interface PresenterObserver {

	void changed(Presenter<?> p);

	void revealed(Presenter<?> p);

}

package eu.caimandesign.gwt.lib.presenter.client;

public interface Presenter<D extends Display> {

	void bind(PresenterObserver... observers);

	boolean isBound();

	void unbind();

	String getStatus();

	void setStatus(String status);

	D getDisplay();

	void revealDisplay();
}

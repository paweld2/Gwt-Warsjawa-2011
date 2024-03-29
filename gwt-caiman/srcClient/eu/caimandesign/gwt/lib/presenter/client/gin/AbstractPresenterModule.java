package eu.caimandesign.gwt.lib.presenter.client.gin;

import static com.google.inject.name.Names.named;

import com.google.gwt.inject.client.AbstractGinModule;
import com.google.gwt.inject.client.binder.GinLinkedBindingBuilder;
import com.google.inject.Singleton;

import eu.caimandesign.gwt.lib.presenter.client.Display;
import eu.caimandesign.gwt.lib.presenter.client.Presenter;

public abstract class AbstractPresenterModule extends AbstractGinModule {

	public AbstractPresenterModule() {
		super();
	}

	/**
	 * Convenience method for binding a presenter as well as it's display.
	 * 
	 * @param <D>
	 *            The display type.
	 * @param presenter
	 *            The presenter interface.
	 * @param presenterImpl
	 *            The presenter implementation.
	 * @param display
	 *            The display type.
	 * @param displayImpl
	 *            The display implementation.
	 */

	protected <D extends Display, P extends Presenter<D>> void bindPresenter( Class<P> presenter, Class<? extends P> presenterImpl, Class<D> display, Class<? extends D> displayImpl) {
    	bind(presenter).to(presenterImpl).in(Singleton.class);
    	bindDisplay(display, displayImpl);
    }

	/**
	 * Convenience method for binding a display implementation.
	 * 
	 * @param <D>
	 *            The display interface type
	 * @param display
	 *            The display interface
	 * @param displayImpl
	 *            The display implementation
	 */
	protected <D extends Display> void bindDisplay(Class<D> display,
			Class<? extends D> displayImpl) {
		bind(display).to(displayImpl);
	}

	/**
	 * Convenience method for binding a type to a
	 * {@link com.google.inject.name.Named} attribute. Use it something like
	 * this:
	 * <p/>
	 * 
	 * <pre>
	 * bindNamed(MyType.class, &quot;Foo&quot;).to(MyImplementation.class);
	 * </pre>
	 * 
	 * @param <T>
	 *            The type.
	 * @param type
	 *            The type.
	 * @param named
	 *            The string to name with.
	 * @return the binding builder.
	 */
	protected <T> GinLinkedBindingBuilder<T> bindNamed(Class<T> type,
			String named) {
		return bind(type).annotatedWith(named(named));
	}

}
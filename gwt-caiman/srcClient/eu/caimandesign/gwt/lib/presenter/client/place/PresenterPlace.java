package eu.caimandesign.gwt.lib.presenter.client.place;

import eu.caimandesign.gwt.lib.presenter.client.Presenter;
import eu.caimandesign.gwt.lib.presenter.client.PresenterObserver;
import eu.caimandesign.gwt.lib.presenter.client.widget.WidgetPresenter;

/**
 * This is a subclass of {@link Place} with some helper values for working with
 * {@link Presenter}s.
 *
 * @author David Peterson
 */
public abstract class PresenterPlace<T extends Presenter<?>> extends Place implements PresenterObserver {

	
    public PresenterPlace() {
    }

    
    
    @Override
	public void changed(Presenter<?> p) {
    	PlaceChangedEvent.fire(eventBus, this);
	}



	@Override
	public void revealed(Presenter<?> p) {
		PlaceRevealedEvent.fire(eventBus, this);
	}



	public abstract T getPresenter();

    /**
     * Calls the {@link Presenter#revealDisplay()} method for the place's
     * presenter.
     */
    @Override
    public void reveal() {
        getPresenter().revealDisplay();
    }

    /**
     * Reveals the display. Subclasses should override this method to perform
     * any custom handling.
     */
    @Override
    protected boolean handleRequest( PlaceRequest request ) {
        T presenter = getPresenter();
        preparePresenter( request, presenter );
        presenter.revealDisplay();
        return true;
    }

    /**
     * This method is called on matching place requests before the presenter is
     * revealed. Subclasses can perform any calls to the presenter to prepare it
     * for display based on the request.
     *
     * @param request   The request.
     * @param presenter The presenter.
     */
    protected abstract void preparePresenter( PlaceRequest request, T presenter );

    @Override
    protected PlaceRequest prepareRequest( PlaceRequest request ) {
        return prepareRequest( request, getPresenter() );
    }

    /**
     * This method is called when creating a {@link PlaceRequest} for this
     * place. It should add any state to the request as defined by the current
     * presenter.
     * <p/>
     * <p/>
     * If nothing is to be done, simply return the <code>request</code>
     * unchanged. Otherwise, call {@link PlaceRequest#with(String, String)} to
     * add parameters. Eg:
     * <p/>
     * <pre>
     * return request.with( &quot;id&quot;, presenter.getId() );
     * </pre>
     *
     * @param request   The current request.
     * @param presenter The presenter.
     * @return The prepared place request.
     */
    protected abstract PlaceRequest prepareRequest( PlaceRequest request, T presenter );

    public static WidgetPresenter<?> getWidgetPresenter( Place place ) {
        Presenter<?> presenter = getPresenter( place );
        if ( presenter instanceof WidgetPresenter<?> )
            return (WidgetPresenter<?>) presenter;
        else
            return null;
    }

    /**
     * Returns the {@link Presenter} for the provided {@link Place} if the place
     * is an instance of {@link PresenterPlace} and the contained
     * {@link Presenter} is an instance of the <code>presenterClass</code>.
     * If not, <code>null</code> is returned.
     *
     * @param place The place.
     * @return The {@link Presenter}, if appropriate.
     */
    public static Presenter<?> getPresenter( Place place ) {
        if ( place instanceof PresenterPlace<?> ) {
            return ( (PresenterPlace<?>) place ).getPresenter();
        }
        return null;
    }
    
    @Override
    public void stopWork() {
    	Presenter<?> presenter = getPresenter();
    	presenter.unbind();
    }



}

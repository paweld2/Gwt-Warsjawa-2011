package eu.caimandesign.gwt.lib.presenter.client.place;

import java.util.HashMap;
import java.util.Map;

import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.History;

import eu.caimandesign.gwt.lib.presenter.client.EventBus;

public abstract class DefaultPlaceManager implements PlaceManager {
    private class PlaceEventHandler implements ValueChangeHandler<String>, PlaceRevealedHandler,
        PlaceChangedHandler {
    	
    	private Place currentActive = null;

        public void onPlaceRevealed( PlaceRevealedEvent event ) {
            Place newplace = event.getPlace();
            if( currentActive != null && ! currentActive.equals(newplace)) {
            	currentActive.stopWork();
            }
            currentActive = newplace;
			updateHistory( newplace );
        }

        public void onPlaceChanged( PlaceChangedEvent event ) {
            Place place = event.getPlace();
            try {
                if ( place.matchesRequest( tokenFormatter.toPlaceRequest( History.getToken() ) ) ) {
                    // Only update if the change comes from a place that matches
                    // the current location.
                    updateHistory( event.getPlace() );
                }
            } catch ( TokenFormatException e ) {
                // Do nothing...
            }
        }

        /**
         * Handles change events from {@link History}.
         */
        public void onValueChange( ValueChangeEvent<String> event ) {
            try {
                PlaceRequestEvent.fire( eventBus, tokenFormatter.toPlaceRequest( event.getValue() ), true );
            } catch ( TokenFormatException e ) {
                e.printStackTrace();
            }
        }

    }

    private final EventBus eventBus;

    private final TokenFormatter tokenFormatter;

    private final Map<Class<? extends Place>, Place> placeMap;
    
    private final Place defaultPlace;

    public DefaultPlaceManager( EventBus eventBus, TokenFormatter tokenFormatter ) {
        this( eventBus, tokenFormatter, (Place[]) null );
    }

    public DefaultPlaceManager( EventBus eventBus, TokenFormatter tokenFormatter, Place... places ) {
        this.eventBus = eventBus;
        this.tokenFormatter = tokenFormatter;

        PlaceEventHandler handler = new PlaceEventHandler();

        // Register ourselves with the History API.
        History.addValueChangeHandler( handler );

        // Listen for manual place change events.
        eventBus.addHandler( PlaceChangedEvent.getType(), handler );

        // Listen for place revelation requests.
        eventBus.addHandler( PlaceRevealedEvent.getType(), handler );

        placeMap = new HashMap<Class<? extends Place>, Place>();

        if ( places != null ) {
        	defaultPlace = places[0];
            for ( Place place : places ) {
                registerPlace( place );
            }
        } else {
        	defaultPlace = null;
        }
    }

    public boolean registerPlace( Place place ) {
        if ( !placeMap.containsKey( place.getClass() ) ) {
            place.addHandlers( eventBus );
            placeMap.put( place.getClass(), place );
            return true;
        }
        return false;
    }

    public boolean deregisterPlace( Place place ) {
        if ( !placeMap.containsKey( place.getClass() ) ) {
            place.removeHandlers( eventBus );
            placeMap.remove( place.getClass() );
            return true;
        }
        return false;
    }

    private void updateHistory( Place place ) {
        updateHistory( place.createRequest() );
    }

    // Updates History if it has changed, without firing another
    // 'ValueChangeEvent'.
    private void updateHistory( PlaceRequest request ) {
        try {
            String requestToken = tokenFormatter.toHistoryToken( request );
            String historyToken = History.getToken();
            if ( historyToken == null || !historyToken.equals( requestToken ) )
                History.newItem( requestToken, false );
        } catch ( TokenFormatException e ) {
            // Do nothing.
        }
    }

    /**
     * Fires a {@link PlaceRequestEvent} with the current history token, if
     * present. If no history token is set, <code>false</code> is returned.
     *
     * @return <code>true</code>
     */
    public boolean fireCurrentPlace() {
		String current = History.getToken();
        if ( current != null && current.trim().length() > 0 ) {
            History.fireCurrentHistoryState();
            return true;
        } else {
        	if( defaultPlace != null) {
        		PlaceRequestEvent.fire(eventBus, defaultPlace.createRequest());
        		return true;
        	}
        }
        return false;
    }
}

package net.customware.gwt.dispatch.shared;

public class UnsupportedActionException extends ActionException {

    /**
	 * 
	 */
	private static final long serialVersionUID = -7802287268855088614L;

	/**
     * For serialization.
     */
    UnsupportedActionException() {
    }
    
    @SuppressWarnings({"unchecked"})
    public UnsupportedActionException( Action<? extends Result> action ) {
        this( ( Class<? extends Action<? extends Result>> ) action.getClass() );
    }

    public UnsupportedActionException( Class<? extends Action<? extends Result>> actionClass ) {
        super( "No handler is registered for " + actionClass.getName() );
    }

}

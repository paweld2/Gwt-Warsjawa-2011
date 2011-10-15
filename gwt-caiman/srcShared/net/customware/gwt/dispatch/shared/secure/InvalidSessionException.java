package net.customware.gwt.dispatch.shared.secure;

import net.customware.gwt.dispatch.shared.ServiceException;

public class InvalidSessionException extends ServiceException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1734070914665457902L;

	public InvalidSessionException() {
        super();
    }

    public InvalidSessionException( String message ) {
        super( message );
    }
}

package eu.caimandesign.gwt.lib.presenter.client.place;

public class TokenFormatException extends RuntimeException {

	private static final long serialVersionUID = -5875697179798167871L;

	public TokenFormatException() {
    }

    public TokenFormatException( String message ) {
        super( message );
    }

    public TokenFormatException( Throwable cause ) {
        super( cause );
    }

    public TokenFormatException( String message, Throwable cause ) {
        super( message, cause );
    }

}

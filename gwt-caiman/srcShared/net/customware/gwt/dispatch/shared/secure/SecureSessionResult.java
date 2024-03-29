package net.customware.gwt.dispatch.shared.secure;

import net.customware.gwt.dispatch.shared.Result;

/**
 * Contains a valid secure session id. Any {@link net.customware.gwt.dispatch.shared.Action}
 * which returns this result will automatically have the specified session id updated as the
 * current session id.
 * <p/>
 * <p/>
 * The {@link SimpleAuthenticationAction} class is an example of this, but more
 * complex authentication requests could be created if required. Simply create a
 * new action that has this class as its Result type. Eg:
 * <p/>
 * <pre>
 * public class MyAuthenticationAction extends Action&lt;SecureSessionResult&gt; {
 *     private String domain;
 * <p/>
 *     private String username;
 * <p/>
 *     private String rsaToken;
 *     ///....
 * }
 * </pre>
 * <p/>
 * <p/>
 * Then, create a handler on the server side, register it and
 *
 * @author David Peterson
 * @see SimpleAuthenticationAction
 */
public class SecureSessionResult implements Result {
    /**
	 * 
	 */
	private static final long serialVersionUID = -7490702463745900754L;
	private String sessionId;

    SecureSessionResult() {
    }

    public SecureSessionResult( String sessionId ) {
        this.sessionId = sessionId;
    }

    public String getSessionId() {
        return sessionId;
    }
}

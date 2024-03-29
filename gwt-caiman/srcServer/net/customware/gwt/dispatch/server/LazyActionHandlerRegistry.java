package net.customware.gwt.dispatch.server;

import java.util.Map;

import net.customware.gwt.dispatch.shared.Action;
import net.customware.gwt.dispatch.shared.Result;

/**
 * This is a lazy-loading implementation of the registry. It will only create
 * action handlers when they are first used. All {@link ActionHandler}
 * implementations <b>must</b> have a public, default constructor.
 * 
 * @author David Peterson
 */
public class LazyActionHandlerRegistry implements ClassActionHandlerRegistry {

    private final Map<Class<? extends Action<?>>, Class<? extends ActionHandler<?, ?>>> handlerClasses;

    private final Map<Class<? extends Action<?>>, ActionHandler<?, ?>> handlers;

    public LazyActionHandlerRegistry() {
        handlerClasses = new java.util.HashMap<Class<? extends Action<?>>, Class<? extends ActionHandler<?, ?>>>(
                100 );
        handlers = new java.util.HashMap<Class<? extends Action<?>>, ActionHandler<?, ?>>( 100 );
    }

    public <A extends Action<R>, R extends Result> void addHandlerClass( Class<A> actionClass,
            Class<? extends ActionHandler<A, R>> handlerClass ) {
        handlerClasses.put( actionClass, handlerClass );
    }

    public <A extends Action<R>, R extends Result> void removeHandlerClass( Class<A> actionClass,
            Class<? extends ActionHandler<A, R>> handlerClass ) {
        Class<? extends ActionHandler<?, ?>> oldHandlerClass = handlerClasses.get( actionClass );
        if ( oldHandlerClass == handlerClass ) {
            handlerClasses.remove( actionClass );
            handlers.remove( actionClass );
        }
    }

    @SuppressWarnings("unchecked")
	public <A extends Action<R>, R extends Result> ActionHandler<A, R> findHandler( A action ) {
        ActionHandler<?, ?> handler = handlers.get( action.getClass() );
        if ( handler == null ) {
            Class<? extends ActionHandler<?, ?>> handlerClass = handlerClasses.get( action.getClass() );
            if ( handlerClass != null ) {
                handler = createInstance( handlerClass );
                if ( handler != null )
                    handlers.put( handler.getActionType(), handler );
            }
        }

        return ( net.customware.gwt.dispatch.server.ActionHandler<A, R> ) handler;
    }

    protected ActionHandler<?, ?> createInstance( Class<? extends ActionHandler<?, ?>> handlerClass ) {
        try {
            return handlerClass.newInstance();
        } catch ( InstantiationException e ) {
            e.printStackTrace();
        } catch ( IllegalAccessException e ) {
            e.printStackTrace();
        }
        return null;
    }

    public void clearHandlers() {
        handlers.clear();
    }

}

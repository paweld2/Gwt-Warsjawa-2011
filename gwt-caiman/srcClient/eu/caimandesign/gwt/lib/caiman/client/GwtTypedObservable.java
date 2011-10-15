package eu.caimandesign.gwt.lib.caiman.client;

import java.util.Vector;

public abstract class GwtTypedObservable<O,S> {
	
	protected abstract void realizeNotification(S source, O observer, int type);
	
	private boolean changed = false;
	private Vector<O> obs;
	public GwtTypedObservable() {
		obs = new Vector<O>();
	}
	
	public synchronized void addObserver(O o) {
		if (o == null)
			throw new NullPointerException();
		if (!obs.contains(o)) {
			obs.addElement(o);
		}
	}
	public synchronized void deleteObserver(O o) {
		obs.removeElement(o);
	}
	
	public void notifyObservers(int type) {
		notifyObservers(null,type);
	}
	
	@SuppressWarnings("unchecked")
	public void notifyObservers(S arg,int type) {
		Object[] arrLocal;

		synchronized (this) {

			if (!changed)
				return;
			arrLocal = obs.toArray();
			clearChanged();
		}

		for (int i = arrLocal.length - 1; i >= 0; i--)
			realizeNotification(arg, (O) arrLocal[i], type);
	}

	public synchronized void deleteObservers() {
		obs.removeAllElements();
	}

	protected synchronized void setChanged() {
		changed = true;
	}

	protected synchronized void clearChanged() {
		changed = false;
	}

	public synchronized boolean hasChanged() {
		return changed;
	}


	public synchronized int countObservers() {
		return obs.size();
	}
}

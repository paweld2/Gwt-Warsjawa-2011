package pl.warsjawa.gwt.gui.service;

import java.util.Date;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface GodzinaServiceAsync {

	void getCurrentDate(AsyncCallback<Date> result);
	
}

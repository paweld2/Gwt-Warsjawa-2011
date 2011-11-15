package pl.warsjawa.gwt.gui.service;

import java.util.Date;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class GodzinaServiceImpl extends RemoteServiceServlet implements
		GodzinaService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public Date getCurrentDate() {
		return new Date();
	}

}

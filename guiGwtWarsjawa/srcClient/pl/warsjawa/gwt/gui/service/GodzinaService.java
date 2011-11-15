package pl.warsjawa.gwt.gui.service;

import java.util.Date;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("godzina")
public interface GodzinaService extends RemoteService {
	Date getCurrentDate();
}

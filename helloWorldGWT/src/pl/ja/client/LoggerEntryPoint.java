package pl.ja.client;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.gwt.core.client.EntryPoint;

public class LoggerEntryPoint implements EntryPoint {

	public static final Logger logger = Logger.getLogger("NameOfYourLogger");

	public void onModuleLoad() {
		logger.log(Level.SEVERE, "LoggerEntryPoint running");
		testFirefoxLogging();
	}

	private void testFirefoxLogging() {
		logger.log(Level.SEVERE, "SEVERE loggin on firefox");
		logger.log(Level.INFO, "INFO loggin on firefox");
		logger.log(Level.WARNING, "WARNING loggin on firefox");
		logger.log(Level.CONFIG, "CONFIG loggin on firefox");
	}

}

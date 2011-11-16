package pl.warsjawa.gwt.gui.client.app.display;

import eu.caimandesign.gwt.lib.presenter.client.gxtdisplay.HasDisplayEventHandlers;
import eu.caimandesign.gwt.lib.presenter.client.widget.WidgetDisplay;

public interface MainDisplay extends WidgetDisplay {

	/**
	 * Events from display are abstract to HasDisplayEventHandlers.
	 * 
	 * This allows to create Display implementations without any Browser dependency
	 * 
	 * @return
	 */
	public HasDisplayEventHandlers getDisplayAbstractionControl();
}

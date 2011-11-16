package pl.warsjawa.gwt.gui.client.gui.display;

import pl.warsjawa.gwt.gui.client.app.display.MainDisplay;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

import eu.caimandesign.gwt.lib.presenter.client.gxtdisplay.DisplayCommandFromGxt;
import eu.caimandesign.gwt.lib.presenter.client.gxtdisplay.HasDisplayEventHandlers;

public class MainDisplayGui implements MainDisplay {

	private final Panel panel;
	
	private final DisplayCommandFromGxt command;
	
	@Inject
	public MainDisplayGui() {
		super();
		panel = new FlowPanel();
		command = new DisplayCommandFromGxt();
		init();
	}
	
	private void init() {
		GWT.log("creating MainDisplayGui");
		final Button sendButton = new Button("Go to second Place");
		sendButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				command.fire();
			}
		});
		panel.add(sendButton);
	}

	public Widget asWidget() {
		return panel;
	}
	
	@Override
	public HasDisplayEventHandlers getDisplayAbstractionControl() {
		return command;
	}

}

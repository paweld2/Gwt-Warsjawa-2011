package pl.warsjawa.gwt.gui.client.gui.display;

import pl.warsjawa.gwt.gui.client.app.display.MainDisplay;
import pl.warsjawa.gwt.gui.client.app.place.MainPlace;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

import eu.caimandesign.gwt.lib.presenter.client.EventBus;
import eu.caimandesign.gwt.lib.presenter.client.place.PlaceRequestEvent;

public class MainDisplayGui implements MainDisplay {

	private final Panel panel;
	
	@Inject
	public MainDisplayGui() {
		super();
		panel = new FlowPanel();
		init();
	}
	
	@Inject
	private MainPlace placeToChange;
	
	@Inject
	private EventBus bus;

	private void init() {
		GWT.log("creating MainDisplayGui");
		final Button sendButton = new Button("Send");
		
		sendButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				PlaceRequestEvent.fire(bus, placeToChange.createRequest());
			}
		});
		final TextBox nameField = new TextBox();
		nameField.setText("GWT User");
		final Label errorLabel = new Label();
		panel.add(sendButton);
		panel.add(nameField);
		panel.add(errorLabel);
		
	}

	public Widget asWidget() {
		return panel;
	}

}

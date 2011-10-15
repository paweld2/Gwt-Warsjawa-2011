package pl.warsjawa.gwt.gui.client.gui.display;

import pl.warsjawa.gwt.gui.client.app.display.MainDisplay;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

public class MainDisplayGui implements MainDisplay {

	private final Panel panel;
	
	@Inject
	public MainDisplayGui() {
		super();
		panel = new FlowPanel();
		init();
	}

	private void init() {
		GWT.log("creating MainDisplayGui");
		final Button sendButton = new Button("Send");
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

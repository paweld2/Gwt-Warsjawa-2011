package pl.warsjawa.gwt.gui.client.gui.display;

import pl.warsjawa.gwt.gui.client.app.display.SecondDisplay;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

import eu.caimandesign.gwt.lib.presenter.client.gxtdisplay.DisplayCommandFromGxt;
import eu.caimandesign.gwt.lib.presenter.client.gxtdisplay.HasDisplayEventHandlers;

public class SecondDisplayUiBinderWidget extends Composite implements SecondDisplay {

	private static SecondDisplayUiBinderWidgetUiBinder uiBinder = GWT
			.create(SecondDisplayUiBinderWidgetUiBinder.class);

	interface SecondDisplayUiBinderWidgetUiBinder extends
			UiBinder<Widget, SecondDisplayUiBinderWidget> {
	}
	
	private final DisplayCommandFromGxt changePlaceCommand;

	public SecondDisplayUiBinderWidget() {
		changePlaceCommand = new DisplayCommandFromGxt();
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiField
	Button button;

	@UiHandler("button")
	void onClick(ClickEvent e) {
		Window.alert("Hello!");
		changePlaceCommand.fire();
	}
	
	@Override
	public Widget asWidget() {
		// w tym przypadku implementacja asWidget juz jest wyzej
		return super.asWidget();
	}
	
	@Override
	public HasDisplayEventHandlers getChangePlaceCommand() {
		return changePlaceCommand;
	}
	
 
}

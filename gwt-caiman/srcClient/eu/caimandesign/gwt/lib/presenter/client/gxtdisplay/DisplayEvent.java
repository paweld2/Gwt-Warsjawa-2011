package eu.caimandesign.gwt.lib.presenter.client.gxtdisplay;

import com.google.gwt.event.shared.GwtEvent;

public class DisplayEvent extends GwtEvent<DisplayHandler> {

	public static final Type<DisplayHandler> TYPE = new Type<DisplayHandler>();

	private final String data;
	private final Integer intData;

	public DisplayEvent(String data) {
		super();
		this.data = data;
		this.intData = null;
	}

	public DisplayEvent(Integer data) {
		super();
		this.data = null;
		this.intData = data;
	}

	@Override
	protected void dispatch(DisplayHandler handler) {
		handler.onDisplayEvent(this);
	}

	@Override
	public Type<DisplayHandler> getAssociatedType() {
		return TYPE;
	}

	public String getData() {
		return data;
	}

	public Integer getIntdata() {
		return intData;
	}

}

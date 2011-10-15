package eu.caimandesign.gwt.lib.presenter.client.widget;


import com.google.gwt.user.client.ui.Widget;

import eu.caimandesign.gwt.lib.presenter.client.Display;

public interface WidgetDisplay extends Display {
    /**
     * Returns the display as a GWT {@link Widget}. This may be the same
     * Display instance, or another object completely.
     * 
     * @return The widget.
     */
    Widget asWidget();
}

package eu.caimandesign.gwt.lib.presenter.client.widget;

import eu.caimandesign.gwt.lib.presenter.client.BasicPresenter;
import eu.caimandesign.gwt.lib.presenter.client.EventBus;

public abstract class WidgetPresenter<D extends WidgetDisplay> extends BasicPresenter<D> implements PresenterWidget<D>{
    public WidgetPresenter( D display, EventBus eventBus ) {
        super( display, eventBus );
    }
}

package gwt.scene.core.client.beans.value;

import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;

import gwt.scene.core.client.beans.InvalidationEvent;
import gwt.scene.core.client.beans.InvalidationHandler;

public abstract class AbstractObservableValue<T> implements ObservableValue<T> {

	private HandlerManager handlerManager;

	private HandlerManager ensureHandlers() {
		return handlerManager == null ? handlerManager = createHandlerManager() : handlerManager;
	}

	private HandlerManager createHandlerManager() {
		return new HandlerManager(this);
	}

	@Override
	public HandlerRegistration addValueChangeHandler(ValueChangeHandler<T> handler) {
		return ensureHandlers().addHandler(ValueChangeEvent.getType(), handler);
	}

	@Override
	public HandlerRegistration addInvalidationHandler(InvalidationHandler handler) {
		return ensureHandlers().addHandler(InvalidationEvent.getType(), handler);
	}

	@Override
	public void fireEvent(GwtEvent<?> event) {
		if (handlerManager != null) {
			handlerManager.fireEvent(event);
		}
	}
}

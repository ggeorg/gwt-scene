package gwt.scene.core.client.beans;

import com.google.gwt.event.shared.GwtEvent;

public class InvalidationEvent extends GwtEvent<InvalidationHandler> {

	private static Type<InvalidationHandler> TYPE;

	public static void fire(HasInvalidationHandlers source) {
		if (TYPE != null) {
			InvalidationEvent event = new InvalidationEvent();
			source.fireEvent(event);
		}
	}

	public static Type<InvalidationHandler> getType() {
		if (TYPE == null) {
			TYPE = new Type<InvalidationHandler>();
		}
		return TYPE;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Type<InvalidationHandler> getAssociatedType() {
		return (Type) TYPE;
	}

	@Override
	protected void dispatch(InvalidationHandler handler) {
		handler.onInvalidated(this);
	}

}

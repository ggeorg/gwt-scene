package gwt.scene.core.client.beans;

import com.google.gwt.event.shared.EventHandler;

public interface InvalidationHandler extends EventHandler {

	void onInvalidated(InvalidationEvent event);
}

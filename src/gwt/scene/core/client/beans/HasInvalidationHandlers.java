package gwt.scene.core.client.beans;

import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;

public interface HasInvalidationHandlers extends HasHandlers {

	HandlerRegistration addInvalidationHandler(InvalidationHandler handler);
}

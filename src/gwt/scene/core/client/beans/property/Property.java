package gwt.scene.core.client.beans.property;

import gwt.scene.core.client.beans.value.ObservableValue;
import gwt.scene.core.client.beans.value.WritableValue;

public interface Property<T> extends ReadOnlyProperty<T>, WritableValue<T> {

	void bind(ObservableValue<? extends T> observable);
	
	void bindBidirectional(Property<T> other);
	
	void unbind();
	
	boolean isBound();
}

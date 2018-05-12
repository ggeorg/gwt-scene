package gwt.scene.core.client.beans.property;

import gwt.scene.core.client.beans.value.ObservableValue;

public interface ReadOnlyProperty<T> extends ObservableValue<T> {

	Object getBean();
	
	String getName();
}

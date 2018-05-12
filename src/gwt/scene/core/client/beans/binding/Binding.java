package gwt.scene.core.client.beans.binding;

import java.util.Set;

import gwt.scene.core.client.beans.Observable;
import gwt.scene.core.client.beans.value.ObservableValue;

public interface Binding<T> extends ObservableValue<T> {

	boolean isValid();
	
	void invalidate();
	
	Set<Observable> getDependencies();
	
	void dispose();
}

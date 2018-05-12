package gwt.scene.core.client.beans.value;

import com.google.gwt.event.logical.shared.HasValueChangeHandlers;

import gwt.scene.core.client.beans.Observable;

public interface ObservableValue<T> extends HasValueChangeHandlers<T>, Observable {

	T getValue();
}

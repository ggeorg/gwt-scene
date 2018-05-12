package gwt.scene.core.client.beans.value;

public interface WritableValue<T> {

	T getValue();
	
	void setValue(T value);
}

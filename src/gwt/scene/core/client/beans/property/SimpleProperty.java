package gwt.scene.core.client.beans.property;

public class SimpleProperty<T> extends AbstractProperty<T> {
	
	private T value;

	@Override
	protected void set(T value) {
		this.value = value;
	}

	@Override
	protected T get() {
		return value;
	}

}

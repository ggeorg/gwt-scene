package gwt.scene.core.client.beans.property;

import com.google.gwt.event.logical.shared.ValueChangeEvent;

import gwt.scene.core.client.beans.InvalidationEvent;
import gwt.scene.core.client.beans.value.AbstractObservableValue;

public abstract class AbstractReadOnlyProperty<T> extends AbstractObservableValue<T> implements ReadOnlyProperty<T> {

	private final Object bean;
	private final String name;

	private boolean valid = true;

	public AbstractReadOnlyProperty() {
		this(null, null);
	}

	public AbstractReadOnlyProperty(Object bean, String name) {
		this.bean = bean;
		this.name = name;
	}

	@Override
	public final T getValue() {
		if (!valid) {
			valid = true;
		}
		return get();
	}

	protected abstract T get();

	@Override
	public Object getBean() {
		return bean;
	}

	@Override
	public String getName() {
		return name;
	}

	public void invalidate() {
		if (valid) {
			valid = false;
			onInvalidating();
			ValueChangeEvent.fire(this, getValue());
			InvalidationEvent.fire(this);
			valid = true;
		}
	}

	protected void onInvalidating() {
		// nothing here
	}

}

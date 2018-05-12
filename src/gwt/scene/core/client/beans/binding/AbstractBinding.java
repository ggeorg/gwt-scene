package gwt.scene.core.client.beans.binding;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.shared.HandlerRegistration;

import gwt.scene.core.client.beans.InvalidationEvent;
import gwt.scene.core.client.beans.InvalidationHandler;
import gwt.scene.core.client.beans.Observable;
import gwt.scene.core.client.beans.value.AbstractObservableValue;

public abstract class AbstractBinding<T> extends AbstractObservableValue<T> implements Binding<T> {

	private T value = null;
	private boolean valid = false;

	private Map<Observable, HandlerRegistration> deps = null;

	@Override
	public Set<Observable> getDependencies() {
		return deps.keySet();
	}

	@Override
	public boolean isValid() {
		return valid;
	}

	@Override
	public final void invalidate() {
		if (valid) {
			valid = false;
			onInvalidating();
			ValueChangeEvent.fire(this, getValue());
			InvalidationEvent.fire(this);
		}
	}

	/**
	 * The method onInvalidating() can be overridden by extending classes to react,
	 * if this binding becomes invalid. The default implementation is empty.
	 */
	protected void onInvalidating() {
	}

	@Override
	public void dispose() {
		// nothing here
	}

	private final InvalidationHandler observer = new InvalidationHandler() {
		@Override
		public void onInvalidated(InvalidationEvent event) {
			invalidate();
		}
	};

	protected final void bind(Observable... dependencies) {
		if (dependencies != null && dependencies.length > 0) {
			if (deps == null) {
				deps = new HashMap<>();
			}

			for (Observable dep : dependencies) {
				deps.put(dep, dep.addInvalidationHandler(observer));
			}
		}
	}

	protected final void unbind() {
		if (deps != null) {
			deps.values().forEach((dep) -> {
				dep.removeHandler();
			});

			deps.clear();
			deps = null;
		}
	}

	@Override
	public final T getValue() {
		if (!valid) {
			value = computeValue();
			valid = true;
		}
		return value;
	}

	protected abstract T computeValue();
}

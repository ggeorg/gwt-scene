package gwt.scene.core.client.beans.property;

import java.util.Objects;

import com.google.gwt.event.shared.HandlerRegistration;

import gwt.scene.core.client.beans.value.ObservableValue;

public abstract class AbstractProperty<T> extends AbstractReadOnlyProperty<T> implements Property<T> {

	private ObservableValue<? extends T> observable = null;
	private HandlerRegistration observableHR = null;

	@Override
	public final void setValue(T value) {
		if (!Objects.equals(get(), value)) {
			set(value);
			invalidate();
		}
	}

	protected abstract void set(T value);

	@Override
	public void bind(final ObservableValue<? extends T> observable) {
		if (observable == null) {
			throw new NullPointerException("Cannot bind to null");
		}

		if (!Objects.equals(this.observable, observable)) {
			unbind();
			this.observable = observable;
			this.observableHR = this.observable.addValueChangeHandler((e) -> {
				setValue(e.getValue());
			});
			setValue(this.observable.getValue());
		}
	}
	
	private Property<T> other;
	
	@Override
	public void bindBidirectional(Property<T> other) {
		this.bind(other);
		this.other = other;
		this.other.bind(this);
	}

	@Override
	public void unbind() {
		if (isBound()) {
			setValue(observable.getValue());
			observableHR.removeHandler();
			observableHR = null;
			observable = null;
			if (this.other != null) {
				this.other.unbind();
				this.other = null;
			}
		}
	}

	@Override
	public boolean isBound() {
		return observableHR != null;
	}

}

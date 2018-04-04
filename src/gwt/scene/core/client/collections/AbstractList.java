package gwt.scene.core.client.collections;

import com.google.gwt.core.client.JavaScriptObject;

public abstract class AbstractList<E> extends JavaScriptObject implements List<E> {

	protected AbstractList() {
	}

	@Override
	public final E get(int index) {
		if (index >= 0 && index < getLength()) {
			return _get(index);
		} else {
			throw new IndexOutOfBoundsException();// TODO message
		}
	}

	public final native E _get(int index) /*-{
		return this[index];
	}-*/;

	@Override
	public final native <T extends List<E>> T push(E element) /*-{
		this.push(element);
		return this;
	}-*/;

	@Override
	public final E update(int index, E element) {
		final E oldValue = get(index);
		_update(index, element);
		return oldValue;
	}

	private final native void _update(int index, E element) /*-{
		this[index] = element;
	}-*/;

	@Override
	public final E remove(int index) {
		final E oldValue = get(index);
		_remove(index);
		return oldValue;
	}

	private final native void _remove(int index) /*-{
		this.splice(index, 1);
	}-*/;

	@Override
	public final native int getLength() /*-{
		return this.length;
	}-*/;

	public final native String toJSON() /*-{
		return JSON.stringify(this);
	}-*/;
}

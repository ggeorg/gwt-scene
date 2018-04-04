package gwt.scene.core.client.collections;

import com.google.gwt.core.client.JavaScriptObject;

public class JsObject extends JavaScriptObject implements Map<String, Object> {

	public static JsObject create() {
		return JavaScriptObject.createObject().cast();
	}

	protected JsObject() {
	}

	@Override
	public final Object get(String key) {
		if (has(key)) {
			return _get(key);
		} else {
			throw new IllegalArgumentException(key + " does not exists.");
		}
	};

	@Override
	public final Object get(String key, Object defaultValue) {
		if (has(key)) {
			return _get(key);
		} else {
			return defaultValue;
		}
	}

	private final native Object _get(String key) /*-{
		return this[key];
	}-*/;

	@SuppressWarnings("unchecked")
	@Override
	public final native JsObject set(String key, Object value) /*-{
		this[key] = value;
		return this;
	}-*/;

	public final native JsObject set(String key, boolean value) /*-{
		this[key] = value;
		return this;
	}-*/;

	public final native JsObject set(String key, char value) /*-{
		this[key] = value;
		return this;
	}-*/;

	public final native JsObject set(String key, byte value) /*-{
		this[key] = value;
		return this;
	}-*/;

	public final native JsObject set(String key, short value) /*-{
		this[key] = value;
		return this;
	}-*/;

	public final native JsObject set(String key, int value) /*-{
		this[key] = value;
		return this;
	}-*/;

	public final native JsObject set(String key, float value) /*-{
		this[key] = value;
		return this;
	}-*/;

	public final native JsObject set(String key, double value) /*-{
		this[key] = value;
		return this;
	}-*/;

	@Override
	public final native Object remove(String key) /*-{
		if (key in this) {
			var oldValue = this[key];
			delete this[key];
			return oldValue;
		}
		return null;
	}-*/;

	@Override
	public final native boolean has(String key) /*-{
		return key in this;
	}-*/;

	public final native String toJSON() /*-{
		return JSON.stringify(this);
	}-*/;
}

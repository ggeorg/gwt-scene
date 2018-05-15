package gwt.scene.core.client.collections;

import com.google.gwt.core.client.JavaScriptObject;

public class JsObject extends JavaScriptObject implements Map<String, Object> {

	public static JsObject create() {
		return JavaScriptObject.createObject().cast();
	}

	protected JsObject() {
	}
	
	// ---------------------------------------------------------------------

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
	
	// ---------------------------------------------------------------------

	public final native boolean get(String key, boolean defaultValue) /*-{
		if (key in this)
			return this[key];
		else
			return defaultValue;
	}-*/;

	public final native char get(String key, char defaultValue) /*-{
		if (key in this)
			return this[key];
		else
			return defaultValue;
	}-*/;

	public final native byte get(String key, byte defaultValue) /*-{
		if (key in this)
			return this[key];
		else
			return defaultValue;
	}-*/;

	public final native JsObject get(String key, short defaultValue) /*-{
		if (key in this)
			return this[key];
		else
			return defaultValue;
	}-*/;

	public final native int get(String key, int defaultValue) /*-{
		if (key in this)
			return this[key];
		else
			return defaultValue;
	}-*/;

	public final native float get(String key, float defaultValue) /*-{
		if (key in this)
			return this[key];
		else
			return defaultValue;
	}-*/;

	public final native double get(String key, double defaultValue) /*-{
		if (key in this)
			return this[key];
		else
			return defaultValue;
	}-*/;
	
	// ---------------------------------------------------------------------

	@SuppressWarnings("unchecked")
	@Override
	public final native JsObject set(String key, Object value) /*-{
		this[key] = value;
		return this;
	}-*/;
	
	// ---------------------------------------------------------------------

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
	
	// ---------------------------------------------------------------------

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
	
	// ---------------------------------------------------------------------

	public final native String toJSON() /*-{
		return JSON.stringify(this);
	}-*/;
}

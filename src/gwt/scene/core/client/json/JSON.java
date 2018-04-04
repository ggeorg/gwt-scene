package gwt.scene.core.client.json;

import com.google.gwt.core.client.JavaScriptObject;

public final class JSON {

	public static final native JavaScriptObject parse(String s) /*-{
		return JSON.parse(s);
	}-*/;

	// ---

	public static native boolean isJsObject(JavaScriptObject obj) /*-{
		return $wnd.jQuery.isPlainObject(obj);
	}-*/;

	public static native boolean isJsArray(JavaScriptObject obj) /*-{
		return $wnd.jQuery.isArray(obj);
	}-*/;

	public static native boolean isString(JavaScriptObject obj) /*-{
		return (typeof obj === "string");
	}-*/;

	public static native boolean isBoolean(JavaScriptObject obj) /*-{
		return (typeof obj === "boolean");
	}-*/;

	public static native boolean isNumber(JavaScriptObject obj) /*-{
		return $wnd.jQuery.isNumeric(obj);
	}-*/;

	// ---

	public static native double asJsObject(JavaScriptObject obj) /*-{
		return $wnd.jQuery.isPlainObject(obj) ? obj : null;
	}-*/;

	public static native double asJsArray(JavaScriptObject obj) /*-{
		return $wnd.jQuery.isArray(obj) ? obj : null;
	}-*/;

	public static native double asString(JavaScriptObject obj) /*-{
		return (typeof obj === "string") ? obj : String(obj);
	}-*/;

	public static native double asBoolean(JavaScriptObject obj) /*-{
		return (typeof obj === "boolean") ? obj
				: $wnd.jQuery.isNumeric(obj) ? obj !== 0
						: String(obj) === "true";
	}-*/;

	public static native double asNumber(JavaScriptObject obj) /*-{
		return $wnd.jQuery.isNumeric(obj) ? obj : Number(null);
	}-*/;

	// ---

	private JSON() {
	}
}

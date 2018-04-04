package gwt.scene.core.client.collections;

import java.util.Comparator;

import com.google.gwt.core.client.JavaScriptObject;

public final class JsArray extends AbstractList<Object> {

	public static final JsArray create() {
		return JavaScriptObject.createArray().cast();
	}
	
//	public static native JsObject cast(JavaScriptObject obj) /*-{
//		return $wnd.jQuery.isArray(obj) ? obj : null;
//	}-*/;

	public static final native JsArray create(JavaScriptObject o) /*-{
		if ($wnd.jQuery.isArray(o))
			return o;
		else
			return [ o ];
	}-*/;

	public static final native JsArray create(JavaScriptObject[] array) /*-{
		return array;
	}-*/;

	public static final native JsArray create(boolean[] array) /*-{
		return array;
	}-*/;

	public static final native JsArray create(char[] array) /*-{
		return array;
	}-*/;

	public static final native JsArray create(byte[] array) /*-{
		return array;
	}-*/;

	public static final native JsArray create(short[] array) /*-{
		return array;
	}-*/;

	public static final native JsArray create(int[] array) /*-{
		return array;
	}-*/;

	public static final native JsArray create(float[] array) /*-{
		return array;
	}-*/;

	public static final native JsArray create(double[] array) /*-{
		return array;
	}-*/;

	protected JsArray() {
	}

	public final native JsArray push(boolean element) /*-{
		this.push(element);
		return this;
	}-*/;

	public final native JsArray push(char element) /*-{
		this.push(element);
		return this;
	}-*/;

	public final native JsArray push(byte element) /*-{
		this.push(element);
		return this;
	}-*/;

	public final native JsArray push(short element) /*-{
		this.push(element);
		return this;
	}-*/;

	public final native JsArray push(int element) /*-{
		this.push(element);
		return this;
	}-*/;

	public final native JsArray push(float element) /*-{
		this.push(element);
		return this;
	}-*/;

	public final native JsArray push(double element) /*-{
		this.push(element);
		return this;
	}-*/;

	public final native <T> void sort(Comparator<T> comparator) /*-{
		this.sort(function(a, b) {
			return comparator.@java.util.Comparator::compare(Ljava/lang/Object;Ljava/lang/Object;)(a, b);
		});
	}-*/;
}

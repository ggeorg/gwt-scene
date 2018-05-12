package gwt.scene.ui.d3.client;

import gwt.scene.core.client.collections.JsArray;

public class D3 {

	// ---------------------------------------------------------------------
	// Array manipulation, ordering, searching, summarizing, etc.
	// ---------------------------------------------------------------------

	public static native JsArray range(int stop) /*-{
		return $wnd.d3.range(stop);
	}-*/;

	public static native JsArray range(int start, int stop) /*-{
		return $wnd.d3.range(start, stop);
	}-*/;

	public static native JsArray range(int start, int stop, double step) /*-{
		return $wnd.d3.range(start, stop);
	}-*/;
}

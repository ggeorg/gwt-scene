package gwt.scene.ui.nvd3.client;

import java.util.function.Function;

import com.google.gwt.core.client.JavaScriptObject;

public class Axis extends JavaScriptObject {

	protected Axis() {
	}

	public final native Axis setLabel(String label) /*-{
		return this.axisLabel(label);
	}-*/;

	// axisLabelDistance

	// domain

	// duration

	// fontSize

	// height

	// margin

	// orient

	// range

	// rangeBand

	// rangeBands

	// rangeLabels

	/**
	 * 
	 * @param format
	 * @return
	 * 
	 * @see https://github.com/d3/d3-format
	 */
	public final native Axis setTickFormat(String format) /*-{
		return this.tickFormat($wnd.d3.format(format));
	}-*/;

	/**
	 * 
	 * @param fcn
	 * @return
	 */
	public final native Axis setTickFormat(Function<Object, String> fcn) /*-{
		return this
				.tickFormat(function(d) {
					return fcn.@java.util.function.Function::apply(Ljava/lang/Object;)(d);
				});
	}-*/;

	/**
	 * 
	 * @param format
	 * @param fcn
	 * @return
	 * 
	 * @see https://github.com/d3/d3-format
	 */
	public final native Axis setTickFormat(String format, Function<String, String> fcn) /*-{
		return this.tickFormat(function(d){
			return fcn.@java.util.function.Function::apply(Ljava/lang/Object;)($wnd.d3.format(format)(d));
		});
	}-*/;

	public final native void showMaxMin(boolean showMaxMin) /*-{
		return this.showMaxMin(showMaxMin);
	}-*/;

	//
}

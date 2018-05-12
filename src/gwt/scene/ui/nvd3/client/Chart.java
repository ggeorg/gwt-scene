package gwt.scene.ui.nvd3.client;

import java.util.function.Supplier;

import com.google.gwt.core.client.JavaScriptObject;

public class Chart extends JavaScriptObject {

	public static native Chart createLineChart() /*-{
		return $wnd.nv.models.lineChart();
	}-*/;

	public static native Chart createDiscreteBarChart() /*-{
		return $wnd.nv.models.discreteBarChart().x(function(d) {
			return d.label
		}).y(function(d) {
			return d.value
		});
	}-*/;
	
	public static native Chart createDiscreteBarChart(Supplier<String> labelSupplier, Supplier<Double> valueSupplier) /*-{
		return $wnd.nv.models.discreteBarChart().x(function(d) {
			return labelSupplier.@java.util.function.Supplier::get();
		}).y(function(d) {
			return valueSupplier.@java.util.function.Supplier::get();
		});
	}-*/;
	
	public static native Chart createHistoricalBarChart() /*-{
		return $wnd.nv.models.historicalBarChart();
	}-*/;
	
	public static native Chart createLinePlusBarChart() /*-{
		return $wnd.nv.models.linePlusBarChart();
	}-*/;

	public static native Chart createMultiBarChart() /*-{
		return $wnd.nv.models.multiBarChart();
	}-*/;

	public static native Chart createScatterChart() /*-{
		return $wnd.nv.models.scatterChart();
	}-*/;

	protected Chart() {
	}

	public final native boolean isShowXAxis() /*-{
		return this.showXAxis();
	}-*/;

	public final native void setShowXAxis(boolean showXAxis) /*-{
		return this.showXAxis();
	}-*/;

	public final native boolean isShowYAxis() /*-{
		return this.showYAxis();
	}-*/;

	public final native void setShowYAxis(boolean showYAxis) /*-{
		return this.showYAxis(showYAxis);
	}-*/;

	public final native Axis getXAxis() /*-{
		return this.xAxis;
	}-*/;

	public final native Axis getX2Axis() /*-{
		return this.x2Axis;
	}-*/;

	public final native Axis getYAxis() /*-{
		return this.yAxis;
	}-*/;

	public final native Axis getY2Axis() /*-{
		return this.y2Axis;
	}-*/;


	public final native void update() /*-{
		this.update();
	}-*/;
}

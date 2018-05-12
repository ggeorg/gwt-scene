package gwt.scene.ui.nvd3.client;

import java.util.function.Supplier;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Element;

public class DiscreteBarChart extends AbstractBarChart {

	public DiscreteBarChart() {
		super(Chart.createDiscreteBarChart());
	}

	public DiscreteBarChart(Supplier<String> labelSupplier, Supplier<Double> valueSupplier) {
		super(Chart.createDiscreteBarChart(labelSupplier, valueSupplier));
	}

	protected native JavaScriptObject initWithChart(Element element, Chart chart) /*-{
		var d3 = $wnd.d3, nv = $wnd.nv;

		var gc = d3.select(element).append('svg');

		nv.addGraph(function() {

			gc.datum([]).call(chart);

			return chart;
		});

		return gc;
	}-*/;

}

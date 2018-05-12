package gwt.scene.ui.nvd3.client;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Element;

public class LinePlusBarChart extends AbstractBarChart {

	public LinePlusBarChart() {
		super(Chart.createLinePlusBarChart());
	}

	@Override
	protected native JavaScriptObject initWithChart(Element element, Chart chart) /*-{
		var d3 = $wnd.d3, nv = $wnd.nv;

		var gc = d3.select(element).append('svg');

		nv.addGraph(function() {

			gc.datum([ {
				values : []
			} ]).call(chart);

			return chart;
		});

		return gc;
	}-*/;
	
	public Axis getX2Axis() {
		return chart.getX2Axis();
	}
	
	public Axis getY2Axis() {
		return chart.getY2Axis();
	}

}

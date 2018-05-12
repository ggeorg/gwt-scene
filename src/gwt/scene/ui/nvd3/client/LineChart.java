package gwt.scene.ui.nvd3.client;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Element;

public class LineChart extends AbstractChart {

	public LineChart() {
		super(Chart.createLineChart());
	}

	@Override
	protected native JavaScriptObject initWithChart(Element element, Chart chart) /*-{
		var d3 = $wnd.d3, nv = $wnd.nv;

	    var gc = d3.select(element)
	        	.append('svg');

	    nv.addGraph(function() {
	        chart.options({
	                duration: 0,
	                useInteractiveGuideline: true
	            });
	            
	        // chart sub-models (ie. xAxis, yAxis, etc) when accessed directly, return themselves, not the parent chart, so need to chain separately
	        chart.xAxis
	            .axisLabel("Time (s)")
	            .tickFormat(d3.format(',.1f'))
	            .staggerLabels(true)
	        ;
	        chart.yAxis
	            .axisLabel('Voltage (v)')
	            .tickFormat(function(d) {
	                if (d == null) {
	                    return 'N/A';
	                }
	                return d3.format(',.2f')(d);
	            })
	        ;
	        
	        gc.datum([]).call(chart);
	        
	        return chart;
	    });

		return gc;
		
	}-*/;

}

package gwt.scene.ui.nvd3.client;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.RequiresResize;

import gwt.scene.core.client.collections.JsArray;
import gwt.scene.ui.client._Widget;

public abstract class AbstractChart extends _Widget implements RequiresResize {

	protected final Chart chart;
	protected final JavaScriptObject gc;

	protected AbstractChart(Chart chart) {
		super(Document.get().createDivElement());
		this.chart = chart;
		gc = initWithChart(getElement(), chart);
	}

	protected abstract JavaScriptObject initWithChart(Element element, Chart chart);
	
	public Axis getXAxis() {
		return chart.getXAxis();
	}
	
	public Axis getYAxis() {
		return chart.getYAxis();
	}

	@Override
	public void onResize() {
		chart.update();
	}
	
	public void setData(JsArray data) {
		setData(gc, chart, data);
	}

	private static native void setData(JavaScriptObject gc, Chart chart, JsArray data) /*-{
		var d3 = $wnd.d3, nv = $wnd.nv;
		//gc.selectAll("*").remove();
		
		console.log(data);

		nv.addGraph(function() {
			gc.datum(data).call(chart);
			return chart;
		}, function() {
			//console.log('done');
		});

	}-*/;

}

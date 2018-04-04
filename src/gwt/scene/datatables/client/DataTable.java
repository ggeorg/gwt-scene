package gwt.scene.datatables.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Element;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

import gwt.scene.core.client.collections.JsObject;

public class DataTable extends Composite {

	private static DataTableUiBinder uiBinder = GWT.create(DataTableUiBinder.class);

	interface DataTableUiBinder extends UiBinder<Widget, DataTable> {
	}

	private final DataTableOptions options;

	private JavaScriptObject dataTable = null;

	public DataTable() {
		this(null);
	}

	public DataTable(DataTableOptions options) {
		this.options = options;
		initWidget(uiBinder.createAndBindUi(this));
	}

	@Override
	protected void onLoad() {
		if (dataTable == null) {
			dataTable = initDataTable(getElement(), options);
		}
	}

	private static native JavaScriptObject initDataTable(Element element, JsObject options) /*-{
		return $wnd.jQuery('table', element).DataTable(options);
	}-*/;

	@Override
	protected void onUnload() {

	}

	//
	// DataTable Core API
	//

	public DataTable clear() {
		if (dataTable != null) {
			clear(dataTable);
		}
		return this;
	}

	private static native void clear(JavaScriptObject dataTable) /*-{
		console.log("clear", dataTable);
		dataTable.clear();
	}-*/;

	public DataTable draw() {
		if (dataTable != null) {
			draw(dataTable);
		}
		return this;
	}

	// paging: {@code full-rest}, {@code full-hold}, or {@code page}.
	public DataTable draw(String paging) {
		if (dataTable != null) {
			draw(dataTable);
		}
		return this;
	}

	private static native void draw(JavaScriptObject dataTable) /*-{
		dataTable.draw();
	}-*/;
}

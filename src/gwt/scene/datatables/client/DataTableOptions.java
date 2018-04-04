package gwt.scene.datatables.client;

import gwt.scene.core.client.collections.JsArray;
import gwt.scene.core.client.collections.JsObject;

public class DataTableOptions extends JsObject {
	
	public static DataTableOptions create() {
		return JsObject.create().cast();
	}

	public static DataTableOptions create(DataTableColumn[] columns) {
		DataTableOptions options = DataTableOptions.create().cast();
		options.set("columns", JsArray.create(columns));
		return options;
	}
	
	protected DataTableOptions() {
	}
	
	//
	// DataTables Features
	//
	
	public final boolean ispaging() {
		return (boolean) get("paging");
	}
	
	public final DataTableOptions setPaging(boolean paging) {
		return (DataTableOptions) set("paging", paging);
	}
	
	public final boolean isScrollX() {
		return (boolean) get("scrollX");
	}
	
	public final DataTableOptions setscrollX(boolean scrollY) {
		return (DataTableOptions) set("scrollX", scrollY);
	}
	
	public final String getScrollY() {
		return (String) get("scrollY");
	}
	
	public final DataTableOptions setscrollY(String scrollY) {
		return (DataTableOptions) set("scrollY", scrollY);
	}
	
	
	public final DataTableColumnList getColumns() {
		return (DataTableColumnList) get("columns");
	}
	
	public final DataTableOptions setColumns(DataTableColumnList columns) {
		return (DataTableOptions) set("columns", columns);
	}
	
	public final JsArray getData() {
		return (JsArray) get("data");
	}
	
	public final DataTableOptions setData(JsObject data) {
		return (DataTableOptions) set("data", data);
	}
	
	public final DataTableOptions setscroller(boolean scroller) {
		return (DataTableOptions) set("scroller", scroller);
	}
}

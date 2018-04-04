package gwt.scene.ui.slickgrid.client;

import gwt.scene.core.client.collections.JsObject;

public interface TableColumnFormatter<T> {
	String format(int row, int cell, T value, TableColumn columnDef, JsObject dataContext);
}

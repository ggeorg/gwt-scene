package gwt.scene.ui.slickgrid.client;

import com.google.gwt.core.client.JavaScriptObject;

import gwt.scene.core.client.collections.AbstractList;

public final class TableColumnList extends AbstractList<TableColumn> {

	public static final TableColumnList create() {
		return JavaScriptObject.createArray().cast();
	}
	
	protected TableColumnList() {}
}

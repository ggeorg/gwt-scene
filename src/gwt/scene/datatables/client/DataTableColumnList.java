package gwt.scene.datatables.client;

import com.google.gwt.core.client.JavaScriptObject;

import gwt.scene.core.client.collections.AbstractList;

public final class DataTableColumnList extends AbstractList<DataTableColumn> {

	public static final DataTableColumnList create() {
		return JavaScriptObject.createArray().cast();
	}

	protected DataTableColumnList() {
	}

}

package gwt.scene.ui.slickgrid.client;

import com.google.gwt.core.client.JavaScriptObject;

import gwt.scene.core.client.collections.JsObject;

public class TableColumn extends JsObject {

	public static TableColumn create() {
		return JsObject.create().cast();
	}

	protected TableColumn() {
	}

	// asyncPostRender

	// behavior

	// cannotTriggerInsert

	// cssClass

	public final String getCssClass() {
		return (String) get("cssClass");
	}

	public final TableColumn setCssClass(String cssClass) {
		return set("cssClass", cssClass).cast();
	}

	// defaultSortAsc

	public final boolean isDefaultSortAsc() {
		return (boolean) get("defaultSortAsc");
	}

	public final TableColumn setDefaultSortAsc(boolean defaultSortAsc) {
		return set("defaultSortAsc", defaultSortAsc).cast();
	}

	// editor

	public final TableCellEditor getEditor() {
		return (TableCellEditor) get("editor");
	}

	public final TableColumn setEditor(TableCellEditor editor) {
		return set("editor", editor).cast();
	}

	// field: String

	public final String getField() {
		return (String) get("field");
	}

	public final TableColumn setField(String field) {
		return set("field", field).cast();
	}

	// focusable: boolean

	public final boolean isFocusable() {
		return (boolean) get("focusable");
	}

	public final TableColumn setFocusable(boolean focusable) {
		return set("focusable", focusable).cast();
	}

	// formatter: function

	@SuppressWarnings("unchecked")
	public final <T> TableColumnFormatter<T> getFormatter() {
		JsObject jsFormatter = (JsObject) get("formatter", null);
		return jsFormatter != null ? (TableColumnFormatter<T>) jsFormatter.get("__java_formatter") : null;
	}

	public final <T> TableColumn setFormatter(TableColumnFormatter<T> formatter) {
		return (TableColumn) set("formatter", toJsFormatter(formatter));
	}

	private final native <T> JavaScriptObject toJsFormatter(TableColumnFormatter<T> formatter) /*-{
		var jsFormatter = function(row, cell, value, columnDef, dataContext) {
			return formatter.@org.webfx.ui.slickgrid.client.TableColumnFormatter::format(IILjava/lang/Object;Lorg/webfx/ui/slickgrid/client/TableColumn;Lorg/webfx/core/client/collections/JsObject;)(row, cell, value, columnDef, dataContext);
		};

		jsFormatter.__java_formatter = formatter;

		return jsFormatter;
	}-*/;

	// headerCssClass

	public final String getHeaderCssClass() {
		return (String) get("headerCssClass");
	}

	public final TableColumn setHeaderCssClass(String headerCssClass) {
		return set("headerCssClass", headerCssClass).cast();
	}

	// id: String

	public final String getId() {
		return (String) get("id");
	}

	public final TableColumn setId(String id) {
		return set("id", id).cast();
	}

	// maxWidth

	public final int getMaxWidth() {
		return (int) get("maxWidth");
	}

	public final TableColumn setMaxWidth(int maxWidth) {
		return set("maxWidth", maxWidth).cast();
	}

	// minWidth: default(30)

	public final int getMinWidth() {
		return (int) get("minWidth");
	}

	public final TableColumn setMinWidth(int minWidth) {
		return set("minWidth", minWidth).cast();
	}

	// name: String

	public final String getName() {
		return (String) get("name");
	}

	public final TableColumn setName(String name) {
		return set("name", name).cast();
	}

	// rendererOnResize

	public final boolean isRendererOnResize() {
		return (boolean) get("rendererOnResize");
	}

	public final TableColumn setRendererOnResize(boolean rendererOnResize) {
		return set("rendererOnResize", rendererOnResize).cast();
	}

	// resizable: boolean

	public final boolean isResizable() {
		return (boolean) get("resizable");
	}

	public final TableColumn setResizable(boolean resizable) {
		return set("resizable", resizable).cast();
	}

	// selectable: boolean

	public final boolean isSelectable() {
		return (boolean) get("selectable");
	}

	public final TableColumn setSelectable(boolean selectable) {
		return set("selectable", selectable).cast();
	}

	// sortable: boolean

	public final boolean isSortable() {
		return (boolean) get("sortable");
	}

	public final TableColumn setSortable(boolean sortable) {
		return set("sortable", sortable).cast();
	}

	// toolTip

	public final String getToolTip() {
		return (String) get("toolTip");
	}

	public final TableColumn setToolTip(String toolTip) {
		return set("toolTip", toolTip).cast();
	}

	// width

	public final int getWidth() {
		return (int) get("width");
	}

	public final TableColumn setWidth(int width) {
		return set("width", width).cast();
	}
}

package gwt.scene.ui.slickgrid.client;

import gwt.scene.core.client.collections.JsObject;

public class TableOptions extends JsObject {
	
	public static TableOptions create() {
		return JsObject.create().cast();
	}

	protected TableOptions() {}
	
	// asyncEditorLoading: boolean

	public final boolean isAsyncEditorLoading() {
		return (boolean) get("asyncEditorLoading");
	}

	public final TableOptions setAsyncEditorLoading(boolean asyncEditorLoading) {
		return set("asyncEditorLoading", asyncEditorLoading).cast();
	}
	
	// asyncEditorLoadDelay
	
	// asyncPostRenderDelay
	
	// autoEdit: boolean
	
	// autoHeight: boolean - this disables vertical scrolling
	
	// cellFlashingCssClass: String
	
	// cellHighlightCssClass: String
	
	// dataItemColumnValueExtractor
	
	// defaultColumnWidth: default(80)
	
	// defaultFormatter
	
	// editable: boolean

	public final boolean isEditable() {
		return (boolean) get("editable");
	}

	public final TableOptions setEditable(boolean editable) {
		return set("editable", editable).cast();
	}
	
	// editCommandHandler
	
	// editorFactory
	
	// editorLock
	
	// enableAddRow
	
	// enableAsyncPostRender
	
	// enableCellRangeSelection
	
	// enableCellNavigation
	
	// enableColumnReorder

	public final boolean isEnableColumnReorder() {
		return (boolean) get("enableColumnReorder");
	}

	public final TableOptions setEnableColumnReorder(boolean enableColumnReorder) {
		return set("enableColumnReorder", enableColumnReorder).cast();
	}
	
	// enableRowReordering
	
	// enableTextSelectionOnCells
	
	// explicitInitialization
	
	// forceFitColumns
	
	// forceSyncScrolling
	
	// formatterFactory
	
	// fullWidthRows
	
	// headerRowHeight
	
	// leaveSpaceForNewRows
	
	// multiColumnSort
	
	// multiSelect
	
	// rowHeight
	
	// selectedCellCssClass
	
	// showHeaderRow
	
	// syncColumnCellResize
	
	// topPanelHeight
}

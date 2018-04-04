package gwt.scene.ui.slickgrid.client;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HasHandlers;

import gwt.scene.core.client.collections.JsObject;

public class TableSortEvent extends GwtEvent<TableSortEvent.Handler> {

	public static interface Handler extends EventHandler {
		void onSort(TableSortEvent event);
	}

	private static Type<Handler> TYPE;

	public static TableSortEvent fire(HasHandlers source, JsObject nativeEvent) {
		TableSortEvent event = new TableSortEvent(nativeEvent);
		if (TYPE != null) {
			source.fireEvent(event);
		}
		return event;
	}

	public static Type<Handler> getType() {
		if (TYPE == null) {
			TYPE = new Type<Handler>();
		}
		return TYPE;
	}

	private final JsObject nativeEvent;

	protected TableSortEvent(JsObject nativeEvent) {
		this.nativeEvent = nativeEvent;
	}

	@Override
	public Type<Handler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(Handler handler) {
		handler.onSort(this);
	}

	public JsObject getNativeEvent() {
		return nativeEvent;
	}

	public boolean isMultiColumnSort() {
		return (boolean) nativeEvent.get("multiColumnSort");
	}

	public TableColumn getSortCol() {
		return (TableColumn) nativeEvent.get("sortCol", null);
	}

	public TableColumnList getSortCols() {
		return (TableColumnList) nativeEvent.get("sortCols", null);
	}

	public boolean isSortAsc() {
		return (boolean) nativeEvent.get("sortAsc");
	}
}

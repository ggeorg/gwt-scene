package gwt.scene.ui.slickgrid.client;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.RequiresResize;

import gwt.scene.core.client.collections.JsArray;
import gwt.scene.core.client.collections.JsObject;
import gwt.scene.ui.client.Widget;

public class TableView extends Widget implements RequiresResize {

	private JavaScriptObject grid = null;

	private JsArray data;
	private TableColumnList columns;
	private TableOptions options;

	private HandlerRegistration onSortHR = null;

	public TableView() {
		this(JsArray.create(), TableColumnList.create(), TableOptions.create());
	}

	public TableView(TableColumnList columns, TableOptions options) {
		this(JsArray.create(), columns, options);
	}

	public TableView(JsArray data, TableColumnList columns, TableOptions options) {
		super(Document.get().createDivElement());
		this.data = data;
		this.columns = columns;
		this.options = options;
	}

	@Override
	protected void onLoad() {
		grid = initTableView(getElement(), data, columns, options);

		Scheduler.get().scheduleDeferred(new ScheduledCommand() {
			@Override
			public void execute() {
				onResize();
			}
		});

		onSortHR = onSort(this, grid, new OnSortHandler() {
			@Override
			public void onSort(JavaScriptObject nativeEvent) {
				TableSortEvent.fire(TableView.this, nativeEvent.cast());
			}
		});
	}

	@Override
	protected void onUnload() {
		if (grid != null) {
			// grid.destroy();

			if (onSortHR == null) {
				onSortHR.removeHandler();
			}
		}
	}

	private static native JavaScriptObject initTableView(Element element, JsArray data, TableColumnList columns,
			TableOptions options) /*-{
				
		var grid = new $wnd.Slick.Grid(element, data, columns, options);
	
		console.log($wnd.Slick.Editors);
		
		return grid;
	}-*/;

	@Override
	public void onResize() {
		resizeCanvas();
		autosizeColumns();
	}

	// ---------------------------------------------------------------------
	// Core
	// ---------------------------------------------------------------------

	/**
	 * 
	 * @return an array of every data object.
	 */
	public JsArray getData() {
		if (grid != null) {
			return getData(grid);
		} else {
			return data;
		}
	}

	private static native JsArray getData(JavaScriptObject grid) /*-{
		return grid.getData();
	}-*/;

	/**
	 * Sets a new source for databinding and removes all rendered rows.
	 * <p>
	 * Note that this doesn't render the new rows; you can follow it with a call to
	 * {@link #render} to do that.
	 * 
	 * @param data
	 *            New databinding source.
	 */
	public void setData(JsArray data) {
		if (grid != null) {
			setData(grid, data, true);
		} else {
			this.data = data;
		}
	}

	/**
	 * Sets a new source for databinding and removes all rendered rows.
	 * <p>
	 * Note that this doesn't render the new rows; you can follow it with a call to
	 * {@link #render} to do that.
	 * 
	 * @param data
	 *            New databinding source.
	 * @param scrollToTop
	 *            If {@code true}, the table will reset the vertical scroll position
	 *            to the top of the table.
	 */
	public void setData(JsArray data, boolean scrollToTop) {
		if (grid != null) {
			setData(grid, data, scrollToTop);
		} else {
			this.data = data;
		}
	}

	private static native void setData(JavaScriptObject grid, JsArray data, boolean scrollToTop) /*-{
		grid.setData(data, scrollToTop);
	}-*/;

	/**
	 * 
	 * @param index
	 *            Item index.
	 * @return the databinding item at a given position.
	 */
	public JsObject getDataItem(int index) {
		if (grid != null) {
			return getDataItem(grid, index);
		} else {
			return (JsObject) data.get(index);
		}
	}

	private static native JsObject getDataItem(JavaScriptObject grid, int index) /*-{
		return grid.getDataItem(index);
	}-*/;

	/**
	 * 
	 * @return the size of the databinding source.
	 */
	public int getDataLength() {
		if (grid != null) {
			return getDataLength(grid);
		} else {
			return data.getLength();
		}
	}

	private static native int getDataLength(JavaScriptObject grid) /*-{
		return grid.getDataLength();
	}-*/;

	/**
	 * 
	 * @return an object containing all of the table options set.
	 */
	public TableOptions getOptions() {
		if (grid != null) {
			return getOptions(grid);
		} else {
			return options;
		}
	}

	private static native TableOptions getOptions(JavaScriptObject grid) /*-{
		return grid.getOptions();
	}-*/;

	/**
	 * Extends grid options with a given hash. If there is an active edit, the grid
	 * will attempt to commit the changes and only continue if the attempt succeeds.
	 * 
	 * @param options
	 *            An object with configuration options.
	 */
	public void setOptions(TableOptions options) {
		if (grid != null) {
			setOptions(grid, options);
		} else {
			this.options = options;
		}
	}

	private static native void setOptions(JavaScriptObject grid, TableOptions options) /*-{
		grid.setOptions(options);
	}-*/;

	// ---------------------------------------------------------------------
	// Columns
	// ---------------------------------------------------------------------

	/**
	 * Proportionately resizes all columns to fill available horizontal space. This
	 * does not take the cell contents into consideration.
	 */
	public void autosizeColumns() {
		if (grid != null) {
			autosizeColumns(grid);
		}
	}

	private static native void autosizeColumns(JavaScriptObject grid) /*-{
		grid.autosizeColumns();
	}-*/;

	// grid.getColumnIndex

	/**
	 * 
	 * @return an array of column definitions, containing the option settings for
	 *         each individual column.
	 */
	public TableColumnList getColumns() {
		if (grid != null) {
			return getColumns(grid);
		} else {
			return columns;
		}
	}

	private static native TableColumnList getColumns(JavaScriptObject grid) /*-{
		return grid.getColumns();
	}-*/;

	/**
	 * Sets table columns.
	 * <p>
	 * Column headers will be recreated and all rendering rows will be removed. To
	 * re-render the table (if necessary), call {@link #render}.
	 * 
	 * @param columns
	 *            An array of column definitions.
	 */
	public void setColumns(TableColumnList columns) {
		if (grid != null) {
			setColumns(grid, columns);
		} else {
			this.columns = columns;
		}
	}

	private static native void setColumns(JavaScriptObject grid, TableColumnList columns) /*-{
		grid.setColumns(columns);
	}-*/;

	// ---------------------------------------------------------------------
	// Cells
	// ---------------------------------------------------------------------

	// ---------------------------------------------------------------------
	// Rendering
	// ---------------------------------------------------------------------

	/**
	 * Redraws the grid. Invalidates all rows and calls {@link #render()}.
	 */
	public void invalidate() {
		if (grid != null) {
			invalidate(grid);
		}
	}

	private static native void invalidate(JavaScriptObject grid) /*-{
		grid.invalidate();
	}-*/;

	/**
	 * Re-renders rows in the DOM.
	 */
	public void render() {
		if (grid != null) {
			render(grid);
		}
	}

	private static native void render(JavaScriptObject grid) /*-{
		grid.render();
	}-*/;

	/**
	 * Resizes the canvas to fit the current container.
	 */
	public void resizeCanvas() {
		if (grid != null) {
			resizeCanvas(grid);
		}
	}

	private static native void resizeCanvas(JavaScriptObject grid) /*-{
		grid.resizeCanvas();
	}-*/;

	// ---------------------------------------------------------------------
	// Headers
	// ---------------------------------------------------------------------

	// ---------------------------------------------------------------------
	// Events
	// ---------------------------------------------------------------------

	// onScroll

	// onSort

	private HandlerRegistration tableSortHR = null;

	public void setTableSortHandler(TableSortEvent.Handler handler) {
		if (tableSortHR != null) {
			tableSortHR.removeHandler();
			tableSortHR = null;
		}
		tableSortHR = addHandler(handler, TableSortEvent.getType());
	}

	// ---------------------------------------------------------------------

	public static interface OnSortHandler {
		void onSort(JavaScriptObject nativeEvent);
	}

	private static native TableHandlerRegistration onSort(TableView source, JavaScriptObject grid,
			OnSortHandler handler) /*-{
		var fcn = function(e, data) {
			handler.@org.webfx.ui.slickgrid.client.TableView.OnSortHandler::onSort(Lcom/google/gwt/core/client/JavaScriptObject;)(data);
		};

		grid.onSort.subscribe(fcn);

		return {
			remove : function() {
				alert('remove');
				grid.onSort.unsubscribe(fcn);
			}
		};
	}-*/;

	static class TableHandlerRegistration extends JavaScriptObject implements HandlerRegistration {
		protected TableHandlerRegistration() {}

		@Override
		public final native void removeHandler() /*-{
			this.remove();
		}-*/;
	}
}

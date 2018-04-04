package gwt.scene.showcase.client;

import com.google.gwt.core.client.Callback;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.RootPanel;

import gwt.scene.core.client.ModuleLoader;
import gwt.scene.core.client.collections.JsArray;
import gwt.scene.core.client.collections.JsObject;
import gwt.scene.datatables.client.DataTable;
import gwt.scene.datatables.client.DataTableColumn;
import gwt.scene.datatables.client.DataTableColumnList;
import gwt.scene.datatables.client.DataTableOptions;
import gwt.scene.ui.client.Button;

public class Showcase2 implements EntryPoint, Callback<Void, Exception> {

	public void onModuleLoad() {
		ModuleLoader.require(this, "DataTables");
	}
	
	// ---

	@Override
	public void onFailure(Exception reason) {
		Window.alert(reason.getMessage());
	}

	@Override
	public void onSuccess(Void result) {
		DataTableOptions options = DataTableOptions.create()
				.setscrollX(true)
				.setscrollY("100%")
				.setPaging(false)
				.setColumns(DataTableColumnList.create()
						.push(DataTableColumn.create("name", "Name"))
						.push(DataTableColumn.create("position", "Position")))
				.setData(JsArray.create()
						.push(JsObject.create()
								.set("name", "Tiger Nixon")
								.set("position", "System Architect")));

		DataTable dataTable = new DataTable(options);
		RootPanel.get().add(dataTable);

		// ---

		RootPanel.get().add(new Button("Refresh", new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				dataTable.clear()
						.draw();
			}
		}));
	}
}

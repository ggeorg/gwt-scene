package gwt.scene.showcase.client;

import java.util.Comparator;

import com.google.gwt.core.client.Callback;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.logical.shared.ResizeEvent;
import com.google.gwt.event.logical.shared.ResizeHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.RootPanel;

import gwt.scene.core.client.ModuleLoader;
import gwt.scene.core.client.collections.JsArray;
import gwt.scene.core.client.collections.JsObject;
import gwt.scene.core.client.json.JSON;
import gwt.scene.ui.client.HBox;
import gwt.scene.ui.slickgrid.client.TableCellEditor;
import gwt.scene.ui.slickgrid.client.TableColumn;
import gwt.scene.ui.slickgrid.client.TableColumnFormatter;
import gwt.scene.ui.slickgrid.client.TableColumnList;
import gwt.scene.ui.slickgrid.client.TableOptions;
import gwt.scene.ui.slickgrid.client.TableSortEvent;
import gwt.scene.ui.slickgrid.client.TableView;

public class Showcase_TableView implements EntryPoint, Callback<Void, Exception> {

	public void onModuleLoad() {
		ModuleLoader.require(this, "UI", "SlickGrid");
	}

	@Override
	public void onSuccess(Void result) {
		
		GWT.log(""+JSON.asBoolean(JSON.parse("0")));
		
		HBox box = new HBox();
		box.setHeight("100%");

		TableColumnList columns = TableColumnList.create()
				.push(TableColumn.create()
						.setId("title")
						.setName("Title")
						.setField("title")
						.setFormatter(new TableColumnFormatter<String>() {
							@Override
							public String format(int row, int cell, String value, TableColumn columnDef, JsObject dataContext) {
								return value;
							}
						})
						.setEditor(TableCellEditor.getTextEditor())
						.setToolTip("The title")
						.setSortable(true))
				.push(TableColumn.create()
						.setId("duration")
						.setName("Duration")
						.setField("duration"))
				.push(TableColumn.create()
						.setId("%")
						.setName("% Complete")
						.setField("percentComplete"))
				.push(TableColumn.create()
						.setId("start")
						.setName("Start")
						.setField("start")
						.setEditor(TableCellEditor.getDateEditor()))
				.push(TableColumn.create()
						.setId("finish")
						.setName("Finish")
						.setField("finish"))
				.push(TableColumn.create()
						.setId("effort-driven")
						.setName("Effort Driven")
						.setField("effortDriven"));

		TableOptions options = TableOptions.create()
				.setEnableColumnReorder(true)
				.setEditable(true);

		JsArray data = JsArray.create();
		for (int i = 0; i < 500; i++) {
			data.push(JsObject.create()
					.set("title", "Task " + i)
					.set("duration", ((int) (2 + Math.random() * 10)) + " days")
					.set("percentComplete", Math.round(Math.random() * 100))
					.set("start", "01/01/2018")
					.set("finish", "01/05/2018")
					.set("effortDriven", (i % 5 == 0)));
		}

		TableView table = new TableView(data, columns, options);
		table.setTableSortHandler(new TableSortEvent.Handler() {
			@Override
			public void onSort(TableSortEvent event) {
				TableView tableView = (TableView) event.getSource();

				tableView.getData().sort(new Comparator<JsObject>() {
					@Override
					public int compare(JsObject o1, JsObject o2) {
						String s1 = o1.get(event.getSortCol().getField(), null).toString();
						String s2 = o2.get(event.getSortCol().getField(), null).toString();
						return s1.compareTo(s2) * (event.isSortAsc() ? 1 : -1);
					}
				});

				tableView.invalidate();
			}
		});
		table.setFlex("1");
		box.add(table);

		RootPanel.get().add(box);

		Window.addResizeHandler(new ResizeHandler() {
			@Override
			public void onResize(ResizeEvent event) {
				box.onResize();
			}
		});
	}

	@Override
	public void onFailure(Exception reason) {
		Window.alert(reason.getMessage());
	}
}

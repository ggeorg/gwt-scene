package gwt.scene.datatables.client;

import gwt.scene.core.client.collections.JsObject;

public class DataTableColumn extends JsObject {

	public static DataTableColumn create(String data, String title) {
		return JsObject.create()
				.set("data", data)
				.set("title", title).cast();
	}

	public static DataTableColumn create(String data, String title, String width) {
		return JsObject.create()
				.set("data", data)
				.set("title", title)
				.set("width", width).cast();
	}

	protected DataTableColumn() {
	}
	
	// TODO columnDefs
	
	// TODO cellType
	
	public final String getClassName() {
		return (String) get("className");
	}
	
	public final void setClassName(String className) {
		set("className", className);
	}
	
	// TODO contentPadding
	
	// TODO createdCell

	public final String getData() {
		return (String) get("data");
	}

	public final void setData(String data) {
		set("data", data);
	}
	
	public final String getDefaultContent() {
		return (String) get("defaultContent");
	}
	
	public final void setDefaultContent(String defaultContent) {
		set("defaultContent", defaultContent);
	}
	
	public final String getName() {
		return (String) get("name");
	}
	
	public final void setName(String name) {
		set("name", name);
	}

	public final boolean isOrderable() {
		return (boolean) get("orderable");
	}
	
	public final void setOrderable(boolean orderable) {
		set("orderable", orderable);
	}

	// TODO orderData

	// TODO orderDataType

	// TODO render

	public final boolean isSearchable() {
		return (boolean) get("searchable");
	}

	public final void setSearchable(boolean searchable) {
		set("searchable", searchable);
	}

	public final String getTitle() {
		return (String) get("title");
	}

	public final void setTitle(String name) {
		set("title", name);
	}

	public final String getType() {
		return (String) get("type");
	}

	public final void setType(String type) {
		set("type", type);
	}

	public final boolean isVisible() {
		return (boolean) get("visible");
	}

	public final void setVisible(boolean visible) {
		set("visible", visible);
	}

	public final String getWidth() {
		return (String) get("width");
	}

	public final void setWidth(String width) {
		set("width", width);
	}
}

package gwt.scene.ui.slickgrid.client;

import com.google.gwt.core.client.JavaScriptObject;

public class TableCellEditor extends JavaScriptObject {

	public static final native TableCellEditor getTextEditor() /*-{
		return $wnd.Slick.Editors.Text;
	}-*/;

	public static final native TableCellEditor getIntegerEditor() /*-{
		return $wnd.Slick.Editors.Integer;
	}-*/;

	public static final native TableCellEditor getFloatEditor() /*-{
		return $wnd.Slick.Editors.Float;
	}-*/;

	public static final native TableCellEditor getDateEditor() /*-{
		return $wnd.Slick.Editors.Date;
	}-*/;

	public static final native TableCellEditor getYesNoSelectEditor() /*-{
		return $wnd.Slick.Editors.YesNoSelect;
	}-*/;

	public static final native TableCellEditor getCheckboxEditor() /*-{
		return $wnd.Slick.Editors.Checkbox;
	}-*/;

	public static final native TableCellEditor getPercentCompleteEditor() /*-{
		return $wnd.Slick.Editors.Checkbox;
	}-*/;

	public static final native TableCellEditor getLongTextEditor() /*-{
		return $wnd.Slick.Editors.LongText;
	}-*/;

	protected TableCellEditor() {
	}
}

package gwt.scene.ui.client;

import java.util.Objects;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.InputElement;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;

public class Datepicker extends Widget {

	private static DatepickerUiBinder uiBinder = GWT.create(DatepickerUiBinder.class);

	interface DatepickerUiBinder extends UiBinder<DivElement, Datepicker> {
	}

	@UiField
	InputElement input;
	
	private JavaScriptObject datepicker;

	public Datepicker() {
		setElement(uiBinder.createAndBindUi(this));
	}

	protected void onLoad() {
		datepicker= initDatepicker(getElement());
	}

	private native JavaScriptObject initDatepicker(Element element) /*-{
		return console.log($wnd.jQuery(element).datepicker());
	}-*/;

	protected void onUnload() {
		
	}
	
	//@Override
	public String getId() {
		return input.getId();
	}

	//@Override
	public void setId(String id) {
		String oldId = getId();
		if (!Objects.equals(oldId, id)) {
			input.setId(id);
		}
	}
}

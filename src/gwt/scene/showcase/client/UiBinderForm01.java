package gwt.scene.showcase.client;

import java.util.Date;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;

import gwt.scene.ui.client._Composite;
import gwt.scene.ui.client.DatetimePicker;
import gwt.scene.ui.client.Form;

public class UiBinderForm01 extends _Composite {

	interface MyUiBinder extends UiBinder<Form, UiBinderForm01> {
		MyUiBinder uiBinder = GWT.create(MyUiBinder.class);
	}

	@UiField
	DatetimePicker datetimePicker;

	public UiBinderForm01() {
		
		initWidget(MyUiBinder.uiBinder.createAndBindUi(this));

		datetimePicker.addValueChangeHandler(new ValueChangeHandler<Date>() {
			@Override
			public void onValueChange(ValueChangeEvent<Date> event) {
				GWT.log(">>> " + event.getValue());
			}
		});
	}

}

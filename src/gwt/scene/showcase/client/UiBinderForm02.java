package gwt.scene.showcase.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;

import gwt.scene.ui.client._Composite;
import gwt.scene.ui.client.Form;
import gwt.scene.ui.client.TextBox;

public class UiBinderForm02 extends _Composite {

	private static MyUiBinder uiBinder = GWT.create(MyUiBinder.class);

	interface MyUiBinder extends UiBinder<Form, UiBinderForm02> {
	}

	@UiField
	TextBox exampleInputEmail1;

	@UiField
	TextBox exampleInputEmail2;

	public UiBinderForm02() {
		initWidget(uiBinder.createAndBindUi(this));
		
		exampleInputEmail2.valueProperty().bindBidirectional(exampleInputEmail1.valueProperty());
	}

}

package gwt.scene.showcase.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;

import gwt.scene.ui.client.Composite;
import gwt.scene.ui.client.Form;

public class UiBinderForm01 extends Composite {

	interface MyUiBinder extends UiBinder<Form, UiBinderForm01> {
		MyUiBinder uiBinder = GWT.create(MyUiBinder.class);
	}

	public UiBinderForm01() {
		initWidget(MyUiBinder.uiBinder.createAndBindUi(this));
	}

}

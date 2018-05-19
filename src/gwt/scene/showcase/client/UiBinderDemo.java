package gwt.scene.showcase.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;

import gwt.scene.ui.client._Composite;
import gwt.scene.ui.client.Container;
import gwt.scene.ui.client.TextBox;

public class UiBinderDemo extends _Composite {

	interface MyUiBinder extends UiBinder<Container, UiBinderDemo> {
		MyUiBinder uiBinder = GWT.create(MyUiBinder.class);
	}
	
	@UiField
	DivElement lala;
	
	@UiField
	TextBox password;
	
	public UiBinderDemo() {
		initWidget(MyUiBinder.uiBinder.createAndBindUi(this));
		
		GWT.log(">>>>"+lala.getId());
	}
}

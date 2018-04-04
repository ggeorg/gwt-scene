package gwt.scene.showcase.client;

import com.google.gwt.core.client.Callback;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.Window;

import gwt.scene.core.client.ModuleLoader;
import gwt.scene.ui.client.Button;
import gwt.scene.ui.client.Container;
import gwt.scene.ui.client.FlowPane;
import gwt.scene.ui.client.Scene;

public class Showcase implements EntryPoint, Callback<Void, Exception> {

	public void onModuleLoad() {
		ModuleLoader.require(this, "UI");
	}
	
	@Override
	public void onSuccess(Void result) {
		uiBinderTest();
		//flowPaneTest();
	}

	private void uiBinderTest() {
		Scene scene = new Scene();
		scene.addStyleName("scene");
		
		Container c = new Container();
		c.setFlex("1");
		c.setPadding("5px 10px");
		scene.add(c);
		
		c.add(new UiBinderForm01());
	}

	@SuppressWarnings("unused")
	private void flowPaneTest() {
		Scene scene = new Scene();
		scene.addStyleName("scene");

		FlowPane flowPane = new FlowPane();
		flowPane.setBorder("1px solid #ccc");
		flowPane.setFlex("1");
		scene.add(flowPane);

		Button btn = new Button("Hello, World!");
		// btn.setFlex("1");
		flowPane.add(btn);

		btn = new Button("Hello, World!");
		// btn.setFlex("1");
		flowPane.add(btn);

		btn = new Button("Hello, World!");
		// btn.setFlex("1");
		flowPane.add(btn);

		btn = new Button("Hello, World!");
		// btn.setFlex("1");
		flowPane.add(btn);

		btn = new Button("Hello, World!");
		// btn.setFlex("1");
		flowPane.add(btn);

		btn = new Button("Hello, World!");
		// btn.setFlex("1");
		flowPane.add(btn);

		btn = new Button("Hello, World!");
		// btn.setFlex("1");
		flowPane.add(btn);

		btn = new Button("Hello, World!");
		// btn.setFlex("1");
		flowPane.add(btn);

		btn = new Button("Hello, World!");
		// btn.setFlex("1");
		flowPane.add(btn);

		btn = new Button("Hello, World!");
		// btn.setFlex("1");
		flowPane.add(btn);

		btn = new Button("Hello, World!");
		// btn.setFlex("1");
		flowPane.add(btn);

		btn = new Button("Hello, World!");
		// btn.setFlex("1");
		flowPane.add(btn);

		btn = new Button("Hello, World!");
		// btn.setFlex("1");
		flowPane.add(btn);

		btn = new Button("Hello, World!");
		// btn.setFlex("1");
		flowPane.add(btn);
	}

	@Override
	public void onFailure(Exception reason) {
		Window.alert(reason.getMessage());
	}
}

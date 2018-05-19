package gwt.scene.showcase.client;

import com.google.gwt.core.client.Callback;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.Window;

import gwt.scene.core.client.DOM;
import gwt.scene.core.client.ModuleLoader;
import gwt.scene.ui.client.AlignItems;
import gwt.scene.ui.client.Bin;
import gwt.scene.ui.client.Button;
import gwt.scene.ui.client.ButtonStyle;
import gwt.scene.ui.client.Direction;
import gwt.scene.ui.client.FlowPane;
import gwt.scene.ui.client.HBox;
import gwt.scene.ui.client.JustifyContent;
import gwt.scene.ui.client.Scene;
import gwt.scene.ui.client.StackPane;
import gwt.scene.ui.client.VBox;

public class Showcase implements EntryPoint, Callback<Void, Exception> {

	public void onModuleLoad() {
		ModuleLoader.require(this, "UI", "Matrix");
	}

	@Override
	public void onSuccess(Void result) {
		Scene scene = new Scene();
		scene.setDirection(Direction.HORIZONTAL);

		StackPane stack = new StackPane();
		stack.setFlex("1");

		{
			FlowPane box = new FlowPane();
			stack.add(box);

			Button btn = new Button("Hello, World!!!");
			box.add(btn);

			box.add(btn);
			btn = new Button("Hello, World!!!");
			box.add(btn);

			box.add(btn);
			btn = new Button("Hello, World!!!");
			box.add(btn);

			box.add(btn);
			btn = new Button("Hello, World!!!");
			box.add(btn);

			box.add(btn);
			btn = new Button("Hello, World!!!");
			box.add(btn);

			box.add(btn);
			btn = new Button("Hello, World!!!");
			box.add(btn);

			box.add(btn);
			btn = new Button("Hello, World!!!");
			box.add(btn);

			box.add(btn);
			btn = new Button("Hello, World!!!");
			box.add(btn);

			box.add(btn);
			btn = new Button("Hello, World!!!");
			box.add(btn);

			box.add(btn);
			btn = new Button("Hello, World!!!");
			box.add(btn);

			box.add(btn);
			btn = new Button("Hello, World!!!");
			box.add(btn);

			box.add(btn);
			btn = new Button("Hello, World!!!");
			box.add(btn);

			box.add(btn);
			btn = new Button("Hello, World!!!");
			box.add(btn);

			box.add(btn);
			btn = new Button("Hello, World!!!");
			box.add(btn);

			box.add(btn);
			btn = new Button("Hello, World!!!");
			box.add(btn);

			box.add(btn);
			btn = new Button("Hello, World!!!");
			box.add(btn);

			box.add(btn);
			btn = new Button("Hello, World!!!");
			box.add(btn);

			box.add(btn);
			btn = new Button("Hello, World!!!");
			box.add(btn);

			box.add(btn);
			btn = new Button("Hello, World!!!");
			box.add(btn);

			box.add(btn);
			btn = new Button("Hello, World!!!");
			box.add(btn);

			box.add(btn);
			btn = new Button("Hello, World!!!");
			box.add(btn);

			box.add(btn);
			btn = new Button("Hello, World!!!");
			box.add(btn);

			box.add(btn);
			btn = new Button("Hello, World!!!");
			box.add(btn);

			box.add(btn);
			btn = new Button("Hello, World!!!");
			box.add(btn);

			box.add(btn);
			btn = new Button("Hello, World!!!");
			box.add(btn);

			box.add(btn);
			btn = new Button("Hello, World!!!");
			box.add(btn);

			box.add(btn);
			btn = new Button("Hello, World!!!");
			box.add(btn);

			box.add(btn);
			btn = new Button("Hello, World!!!");
			box.add(btn);

			box.add(btn);
			btn = new Button("Hello, World!!!");
			box.add(btn);

			box.add(btn);
			btn = new Button("Hello, World!!!");
			box.add(btn);

			box.add(btn);
			btn = new Button("Hello, World!!!");
			box.add(btn);

			box.add(btn);
			btn = new Button("Hello, World!!!");
			box.add(btn);

			box.add(btn);
			btn = new Button("Hello, World!!!");
			box.add(btn);

			box.add(btn);
			btn = new Button("Hello, World!!!");
			box.add(btn);

			box.add(btn);
			btn = new Button("Hello, World!!!");
			box.add(btn);

			box.add(btn);
			btn = new Button("Hello, World!!!");
			box.add(btn);

			box.add(btn);
			btn = new Button("Hello, World!!!");
			box.add(btn);

			box.add(btn);
			btn = new Button("Hello, World!!!");
			box.add(btn);

			box.add(btn);
			btn = new Button("Hello, World!!!");
			box.add(btn);

			box.add(btn);
			btn = new Button("Hello, World!!!");
			box.add(btn);

			box.add(btn);
			btn = new Button("Hello, World!!!");
			box.add(btn);

			box.add(btn);
			btn = new Button("Hello, World!!!");
			box.add(btn);

			box.add(btn);
			btn = new Button("Hello, World!!!");
			box.add(btn);

			box.add(btn);
			btn = new Button("Hello, World!!!");
			box.add(btn);

			box.add(btn);
			btn = new Button("Hello, World!!!");
			box.add(btn);

			box.add(btn);
			btn = new Button("Hello, World!!!");
			box.add(btn);

			box.add(btn);
			btn = new Button("Hello, World!!!");
			box.add(btn);

			box.add(btn);
			btn = new Button("Hello, World!!!");
			box.add(btn);

			box.add(btn);
			btn = new Button("Hello, World!!!");
			box.add(btn);

			box.add(btn);
			btn = new Button("Hello, World!!!");
			box.add(btn);

			box.add(btn);
			btn = new Button("Hello, World!!!");
			box.add(btn);

			box.add(btn);
			btn = new Button("Hello, World!!!");
			box.add(btn);

			box.add(btn);
			btn = new Button("Hello, World!!!");
			box.add(btn);

			box.add(btn);
			btn = new Button("Hello, World!!!");
			box.add(btn);

			box.add(btn);
			btn = new Button("Hello, World!!!");
			box.add(btn);

			box.add(btn);
			btn = new Button("Hello, World!!!");
			box.add(btn);

			box.add(btn);
			btn = new Button("Hello, World!!!");
			box.add(btn);

			box.add(btn);
			btn = new Button("Hello, World!!!");
			box.add(btn);

			box.add(btn);
			btn = new Button("Hello, World!!!");
			box.add(btn);

			box.add(btn);
			btn = new Button("Hello, World!!!");
			box.add(btn);

			box.add(btn);
			btn = new Button("Hello, World!!!");
			box.add(btn);

			box.add(btn);
			btn = new Button("Hello, World!!!");
			box.add(btn);

			box.add(btn);
			btn = new Button("Hello, World!!!");
			box.add(btn);

			box.add(btn);
			btn = new Button("Hello, World!!!");
			box.add(btn);

			box.add(btn);
			btn = new Button("Hello, World!!!");
			box.add(btn);

			box.add(btn);
			btn = new Button("Hello, World!!!");
			box.add(btn);

			box.add(btn);
			btn = new Button("Hello, World!!!");
			box.add(btn);

			box.add(btn);
			btn = new Button("Hello, World!!!");
			box.add(btn);

			box.add(btn);
			btn = new Button("Hello, World!!!");
			box.add(btn);

			box.add(btn);
			btn = new Button("Hello, World!!!");
			box.add(btn);

			box.add(btn);
			btn = new Button("Hello, World!!!");
			box.add(btn);
		}

		{
			HBox box = new HBox();
			stack.add(box);

			Button btn = new Button("Hello, World!!!");
			box.add(btn);

			box.add(btn);
			btn = new Button("Hello, World!!!");
			box.add(btn);
		}

		{
			Button btn = new Button("Hello, World!!!");
			btn.setStyle(ButtonStyle.INFO);
			Bin bin = new Bin(btn);
			bin.setAlignItems(AlignItems.END);
			bin.setJustifyContent(JustifyContent.END);
			
			stack.add(bin);
		}
		
		scene.add(stack);
	}

	@Override
	public void onFailure(Exception reason) {
		Window.alert(reason.getMessage());
	}
}

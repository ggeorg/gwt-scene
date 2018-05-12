package gwt.scene.showcase.client;

import com.google.gwt.core.client.Callback;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.Window;

import gwt.scene.core.client.ModuleLoader;
import gwt.scene.ui.client.Canvas;
import gwt.scene.ui.client.Direction;
import gwt.scene.ui.client.Scene;

public class Showcase implements EntryPoint, Callback<Void, Exception> {

	public void onModuleLoad() {
		ModuleLoader.require(this, "UI");
	}

	@Override
	public void onSuccess(Void result) {
		Scene scene = new Scene();
		scene.setDirection(Direction.HORIZONTAL);
		
		Canvas canvas = new Canvas();
		canvas.setFlex("1");
		
		scene.add(canvas);
	}

	@Override
	public void onFailure(Exception reason) {
		Window.alert(reason.getMessage());
	}
}

package gwt.scene.showcase.client;

import com.google.gwt.core.client.Callback;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.RootPanel;

import gwt.scene.core.client.DOM;
import gwt.scene.core.client.ModuleLoader;
import gwt.scene.ui.client.Button;
import gwt.scene.ui.client.ButtonStyle;
import gwt.scene.ui.client.HBox;
import gwt.scene.ui.client.Splitter;
import gwt.scene.ui.client.VBox;
import gwt.scene.ui.client.Splitter.Grow;

public class Showcase3 implements EntryPoint, Callback<Void, Exception> {

	public void onModuleLoad() {
		ModuleLoader.require(this, "UI");
	}

	@Override
	public void onSuccess(Void result) {
		HBox box = new HBox();
		box.setHeight("100%");
		//box.setDirection(Direction.VERTICAL_REVERSE);
		//box.setAlign(Align.CENTER);
		//box.setPack(Pack.END);
		
		Button btn1 = new Button("Info");
		btn1.setWidth("auto");
		btn1.setFlex("0 0 auto");
		btn1.setStyle(ButtonStyle.OUTLINE_INFO);
		box.add(btn1);
		
		box.add(new Splitter());

		VBox box2 = new VBox();
		box2.setFlex("1");
		//DOM.setCss(box2, "border", "1px solid green");
		box.add(box2);
		
		Button btn3 = new Button("Danger");
		btn3.setStyle(ButtonStyle.OUTLINE_DANGER);
		box2.add(btn3);
		
		box2.add(new Splitter());
		
//		Button btn4 = new Button("Danger");
//		btn4.setStyle(ButtonStyle.OUTLINE_DANGER);
//		btn4.setFlex("2");
//		box2.add(btn4);
		
		UiBinderDemo d = new UiBinderDemo();
		d.setFlex("1");
		//DOM.setStyleAttribute(d.getElement(), "border", "1px solid green");
		DOM.setCss(d, "border", "1px solid green");
		box2.add(d);
		
		box.add(new Splitter(Grow.AFTER));
		
		Button btn2 = new Button("Danger");
		btn2.setWidth("30%");
		btn2.setStyle(ButtonStyle.OUTLINE_DANGER);
		btn2.setFlex("0 0 auto");
		//btn2.setSelfAlign(Align.CENTER);
		box.add(btn2);
		
		RootPanel.get().add(box);
	}

	@Override
	public void onFailure(Exception reason) {
		Window.alert(reason.getMessage());
	}
}

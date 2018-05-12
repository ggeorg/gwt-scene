package gwt.scene.ui.client;

public class Canvas extends Composite {

	public Canvas() {
		initWidget(com.google.gwt.canvas.client.Canvas.createIfSupported());
	}
}

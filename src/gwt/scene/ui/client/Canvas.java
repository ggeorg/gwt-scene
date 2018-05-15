package gwt.scene.ui.client;

import com.google.gwt.dom.client.CanvasElement;

import gwt.scene.core.client.collections.JsObject;
import gwt.scene.ui.client.dom.Context2D;
import gwt.scene.ui.client.dom.WebGLContext;

public class Canvas extends Composite {

	public Canvas() {
		initWidget(com.google.gwt.canvas.client.Canvas.createIfSupported());
	}

	@Override
	protected final Canvas getWidget() {
		return (Canvas) super.getWidget();
	}

	public Context2D getContext2d() {
		return getWidget().getContext2d();
	}

	/**
	 * Creates a WebGL 1.0 context upon this canvas.
	 * 
	 * @return The created WebGL context object.
	 */
	public WebGLContext getContext3d() {
		return Canvas.getContext3d(getElement().cast(), WebGLContext.CONTEXT_ID, null);
	}

	private static native WebGLContext getContext3d(CanvasElement canvas, String[] contextType,
			JsObject attributes) /*-{
		var gl = null;
		for (var i = 0; i < contextType.length; ++i) {
			try {
				if (attributes) {
					gl = canvas.getContext(contextType[i], attributes);
				} else {
					gl = canvas.getContext(contextType[i]);
				}
			} catch (e) {
			}
			if (gl) {
				break;
			}
		}
		return gl;
	}-*/;
}

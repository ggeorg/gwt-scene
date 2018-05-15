package gwt.scene.core.matrix.client;

import com.google.gwt.core.client.JavaScriptObject;

public class Matrix4 extends JavaScriptObject {

	public static final native Matrix4 create() /*-{
		return $wnd.___GL_Matrix_.mat4.create();
	}-*/;

	/**
	 * Generates a perspective projection matrix with the given bounds.
	 * 
	 * @param mat4
	 * @param fovy
	 * @param aspect
	 * @param near
	 * @param far
	 */
	public static final native void perspective(Matrix4 mat4,
			double fovy, double aspect, double near, double far) /*-{
		return $wnd.___GL_Matrix_.mat4.perspective(mat4, fovy, aspect, near, far);
	}-*/;

	/**
	 * Translate a mat3 by the given vector.
	 * 
	 * @param out
	 * @param a
	 * @param v
	 */
	public static final native void translate(Matrix4 out, Matrix4 a, double[] v) /*-{
		return $wnd.___GL_Matrix_.mat4.translate(out, a, v);
	}-*/;

	protected Matrix4() {
	}
}

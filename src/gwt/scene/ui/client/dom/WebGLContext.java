package gwt.scene.ui.client.dom;

import com.google.gwt.canvas.dom.client.Context;
import com.google.gwt.core.client.JavaScriptObject;

import gwt.scene.ui.client.Canvas;

/**
 * OpenGL ES 2.0 rendering context for drawing surface of a HTML
 * {@code <canvas>} element.
 * <p>
 * To get an instance of this class, call {@link Canvas#getContext3d()}.
 */
public class WebGLContext extends JavaScriptObject implements Context {

	//@formatter:off
    public static final int ARRAY_BUFFER                                 = 0x8892;
    public static final int BYTE                                         = 0x1400;
	public static final int COLOR_BUFFER_BIT                             = 0x4000;
    public static final int COLOR_CLEAR_VALUE                            = 0x0C22;
    public static final int COMPILE_STATUS                               = 0x8B81;
    public static final int DEPTH_TEST                                   = 0x0B71;
    public static final int DEPTH_BUFFER_BIT                             = 0x0100;
    public static final int FLOAT                                        = 0x1406;
    public static final int FRAGMENT_SHADER                              = 0x8B30;
    public static final int LEQUAL                                       = 0x0203;
    public static final int SHORT                                        = 0x1402;
    public static final int STENCIL_BUFFER_BIT                           = 0x0400;
    public static final int ELEMENT_ARRAY_BUFFER                         = 0x8893;
    public static final int LINK_STATUS                                  = 0x8B82;
    public static final int STATIC_DRAW                                  = 0x88E4;
    public static final int TRIANGLE_STRIP                               = 0x0005;
    public static final int UNSIGNED_BYTE                                = 0x1401;
    public static final int UNSIGNED_SHORT                               = 0x1403;
    public static final int VERTEX_SHADER                                = 0x8B31;
	//@formatter:on

	/**
	 * Specifies the context id property used in creating a Context.
	 */
	public static final String[] CONTEXT_ID = { "webgl", "experimental-webgl", "moz-webgl", "webkit-3d" };

	protected WebGLContext() {
	}

	/**
	 * Attaches either a fragment or vertex {@link WebGLShader} to a
	 * {@link WebGLProgram}.
	 * 
	 * @param program
	 *            A {@link WebGLProgram}.
	 * @param shader
	 *            A fragment or vertex {@link WebGLShader}.
	 * 
	 * @see https://www.khronos.org/registry/webgl/specs/latest/1.0/#5.14.9
	 */
	public final native void attachShader(WebGLProgram program, WebGLShader shader) /*-{
		this.attachShader(program, shader);
	}-*/;

	// TODO @throws INVALID_OPERATION
	public final native void bindBuffer(int target, WebGLBuffer buffer) /*-{
		this.bindBuffer(target, buffer);
	}-*/;

	// throws OUT_OF_MEMORY, INVALID_VALUE, INVALID_ENUM
	public final native void bufferData(int target, float[] data, int usage) /*-{
		this.bufferData(target, new Float32Array(data), usage);
	}-*/;

	// throws OUT_OF_MEMORY, INVALID_VALUE, INVALID_ENUM
	public final native void bufferData(int target, int[] data, int usage) /*-{
		this.bufferData(target, new Uint16Array(data), usage);
	}-*/;

	/**
	 * 
	 * @param mask
	 *            A bit mask that indicates the buffers to be cleared. Possible
	 *            values are:
	 *            <ul>
	 *            <li>{@link WebGLContext#COLOR_BUFFER_BIT}</li>
	 *            <li>{@link WebGLContext#DEPTH_BUFFER_BIT}</li>
	 *            <li>{@link WebGLContext#STENCIL_BUFFER_BIT}</li>
	 *            </ul>
	 */
	public final native void clear(int mask) /*-{
		this.clear(mask);
	}-*/;

	/**
	 * Specifies what color values to use when calling the clear() method. The
	 * values are clamped between 0 and 1.
	 * 
	 * @param r
	 * @param g
	 * @param b
	 * @param a
	 */
	public final native void clearColor(float r, float g, float b, float a) /*-{
		this.clearColor(r, g, b, a);
	}-*/;

	/**
	 * Specifies the clear value for the depth buffer.
	 * <p>
	 * This specifies what depth value to use when calling the {@link #clear(int)}
	 * method. The value is clamped between 0 and 1.
	 * 
	 * @param depth
	 *            The depth value used when the depth buffer is cleared (default
	 *            value is 1).
	 */
	public final native void clearDepth(double depth) /*-{
		this.clearDepth(depth);
	}-*/;

	/**
	 * Compiles a GLSL shader into binary data so that it can be used by a
	 * WebGLProgram.
	 * 
	 * @param shader
	 *            A fragment or vertex {@link WebGLShader}.
	 * 
	 * @see https://www.khronos.org/registry/webgl/specs/latest/1.0/#5.14.9
	 */
	public final native void compileShader(WebGLShader shader) /*-{
		this.compileShader(shader);
	}-*/;

	/**
	 * 
	 * @return a WebGLBuffer storing data such as vertices or colors.
	 */
	public final native WebGLBuffer createBuffer() /*-{
		return this.createBuffer();
	}-*/;

	/**
	 * Creates and initializes a {@link WebGLProgram} object.
	 */
	public final native WebGLProgram createProgram() /*-{
		return this.createProgram();
	}-*/;

	/**
	 * 
	 * @param type
	 *            either {@link #VERTEX_SHADER} or {@link #FRAGMENT_SHADER}.
	 */
	public final native WebGLShader createShader(int type) /*-{
		return this.createShader(type);
	}-*/;

	/**
	 * 
	 * @param shader
	 */
	public final native void deleteShader(WebGLShader shader) /*-{
		this.deleteShader(shader);
	}-*/;

	/**
	 * 
	 * @param func
	 */
	public final native void depthFunc(int func) /*-{
		this.depthFunc(func);
	}-*/;

	/**
	 * 
	 * @param cap
	 */
	public final native void enable(int cap) /*-{
		this.enable(cap);
	}-*/;

	/**
	 * Returns the location of an attribute variable in a given
	 * {@link WebGLProgram}.
	 * 
	 * @param program
	 *            A {@link WebGLProgram} containing the attribute variable.
	 * @param name
	 *            The name of the attribute variable whose location to get.
	 * @return A number indicating the location of the variable name if found;
	 *         {@code -1} otherwise.
	 */
	public final native int getAttribLocation(WebGLProgram program, String name) /*-{
		return this.getAttribLocation(program, name);
	}-*/;

	/**
	 * 
	 * @param pname
	 * @return
	 */
	public final native <T> T getParameter(int pname) /*-{
		console.log(this.getParameter(pname));
		return null;
	}-*/;

	/**
	 * 
	 * @param program
	 * @return the information log for the specified {@link WebGLProgram} object.
	 */
	public final native String getProgramInfoLog(WebGLProgram program) /*-{
		return this.getProgramInfoLog(program);
	}-*/;

	/**
	 * 
	 * @param shaderProgram
	 * @param linkStatus
	 * @return the information about the given program.
	 */
	public final native boolean getProgramParameter(WebGLProgram program, int pname) /*-{
		return this.getProgramParameter(program, pname);
	}-*/;

	/**
	 * Returns the information log for the specified {@link WebGLShader} object.
	 * 
	 * @param shader
	 *            A {@link WebGLShader} to query.
	 * @return A string containing diagnostic messages, warning messages, and other
	 *         information about the last compile operation.
	 * 
	 * @see https://www.khronos.org/registry/webgl/specs/latest/1.0/#5.14.9
	 */
	public final native String getShaderInfoLog(WebGLShader shader) /*-{
		return this.getShaderInfoLog(shader);
	}-*/;

	/**
	 * Returns information about the given shader.
	 * 
	 * @param shader
	 * @param pname
	 * @return
	 */
	public final native boolean getShaderParameter(WebGLShader shader, int pname) /*-{
		// TODO
		var shaderInformation = this.getShaderParameter(shader, pname);
		console.log(shaderInformation);
		return shaderInformation;
	}-*/;

	/**
	 * 
	 * @param program
	 * @param name
	 * @return
	 */
	public final native WebGLUniformLocation getUniformLocation(WebGLProgram program, String name) /*-{
		return this.getUniformLocation(program, name);
	}-*/;

	/**
	 * Links a given {@link WebGLProgram} to the attached vertex and fragment
	 * shaders.
	 * 
	 * @param program
	 *            A {@link WebGLProgram}.
	 * 
	 * @see https://www.khronos.org/registry/webgl/specs/latest/1.0/#5.14.9
	 */
	public final native void linkProgram(WebGLProgram program) /*-{
		this.linkProgram(program);
	}-*/;

	/**
	 * Sets the source code of a {@link WebGLShader}.
	 * 
	 * @param shader
	 * @param source
	 * 
	 * @see https://www.khronos.org/registry/webgl/specs/latest/1.0/#5.14.9
	 */
	public final native void shaderSource(WebGLShader shader, String source) /*-{
		this.shaderSource(shader, source);
	}-*/;

	/**
	 * Binds the buffer currently bound to {@link #ARRAY_BUFFER} to a generic vertex
	 * attribute of the current vertex buffer object and specifies its layout.
	 * 
	 * @param index
	 *            The index of the vertex attribute that is to be modified.
	 * @param size
	 *            The number of components per vertex attribute (must be 1,2,3, or
	 *            4).
	 * @param type
	 *            The data type of each component in the array. Possible values:
	 *            <ul>
	 *            <li>{@link WebGLContext#BYTE}: signed 8-bit integer, with values
	 *            in [-128, 127]</li>
	 *            <li>{@link WebGLContext#SHORT}: signed 16-bit integer, with values
	 *            in [-32768, 32767]</li>
	 *            <li>{@link WebGLContext#UNSIGNED_BYTE}: unsigned 8-bit integer,
	 *            with values in [0, 255]</li>
	 *            <li>{@link WebGLContext#UNSIGNED_SHORT}: unsigned 16-bit integer,
	 *            with values in [0, 65535]</li>
	 *            <li>{@link WebGLContext#FLOAT}: 32-bit IEEE floating point
	 *            number</li>
	 *            </ul>
	 * @param normalized
	 *            A boolean specifying whether integer data values should be
	 *            normalized into a certain range when casted to a float.
	 * @param stride
	 *            The offset in bytes between the beginning of consecutive vertex
	 *            attributes. If stride is 0, the attribute is assumed to be tightly
	 *            packed, that is, the attributes are not interleaved but each
	 *            attribute is in a separate block, and the next vertex attribute
	 *            follows immediately after the current vertex.
	 * @param offset
	 *            The offset in bytes of the first component in the vertex attribute
	 *            array. Must be a multiple of {@code type}.
	 * 
	 * @see https://www.khronos.org/registry/webgl/specs/latest/1.0/#5.14.10
	 */
	public final native void vertexAttribPointer(int index, int size, int type, boolean normalized, int stride,
			int offset) /*-{
		this.vertexAttribPointer(index, size, type, normalized, stride, offset)
	}-*/;

	/**
	 * Turns on the generic vertex attribute array at the specified index into the
	 * list of attribute arrays.
	 * 
	 * @param index
	 *            The index number that uniquely identifies the vertex attribute to
	 *            enable. If you know the name of the attribute but not its index,
	 *            you can get the index by calling
	 *            {@link #getAttribLocation(WebGLProgram, String)}.
	 * 
	 * @see https://www.khronos.org/registry/webgl/specs/latest/1.0/#5.14.10
	 */
	public final native void enableVertexAttribArray(int index) /*-{
		this.enableVertexAttribArray(index);
	}-*/;

	/**
	 * Sets the specified {@link WebGLProgram} as part of the current rendering
	 * state.
	 * 
	 * @param program
	 *            A {@link WebGLProgram} to use.
	 */
	public final native void useProgram(WebGLProgram program) /*-{
		this.useProgram(program);
	}-*/;

	/**
	 * 
	 * @param location
	 * @param transpose
	 * @param value
	 */
	public final native void uniformMatrix4fv(WebGLUniformLocation  location, boolean transpose, JavaScriptObject /*Float32Array*/ value) /*-{
		this.uniformMatrix4fv(location, transpose, value);
	}-*/;

	/**
	 * Renders primitives from array data.
	 * 
	 * @param mode The primitive type to render.
	 * @param first The starting index in the array of vector points.
	 * @param count The number of indices to be rendered.
	 * 
	 * @see https://www.khronos.org/registry/webgl/specs/latest/1.0/#5.14.11
	 */
	public final native void drawArrays(int mode, int first, int count) /*-{
		this.drawArrays(mode, first, count);
	}-*/;

}

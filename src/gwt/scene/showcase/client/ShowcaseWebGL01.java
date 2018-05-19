package gwt.scene.showcase.client;

import com.google.gwt.core.client.Callback;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Window;

import gwt.scene.core.client.ModuleLoader;
import gwt.scene.core.client.collections.JsObject;
import gwt.scene.core.client.json.JSON;
import gwt.scene.core.matrix.client.Matrix4;
import gwt.scene.ui.client.Canvas;
import gwt.scene.ui.client.Direction;
import gwt.scene.ui.client.Scene;
import gwt.scene.ui.client.dom.WebGLBuffer;
import gwt.scene.ui.client.dom.WebGLContext;
import gwt.scene.ui.client.dom.WebGLProgram;
import gwt.scene.ui.client.dom.WebGLShader;
import gwt.scene.ui.client.dom.WebGLUniformLocation;

public class ShowcaseWebGL01 implements EntryPoint, Callback<Void, Exception> {

	public void onModuleLoad() {
		ModuleLoader.require(this, "UI", "Matrix");
	}

	@Override
	public void onSuccess(Void result) {
		Scene scene = new Scene();
		scene.setDirection(Direction.HORIZONTAL);

		Canvas canvas = new Canvas();
		canvas.setFlex("1");

		scene.add(canvas);
		
		// ---

		WebGLContext gl = canvas.getContext3d();
		//gl.clearColor(.3f, .3f, .5f, 1.0f);
		//gl.clear(WebGLContext.COLOR_BUFFER_BIT);
		// gl.getParameter(WebGLContext.COLOR_CLEAR_VALUE);

		// Vertex shader program
		String vsSource = MyResources.INSTANCE.vsSource().getText();

		// Fragment shader program
		String fsSource = MyResources.INSTANCE.fsSource().getText();

		// Initialize a shader program; this is where all the lighting
		// for the vertices and so forth is establish.
		WebGLProgram shaderProgram = initShaderProgram(gl, vsSource, fsSource);

		// Collect all the info needed to use the shader program.
		// Look at which attribute our shader program is using for
		// aVertexProsition and look up uniform locations.
		JsObject programInfo = JsObject.create()
				.set("program", shaderProgram)
				.set("attribLocations", JsObject.create()
						.set("vertexPosition", gl.getAttribLocation(shaderProgram, "aVertexPosition")))
				.set("uniformLocations", JsObject.create()
						.set("projectionMatrix", gl.getUniformLocation(shaderProgram, "uProjectionMatrix"))
						.set("modelViewMatrix", gl.getUniformLocation(shaderProgram, "uModelViewMatrix")));

		// Here's where we call the routine that builds all the objects we'll be
		// drawing.
		JsObject buffers = initBuffers(gl);

		// Draw the scene
		drawScene(canvas, gl, programInfo, buffers);
	}

	private void drawScene(Canvas canvas, WebGLContext gl, JsObject programInfo, JsObject buffers) {
		gl.clearColor(0.0f, 0.0f, 0.0f, 1.0f); // Clear to black, fully opaque
		gl.clearDepth(1.0); // Clear everything
		gl.enable(WebGLContext.DEPTH_TEST); // Enable depth testing
		gl.depthFunc(WebGLContext.LEQUAL); // Near things obscure far things

		// Clear the canvas before we start drawing on it.

		gl.clear(WebGLContext.COLOR_BUFFER_BIT | WebGLContext.DEPTH_BUFFER_BIT);

		// Create a perspective matrix, a special matrix that is
		// used to simulate the distortion of perspective in a camera.
		// Our field of view is 45 degrees, with a width/height
		// ratio that matches the display size of the canvas
		// and we only want to see objects between 0.1 units
		// and 100 units away from the camera.

		double fieldOfView = 45 * Math.PI / 180; // in radians
		double aspect = (double) canvas.getElement().getClientWidth() / (double) canvas.getElement().getClientHeight();
		double zNear = 0.1;
		double zFar = 100.0;
		Matrix4 projectionMatrix = Matrix4.create();

		// note: glmatrix.js always has the first argument
		// as the destination to receive the result.
		Matrix4.perspective(projectionMatrix, fieldOfView, aspect, zNear, zFar);

		// Set the drawing position to the "identity" point, which is
		// the center of the scene.
		Matrix4 modelViewMatrix = Matrix4.create();

		// Now move the drawing position a bit to where we want to
		// start drawing the square.

		Matrix4.translate(modelViewMatrix, modelViewMatrix, new double[] { -0.0, 0.0, -6.0 });

		// Tell WebGL how to pull the positions from the position
		// buffer into the vertexPosition attribute.
		{
			int numComponents = 2;
			int type = WebGLContext.FLOAT;
			boolean normalize = false;
			int stride = 0;
			int offset = 0;
			
			gl.bindBuffer(WebGLContext.ARRAY_BUFFER, (WebGLBuffer) buffers.get("position"));
			
			JsObject attribLocations = (JsObject) programInfo.get("attribLocations");
			int vertexPosition = attribLocations.get("vertexPosition", -1);
			gl.vertexAttribPointer(vertexPosition,
					numComponents,
					type,
					normalize,
					stride,
					offset);
			gl.enableVertexAttribArray(vertexPosition);
		}

		// Tell WebGL to use our program when drawing

		gl.useProgram((WebGLProgram) programInfo.get("program"));

		// Set the shader uniforms

		{
			WebGLUniformLocation location = (WebGLUniformLocation) JSON
					.asJsObject((JavaScriptObject) programInfo.get("uniformLocations")).get("projectionMatrix");
			gl.uniformMatrix4fv(location, false, projectionMatrix);
		}

		{
			WebGLUniformLocation location = (WebGLUniformLocation) JSON
					.asJsObject((JavaScriptObject) programInfo.get("uniformLocations")).get("modelViewMatrix");
			gl.uniformMatrix4fv(location, false, modelViewMatrix);
		}
		
		gl.drawArrays(WebGLContext.TRIANGLE_STRIP, 0, 4);
	}

	private JsObject initBuffers(WebGLContext gl) {

		// Create a buffer for the square's positions.

		WebGLBuffer positionBuffer = gl.createBuffer();

		// Select the positionBuffer as the one to apply buffer
		// operations to from here out.

		gl.bindBuffer(WebGLContext.ARRAY_BUFFER, positionBuffer);

		// Now create an array of positions for the square.

		float positions[] = {
				1.0f, 1.0f,
				-1.0f, 1.0f,
				1.0f, -1.0f,
				-1.0f, -1.0f };

		// Now pass the list of positions into WebGL to build the
		// shape. We do this by creating a Float32Array from the
		// JavaScript array, then use it to fill the current buffer.

		gl.bufferData(WebGLContext.ARRAY_BUFFER, positions, WebGLContext.STATIC_DRAW);

		return JsObject.create()
				.set("position", positionBuffer);
	}

	private WebGLProgram initShaderProgram(WebGLContext gl, String vsSource, String fsSource) {
		WebGLShader vertexShader = loadShader(gl, WebGLContext.VERTEX_SHADER, vsSource);
		WebGLShader fragmentShader = loadShader(gl, WebGLContext.FRAGMENT_SHADER, fsSource);

		// Create the shader program

		WebGLProgram shaderProgram = gl.createProgram();
		gl.attachShader(shaderProgram, vertexShader);
		gl.attachShader(shaderProgram, fragmentShader);
		gl.linkProgram(shaderProgram);

		// If creating the shader program failed, alert

		if (!gl.getProgramParameter(shaderProgram, WebGLContext.LINK_STATUS)) {
			Window.alert("Unable to initialize the shader program: " + gl.getProgramInfoLog(shaderProgram));
			return null;
		}

		return shaderProgram;
	}

	// Creates a shader of the given type, uploads the source and compiles it.
	private WebGLShader loadShader(WebGLContext gl, int type, String source) {
		WebGLShader shader = gl.createShader(type);

		// Send the source to the shader object

		gl.shaderSource(shader, source);

		// Compile the shader program

		gl.compileShader(shader);

		// See if it compiled successfully

		if (!gl.getShaderParameter(shader, WebGLContext.COMPILE_STATUS)) {
			Window.alert("An error occurred compiling the shader: " + gl.getShaderInfoLog(shader));
			gl.deleteShader(shader);
			return null;
		}

		return shader;
	}

	@Override
	public void onFailure(Exception reason) {
		Window.alert(reason.getMessage());
	}
}

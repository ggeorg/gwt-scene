package gwt.scene.ui.client;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Style;
import com.google.gwt.dom.client.Style.Overflow;
import com.google.gwt.dom.client.Style.Position;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.logical.shared.ResizeEvent;
import com.google.gwt.event.logical.shared.ResizeHandler;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.RootPanel;

import gwt.scene.core.client.DOM;

/**
 * The GWT-Scene {@code Scene} class is the container for all content in a scene
 * graph.
 * 
 * @author ggeorg
 */
public class Scene extends Box {

	private final Timer onResizeTimer = new Timer() {
		@Override
		public void run() {
			Scene.this.onResize();
		}
	};

	public Scene() {
		setDirection(Direction.VERTICAL);
		setFlex("1");
		
		// Set Document height and overflow style.
		Style documentStyle = Document.get().getDocumentElement().getStyle();
		documentStyle.setProperty("minWidth", "100%");
		documentStyle.setProperty("minHeight", "100%");
		documentStyle.setOverflow(Overflow.HIDDEN);

		// Make BODY flexible.
		RootPanel root = RootPanel.get();
		root.setStylePrimaryName("flex");
		DOM.setFlex(root, "1");

		// Set BODY overflow style.
		Style rootStyle = root.getElement().getStyle();
		rootStyle.setOverflow(Overflow.HIDDEN);

		// Give body a predefined height; this is required by
		// Scrollable containers with dynamic height using Flexbox.
		// Note: setting height to 100% does not work.
		rootStyle.setPosition(Position.ABSOLUTE);
		rootStyle.setTop(0, Unit.PX);
		rootStyle.setLeft(0, Unit.PX);
		rootStyle.setBottom(0, Unit.PX);
		rootStyle.setRight(0, Unit.PX);

		// Add Window resize handler.
		Window.addResizeHandler(new ResizeHandler() {
			@Override
			public void onResize(ResizeEvent event) {
				onResizeTimer.schedule(333);
			}
		});

		// Attach to body...
		root.add(this);
	}

	@Override
	public Direction getDirection() {
		return super.getDirection();
	}

	@Override
	public void setDirection(Direction direction) {
		super.setDirection(direction);
	}
}

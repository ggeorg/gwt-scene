package gwt.scene.ui.client;

import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Style;
import com.google.gwt.dom.client.Style.Cursor;
import com.google.gwt.dom.client.Style.Display;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;

import gwt.scene.core.client.collections.JsObject;

public class Splitter extends Composite {

	public static enum Grow {
		BEFORE, AFTER
	}

	private Grow grow;

	public Splitter() {
		this(Grow.BEFORE);
	}

	public Splitter(Grow grow) {
		// initWidget(new Anchor(true));
		initWidget(new SimplePanel());

		setStyleName("splitter");

		Style style = getElement().getStyle();
		style.setZIndex(1);
		// style.setProperty("background", "#888");

		setGrow(grow);
	}

	public Grow getGrow() {
		return grow;
	}

	public void setGrow(Grow grow) {
		this.grow = grow;
	}

	@Override
	protected void onLoad() {
		Element elem = getElement();
		Element previous = elem.getPreviousSiblingElement();
		Element next = elem.getNextSiblingElement();

		Widget parent = getParent();
		if (parent instanceof HBox) {
			Style style = getElement().getStyle();
			style.setDisplay(Display.INLINE_BLOCK);
			style.setCursor(Cursor.COL_RESIZE);
			setSize("8px", "");
			// style.setProperty("minWidth", "8px");
			style.setProperty("margin", "-4px");
			if (grow == Grow.BEFORE) {
				initResizable(previous, JsObject.create()
						.set("handleSelector", elem)
						.set("resizeWidth", true)
						.set("resizeHeight", false)
						.set("resizeWidthFrom", "right"));
			} else {
				initResizable(next, JsObject.create()
						.set("handleSelector", elem)
						.set("resizeWidth", true)
						.set("resizeHeight", false)
						.set("resizeWidthFrom", "left"));
			}
		} else if (parent instanceof VBox) {
			Style style = getElement().getStyle();
			style.setDisplay(Display.BLOCK);
			style.setCursor(Cursor.ROW_RESIZE);
			setSize("", "8px");
			// style.setProperty("minWidth", "8px");
			style.setProperty("margin", "-4px");
			if (grow == Grow.BEFORE) {
				initResizable(previous, JsObject.create()
						.set("handleSelector", elem)
						.set("resizeWidth", false)
						.set("resizeHeight", true)
						.set("resizeHeightFrom", "bottom"));
			} else {
				initResizable(next, JsObject.create()
						.set("handleSelector", elem)
						.set("resizeWidth", false)
						.set("resizeHeight", true)
						.set("resizeHeightFrom", "top"));
			}
		}
	}

	@Override
	protected void onUnload() {
		destroyResizable(getElement());
	}

	private native void initResizable(Element element, JsObject options) /*-{
		try {
			$wnd.jQuery(element).resizable(options);
		} catch (e) {
			console.error(e);
			throw e;
		}
	}-*/;

	private native void destroyResizable(Element element) /*-{
		try {
			$wnd.jQuery(element).resizable("destroy");
		} catch (e) {
			console.error(e);
			throw e;
		}
	}-*/;
}

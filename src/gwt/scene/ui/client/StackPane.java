package gwt.scene.ui.client;

import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.Widget;

/**
 * 
 */
public class StackPane extends AbstractPanel {

	public StackPane() {
		super();

		// Setting the panel's position style to 'relative' causes it to be treated
		// as a new positioning context for its children.
		getElement().getStyle().setProperty("position", "relative");
		getElement().getStyle().setProperty("overflow", "hidden");
	}

	@Deprecated
	protected void add(Widget child, com.google.gwt.user.client.Element container) {
		super.add(child, container);
		if (child.getParent() == this) {
			Element elem = child.getElement();
			elem.getStyle().setProperty("position", "absolute");
			elem.getStyle().setProperty("left", 0 + "px");
			elem.getStyle().setProperty("top", 0 + "px");
			elem.getStyle().setProperty("right", 0 + "px");
			elem.getStyle().setProperty("bottom", 0 + "px");
		}
	}

	@Override
	public boolean remove(Widget w) {
		boolean removed = super.remove(w);
		if (removed) {
			Element elem = w.getElement();
			elem.getStyle().setProperty("left", "");
			elem.getStyle().setProperty("top", "");
			elem.getStyle().setProperty("right", "");
			elem.getStyle().setProperty("bottom", "");
			elem.getStyle().setProperty("position", "");
		}
		return removed;
	}
}

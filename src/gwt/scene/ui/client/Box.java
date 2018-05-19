package gwt.scene.ui.client;

import java.util.Objects;

import com.google.gwt.dom.client.Style;
import com.google.gwt.dom.client.Style.Overflow;

import gwt.scene.core.client.DOM;

public abstract class Box extends AbstractPanel {

	public Box() {
		this(false);
	}

	protected Box(boolean wrap) {
		setStyleName("flex");

		if (wrap) {
			addStyleDependentName("wrap");
		} else {
			addStyleDependentName("nowrap");
		}

		// Set default behavior.
		setDirection(Direction.HORIZONTAL);
		setAlignItems(AlignItems.STRETCH);
		setJustifyContent(JustifyContent.START);

		// Set overflow to hidden.
		Style style = getElement().getStyle();
		style.setOverflow(Overflow.HIDDEN);
	}

	protected Direction getDirection() {
		Direction result = null;
		for (Direction e : Direction.values()) {
			if (DOM.hasStyleName(this, e.getValue())) {
				result = e;
			} // XXX use last
		}
		return result;
	}

	protected void setDirection(Direction direction) {
		Direction oldDirection = getDirection();
		if (!Objects.equals(oldDirection, direction)) {
			if (oldDirection != null) {
				removeStyleName(oldDirection.getValue());
			}
			addStyleName(direction.getValue());
		}
	}

	public AlignItems getAlignItems() {
		AlignItems result = null;
		for (AlignItems e : AlignItems.values()) {
			if (DOM.hasStyleName(this, e.getValue())) {
				result = e;
			} // XXX use last
		}
		return result;
	}

	public void setAlignItems(AlignItems value) {
		AlignItems oldValue = getAlignItems();
		if (!Objects.equals(oldValue, value)) {
			if (oldValue != null) {
				removeStyleName(oldValue.getValue());
			}
			addStyleName(value.getValue());
		}
	}

	public JustifyContent getJustifyContent() {
		JustifyContent result = null;
		for (JustifyContent e : JustifyContent.values()) {
			if (DOM.hasStyleName(this, e.getValue())) {
				result = e;
			} // XXX use last
		}
		return result;
	}

	public void setJustifyContent(JustifyContent value) {
		JustifyContent oldValue = getJustifyContent();
		if (!Objects.equals(oldValue, value)) {
			if (oldValue != null) {
				removeStyleName(oldValue.getValue());
			}
			addStyleName(value.getValue());
		}
	}

	protected AlignContent getAlignContent() {
		AlignContent result = null;
		for (AlignContent e : AlignContent.values()) {
			if (DOM.hasStyleName(this, e.getValue())) {
				result = e;
			} // XXX use last
		}
		return result;
	}

	protected void setAlignContent(AlignContent value) {
		AlignContent oldValue = getAlignContent();
		if (!Objects.equals(oldValue, value)) {
			if (oldValue != null) {
				removeStyleName(oldValue.getValue());
			}
			addStyleName(value.getValue());
		}
	}
}

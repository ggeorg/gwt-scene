package gwt.scene.ui.client;

import java.util.Iterator;
import java.util.Objects;

import com.google.gwt.dom.client.Style;
import com.google.gwt.dom.client.Style.Overflow;
import com.google.gwt.user.client.ui.ProvidesResize;
import com.google.gwt.user.client.ui.RequiresResize;
import com.google.gwt.user.client.ui.Widget;

import gwt.scene.core.client.DOM;

public abstract class Box extends com.google.gwt.user.client.ui.FlowPanel
		implements SceneNode, RequiresResize, ProvidesResize {

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

	//
	// SceneNode implementation
	//

	@Override
	public String getFlex() {
		return DOM.getFlex(this);
	}

	@Override
	public void setFlex(String flex) {
		DOM.setFlex(this, flex);
	}

	@Override
	public String getMargin() {
		return DOM.getFlex(this);
	}

	@Override
	public void setMargin(String margin) {
		DOM.setMargin(this, margin);
	}

	@Override
	public String getBorder() {
		return DOM.getBorder(this);
	}

	@Override
	public void setBorder(String border) {
		DOM.setBorder(this, border);
	}

	@Override
	public String getPadding() {
		return DOM.getPadding(this);
	}

	@Override
	public void setPadding(String padding) {
		DOM.setPadding(this, padding);
	}

	@Override
	public String getBackground() {
		return DOM.getBackground(this);
	}

	@Override
	public void setBackground(String background) {
		DOM.setBackground(this, background);
	}

	//
	// RequiresResize implementation
	//

	@Override
	public void onResize() {
		for (Iterator<Widget> iter = iterator(); iter.hasNext();) {
			final Widget child = iter.next();
			if (child instanceof RequiresResize) {
				((RequiresResize) child).onResize();
			}
		}
	}
}

package gwt.scene.ui.client;

import com.google.gwt.dom.client.Element;

import gwt.scene.core.client.DOM;

public class Widget extends com.google.gwt.user.client.ui.Widget
		implements SceneNode/*, HasSelfAlign*/ {

	public Widget(Element element) {
		setElement(element);
	}

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
}

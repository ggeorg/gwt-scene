package gwt.scene.ui.client;

import java.util.Objects;

import gwt.scene.core.client.DOM;

public class TextArea extends com.google.gwt.user.client.ui.TextArea
		implements FormControl, SceneNode {

	public TextArea() {
		super();
		setStyleName("form-control");
	}

	@Override
	public String getId() {
		return getElement().getId();
	}

	@Override
	public void setId(String id) {
		String oldId = getId();
		if (!Objects.equals(oldId, id)) {
			getElement().setId(id);
		}
	}

	public String getPlaceholder() {
		return DOM.getAttribute(this, "placeholder");
	}

	public void setPlaceholder(String placeholder) {
		String oldPlaceholder = getPlaceholder();
		if (!Objects.equals(oldPlaceholder, placeholder)) {
			if (placeholder != null) {
				DOM.setAttribute(this, "placeholder", placeholder);
			} else {
				DOM.removeAttribute(this, "placeholder");
			}
		}
	}
	
	public Sizing getSizing() {
		Sizing result = null;
		for (Sizing e : Sizing.values()) {
			if (DOM.hasStyleDependentName(this, e.getValue())) {
				result = e;
			} // XXX use last
		}
		return result;
	}
	
	public void setSizing(Sizing value) {
		Sizing oldValue = getSizing();
		if (!Objects.equals(oldValue, value)) {
			if (oldValue != null) {
				removeStyleDependentName(oldValue.getValue());
			}
			addStyleDependentName(value.getValue());
		}
	}
	
	@Override
	public boolean isRequired() {
		return DOM.isRequired(this);
	}

	@Override
	public void setRequired(boolean required) {
		DOM.setRequired(this, required);
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
	// DOM attributes
	//

	private String attributes;

	@Override
	public String getAttributes() {
		return attributes;
	}

	@Override
	public void setAttributes(String data) {
		if (!Objects.equals(this.attributes, data)) {
			if (this.attributes != null) {
				DOM.removeAttributes(this, data);
			}
			this.attributes = data;
			if (this.attributes != null) {
				DOM.setAttributes(this, data);
			}
		}
	}
}

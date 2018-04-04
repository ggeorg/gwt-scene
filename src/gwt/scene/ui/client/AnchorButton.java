package gwt.scene.ui.client;

import java.util.Objects;

import gwt.scene.core.client.DOM;

public class AnchorButton extends com.google.gwt.user.client.ui.Anchor
		implements SceneNode, HasSelfAlign {

	public AnchorButton() {
		super(true);
	}

	public AnchorButton(boolean useDefaultHref) {
		super(useDefaultHref);
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
	// HasSelfAlign implementation
	//

	@Override
	public AlignItems getSelfAlign() {
		return DOM.getSelfAlign(this);
	}

	@Override
	public void setSelfAlign(AlignItems align) {
		AlignItems oldValue = getSelfAlign();
		if (!Objects.equals(oldValue, align)) {
			DOM.setSelfAlign(this, align);
		}
	}
}

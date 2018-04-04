package gwt.scene.ui.client;

import java.util.Objects;

import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.safehtml.shared.annotations.IsSafeHtml;

import gwt.scene.core.client.DOM;

public class Button extends com.google.gwt.user.client.ui.Button 
	implements SceneNode, HasSelfAlign {

	public Button() {
		super();
		initButton();
	}

	public Button(@IsSafeHtml String html) {
		super(html);
		initButton();
	}

	public Button(String html, ClickHandler clickHandler) {
		super(html, clickHandler);
		initButton();
	}

	private void initButton() {
		setStylePrimaryName("btn");
		setType(ButtonType.BUTTON);
		setStyle(ButtonStyle.PRIMARY);
	}

	public ButtonType getType() {
		return ButtonType.fromString(DOM.getAttribute(this, "type"));
	}

	public void setType(ButtonType type) {
		if (!Objects.equals(getType(), type)) {
			DOM.setAttribute(this, "type", type.getTypeName());
		}
	}

	public ButtonStyle getStyle() {
		ButtonStyle result = null;
		for (ButtonStyle buttonType : ButtonStyle.values()) {
			if (DOM.hasStyleDependentName(this, buttonType.getValue())) {
				result = buttonType;
			} // last is valid
		}
		return result;
	}

	public void setStyle(ButtonStyle style) {
		ButtonStyle oldStyle = getStyle();
		if (!Objects.equals(oldStyle, style)) {
			if (oldStyle != null) {
				removeStyleDependentName(oldStyle.getValue());
			}
			addStyleDependentName(style.getValue());
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

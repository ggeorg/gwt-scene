package gwt.scene.ui.client;

import java.util.Iterator;

import com.google.gwt.user.client.ui.ProvidesResize;
import com.google.gwt.user.client.ui.RequiresResize;
import com.google.gwt.user.client.ui.Widget;

import gwt.scene.core.client.DOM;

public abstract class AbstractPanel extends com.google.gwt.user.client.ui.FlowPanel
		implements SceneNode, RequiresResize, ProvidesResize {
	
	public AbstractPanel() {
		super();
	}
	
	public AbstractPanel(String tag) {
		super(tag);
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

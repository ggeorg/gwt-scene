package gwt.scene.ui.client;

import java.util.Iterator;

import com.google.gwt.dom.client.Style;
import com.google.gwt.dom.client.Style.Overflow;
import com.google.gwt.safehtml.shared.annotations.IsSafeHtml;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.ProvidesResize;
import com.google.gwt.user.client.ui.RequiresResize;
import com.google.gwt.user.client.ui.Widget;

import gwt.scene.core.client.DOM;

public class Container extends HTMLPanel 
	implements SceneNode, RequiresResize, ProvidesResize {

	private boolean fluid;
	
	public Container() {
		this(null);
	}
	
	public Container(@IsSafeHtml String html) {
		super(html);
		setStyleName("container-fluid");
		
		// Set overflow to auto.
		Style style = getElement().getStyle();
		style.setOverflow(Overflow.AUTO);
	}

	protected boolean isFluid() {
		return fluid;
	}

	protected void setFluid(boolean fluid) {
		this.fluid = fluid;
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

package gwt.scene.ui.client;

import com.google.gwt.uibinder.client.UiChild;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.SimplePanel;

import gwt.scene.core.client.DOM;

/**
 * 
 */
public class Card extends _Composite {

	private HTML header = null;

	public Card() {
		final VBox box = new VBox();
		initWidget(box);
		box.add(header = new HTML());
		header.addStyleName("card-header");
		header.addStyleName("hidden");
		addStyleName("card");
	}

	public String getHeader() {
		return header != null ? header.getHTML() : null;
	}

	public void setHeader(String header) {
		if (header != null) {
			this.header.setHTML(header);
			this.header.removeStyleName("hidden");
		} else {
			this.header.setHTML("");
			this.header.addStyleName("hidden");
		}
	}

	@UiChild(tagname = "body")
	public void addBody(IsWidget body) {
		addBody(body.asWidget());
	}

	@UiChild(tagname = "body")
	public void addBody(com.google.gwt.user.client.ui.Widget body) {
		body.addStyleName("card-body");
		DOM.setFlex(body, "1");
		((VBox) getWidget()).add(body);
	}
}

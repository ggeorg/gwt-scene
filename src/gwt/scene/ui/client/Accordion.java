package gwt.scene.ui.client;

import com.google.gwt.user.client.ui.Widget;

public class Accordion extends AbstractPanel {

	public Accordion() {
		super();
		setStyleName("accordion");
	}
	
	@Override
	protected void add(Widget child, com.google.gwt.user.client.Element container) {
		if (!(child instanceof Card)) {
			
		}
	}
}

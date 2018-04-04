package gwt.scene.ui.client;

import gwt.scene.core.client.DOM;

public class VBox extends Box {

	public VBox() {
		setDirection(Direction.VERTICAL);
	}

	public boolean isReverse() {
		return DOM.hasStyleName(this, Direction.VERTICAL_REVERSE.getValue());
	}

	public void setReverse(boolean reverse) {
		if (reverse) {
			setDirection(Direction.VERTICAL_REVERSE);
		} else {
			setDirection(Direction.VERTICAL);
		}
	}
}

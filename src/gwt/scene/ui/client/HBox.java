package gwt.scene.ui.client;

import gwt.scene.core.client.DOM;

public class HBox extends Box {

	public HBox() {
		setDirection(Direction.HORIZONTAL);
	}

	public boolean isReverse() {
		return DOM.hasStyleName(this, Direction.HORIZONTAL_REVERSE.getValue());
	}

	public void setReverse(boolean reverse) {
		if (reverse) {
			setDirection(Direction.HORIZONTAL_REVERSE);
		} else {
			setDirection(Direction.HORIZONTAL);
		}
	}
}

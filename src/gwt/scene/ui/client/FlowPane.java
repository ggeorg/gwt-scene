package gwt.scene.ui.client;

import com.google.gwt.dom.client.Style;
import com.google.gwt.dom.client.Style.Overflow;

public class FlowPane extends Box {

	public FlowPane() {
		super(true);
		
		// Set default behavior.
		setJustifyContent(JustifyContent.START);
		setAlignContent(AlignContent.START);
		
		// Set overflow to auto.
		Style style = getElement().getStyle();
		style.setOverflow(Overflow.AUTO);
	}

	@Override
	public Direction getDirection() {
		return super.getDirection();
	}

	@Override
	public void setDirection(Direction direction) {
		super.setDirection(direction);
	}
	
	@Override
	public AlignContent getAlignContent() {
		return super.getAlignContent();
	}

	@Override
	public void setAlignContent(AlignContent alignContent) {
		super.setAlignContent(alignContent);
	}
}

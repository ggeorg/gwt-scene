package gwt.scene.ui.client;

import com.google.gwt.dom.client.Style;
import com.google.gwt.dom.client.Style.Overflow;
import com.google.gwt.uibinder.client.UiChild;
import com.google.gwt.user.client.ui.HasOneWidget;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;

/**
 * Base class for panels that contain only one widget.
 */
public class Bin extends _Composite implements HasOneWidget {

	public Bin() {
		HBox box = new HBox();
		box.setJustifyContent(JustifyContent.CENTER);
		box.setAlignItems(AlignItems.CENTER);
		initWidget(box);

		// Set overflow to visible.
		Style style = getElement().getStyle();
		style.setOverflow(Overflow.VISIBLE);
	}

	public Bin(Widget child) {
		this();
		setWidget(child);
	}

	@Override
	public Widget getWidget() {
		HBox box = (HBox) super.getWidget();
		if (box.getWidgetCount() > 0) {
			return box.getWidget(0);
		} else {
			return null;
		}
	}

	@Override
	public void setWidget(IsWidget w) {
		setWidget(w != null ? w.asWidget() : null);
	}

	@UiChild(tagname = "widget")
	@Override
	public void setWidget(Widget widget) {
		HBox box = (HBox) super.getWidget();
		
		// Can't add() more than one widget to a SimplePanel.
		if (getWidget() != null) {
			box.clear();
		}

		box.add(widget);
	}
	
	public AlignItems getAlignItems() {
		HBox box = (HBox) super.getWidget();
		return box.getAlignItems();
	}

	public void setAlignItems(AlignItems value) {
		HBox box = (HBox) super.getWidget();
		box.setAlignItems(value);
	}

	public JustifyContent getJustifyContent() {
		HBox box = (HBox) super.getWidget();
		return box.getJustifyContent();
	}

	public void setJustifyContent(JustifyContent value) {
		HBox box = (HBox) super.getWidget();
		box.setJustifyContent(value);
	}
}

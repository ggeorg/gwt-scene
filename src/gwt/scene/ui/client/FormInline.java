package gwt.scene.ui.client;

import com.google.gwt.safehtml.shared.annotations.IsSafeHtml;

public class FormInline extends Form {

	public FormInline() {
		this(null);
	}

	public FormInline(@IsSafeHtml String html) {
		super(html);
		setStyleName("form-inline");
	}
}

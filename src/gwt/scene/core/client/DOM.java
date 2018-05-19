package gwt.scene.core.client;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;

import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.Widget;

import gwt.scene.ui.client.AlignItems;
import gwt.scene.ui.client.FormControl;

public class DOM {

	//
	// CSS
	//

	public static String getCss(Widget w, String name) {
		return getCss(w.getElement(), name);
	}

	public static String getCss(Element element, String name) {
		return element.getStyle().getProperty(name);
	}

	public static void setCss(Widget w, String name, String value) {
		setCss(w.getElement(), name, value);
	}

	public static void setCss(Element element, String name, String value) {
		element.getStyle().setProperty(name, value);
	}

	//
	// attributes
	//

	public static String getAttribute(Widget w, String name) {
		return getAttribute(w.getElement(), name);
	}

	public static String getAttribute(Element element, String name) {
		return element.getAttribute(name);
	}

	public static void setAttribute(Widget w, String name, String value) {
		setAttribute(w.getElement(), name, value);
	}

	public static void setAttribute(Element element, String name, String value) {
		element.setAttribute(name, value);
	}

	public static void removeAttribute(Widget w, String name) {
		removeAttribute(w.getElement(), name);
	}

	public static native void removeAttribute(Element element, String name) /*-{
		$wnd.jQuery(element).removeAttr(name);
	}-*/;

	//
	// styleName
	//

	public static boolean hasStyleName(Widget w, String styleName) {
		return hasClass(w.getElement(), styleName);
	}

	public static boolean hasStyleDependentName(Widget w, String styleName) {
		return hasClass(w.getElement(), w.getStylePrimaryName() + "-" + styleName);
	}

	public static native boolean hasClass(Element elem, String className) /*-{
		return className != null ? $wnd.jQuery(elem).hasClass(className)
				: false;
	}-*/;

	//
	// flex
	//

	public static String getFlex(Widget w) {
		return DOM.getCss(w, "flex");
	}

	public static void setFlex(Widget w, String flex) {
		if (!Objects.equals(getFlex(w), flex)) {
			DOM.setCss(w, "flex", flex);
		}
	}

	//
	// margin
	//

	public static String getMargin(Widget w) {
		return DOM.getCss(w, "margin");
	}

	public static void setMargin(Widget w, String margin) {
		if (!Objects.equals(getMargin(w), margin)) {
			DOM.setCss(w, "margin", margin);
		}
	}

	//
	// border
	//

	public static String getBorder(Widget w) {
		return DOM.getCss(w, "border");
	}

	public static void setBorder(Widget w, String border) {
		if (!Objects.equals(getBorder(w), border)) {
			DOM.setCss(w, "border", border);
		}
	}

	//
	// padding
	//

	public static String getPadding(Widget w) {
		return DOM.getCss(w, "padding");
	}

	public static void setPadding(Widget w, String padding) {
		if (!Objects.equals(getPadding(w), padding)) {
			DOM.setCss(w, "padding", padding);
		}
	}

	//
	// background
	//

	public static String getBackground(Widget w) {
		return DOM.getCss(w, "background");
	}

	public static void setBackground(Widget w, String background) {
		if (!Objects.equals(getBackground(w), background)) {
			DOM.setCss(w, "background", background);
		}
	}

	//
	// self-align
	//

	public static AlignItems getSelfAlign(Widget w) {
		AlignItems align = null;
		for (AlignItems e : AlignItems.values()) {
			String value = "align-self-" + e.getValue();
			if (DOM.hasStyleName(w, value)) {
				align = e;
			}
		}
		return align; // last match
	}

	public static void setSelfAlign(Widget w, AlignItems align) {
		for (AlignItems e : AlignItems.values()) {
			String value = "align-self-" + e.getValue();
			if (DOM.hasStyleName(w, value)) {
				w.removeStyleName(value);
			}
		}
		if (align != null) {
			w.addStyleName("align-self-" + align.getValue());
		}
	}

	//
	// attributes
	//

	public static void removeAttributes(Widget w, String attributes) {
		Map<String, String> map = parseAttributes(attributes);
		for (Entry<String, String> entry : map.entrySet()) {
			removeAttribute(w, entry.getKey());
		}
	}

	public static void setAttributes(Widget w, String attributes) {
		Map<String, String> map = parseAttributes(attributes);
		for (Entry<String, String> entry : map.entrySet()) {
			setAttribute(w, entry.getKey(), entry.getValue());
		}
	}

	private static Map<String, String> parseAttributes(String attributes) {
		Map<String, String> map = new HashMap<>();
		String[] _attributes = attributes.split(";");
		if (_attributes != null && _attributes.length > 0) {
			for (String attribute : _attributes) {
				attribute = trimToNull(attribute);
				if (attribute != null && attribute.contains(":")) {
					String[] _attribute = attribute.split(":");
					if (_attribute != null && _attribute.length == 2) {
						String key = trimToNull(_attribute[0]);
						if (key != null) {
							String value = trimToNull(_attribute[1]);
							if (value != null) {
								map.put(key, value);
							}
						}
					}
				}
			}
		}
		return map;
	}

	private static String trimToNull(String s) {
		String result = null;
		if (s != null) {
			result = s.trim();
			if (result.length() > 0) {
				return result;
			}
		}
		return result;
	}

	//
	// required (form fields)
	//

	public static boolean isRequired(FormControl formControl) {
		return formControl.asWidget()
				.getElement().getPropertyBoolean("required");
	}

	public static void setRequired(FormControl formControl, boolean required) {
		formControl.asWidget()
				.getElement().setPropertyBoolean("required", required);
	}
	
	//
	// CSS: pinter-events 
	//

	/**
	 * The {@code pointer-events} CSS property
	 * @param w
	 * @param string
	 */
	public static void setPointerEvents(Widget w, String value) {
		setPointerEvents(w.getElement(), value);
	}

	public static void setPointerEvents(Element element, String value) {
		setCss(element, "pointerEvents", value);
	}
}

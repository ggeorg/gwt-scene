package gwt.scene.ui.client;

public enum ButtonStyle {
	//@formatter:off
	PRIMARY("primary"),
	SECONDARY("secondary"), 
	SUCCESS("success"), 
	DANGER("danger"),
	WARNING("warning"), 
	INFO("info"), 
	LIGHT("light"), 
	DARK("dark"),
	
	OUTLINE_PRIMARY("outline-primary"),
	OUTLINE_SECONDARY("outline-secondary"), 
	OUTLINE_SUCCESS("outline-success"), 
	OUTLINE_DANGER("outline-danger"),
	OUTLINE_WARNING("outline-warning"), 
	OUTLINE_INFO("outline-info"), 
	OUTLINE_LIGHT("outline-light"), 
	OUTLINE_DARK("outline-dark"), 
	
	LINK("link");
	//@formatter:on

	private final String value;

	ButtonStyle(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public static ButtonStyle fromString(String styleName) {
		for (ButtonStyle e : ButtonStyle.values()) {
			if (e.value.equals(styleName)) {
				return e;
			}
		}
		return null;
	}
}

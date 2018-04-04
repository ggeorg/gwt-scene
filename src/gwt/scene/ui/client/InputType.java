package gwt.scene.ui.client;

public enum InputType {

	//@formatter:off
	TEXT("text"),
	PASSWORD("password"),
	HIDDEN("hidden"),
	FILE("file"),
	EMAIL("email");
	//@formatter:on

	private final String value;

	InputType(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public static InputType fromString(String value) {
		for (InputType e : InputType.values()) {
			if (e.value.equals(value)) {
				return e;
			}
		}
		return null;
	}
}

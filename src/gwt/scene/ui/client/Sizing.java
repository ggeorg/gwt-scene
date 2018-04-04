package gwt.scene.ui.client;

public enum Sizing {

	/** */
	LARGE("lg"),
	
	/** */
	DEFAULT("no-sizing"),
	
	/** */
	SMALL("sm");

	private final String value;

	Sizing(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public static Sizing fromString(String value) {
		for (Sizing e : Sizing.values()) {
			if (e.value.equals(value)) {
				return e;
			}
		}
		return null;
	}
}

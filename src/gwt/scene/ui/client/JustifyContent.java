package gwt.scene.ui.client;

/**
 * Defines how space is distributed between and around items along the main axis
 * of their container.
 * 
 * @author ggeorg
 */
public enum JustifyContent {
	
	/**
	 * Items are positioned at the beginning of the container.
	 */
	START("justify-content-start"), 
	
	/**
	 * Items are positioned at the end of the container.
	 */
	END("justify-content-end"), 
	
	/**
	 * Items are positioned at the center of the container.
	 */
	CENTER("justify-content-center"), 
	
	/**
	 * Items are positioned with space between the lines.
	 */
	SPACE_BETWEEN("justify-content-space-between"),
	
	/**
	 * Items are positioned with space before, between, and after the lines.
	 */
	SPACE_AROUND("justify-content-space-around");
	
	private final String value;

	JustifyContent(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public static JustifyContent fromString(String value) {
		for (JustifyContent e : JustifyContent.values()) {
			if (e.value.equals(value)) {
				return e;
			}
		}
		return null;
	}
}

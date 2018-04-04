package gwt.scene.ui.client;

/**
 * Defines how space is distributed between and around items along the
 * cross-axis of their container.
 * 
 * @author ggeorg
 */
public enum AlignItems {

	/**
	 * Items are stretched to fit the container.
	 */
	STRETCH("align-items-stretch"),
	
	/**
	 * Items are positioned at the center of the container.
	 */
	CENTER("align-items-center"), 
	
	/**
	 * Items are positioned at the beginning of the container.
	 */
	START("align-items-flex-start"), 
	
	/**
	 * Items are positioned at the end of the container.
	 */
	END("align-items-flex-end"), 
	
	/**
	 * Items are positioned at the baseline of the container.
	 */
	BASELINE("align-items-baseline");

	private final String value;

	AlignItems(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public static AlignItems fromString(String value) {
		for (AlignItems e : AlignItems.values()) {
			if (e.value.equals(value)) {
				return e;
			}
		}
		return null;
	}
}

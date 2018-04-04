package gwt.scene.ui.client;

/**
 * Defines how space is distributed between and around content items along the
 * cross-axis of their container.
 * <p>
 * Note: this property has no effect on single line flexible boxes.
 * 
 * @author ggeorg
 */
public enum AlignContent {

	/**
	 * Lines stretch to take up the remaining space.
	 */
	STRETCH("align-content-stretch"),

	/**
	 * Lines are packed toward the center of the container.
	 */
	CENTER("align-content-center"),

	/**
	 * Lines are packed toward the start of the container.
	 */
	START("align-content-start"),

	/**
	 * Lines are packed toward the end of the container.
	 */
	END("align-content-end"),

	/**
	 * Lines are evenly distributed in the container.
	 */
	SPACE_BETWEEN("align-content-space-between"),

	/**
	 * Lines are evenly distributed in the container, with half-size spaces on
	 * either end.
	 */
	SPACE_AROUND("align-content-space-around");

	private final String value;

	AlignContent(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public static AlignContent fromString(String value) {
		for (AlignContent e : AlignContent.values()) {
			if (e.value.equals(value)) {
				return e;
			}
		}
		return null;
	}
}

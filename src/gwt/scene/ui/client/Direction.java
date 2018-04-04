package gwt.scene.ui.client;

/**
 * The {@code flex-direction} CSS property specifies how flex items are placed
 * in the flex container defining the main axis and the direction (normal or
 * reversed).
 * 
 * @author ggeorg
 */
public enum Direction {

	/**
	 * Default value. The flexible items are displayed horizontally, as a row.
	 */
	HORIZONTAL("direction-row"),

	/**
	 * Same as row, but in reverse order.
	 */
	HORIZONTAL_REVERSE("direction-row-reverse"),

	/**
	 * The flexible items are displayed vertically, as a column.
	 */
	VERTICAL("direction-column"),

	/**
	 * Same as column, but in reverse order.
	 */
	VERTICAL_REVERSE("direction-column-reverse");

	private final String value;

	Direction(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public static Direction fromString(String value) {
		for (Direction e : Direction.values()) {
			if (e.value.equals(value)) {
				return e;
			}
		}
		return null;
	}
}

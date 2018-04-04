package gwt.scene.ui.client;

public enum ButtonType {
	BUTTON("button"), 
	RESET("reset"), 
	SUBMIT("submit");
	
	private final String typeName;
	
	ButtonType(String typeName) {
		this.typeName = typeName;
	}

	public String getTypeName() {
		return typeName;
	}
	
	public static ButtonType fromString(String typeName) {
		for (ButtonType buttonType : ButtonType.values()) {
			if (buttonType.typeName.equals(typeName)) {
				return buttonType;
			}
		}
		return null;
	}
}

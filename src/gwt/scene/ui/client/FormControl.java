package gwt.scene.ui.client;

import com.google.gwt.user.client.ui.IsWidget;

public interface FormControl extends IsWidget {

	String getId();

	void setId(String id);

	boolean isRequired();

	void setRequired(boolean required);

	String getAttributes();

	void setAttributes(String attributes);

}

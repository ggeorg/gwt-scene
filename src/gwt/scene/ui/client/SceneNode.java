package gwt.scene.ui.client;

import com.google.gwt.user.client.ui.IsWidget;

public interface SceneNode extends IsWidget {

	String getFlex();

	void setFlex(String flex);
	
	String getMargin();
	
	void setMargin(String margin);
	
	String getBorder();
	
	void setBorder(String border);
	
	String getPadding();
	
	void setPadding(String padding);
	
	String getBackground();
	
	void setBackground(String background);
	
	// TODO color/opacity
}

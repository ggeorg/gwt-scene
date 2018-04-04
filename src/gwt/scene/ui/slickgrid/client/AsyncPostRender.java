package gwt.scene.ui.slickgrid.client;

import com.google.gwt.dom.client.Element;

import gwt.scene.core.client.collections.JsObject;

public interface AsyncPostRender {
	void render(Element cellNode, int row, JsObject dataContext, TableColumn columnDef);
}

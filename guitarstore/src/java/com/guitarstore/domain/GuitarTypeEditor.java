package com.guitarstore.domain;

import com.guitarstore.service.GuitarService;
import java.beans.PropertyEditorSupport;

/**
 * This is an editor to convert a GuitarType ID into a
 * GuitarType object. In order to do so, itemValue on the option items
 * in the JSP must be populated with the ID. Register this custom editor in a
 * controller method that's annotated with @InitBinder.
 *
 * @author jenkinset
 */
public class GuitarTypeEditor extends PropertyEditorSupport {
	private GuitarService guitarService;

	public GuitarTypeEditor(GuitarService guitarService) {
		this.guitarService = guitarService;
	}

	/**
	 * Convert a GuitarType ID into a GuitarType object.
	 * 
	 * @param text
	 * @throws IllegalArgumentException
	 */
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		int guitarTypeId = Integer.parseInt(text);
		GuitarType guitarType = guitarService.getGuitarType(guitarTypeId);
		setValue(guitarType);
	}

	@Override
	public String getAsText() {
		GuitarType gt = (GuitarType)getValue();
		if(gt == null) {
			return null;
		} else {
			return Integer.toString(gt.getId());
		}
	}
}

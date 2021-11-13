package com.priyank.lc.propertyeditor;

import java.beans.PropertyEditorSupport;


public class NamePropertyEditor extends PropertyEditorSupport{

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		
		String myConvertedString = text.toUpperCase();
		setValue(myConvertedString);
	}
	
}

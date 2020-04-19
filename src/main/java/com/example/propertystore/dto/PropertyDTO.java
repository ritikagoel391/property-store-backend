package com.example.propertystore.dto;

/**
 * This is a DTO class for entity - {@link Property}.
 * 
 * @author ritika.goel
 *
 */
public class PropertyDTO {
	private String propertyName;
	private String propertyValue;

	public PropertyDTO(String propertyName, String propertyValue) {
		super();
		this.propertyName = propertyName;
		this.propertyValue = propertyValue;
	}

	public String getPropertyName() {
		return propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	public String getPropertyValue() {
		return propertyValue;
	}

	public void setPropertyValue(String propertyValue) {
		this.propertyValue = propertyValue;
	}
}

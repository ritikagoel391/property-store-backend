package com.example.propertystore.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.model.BaseResponse;
import com.example.propertystore.entity.Property;
import com.example.propertystore.service.PropertyStoreService;

public class PropertyStoreControllerImpl implements PropertyStoreController {
	
	@Autowired
	PropertyStoreService propertyStoreService;

	@Override
	public BaseResponse addProperty(Property property) {
		return propertyStoreService.addProperty(property);
	}
	
	@Override
	public BaseResponse editProperty(Property property) {
		return propertyStoreService.editProperty(property);
	}

	@Override
	public BaseResponse deleteProperty(String propertyName) {
		return propertyStoreService.deleteProperty(propertyName);
	}

	@Override
	public BaseResponse getProperty(String propertyName) {
		return propertyStoreService.getProperty(propertyName);
	}

	@Override
	public BaseResponse getProperties() {
		return propertyStoreService.getProperties();
	}

}

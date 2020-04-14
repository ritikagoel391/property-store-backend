package com.example.propertystore.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.model.BaseResponse;
import com.example.propertystore.entity.Property;
import com.example.propertystore.service.PropertyStoreService;

/**
 * This is the implementation of controller class that facilitates CRUD
 * operations for the property-store application.
 * 
 * @author ritika.goel
 *
 */
public class PropertyStoreControllerImpl implements PropertyStoreController {

	@Autowired
	PropertyStoreService propertyStoreService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public BaseResponse addProperty(Property property) {
		return propertyStoreService.addProperty(property);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public BaseResponse editProperty(Property property) {
		return propertyStoreService.editProperty(property);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public BaseResponse deleteProperty(String propertyName) {
		return propertyStoreService.deleteProperty(propertyName);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public BaseResponse getProperty(String propertyName) {
		return propertyStoreService.getProperty(propertyName);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public BaseResponse getProperties() {
		return propertyStoreService.getProperties();
	}

}

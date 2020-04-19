package com.example.propertystore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.exception.ApplicationException;
import com.example.propertystore.constants.PropertyStoreApiName;
import com.example.propertystore.dto.PropertyDTO;
import com.example.propertystore.entity.Property;
import com.example.propertystore.service.PropertyStoreService;
import com.example.response.ResponseUtil;
import com.example.response.model.ApplicationResponse;

/**
 * This is the implementation of controller class that facilitates CRUD
 * operations for the property-store application.
 * 
 * @author ritika.goel
 *
 */
@RestController
public class PropertyStoreControllerImpl implements PropertyStoreController {

	@Autowired
	PropertyStoreService propertyStoreService;

	/**
	 * {@inheritDoc}
	 * 
	 */
	@Override
	public ApplicationResponse<PropertyDTO> addProperty(Property property) throws ApplicationException {
		return ResponseUtil.createApplicationResponse(PropertyStoreApiName.PROPERTY_STORE_ADD_PROPERTY.toString(),
				propertyStoreService.addProperty(property, PropertyStoreApiName.PROPERTY_STORE_ADD_PROPERTY.toString()));
	}

	/**
	 * {@inheritDoc}
	 * 
	 */
	@Override
	public ApplicationResponse<PropertyDTO> editProperty(PropertyDTO property) throws ApplicationException {
		return ResponseUtil.createApplicationResponse(PropertyStoreApiName.PROPERTY_STORE_EDIT_PROPERTY.toString(),
				propertyStoreService.editProperty(property, PropertyStoreApiName.PROPERTY_STORE_EDIT_PROPERTY.toString()));
	}

	/**
	 * {@inheritDoc}
	 * 
	 */
	@Override
	public ApplicationResponse<PropertyDTO> deleteProperty(String propertyName) throws ApplicationException {
		return ResponseUtil.createApplicationResponse(PropertyStoreApiName.PROPERTY_STORE_DELETE_PROPERTY.toString(),
				propertyStoreService.deleteProperty(propertyName, PropertyStoreApiName.PROPERTY_STORE_DELETE_PROPERTY.toString()));
	}

	/**
	 * {@inheritDoc}
	 * 
	 */
	@Override
	public ApplicationResponse<PropertyDTO> getProperty(String propertyName) throws ApplicationException {
		return ResponseUtil.createApplicationResponse(PropertyStoreApiName.PROPERTY_STORE_GET_PROPERTY.toString(),
				propertyStoreService.getProperty(propertyName, PropertyStoreApiName.PROPERTY_STORE_GET_PROPERTY.toString()));
	}

	/**
	 * {@inheritDoc}
	 * 
	 */
	@Override
	public ApplicationResponse<List<PropertyDTO>> getProperties() throws ApplicationException {
		return ResponseUtil.createApplicationResponse(PropertyStoreApiName.PROPERTY_STORE_GET_PROPERTIES.toString(),
				propertyStoreService.getProperties(PropertyStoreApiName.PROPERTY_STORE_GET_PROPERTIES.toString()));
	}

}

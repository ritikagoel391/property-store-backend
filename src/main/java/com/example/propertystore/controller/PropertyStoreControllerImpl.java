package com.example.propertystore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.constants.ApiResponseCode;
import com.example.constants.Status;
import com.example.exception.ApplicationException;
import com.example.exception.ApplicationExceptionHelper;
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

	@Autowired
	ApplicationExceptionHelper exceptionHelper;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ApplicationResponse addProperty(Property property) {
		return propertyStoreService.addProperty(property);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ApplicationResponse editProperty(Property property) {
		return propertyStoreService.editProperty(property);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ApplicationResponse deleteProperty(String propertyName) {
		return propertyStoreService.deleteProperty(propertyName);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ApplicationResponse getProperty(String propertyName) {
		return propertyStoreService.getProperty(propertyName);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @throws ApplicationException
	 */
	@Override
	public ApplicationResponse<List<PropertyDTO>> getProperties() throws ApplicationException {
		ApplicationResponse<List<PropertyDTO>> response = null;
		try {
			response = ResponseUtil.createApplicationResponse(
					PropertyStoreApiName.PROPERTY_STORE_GET_PROPERTIES.toString(),
					propertyStoreService.getProperties());
		} catch (Exception e) {
			exceptionHelper.raiseApplicationException(HttpStatus.INTERNAL_SERVER_ERROR, Status.FAILURE,
					ApiResponseCode.INTERNAL_SERVER_ERROR,
					PropertyStoreApiName.PROPERTY_STORE_GET_PROPERTIES.toString(), null);
		}
		return response;
	}

}

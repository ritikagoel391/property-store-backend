package com.example.propertystore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.constants.ApiResponseCode;
import com.example.constants.Status;
import com.example.exception.ApplicationException;
import com.example.exception.ApplicationExceptionHelper;
import com.example.model.BaseResponse;
import com.example.propertystore.entity.Property;
import com.example.propertystore.repository.PropertyRepository;

/**
 * This is the implementation of service class that facilitates CRUD operations
 * for the property-store application.
 * 
 * @author ritika.goel
 *
 */
@Service
public class PropertyStoreServiceImpl implements PropertyStoreService {

	@Autowired
	PropertyRepository propertyStoreRepository;

	@Autowired
	ApplicationExceptionHelper exceptionHelper;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public BaseResponse addProperty(Property property) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public BaseResponse editProperty(Property property) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public BaseResponse deleteProperty(String propertyName) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public BaseResponse getProperty(String propertyName) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 * @throws ApplicationException 
	 */
	@Override
	public BaseResponse getProperties() throws ApplicationException {
		exceptionHelper.raiseApplicationException(HttpStatus.INTERNAL_SERVER_ERROR, Status.FAILURE,
				ApiResponseCode.INTERNAL_SERVER_ERROR, "PROPERTY_STORE:GET_PROPERTIES", null);
		return null;
	}
}

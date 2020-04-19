package com.example.propertystore.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.constants.ApiResponseCode;
import com.example.constants.Status;
import com.example.exception.ApplicationException;
import com.example.exception.ApplicationExceptionHelper;
import com.example.propertystore.constants.PropertyStoreApiName;
import com.example.propertystore.constants.PropertyStoreConstants;
import com.example.propertystore.dto.PropertyDTO;
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
	ApplicationExceptionHelper exceptionHelper;

	@Autowired
	PropertyRepository propertyStoreRepository;

	/**
	 * {@inheritDoc}
	 *
	 */
	@Override
	public PropertyDTO addProperty(Property property) throws ApplicationException {
		PropertyDTO propDTO = null;
		try {
			Property prop = propertyStoreRepository.save(property);
			propDTO = new PropertyDTO(prop.getPropertyName(), prop.getPropertyValue());
		} catch (Exception e) {
			sendExceptionResponse(HttpStatus.INTERNAL_SERVER_ERROR, Status.FAILURE, ApiResponseCode.INTERNAL_SERVER_ERROR, PropertyStoreApiName.PROPERTY_STORE_ADD_PROPERTY.toString(),
					e.getMessage());
		}
		return propDTO;
	}

	/**
	 * {@inheritDoc}
	 * 
	 */
	@Override
	public PropertyDTO editProperty(PropertyDTO property) throws ApplicationException {
		PropertyDTO propDTO = null;
		try {
			Optional<Property> propOpt = propertyStoreRepository.findByPropertyName(property.getPropertyName());
			if (propOpt.isPresent()) {
				Property prop = propOpt.get();
				prop.setPropertyValue(property.getPropertyValue());
				propDTO = this.addProperty(prop);
			} else {
				sendExceptionResponse(HttpStatus.OK, Status.SUCCESS, ApiResponseCode.NOT_FOUND, PropertyStoreApiName.PROPERTY_STORE_EDIT_PROPERTY.toString(),
						PropertyStoreConstants.MSG_NO_PROP_FOUND + property.getPropertyName());
			}
		} catch (Exception e) {
			sendExceptionResponse(HttpStatus.INTERNAL_SERVER_ERROR, Status.FAILURE, ApiResponseCode.INTERNAL_SERVER_ERROR, PropertyStoreApiName.PROPERTY_STORE_EDIT_PROPERTY.toString(),
					e.getMessage());
		}
		return propDTO;
	}

	/**
	 * {@inheritDoc}
	 * 
	 */
	@Override
	public PropertyDTO deleteProperty(String propertyName) throws ApplicationException {
		PropertyDTO propDTO = null;
		try {
			Optional<Property> propOpt = propertyStoreRepository.deleteByPropertyName(propertyName);
			if (propOpt.isPresent()) {
				Property prop = propOpt.get();
				propDTO = new PropertyDTO(prop.getPropertyName(), prop.getPropertyValue());
			} else {
				sendExceptionResponse(HttpStatus.OK, Status.SUCCESS, ApiResponseCode.NOT_FOUND, PropertyStoreApiName.PROPERTY_STORE_DELETE_PROPERTY.toString(),
						PropertyStoreConstants.MSG_NO_PROP_FOUND + propertyName);
			}
		}catch (Exception e) {
			sendExceptionResponse(HttpStatus.INTERNAL_SERVER_ERROR, Status.FAILURE, ApiResponseCode.INTERNAL_SERVER_ERROR, PropertyStoreApiName.PROPERTY_STORE_DELETE_PROPERTY.toString(),
					e.getMessage());
		}
		return propDTO;
	}

	/**
	 * {@inheritDoc}
	 * 
	 */
	@Override
	public PropertyDTO getProperty(String propertyName) throws ApplicationException {
		PropertyDTO propDTO = null;
		try {
			Optional<Property> propOpt = propertyStoreRepository.findByPropertyName(propertyName);
			if (propOpt.isPresent()) {
				Property prop = propOpt.get();
				propDTO = new PropertyDTO(prop.getPropertyName(), prop.getPropertyValue());
			} else {
				sendExceptionResponse(HttpStatus.OK, Status.SUCCESS, ApiResponseCode.NOT_FOUND, PropertyStoreApiName.PROPERTY_STORE_GET_PROPERTY.toString(),
						PropertyStoreConstants.MSG_NO_PROP_FOUND + propertyName);
			}
		} catch (Exception e) {
			sendExceptionResponse(HttpStatus.INTERNAL_SERVER_ERROR, Status.FAILURE, ApiResponseCode.INTERNAL_SERVER_ERROR, PropertyStoreApiName.PROPERTY_STORE_GET_PROPERTY.toString(),
					e.getMessage());
		}
		return propDTO;
	}

	/**
	 * {@inheritDoc}
	 *
	 */
	@Override
	public List<PropertyDTO> getProperties() throws ApplicationException {
		List<PropertyDTO> propDtoList = null;
		try {
			List<Property> propList = propertyStoreRepository.findAll();
			propDtoList = propList.stream().map(prop -> new PropertyDTO(prop.getPropertyName(), prop.getPropertyValue()))
					.collect(Collectors.toList());
		}catch (Exception e) {
			sendExceptionResponse(HttpStatus.INTERNAL_SERVER_ERROR, Status.FAILURE, ApiResponseCode.INTERNAL_SERVER_ERROR, PropertyStoreApiName.PROPERTY_STORE_GET_PROPERTY.toString(),
					e.getMessage());
		}
		return propDtoList;
	}
	
	/**
	 * Generic method to send exception response for this service.
	 * 
	 * @param httpStatus
	 * @param status
	 * @param apiResponseCode
	 * @param apiName
	 * @param message
	 * @throws ApplicationException
	 */
	private void sendExceptionResponse(HttpStatus httpStatus, Status status, ApiResponseCode apiResponseCode, String apiName, String message) throws ApplicationException {
		exceptionHelper.raiseApplicationException(httpStatus, status, apiResponseCode,	apiName,
				exceptionHelper.addErrorSourceToList(apiName, message));
	}
}

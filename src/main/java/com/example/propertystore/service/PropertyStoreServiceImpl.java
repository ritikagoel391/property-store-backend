package com.example.propertystore.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.constants.ApiResponseCode;
import com.example.constants.Status;
import com.example.exception.ApplicationException;
import com.example.exception.ApplicationExceptionHelper;
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
	@Transactional(rollbackOn = Exception.class)
	public PropertyDTO addProperty(Property property, String apiName) throws ApplicationException {
		PropertyDTO propDTO = null;
		try {
			Property prop = propertyStoreRepository.save(property);
			propDTO = new PropertyDTO(prop.getPropertyName(), prop.getPropertyValue());
		} catch (RuntimeException e) {
			sendExceptionResponse(HttpStatus.INTERNAL_SERVER_ERROR, Status.FAILURE, ApiResponseCode.INTERNAL_SERVER_ERROR, apiName, e.getMessage());
		}
		return propDTO;
	}

	/**
	 * {@inheritDoc}
	 * 
	 */
	@Override
	@Transactional(rollbackOn = Exception.class)
	public PropertyDTO editProperty(PropertyDTO property, String apiName) throws ApplicationException {
		PropertyDTO propDTO = null;
		try {
			Optional<Property> propOpt = propertyStoreRepository.findByPropertyName(property.getPropertyName());
			if (propOpt.isPresent()) {
				Property prop = propOpt.get();
				prop.setPropertyValue(property.getPropertyValue());
				propDTO = this.addProperty(prop, apiName);
			} else {
				sendExceptionResponse(HttpStatus.OK, Status.SUCCESS, ApiResponseCode.NOT_FOUND, apiName, PropertyStoreConstants.MSG_NO_PROP_FOUND + property.getPropertyName());
			}
		} catch (RuntimeException e) {
			sendExceptionResponse(HttpStatus.INTERNAL_SERVER_ERROR, Status.FAILURE, ApiResponseCode.INTERNAL_SERVER_ERROR, apiName, e.getMessage());
		}
		return propDTO;
	}

	/**
	 * {@inheritDoc}
	 * 
	 */
	@Override
	@Transactional(rollbackOn = Exception.class)
	public PropertyDTO deleteProperty(String propertyName, String apiName) throws ApplicationException {
		PropertyDTO prop = null;
		try {
			prop = this.getProperty(propertyName, apiName);
			Optional<Integer> deleteCountOpt = propertyStoreRepository.deleteByPropertyName(propertyName);
			if (deleteCountOpt.isPresent() && deleteCountOpt.get() <= 0) {
				sendExceptionResponse(HttpStatus.OK, Status.SUCCESS, ApiResponseCode.NOT_FOUND, apiName, PropertyStoreConstants.MSG_NO_PROP_FOUND + propertyName);
			}
		}catch (RuntimeException e) {
			sendExceptionResponse(HttpStatus.INTERNAL_SERVER_ERROR, Status.FAILURE, ApiResponseCode.INTERNAL_SERVER_ERROR, apiName, e.getMessage());
		}
		return prop;
	}

	/**
	 * {@inheritDoc}
	 * 
	 */
	@Override
	public PropertyDTO getProperty(String propertyName, String apiName) throws ApplicationException {
		PropertyDTO propDTO = null;
		try {
			Optional<Property> propOpt = propertyStoreRepository.findByPropertyName(propertyName);
			if (propOpt.isPresent()) {
				Property prop = propOpt.get();
				propDTO = new PropertyDTO(prop.getPropertyName(), prop.getPropertyValue());
			} else {
				sendExceptionResponse(HttpStatus.OK, Status.SUCCESS, ApiResponseCode.NOT_FOUND, apiName, PropertyStoreConstants.MSG_NO_PROP_FOUND + propertyName);
			}
		} catch (RuntimeException e) {
			sendExceptionResponse(HttpStatus.INTERNAL_SERVER_ERROR, Status.FAILURE, ApiResponseCode.INTERNAL_SERVER_ERROR, apiName, e.getMessage());
		}
		return propDTO;
	}

	/**
	 * {@inheritDoc}
	 *
	 */
	@Override
	public List<PropertyDTO> getProperties(String apiName) throws ApplicationException {
		List<PropertyDTO> propDtoList = null;
		try {
			List<Property> propList = propertyStoreRepository.findAll();
			propDtoList = propList.stream().map(prop -> new PropertyDTO(prop.getPropertyName(), prop.getPropertyValue())).collect(Collectors.toList());
		}catch (RuntimeException e) {
			sendExceptionResponse(HttpStatus.INTERNAL_SERVER_ERROR, Status.FAILURE, ApiResponseCode.INTERNAL_SERVER_ERROR, apiName, e.getMessage());
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

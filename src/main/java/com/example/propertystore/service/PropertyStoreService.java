package com.example.propertystore.service;

import com.example.exception.ApplicationException;
import com.example.model.BaseResponse;
import com.example.propertystore.entity.Property;

/**
 * This is a service class that facilitates CRUD operations for the
 * property-store application.
 * 
 * @author ritika.goel
 *
 */
public interface PropertyStoreService {

	/**
	 * This method allows the client to add a new property to the database.
	 * 
	 * @param property
	 * @return
	 */
	BaseResponse addProperty(Property propertyStore);

	/**
	 * This method allows the client to update the value of an existing property.
	 * 
	 * @param property
	 * @return
	 */
	BaseResponse editProperty(Property property);

	/**
	 * This method allows the client to delete a property from the database.
	 * 
	 * @param propertyName
	 * @return
	 */
	BaseResponse deleteProperty(String propertyName);

	/**
	 * This method allows the client to retrieve the value based on property name.
	 * 
	 * @param propertyName
	 * @return
	 */
	BaseResponse getProperty(String propertyName);

	/**
	 * This method allows the client to retrieve all property names present within
	 * the database.
	 * 
	 * @return
	 * @throws ApplicationException 
	 */
	BaseResponse getProperties() throws ApplicationException;

}

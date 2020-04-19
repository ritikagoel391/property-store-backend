package com.example.propertystore.service;

import java.util.List;

import com.example.exception.ApplicationException;
import com.example.propertystore.dto.PropertyDTO;
import com.example.propertystore.entity.Property;
import com.example.response.model.ApplicationResponse;

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
	ApplicationResponse addProperty(Property propertyStore);

	/**
	 * This method allows the client to update the value of an existing property.
	 * 
	 * @param property
	 * @return
	 */
	ApplicationResponse editProperty(Property property);

	/**
	 * This method allows the client to delete a property from the database.
	 * 
	 * @param propertyName
	 * @return
	 */
	ApplicationResponse deleteProperty(String propertyName);

	/**
	 * This method allows the client to retrieve the value based on property name.
	 * 
	 * @param propertyName
	 * @return
	 */
	ApplicationResponse getProperty(String propertyName);

	/**
	 * This method allows the client to retrieve all property names present within
	 * the database.
	 * 
	 * @return
	 * @throws ApplicationException 
	 */
	List<PropertyDTO> getProperties();

}

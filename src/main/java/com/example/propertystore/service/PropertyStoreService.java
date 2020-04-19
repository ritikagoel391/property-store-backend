package com.example.propertystore.service;

import java.util.List;

import com.example.exception.ApplicationException;
import com.example.propertystore.dto.PropertyDTO;
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
	 * @throws ApplicationException 
	 */
	PropertyDTO addProperty(Property propertyStore) throws ApplicationException;

	/**
	 * This method allows the client to update the value of an existing property.
	 * 
	 * @param property
	 * @return
	 * @throws ApplicationException 
	 */
	PropertyDTO editProperty(PropertyDTO property) throws ApplicationException;

	/**
	 * This method allows the client to delete a property from the database.
	 * 
	 * @param propertyName
	 * @return
	 * @throws ApplicationException 
	 */
	PropertyDTO deleteProperty(String propertyName) throws ApplicationException;

	/**
	 * This method allows the client to retrieve the value based on property name.
	 * 
	 * @param propertyName
	 * @return
	 * @throws ApplicationException 
	 */
	PropertyDTO getProperty(String propertyName) throws ApplicationException;

	/**
	 * This method allows the client to retrieve all property names present within
	 * the database.
	 * 
	 * @return
	 * @throws ApplicationException 
	 */
	List<PropertyDTO> getProperties() throws ApplicationException;

}

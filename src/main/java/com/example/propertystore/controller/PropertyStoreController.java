package com.example.propertystore.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.exception.ApplicationException;
import com.example.model.BaseResponse;
import com.example.propertystore.entity.Property;

/**
 * This is a controller class that facilitates CRUD operations for the
 * property-store application.
 * 
 * @author ritika.goel
 *
 */
@RequestMapping(value = "/")
public interface PropertyStoreController {

	/**
	 * This method allows the client to add a new property to the database.
	 * 
	 * @param property
	 * @return
	 */
	@PostMapping(value = "add")
	BaseResponse addProperty(@RequestBody Property property);

	/**
	 * This method allows the client to update the value of an existing property.
	 * 
	 * @param property
	 * @return
	 */
	@PutMapping(value = "update")
	BaseResponse editProperty(@RequestBody Property property);

	/**
	 * This method allows the client to delete a property from the database.
	 * 
	 * @param propertyName
	 * @return
	 */
	@DeleteMapping(value = "delete")
	BaseResponse deleteProperty(@RequestParam String propertyName);

	/**
	 * This method allows the client to retrieve the value based on property name.
	 * 
	 * @param propertyName
	 * @return
	 */
	@GetMapping(value = "find")
	BaseResponse getProperty(@RequestParam String propertyName);

	/**
	 * This method allows the client to retrieve all property names present within
	 * the database.
	 * 
	 * @return
	 * @throws ApplicationException 
	 */
	@GetMapping(value = "properties")
	BaseResponse getProperties() throws ApplicationException;
}

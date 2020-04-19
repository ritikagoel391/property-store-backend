package com.example.propertystore.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.exception.ApplicationException;
import com.example.propertystore.dto.PropertyDTO;
import com.example.propertystore.entity.Property;
import com.example.response.model.ApplicationResponse;

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
	ApplicationResponse addProperty(@RequestBody Property property);

	/**
	 * This method allows the client to update the value of an existing property.
	 * 
	 * @param property
	 * @return
	 */
	@PutMapping(value = "update")
	ApplicationResponse editProperty(@RequestBody Property property);

	/**
	 * This method allows the client to delete a property from the database.
	 * 
	 * @param propertyName
	 * @return
	 */
	@DeleteMapping(value = "delete")
	ApplicationResponse deleteProperty(@RequestParam String propertyName);

	/**
	 * This method allows the client to retrieve the value based on property name.
	 * 
	 * @param propertyName
	 * @return
	 */
	@GetMapping(value = "find")
	ApplicationResponse getProperty(@RequestParam String propertyName);

	/**
	 * This method allows the client to retrieve all property names present within
	 * the database.
	 * 
	 * @return
	 * @throws ApplicationException 
	 */
	@GetMapping(value = "properties")
	ApplicationResponse<List<PropertyDTO>> getProperties() throws ApplicationException;
}

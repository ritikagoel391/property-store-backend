package com.example.propertystore.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.propertystore.dto.PropertyDTO;
import com.example.propertystore.entity.Property;
import com.example.propertystore.repository.PropertyRepository;
import com.example.response.model.ApplicationResponse;

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

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ApplicationResponse addProperty(Property property) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ApplicationResponse editProperty(Property property) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ApplicationResponse deleteProperty(String propertyName) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ApplicationResponse getProperty(String propertyName) {
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 *
	 */
	@Override
	public List<PropertyDTO> getProperties() {
		List<Property> propList = propertyStoreRepository.findAll();
		return propList.stream().map(prop -> new PropertyDTO(prop.getPropertyName(), prop.getPropertyValue()))
				.collect(Collectors.toList());
	}
}

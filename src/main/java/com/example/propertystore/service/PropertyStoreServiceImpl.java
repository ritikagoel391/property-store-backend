package com.example.propertystore.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.model.BaseResponse;
import com.example.propertystore.entity.Property;
import com.example.propertystore.repository.PropertyRepository;

/**
 * This is the implementation of service class that facilitates CRUD
 * operations for the property-store application.
 * 
 * @author ritika.goel
 *
 */
public class PropertyStoreServiceImpl implements PropertyStoreService {

	@Autowired
	PropertyRepository propertyStoreRepository;

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
	 */
	@Override
	public BaseResponse getProperties() {
		// TODO Auto-generated method stub
		return null;
	}
}

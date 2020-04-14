package com.example.propertystore.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.model.BaseResponse;
import com.example.propertystore.entity.Property;
import com.example.propertystore.repository.PropertyStoreRepository;

public class PropertyStoreServiceImpl implements PropertyStoreService {

	@Autowired
	PropertyStoreRepository propertyStoreRepository;

	@Override
	public BaseResponse addProperty(Property property) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BaseResponse editProperty(Property property) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BaseResponse deleteProperty(String propertyName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BaseResponse getProperty(String propertyName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BaseResponse getProperties() {
		// TODO Auto-generated method stub
		return null;
	}

}

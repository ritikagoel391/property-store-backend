package com.example.propertystore.service;

import org.springframework.stereotype.Service;

import com.example.model.BaseResponse;
import com.example.propertystore.entity.Property;

@Service
public interface PropertyStoreService {

	BaseResponse addProperty(Property propertyStore);

	BaseResponse editProperty(Property property);

	BaseResponse deleteProperty(String propertyName);

	BaseResponse getProperty(String propertyName);

	BaseResponse getProperties();

}

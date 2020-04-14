package com.example.propertystore.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.BaseResponse;
import com.example.propertystore.entity.Property;

@RestController
public interface PropertyStoreController {

	@PostMapping(value = "/add")
	BaseResponse addProperty(@RequestBody Property property);
	
	@PutMapping(value = "/update")
	BaseResponse editProperty(@RequestBody Property property);
	
	@DeleteMapping(value = "/delete")
	BaseResponse deleteProperty(@RequestParam String propertyName);

	@GetMapping(value = "/find")
	BaseResponse getProperty(@RequestParam String propertyName);
	
	@GetMapping(value = "/properties")
	BaseResponse getProperties();
}

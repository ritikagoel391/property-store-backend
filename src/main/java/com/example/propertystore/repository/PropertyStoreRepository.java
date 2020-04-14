package com.example.propertystore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.propertystore.entity.Property;

public interface PropertyStoreRepository extends JpaRepository<Property, Long> {

}

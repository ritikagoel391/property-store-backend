package com.test.propertystore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.propertystore.entity.PropertyStore;

public interface PropertyStoreRepository extends JpaRepository<PropertyStore, Long> {

}

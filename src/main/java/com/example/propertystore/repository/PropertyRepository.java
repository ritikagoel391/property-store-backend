package com.example.propertystore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.propertystore.entity.Property;

/**
 * This interface deines the JPA repository for {@link Property} entity.
 * 
 * @author ritika.goel
 *
 */
public interface PropertyRepository extends JpaRepository<Property, Long> {

}

package com.example.propertystore.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.propertystore.entity.Property;

/**
 * This interface defines the JPA repository for {@link Property} entity.
 * 
 * @author ritika.goel
 *
 */
public interface PropertyRepository extends JpaRepository<Property, Long> {
	Optional<Property> findByPropertyName(String propertyName);
	Optional<Property> deleteByPropertyName(String propertyName);
}

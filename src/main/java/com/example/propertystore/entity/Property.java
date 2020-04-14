package com.example.propertystore.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * This is an entity class for DB table - Property.
 * 
 * @author ritika.goel
 *
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Property implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -64886380656383874L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, unique = true)
	private String propertyName;

	@Column(nullable = false)
	private String propertyValue;

}

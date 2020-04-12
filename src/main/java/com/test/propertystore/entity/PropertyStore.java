package com.test.propertystore.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PropertyStore implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -64886380656383874L;

	@Id
	private Long id;
	
	@Column(nullable = false)
	private String propertyName;
	
	@Column(nullable = false)
	private String propertyValue;

}

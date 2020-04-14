package com.example.propertystore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * This is the starting point of this spring boot application.
 * 
 * @author ritika.goel
 *
 */
@SpringBootApplication
public class PropertyStoreBackendApplication {

	/**
	 * This is similar to standalone java applictions and provides the entry point
	 * for the JVM.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(PropertyStoreBackendApplication.class, args);
	}

}

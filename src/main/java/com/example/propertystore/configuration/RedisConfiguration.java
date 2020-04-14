package com.example.propertystore.configuration;

import org.springframework.context.annotation.Configuration;

/**
 * The application at startup loads all the existing properties from the
 * postgres database into REDIS cache. Also, it updates the same as any insert /
 * update / delete operations are performed. This class defines the beans
 * required for initializing REDIS.
 * 
 * @author ritika.goel
 *
 */
@Configuration
public class RedisConfiguration {

}

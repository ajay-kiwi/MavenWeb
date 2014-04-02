package com.self.org.config;

import org.apache.commons.configuration.PropertiesConfiguration;
import org.springframework.beans.factory.InitializingBean;

/**
 * 
 * @author Evan Savage <savage.evan@gmail.com>
 *
 * Simple wrapper around PropertiesConfiguration.  This provides a way to set application-wide
 * settings at startup via a configuration file.
 */
public class Configuration implements InitializingBean {
    public PropertiesConfiguration properties;
    
    public Configuration(){
    	
    }
    public void setProperties(PropertiesConfiguration properties) {
        this.properties = properties;
    }
    
    @Override
    public void afterPropertiesSet() throws Exception {
    }

    public String get(String key) {
        return properties.getString(key);
    }
}

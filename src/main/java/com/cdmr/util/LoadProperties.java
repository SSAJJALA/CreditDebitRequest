package com.cdmr.util;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.Properties;

/**
 * Load CDMR properties
 *
 * @author  Siva Sajjala
 * @version 1.0
 * @since   2016-12-02
 */
public class LoadProperties {

    private final Logger log = Logger.getLogger(this.getClass());
    private Properties properties;

    /**
     * Main method to load cdmr.properties file
     * @throws Exception
     */
    public Properties loadProperties() throws Exception {
        properties = new Properties();
        try {
            properties.load (this.getClass().getResourceAsStream("/cdmr.properties"));
        } catch (IOException ioe) {
            log.error("cdmr.loadProperties()...Cannot load the properties file");
            throw ioe;
        } catch (Exception e) {
            log.error("cdmr.loadProperties()..." + e);
            throw e;
        }

        return properties;
    }
}

package com.cdmr.webservices;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by student on 10/15/16.
 */


//Defines the base URI for all resource URIs.
@ApplicationPath("/rest")
public class RestApplication extends Application {
    //The method returns a non-empty collection with classes, that must be included in the published JAX-RS application
    @Override
    public Set<Class<?>> getClasses() {
        HashSet h = new HashSet<Class<?>>();
        h.add(CustomerLookup.class );
        return h;
    }
}
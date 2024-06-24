package com.indusind.aem.platform.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.*;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;


@Model(adaptables = Resource.class, adapters = Author.class)
public class AuthorImpl implements Author{
    @ValueMapValue
    @Default(values = "DEFAULT")
    private String fname;
    
    @ValueMapValue
    @Default(values = "DEFAULT")     
    private String lname;

    @Override
    public String getFname() {
        return fname;
    }
    
    @Override
    public String getLname() {
        return lname;
    } 
}
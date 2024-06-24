package com.indusind.aem.platform.core.models;

import javax.annotation.PostConstruct;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.indusind.aem.platform.core.services.impl.AashishConfigImpl;

@Model(adaptables = Resource.class)
public class AashishServiceToModel {

    private static final Logger log = LoggerFactory.getLogger(AashishServiceToModel.class);

    @OSGiService
    private AashishConfigImpl aashishConfigImpl;

    private boolean isEnabled;
    private String fullName;
    private String customProperty;

    @PostConstruct
    protected void init() {
        this.fullName=aashishConfigImpl.getFullName();
        this.customProperty=aashishConfigImpl.getCustomProperty();
        this.isEnabled=aashishConfigImpl.isEnabled();
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public String getFullName() {
        return fullName;
    }

    public String getCustomProperty() {
        return customProperty;
    }    
}

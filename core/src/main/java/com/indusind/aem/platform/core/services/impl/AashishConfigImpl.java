package com.indusind.aem.platform.core.services.impl;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.metatype.annotations.Designate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.indusind.aem.platform.core.services.AashishConfig;

@Component(immediate = true,service = AashishConfigImpl.class)
@Designate(ocd = AashishConfig.class)
 public class AashishConfigImpl{  
       
    private volatile boolean isEnabled;
    
    private volatile String fullName;

    private volatile String customProperty;

    public boolean isEnabled() {
        return isEnabled;
    }

    public String getFullName() {
        return fullName;
    }

    public String getCustomProperty() {
        return customProperty;
    }

    private static final Logger log= LoggerFactory.getLogger(AashishConfigImpl.class);  

    @Activate
    protected void activate(AashishConfig config) {
        log.info("AAshish Impl");
        this.isEnabled = config.isEnabled1();
        this.fullName = config.fullName1();
        this.customProperty = config.custom1();
        log.info("CustomService Configuration - isEnabled: {}, fullName: {}, customProperty: {}", isEnabled, fullName, customProperty);
    }
}

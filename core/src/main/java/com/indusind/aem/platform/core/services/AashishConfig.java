package com.indusind.aem.platform.core.services;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(name = "Aashish Service Configuration", description = "Service Configuration")
public @interface AashishConfig {

    @AttributeDefinition(name = "Enable", description = "activate your cofiguration")
    boolean isEnabled1() default true;

    @AttributeDefinition(name = "Full Name", description = "fullname of the developer")
    String fullName1() default "";

    @AttributeDefinition(name = "Custom Property", description = "custom property")
    String custom1() default "";
}
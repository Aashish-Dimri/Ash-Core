package com.indusind.aem.platform.core.services;

import org.apache.sling.caconfig.annotation.Configuration;
import org.apache.sling.caconfig.annotation.Property;

@Configuration(label="Ash Context Aware configuration",description="Configuration for context aware.")
public @interface ASHCAConfig {
    @Property(label="Ash Country Site",
    description="Site Name")
    String siteCountry() default "us";

    @Property(label="Ash Site Locale",
    description="Ash site for diffrent language")
    String siteLocale() default "en";

    @Property(label="Ash Site Admin",
    description="Admin for updating country site.")
    String siteAdmin() default "aashish";

    @Property(label="Site Section",
    description="Site section for Indusind Sites")
    String siteSection() default "aem";
}

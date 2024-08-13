package com.indusind.aem.platform.core.solr.config;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@Component(service = {OakSolrServerConfiguration.class})
public class OakSolrServerConfiguration {

    @ObjectClassDefinition(name = "Oak Solr Server Configuration")
    public @interface OakSolrServerConfigurationService {
        @AttributeDefinition(name = "Solr Server URL", description = "URL of the Solr server")
        String solrServerUrl() default "http://localhost:8983/solr/";

        @AttributeDefinition(name = "Solr Core Name", description = "Name of the Solr core")
        String solrCoreName() default "aashish";
    }

    private String solrServerUrl;
    private String solrCoreName;

    @Activate
    @Modified
    protected void activate(OakSolrServerConfigurationService config) {
        this.solrServerUrl = config.solrServerUrl();
        this.solrCoreName = config.solrCoreName();
    }

    public String getSolrServerUrl() {
        return solrServerUrl;
    }

    public String getSolrCoreName() {
        return solrCoreName;
    }
}

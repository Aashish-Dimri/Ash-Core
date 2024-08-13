package com.indusind.aem.platform.core.solr.service;

import java.io.IOException;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.indusind.aem.platform.core.solr.config.OakSolrServerConfiguration;

@Component(service = SolrQueryService.class)
public class SolrQueryService {

    private static final Logger log = LoggerFactory.getLogger(SolrQueryService.class);

    @Reference
    private OakSolrServerConfiguration solrConfig;

    public String queryContent(String query, String rows) {
        String solrQueryUrl = solrConfig.getSolrServerUrl() + solrConfig.getSolrCoreName() + "/select?q=" + query + "&rows=" + rows;
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpGet get = new HttpGet(solrQueryUrl);
            try (CloseableHttpResponse response = httpClient.execute(get)) {
                return EntityUtils.toString(response.getEntity());
            }
        } catch (IOException e) {
            log.error("Error querying Solr", e);
            return null;
        }
    }
}
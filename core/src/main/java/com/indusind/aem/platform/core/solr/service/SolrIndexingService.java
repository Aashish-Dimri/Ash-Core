package com.indusind.aem.platform.core.solr.service;

import java.io.IOException;
import java.util.*;
import javax.jcr.query.Query;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.apache.sling.api.resource.ValueMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.indusind.aem.platform.core.solr.config.OakSolrServerConfiguration;

@Component(service = SolrIndexingService.class)
public class SolrIndexingService {

    @Reference
    private OakSolrServerConfiguration solrConfig;

    private static final Logger log = LoggerFactory.getLogger(SolrIndexingService.class);

    @Reference
    private ResourceResolverFactory resourceResolverFactory;
    public String getContent() throws Exception {

        Map<String, Object> param = new HashMap<>();
        param.put(ResourceResolverFactory.SUBSERVICE, "aashish");
        JSONArray jsonArray = new JSONArray();
        try (ResourceResolver resolver = resourceResolverFactory.getServiceResourceResolver(param)) {
            String query = "SELECT * FROM [cq:Page] AS s WHERE ISDESCENDANTNODE(s, '/content/Indusind')";
            resolver.findResources(query, Query.JCR_SQL2).forEachRemaining(resource -> {
                try {
                    Resource jcrContent = resource.getChild("jcr:content");
                    if (jcrContent != null) {
                        ValueMap properties = jcrContent.getValueMap();
                        JSONObject jsonObject = new JSONObject();
                        jsonObject.put("id", resource.getPath());
                        jsonObject.put("Name", properties.get("jcr:title", String.class));
                        jsonObject.put("Description", properties.get("jcr:description", String.class));
                        jsonObject.put("jcrCreated", properties.get("jcr:created", String.class));
                        jsonObject.put("lastModified", properties.get("cq:lastModified", String.class));
                        jsonObject.put("lastPublished", properties.get("cq:lastReplicated", String.class));
                        jsonArray.put(jsonObject);
                    }
                } catch (JSONException ex) {
                    log.error("Error creating JSON object for resource", ex);
                }
            });
        }
        sendToSolr(jsonArray);
        return jsonArray.toString();
    }

    private void sendToSolr(JSONArray jsonArray) throws IOException {
        String solrUrl = solrConfig.getSolrServerUrl() + solrConfig.getSolrCoreName() + "/update/json/docs";
    
        try (CloseableHttpClient client = HttpClients.createDefault()) {
            HttpPost post = new HttpPost(solrUrl);
            StringEntity entity = new StringEntity(jsonArray.toString(), "UTF-8");
            post.setEntity(entity);
            post.setHeader("Content-type", "application/json");
            
            try (CloseableHttpResponse response = client.execute(post)) {
                int statusCode = response.getStatusLine().getStatusCode();
                log.info("Response status: {}", statusCode);
                if (statusCode != 200) {
                    log.error("Failed to send data to Solr. Status code: {}, Reason: {}", 
                              statusCode, response.getStatusLine().getReasonPhrase());
                } else {
                    log.info("Successfully sent data to Solr");
                }
            }
        }
    }
}
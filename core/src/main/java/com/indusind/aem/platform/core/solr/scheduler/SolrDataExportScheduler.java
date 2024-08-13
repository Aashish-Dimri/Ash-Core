package com.indusind.aem.platform.core.solr.scheduler;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

import javax.jcr.query.Query;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.commons.scheduler.ScheduleOptions;
import org.apache.sling.commons.scheduler.Scheduler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.metatype.annotations.Designate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.indusind.aem.platform.core.solr.config.OakSolrServerConfiguration;

@Component(service = Runnable.class, immediate = true)
@Designate(ocd = SolrDataExport.class)
public class SolrDataExportScheduler implements Runnable {
    @Reference
    private ResourceResolverFactory resourceResolverFactory;

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Reference
    private Scheduler scheduler;

    @Reference
    private OakSolrServerConfiguration solrConfig;

    private boolean initialRun = true;
    private long lastRunTime;

    @Activate
    protected void activate(final SolrDataExport config) {
        log.error("demoScheduler activate method called");
        addScheduler(config);
    }

    public void addScheduler(SolrDataExport config) {
        if (config.serviceEnabled()) {
            ScheduleOptions options = scheduler.EXPR(config.schedulerExpression());
            options.name(config.schedulerName());
            options.canRunConcurrently(config.schedulerConcurrent());
            scheduler.schedule(this, options);
            log.error("Scheduler added successfully name='{}'", config.schedulerName());
        } else {
            log.error("SimpleScheduledTask disabled");
        }
    }

    @Deactivate
    protected void deactivate(SolrDataExport config) {
        scheduler.unschedule(config.schedulerName());
        log.error("demoScheduler removed successfully >>>>>>>   ");
    }

    @Override
    public void run() {
        log.info("Running Scheduler Task >> KARTIK");
        Map<String, Object> param = new HashMap<>();
        param.put(ResourceResolverFactory.SUBSERVICE, "aashish");
        JSONArray jsonArray = new JSONArray();

        try (ResourceResolver resolver = resourceResolverFactory.getServiceResourceResolver(param)) {
            String query;
            if (initialRun) {
                query = "SELECT * FROM [cq:Page] AS s WHERE ISDESCENDANTNODE(s, '/content/Indusind') " +
                        "AND [jcr:content/cq:lastReplicated] IS NOT NULL";
                lastRunTime = System.currentTimeMillis();
                initialRun = false;
            } else {
                long currentTime = System.currentTimeMillis();
                long startTime = lastRunTime - 10*60*1000;
                query = String.format("SELECT * FROM [cq:Page] AS s WHERE ISDESCENDANTNODE(s, '/content/Indusind') " +
                        "AND [jcr:content/cq:lastReplicated] >= CAST('%s' AS DATE)",
                        formatDate(startTime));
                lastRunTime = currentTime;
            }
            resolver.findResources(query, Query.JCR_SQL2).forEachRemaining(resource -> {
                try {
                    Resource jcrContent = resource.getChild("jcr:content");
                    if (jcrContent != null) {
                        ValueMap properties = jcrContent.getValueMap();
                        JSONObject jsonObject = new JSONObject();
                        jsonObject.put("Page Path", resource.getPath());
                        jsonObject.put("Name", properties.get("jcr:title", String.class));
                        jsonObject.put("Description", properties.get("jcr:description", String.class));
                        jsonObject.put("lastModified", properties.get("cq:lastModified", String.class));
                        jsonObject.put("lastPublished", properties.get("cq:lastReplicated", String.class));
                        jsonArray.put(jsonObject);
                    }
                } catch (JSONException ex) {
                    log.error("Error creating JSON object for resource", ex);
                }
            });
        } catch (LoginException ex) {
            log.error("Error obtaining resource resolver", ex);
        }

        String solrUrl = solrConfig.getSolrServerUrl() + solrConfig.getSolrCoreName() + "/update/json/docs";
        try (CloseableHttpClient client = HttpClients.createDefault()) {
            HttpPost post = new HttpPost(solrUrl);
            StringEntity entity = new StringEntity(jsonArray.toString());
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
            } catch (IOException ex) {
                log.error("IOException during Solr update", ex);
            }
        } catch (IOException ex) {
            log.error("IOException creating HTTP client", ex);
        }
    }

    private String formatDate(long timeInMillis) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
        return sdf.format(new Date(timeInMillis));
    }
}
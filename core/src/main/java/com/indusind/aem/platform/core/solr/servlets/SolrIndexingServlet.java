package com.indusind.aem.platform.core.solr.servlets;

import java.io.IOException;

import javax.servlet.Servlet;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletPaths;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.indusind.aem.platform.core.solr.service.SolrIndexingService;

@Component(service = {Servlet.class})
@SlingServletPaths(value = {"/bin/indexContent"})
public class SolrIndexingServlet extends SlingAllMethodsServlet {

    @Reference
    private SolrIndexingService solrIndexingService;

    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws IOException {
        try {
            String queryResults = solrIndexingService.getContent();
            response.setContentType("application/json");
            response.getWriter().write(queryResults);
        } catch (Exception e) {
            response.setStatus(SlingHttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().write("Error fetching content: " + e.getMessage());
        }
    }
}
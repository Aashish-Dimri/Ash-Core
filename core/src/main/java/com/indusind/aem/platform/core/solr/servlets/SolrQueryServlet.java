package com.indusind.aem.platform.core.solr.servlets;

import java.io.IOException;

import javax.servlet.Servlet;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletPaths;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.indusind.aem.platform.core.solr.service.SolrQueryService;

@Component(service = {Servlet.class})
@SlingServletPaths(value = {"/bin/queryContent"})
public class SolrQueryServlet extends SlingAllMethodsServlet {

    @Reference
    private SolrQueryService solrQueryService;

    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws IOException {
        String query = request.getParameter("q");
        String rows= request.getParameter("rows");
        String results = solrQueryService.queryContent(query,rows);
        response.getWriter().write(results);
    }
}
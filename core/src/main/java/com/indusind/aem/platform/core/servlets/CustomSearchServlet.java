package com.indusind.aem.platform.core.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.jcr.Session;
import javax.servlet.Servlet;
import javax.servlet.ServletException;

import static org.apache.sling.api.servlets.ServletResolverConstants.SLING_SERVLET_METHODS;
import static org.apache.sling.api.servlets.ServletResolverConstants.SLING_SERVLET_PATHS;
import static org.apache.sling.api.servlets.ServletResolverConstants.SLING_SERVLET_EXTENSIONS;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.api.resource.Resource;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.day.cq.search.PredicateConverter;
import com.day.cq.search.PredicateGroup;
import com.day.cq.search.Query;
import com.day.cq.search.QueryBuilder;
import com.day.cq.search.result.SearchResult;
import com.day.cq.search.result.Hit;

@Component(
        service = Servlet.class, property = {
                SLING_SERVLET_METHODS + "=GET",
                SLING_SERVLET_PATHS + "=/bin/customsearch",
                SLING_SERVLET_EXTENSIONS + "=json"
        }
)
public class CustomSearchServlet extends SlingAllMethodsServlet
 {
    private static final Logger logger = LoggerFactory.getLogger(CustomSearchServlet.class);

    @Reference
    private QueryBuilder queryBuilder;

    @Reference
    private ResourceResolverFactory resourceResolverFactory;
  
    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException {
        String fullText = request.getParameter("fullText");
        String searchRootPath = request.getParameter("searchRootPath");
        logger.info("checking value"+fullText);
        ResourceResolver resourceResolver = request.getResource().getResourceResolver();
        
        Map<String, String> predicatesMap = new HashMap<>();
        predicatesMap.put("path", searchRootPath);
        predicatesMap.put("type", "cq:Page");
        predicatesMap.put("group.p.or", "true");
        predicatesMap.put("group.1_property", "jcr:content/jcr:title");
        predicatesMap.put("group.1_property.value", "%"+fullText+"%");
        predicatesMap.put("group.1_property.operation", "like");
        predicatesMap.put("group.2_property", "jcr:content/jcr:description");
        predicatesMap.put("group.2_property.value", "%"+fullText+"%");
        predicatesMap.put("group.2_property.operation", "like");
        predicatesMap.put("p.limit","-1");

        PredicateGroup predicates = PredicateConverter.createPredicates(predicatesMap);
        
        Session session = resourceResolver.adaptTo(Session.class);
        Query query = queryBuilder.createQuery(predicates, session);
        
        SearchResult searchResult = query.getResult();
        
        response.setContentType("application/json");
        try (PrintWriter out = response.getWriter())
         {
            out.write("{");
            out.write("\"results\": [");
            boolean first = true;
            for (Hit hit : searchResult.getHits()) 
            {
                if (!first) 
                {
                    out.write(",");
                }
                Resource resource = hit.getResource();
                ValueMap props = hit.getProperties();
                out.write("{");
                out.write("\"path\": \"" + resource.getPath() + "\",");
                out.write("\"title\": \"" + props.get("jcr:title",String.class) + "\",");
                out.write("\"description\": \"" + props.get("jcr:description",String.class) + "\"");
                out.write("}"); 
                first = false;
            }
            out.write("]");
            out.write("}");
        } catch (Exception e) 
        {
            response.setStatus(SlingHttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            e.printStackTrace(response.getWriter());
        }
    }
}
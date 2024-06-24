package com.indusind.aem.platform.core.servlets;

import java.io.IOException;
import java.util.*;

import javax.jcr.Session;
import javax.servlet.Servlet;
import javax.jcr.Node;
import javax.jcr.NodeIterator;
import javax.servlet.ServletException;
import org.apache.commons.lang.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.indusind.aem.platform.core.models.ModelData;
import com.day.cq.search.PredicateGroup;
import com.day.cq.search.Query;
import com.day.cq.search.QueryBuilder;
import com.day.cq.search.result.Hit;
import com.day.cq.search.result.SearchResult;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component(service = Servlet.class, property = { Constants.SERVICE_DESCRIPTION + "=Query Builder servlet",
		"sling.servlet.methods=" + HttpConstants.METHOD_GET, "sling.servlet.paths=" + "/bin/demo/querybuilder"})
public class QueryBuilderServlet extends SlingSafeMethodsServlet {
	private static final long serialVersionUID = 2610051404257637265L;
	private static final Logger log = LoggerFactory.getLogger(QueryBuilderServlet.class);
	/**
	 * Injecting the QueryBuilder dependency
	 */
	@Reference
	private QueryBuilder builder;
	
	/**
	 * Session object
	 */
	private Session session;

	
	/**
	 * Overridden doGet() method which executes on HTTP GET request
	 */
	@Override
	protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException,IOException{
	//	ResultSet rs=new ResultSet();
		try {
			log.info("----------< Executing Query Builder Servlet >----------");
			/**
			 * This parameter is passed in the HTTP call
			 */
			String[] selectors = request.getRequestPathInfo().getSelectors();
			String param = selectors[0];
			int x = Integer.parseInt(param);
			int flag=2;
			if(x==0) flag=1;
			x*=5;
			x-=5;
			//String k=Integer.toString(x);
			log.info("Search term is: {}", param);			
			/**
			 * Get resource resolver instance
			 */
			ResourceResolver resourceResolver = request.getResourceResolver();			
			/**
			 * Adapting the resource resolver to the session object
			 */
			session = resourceResolver.adaptTo(Session.class);			
			/**
			 * Map for the predicates
			 */
			Map<String, String> predicate = new HashMap<>();            
            String tagValue = StringUtils.EMPTY;
			/**
			 * Configuring the Map for the predicate
			 */
			predicate.put("path", "/content/Indusind/us/NewsPaper");
			predicate.put("type", "cq:Page");
            predicate.put("tagid", tagValue);
			predicate.put("tagid.property", "jcr:content/cq:tags");
			predicate.put("group.p.or", "true");
			if(flag==1) predicate.put("p.limit", "-1");
			else if(flag==2){
			predicate.put("p.offset",selectors[1]);
			predicate.put("p.limit", selectors[2]);
			}
			predicate.put("orderby", "@jcr:content/jcr:title");
			predicate.put("orderby.sort", "asc");	
			/**
			 * Creating the Query instance
			 */
			Query query = builder.createQuery(PredicateGroup.create(predicate), session);			
			//query.setStart(1);
			//query.setHitsPerPage(5);			
			/**
			 * Getting the search results
			 */


			SearchResult searchResult = query.getResult();
			List<Object> ans=new ArrayList<>();
			ModelData a;			
			for(Hit hit : searchResult.getHits()) {
				a=new ModelData();
				ValueMap valueMap = hit.getProperties();	
				String relativepath = "jcr:content/root/container/container";
                Node node = hit.getNode();
                Node preimage =node.getNode(relativepath);  
                String fileReference =StringUtils.EMPTY;

                if(preimage.hasNodes()){
                    NodeIterator image = preimage.getNodes("image* | image");
                    while(image.hasNext()){
                        Node finalimage = image.nextNode();
                        if(finalimage.hasProperty("fileReference")){
                            fileReference = (finalimage.getProperty("fileReference").getString());
                        }
                    }
                }			
				String title = hit.getTitle();
				String path ="http://localhost:4502"+hit.getPath()+".html";
                String description = valueMap.get("jcr:description", String.class);
				String tags = valueMap.get("cq:tags", String.class);
                String summary = valueMap.get("jcr:summary", String.class);
                String modified=valueMap.get("cq:lastModified", String.class);

                a.setTitle(title);
				a.setUrl(path);
                a.setDescription(description);
				a.setTags(tags);
                a.setSummary(summary);
                a.setImage(fileReference);
				a.setLmod(modified);
                ans.add(a);
			}
            ObjectMapper map=new ObjectMapper();
			String json = map.writerWithDefaultPrettyPrinter().writeValueAsString(ans);
			response.getWriter().write(json);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			if(session != null) {
				session.logout();
			}
		}
	}
}

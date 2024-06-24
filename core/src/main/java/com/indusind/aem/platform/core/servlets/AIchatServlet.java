// package com.indusind.aem.platform.core.servlets;
// import javax.jcr.Session;

// import java.io.IOException;

// import javax.jcr.Node;
// import javax.jcr.Value;
// import javax.servlet.ServletException;

// import org.apache.sling.api.SlingHttpServletResponse;

// public class DynamicNodeCreationServlet extends SimpleServlet {
// @Override
// protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException {
//     // Get the path parameter.
//     String path = request.getParameter("path");

//     Session session;
//     // Create the node.
//     Node node = session.getRootNode().addNode(path);

//     // Add properties to the node.
//     node.setProperty("name", "My Node");
//     node.setProperty("description", "This is my dynamically created node.");

//     // Save the session.
//     session.save();

//     // Redirect to the page.
//     response.sendRedirect("/myNode");
// }
// }
package com.indusind.aem.platform.core.servlets;

import org.apache.sling.api.SlingHttpServletRequest;

import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.indusind.aem.platform.core.models.YourDataModel;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.jcr.Node;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;


@Component(service = Servlet.class, property = {
		"sling.servlet.methods=POST",
		"sling.servlet.paths=/bin/custom/nodeservlet",
		"sling.servlet.extensions=json"
})
public class AIchatServlet extends SlingAllMethodsServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger LOG = LoggerFactory.getLogger(AIchatServlet.class);

	@Override
	protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response)
	        throws ServletException, IOException {
	    response.setCharacterEncoding("UTF-8");

	    String contentType = request.getContentType();

	    if (contentType != null && contentType.startsWith("application/json")) {
	        try {
	            StringBuilder sb = new StringBuilder();
	            BufferedReader reader = request.getReader();
	            String line;

	            while ((line = reader.readLine()) != null) {
	                sb.append(line);
	            }
	            String json = sb.toString();

	            LOG.info("Received JSON data: {}", json);

	            ObjectMapper objectMapper = new ObjectMapper();
	            YourDataModel data = objectMapper.readValue(json, YourDataModel.class);
	            String name = data.getName();
	            String lastname = data.getLastname();
	     //       String gender = data.getGender();
	       //     String dob = data.getDob();
	         //   String married = data.getMarried();
	           // String image = data.getImage();

	            LOG.info("Extracted data: name={}, lastName={}, gender={}, dob={}, married={}",
	                    name, lastname);
	                    //gender, dob, married);

	            // Get the current resource resolver
	            ResourceResolver resourceResolver = request.getResourceResolver();

	            // Define the parent node path (you may adjust this path as per your content structure)
	            String parentNodePath = "/content/Indusind/jcr:content/aashi";

	            // Get the parent node based on the path
	            Node parentNode = resourceResolver.getResource(parentNodePath).adaptTo(Node.class);

	            // Create a new node under the parent node
	            Node newNode = parentNode.addNode("newNodeName"); // Provide a suitable name for the new node

	            // Set properties for the new node
	            newNode.setProperty("name", name);
	            newNode.setProperty("lastname", lastname);
	   //         newNode.setProperty("gender", gender);
	     //       newNode.setProperty("dob", dob);
	      //      newNode.setProperty("married", married);
	        //    newNode.setProperty("image", image);

	            // Save the changes
	            resourceResolver.commit();

	            response.setStatus(SlingHttpServletResponse.SC_OK);
	            response.getWriter().write("Node created successfully");

	            LOG.info("Node created successfully");
	        } catch (Exception e) {
	            e.printStackTrace();
	            response.setStatus(SlingHttpServletResponse.SC_INTERNAL_SERVER_ERROR);
	            response.getWriter().write("Error creating the node");
	            LOG.error("Error creating the node", e);
	        }
	    } else {
	        response.setStatus(SlingHttpServletResponse.SC_BAD_REQUEST);
	        response.getWriter().write("Invalid content type. Expected application/json.");
	        LOG.error("Invalid content type. Expected application/json.");
	    }
	    }
	}

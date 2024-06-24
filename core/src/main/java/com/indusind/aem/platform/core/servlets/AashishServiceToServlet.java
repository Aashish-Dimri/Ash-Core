package com.indusind.aem.platform.core.servlets;

import java.io.IOException;
import javax.servlet.Servlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import com.indusind.aem.platform.core.services.impl.AashishConfigImpl;
import com.google.gson.JsonObject;

@Component(service = Servlet.class, property = {
    "sling.servlet.methods=GET",
    "sling.servlet.resourceTypes=Indusind/components/page"
})
public class AashishServiceToServlet extends SlingSafeMethodsServlet {

    @Reference
    AashishConfigImpl ashImpl;
    
    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws IOException{
        
        JsonObject jsonResponse = new JsonObject();
        jsonResponse.addProperty("fullName", ashImpl.getFullName());
        jsonResponse.addProperty("customProperty", ashImpl.getCustomProperty());
        jsonResponse.addProperty("enabled", ashImpl.isEnabled());
        
        response.setContentType("application/json");
        response.getWriter().write(jsonResponse.toString());

    }
}
package com.indusind.aem.platform.core.servlets;

import java.io.IOException;
import javax.servlet.Servlet;
import javax.servlet.ServletException;

import static org.apache.sling.api.servlets.ServletResolverConstants.SLING_SERVLET_METHODS;
import static org.apache.sling.api.servlets.ServletResolverConstants.SLING_SERVLET_PATHS;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.indusind.aem.platform.core.services.DemoMicroService;

@Component(
        service = Servlet.class, property = {
                SLING_SERVLET_METHODS + "=GET",
                SLING_SERVLET_PATHS + "=/bin/demo/greeting"
        }
)
public class DemoMicroserviceServlet extends SlingAllMethodsServlet
 {
    private static final Logger logger = LoggerFactory.getLogger(DemoMicroserviceServlet.class);

    @Reference
    DemoMicroService dMS;
    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name")==null?"World" : request.getParameter("name");
        response.setContentType("text/plain");
        logger.info(dMS.getGreeting(name));
        response.getWriter().write(dMS.getGreeting(name));
    }
}
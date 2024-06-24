package com.indusind.aem.platform.core.servlets;

import java.io.IOException;
import java.util.*;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.osgi.service.component.annotations.Component;
import org.apache.sling.settings.SlingSettingsService;
import org.osgi.service.component.annotations.Reference;

@Component(service = Servlet.class, property = { "sling.servlet.paths=/bin/custom/runmode" })
public class RunModes extends SlingSafeMethodsServlet {

    private static final long serialVersionUID = 1L;

    @Reference
    private SlingSettingsService slingSettingsService;
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response)
            throws ServletException, IOException {
                Set<String> activeRunModes = slingSettingsService.getRunModes();
                response.getWriter().println("Active Run Modes:");
                for (String runMode : activeRunModes) {
                  response.getWriter().println(runMode);
                }
    }
}
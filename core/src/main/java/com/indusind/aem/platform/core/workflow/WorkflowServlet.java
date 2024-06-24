package com.indusind.aem.platform.core.workflow;

import java.io.IOException;

import javax.servlet.Servlet;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adobe.granite.workflow.WorkflowException;
import com.adobe.granite.workflow.WorkflowSession;
import com.adobe.granite.workflow.exec.WorkflowData;
import com.adobe.granite.workflow.model.WorkflowModel;

@Component(service = Servlet.class, property = {
    "sling.servlet.methods=GET",
    "sling.servlet.paths=/aashish/forworkflow"
})
public class WorkflowServlet extends SlingSafeMethodsServlet {

    private static final Logger log = LoggerFactory.getLogger(WorkflowServlet.class);

    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws IOException {
        String status = "executing workflow";
        String pagePath = request.getParameter("path");

        ResourceResolver resourceResolver = request.getResourceResolver();
        try {
            WorkflowSession workflowSession = resourceResolver.adaptTo(WorkflowSession.class);
            WorkflowModel workflowModel = workflowSession.getModel("/var/workflow/models/ash-model");
            WorkflowData workflowData = workflowSession.newWorkflowData("JCR_PATH", pagePath);
            workflowSession.startWorkflow(workflowModel, workflowData);
            status = workflowSession.startWorkflow(workflowModel, workflowData).getState();
        } catch (WorkflowException e) {
            log.error("Unexpected error occurred: ", e);
            status = "Error: " + e.getMessage();
        }
        response.getWriter().write(status);
    }
}
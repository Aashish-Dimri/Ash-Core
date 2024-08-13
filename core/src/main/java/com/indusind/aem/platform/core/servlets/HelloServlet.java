package com.indusind.aem.platform.core.servlets;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.Servlet;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.osgi.service.component.annotations.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component(service = Servlet.class, property = {
    "sling.servlet.methods=GET",
    "sling.servlet.paths=/bin/custom/hello"
})
public class HelloServlet extends SlingSafeMethodsServlet {

    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws IOException {
      String companyCode = request.getParameter("cCode");
      String bassCode = request.getParameter("bCode");
      boolean bassFlow = false;

      HashMap<String, String> map = new HashMap<>();
      map.put("company12", "bass12");
      map.put("company123", "bass123");
      map.put("company1234", "bass1234");

      if (bassCode != null && bassCode.equals(map.get(companyCode))) {
        bassFlow = true;
        String basePath = "/content/dam/HDFCSavingsUnifiedURL/banners/" + companyCode;
        String webfile = basePath + "/1440x200.jpg";
        String logo = "/content/dam/HDFCSavingsUnifiedURL/banners/" + bassCode + "/logo.png";

        HashMap<String, Object> jsonResponse = new HashMap<>();
        jsonResponse.put("bassFlow", bassFlow);
        jsonResponse.put("webfile", webfile);
        jsonResponse.put("logo", logo);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        ObjectMapper objectMapper = new ObjectMapper();
        response.getWriter().write(objectMapper.writeValueAsString(jsonResponse));
      }
      else{
        response.getWriter().write("Company Code and Promo Code Does not match with each other");
      } 
    }
}

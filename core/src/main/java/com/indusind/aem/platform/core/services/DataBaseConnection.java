package com.indusind.aem.platform.core.services;

import java.sql.Connection;
import java.sql.DriverManager;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DataBaseConnection extends SlingAllMethodsServlet {

    private static final Logger log = LoggerFactory.getLogger(DataBaseConnection.class);
    
    public static Connection getConnection(){
        log.info("getting started");
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/office", "root", "root");
            log.info("Connected to the Data Base");
            }
            catch(Exception e)
            {
                log.error("Not Connected to the DataBase"+e.toString());
            }
            return conn;
    }

}
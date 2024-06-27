package com.indusind.aem.platform.core.servlets;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.indusind.aem.platform.core.services.DataBaseConnection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.Servlet;
import javax.servlet.ServletException;

@Component(service = Servlet.class, property = {
    "sling.servlet.methods=POST", 
    "sling.servlet.paths=/bin/crud"
})
public class Dbcrud extends SlingAllMethodsServlet {
    
    private static final Logger LOG = LoggerFactory.getLogger(Dbcrud.class);
    
    @Override
    protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/plain");
        String table = request.getParameter("tableName");
        String fname = request.getParameter("fName");
        String lname = request.getParameter("lName");
        String id = request.getParameter("id");
        String position = request.getParameter("position");
        String operation = request.getParameter("Source");
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs =null;
        conn = DataBaseConnection.getConnection();
        if (conn == null) {
            LOG.error("Failed to obtain database connection.");
            response.getWriter().println("Error: Unable to connect to the database.");
            return;
        }
        try {
            conn = DataBaseConnection.getConnection();
            if (conn == null) {
                LOG.error("Failed to obtain database connection.");
                response.getWriter().println("Error: Unable to connect to the database.");
                return;
            }

            switch (operation) {
                case "Create":
                    stmt = conn.prepareStatement("INSERT INTO employees (firstname, lastname, id, position) VALUES (?, ?, ?, ?)");
                    stmt.setString(1, fname);
                    stmt.setString(2, lname);
                    stmt.setString(3, id);
                    stmt.setString(4, position);
                    int addStatus = stmt.executeUpdate();
                    response.getWriter().println(addStatus > 0 ? "Inserted Successfully" : "Error while inserting");
                    break;

                case "Read":
                    StringBuilder result = new StringBuilder();
                    stmt = conn.prepareStatement("SELECT * FROM employees");
                    rs = stmt.executeQuery();
                    while (rs.next()) {
                        String firstName = rs.getString("firstname");
                        String lastName = rs.getString("lastname");
                        String pos = rs.getString("position");
                        String empId = rs.getString("id");
                        result.append(firstName).append(" ").append(lastName).append(" is added as ").append(pos).append(" with Employee Id: ").append(empId).append("\n");
                    }
                    response.getWriter().print(result.toString());
                    break;

                case "Update":
                    stmt = conn.prepareStatement("SELECT COUNT(*) FROM employees WHERE id = ?");
                    stmt.setString(1, id);
                    rs = stmt.executeQuery();
                    if (rs.next() && rs.getInt(1) > 0) {
                        stmt = conn.prepareStatement("UPDATE employees SET firstname=?, lastname=?, position=? WHERE id=?");
                        stmt.setString(1, fname);
                        stmt.setString(2, lname);
                        stmt.setString(3, position);
                        stmt.setString(4, id);
                        int updateStatus = stmt.executeUpdate();
                        response.getWriter().println(updateStatus > 0 ? "Updated Successfully" : "Can't update");
                    } else {
                        stmt = conn.prepareStatement("INSERT INTO employees (firstname, lastname, id, position) VALUES (?, ?, ?, ?)");
                        stmt.setString(1, fname);
                        stmt.setString(2, lname);
                        stmt.setString(3, id);
                        stmt.setString(4, position);
                        int insertStatus = stmt.executeUpdate();
                        response.getWriter().println(insertStatus > 0 ? "Inserted Successfully" : "Error while inserting");
                    }
                    break;

                case "Delete":
                    stmt = conn.prepareStatement("DELETE FROM employees WHERE id=?");
                    stmt.setString(1, id);
                    int deleteStatus = stmt.executeUpdate();
                    response.getWriter().println(deleteStatus > 0 ? "Deleted Successfully" : "Can't delete");
                    break;

                default:
                    response.getWriter().println("Invalid operation");
                    break;
            }
        } catch (SQLException se) {
            LOG.error("SQL Exception: ", se);
            response.getWriter().println("SQL Exception: " + se.getMessage());
        } catch (Exception e) {
            LOG.error("Exception: ", e);
            response.getWriter().println("Exception: " + e.getMessage());
        } finally { 
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException se) {
                LOG.error("SQL Exception during statement close: ", se);
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                LOG.error("SQL Exception during connection close: ", se);
            }
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException se) {
                LOG.error("SQL Exception during resultset close: ", se);
            }
        }
    }
}

package org.geektimes.projects.servlet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * TODO
 *
 * @author: Yu
 * @since: 1.0
 */
public class JumpServlet extends HttpServlet {
    private Logger logger = Logger.getLogger(JumpServlet.class.getName());
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            Context initCtx = new InitialContext();
            Context envCtx = (Context) initCtx.lookup("java:comp/env");
            DataSource ds = (DataSource) envCtx.lookup("jdbc/EmployeeDB");
            Connection conn = ds.getConnection();
            resp.getWriter().write("Get Connection success !"+ conn.getClass());
            conn.close();
        }catch (NamingException | SQLException e){
            logger.log(Level.SEVERE,e.getMessage());
            resp.getWriter().write("Get Connection fail !"+ e.getMessage());

        }
    }
}

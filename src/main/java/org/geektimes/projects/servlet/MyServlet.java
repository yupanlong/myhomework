package org.geektimes.projects.servlet;

import javax.jws.WebService;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * TODO
 *
 * @author: Yu
 * @since: 1.0
 */
@WebServlet(name = "myServlet",value = "/myServlet")
public class MyServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("MyServlet 正在服务。。。");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/jumpServlet");
        requestDispatcher.forward(req,resp);
    }
}

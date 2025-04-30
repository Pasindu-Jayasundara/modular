package org.example.webapp.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.webapp.remote.ARemote;

import javax.naming.InitialContext;
import java.io.IOException;

@WebServlet("/home")
public class Home extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        resp.getWriter().println("<h1>This is Home</h1>");

        try {

            InitialContext initialContext = new InitialContext();
            ARemote aRemote = (ARemote) initialContext.lookup("java:global/app-module/A");

            aRemote.m();

        }catch (Exception e) {
            e.printStackTrace();
        }

    }
}

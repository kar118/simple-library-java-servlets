package com.example.servlets.servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect(getServletContext().getContextPath());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");

        if("admin".equals(login)) {
            RequestDispatcher adminDispatcher =
                    request.getRequestDispatcher("admin-login");
            adminDispatcher.forward(request, response);
        } else {
            RequestDispatcher userDispatcher =
                    request.getRequestDispatcher("user-login");
            userDispatcher.forward(request, response);
        }
    }
}

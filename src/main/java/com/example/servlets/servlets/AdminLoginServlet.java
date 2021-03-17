package com.example.servlets.servlets;

import com.example.servlets.enums.Role;
import com.example.servlets.models.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AdminLoginServlet", value = "/admin-login")
public class AdminLoginServlet extends HttpServlet {
    private final String ADMIN_LOGIN = "admin";
    private final String ADMIN_PASSWORD = "admin";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User(request.getParameter("login"), request.getParameter("password"), Role.ADMIN);

        RequestDispatcher requestDispatcher;

        if(ADMIN_LOGIN.equals(user.getLogin()) && ADMIN_PASSWORD.equals(user.getPass())) {
            requestDispatcher = request.getRequestDispatcher("admin");
            request.getServletContext().setAttribute("user", user);
        } else {
            requestDispatcher = request.getRequestDispatcher("loginFailed.html");
        }
        requestDispatcher.forward(request, response);
    }
}

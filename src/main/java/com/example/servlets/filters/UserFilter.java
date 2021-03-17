package com.example.servlets.filters;

import com.example.servlets.enums.Role;
import com.example.servlets.models.User;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "UserFilter", urlPatterns = {"/dashboard"})
public class UserFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        User user = (User) request.getServletContext().getAttribute("user");

        HttpServletResponse httpServletResponse = (HttpServletResponse) response;

        if (user != null && user.getRole().equals(Role.ADMIN)) {
            httpServletResponse.sendRedirect("admin");
        } else if (user == null) {
            httpServletResponse.sendRedirect("login.html");
        }

        chain.doFilter(request, response);
    }
}

package com.example.servlets.servlets;

import com.example.servlets.models.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

@WebServlet(name = "UserLoginServlet", value = "/user-login")
public class UserLoginServlet extends HttpServlet {
    private HashMap<String, String> userDatabase;

    @Override
    public void init() throws ServletException {
        userDatabase = new HashMap<>();
        userDatabase.put("john", "smith");
        userDatabase.put("jack","mac");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User(request.getParameter("login"), request.getParameter("password"));

        Boolean isUserValid = checkUser(user);

        RequestDispatcher requestDispatcher;

        if (isUserValid) {
            requestDispatcher = request.getRequestDispatcher("dashboard");
            request.getServletContext().setAttribute("user", user);
        } else {
            requestDispatcher = request.getRequestDispatcher("loginFailed.html");
        }
        requestDispatcher.forward(request, response);
    }

    private boolean checkUser(User user) {
        if (userDatabase.containsKey(user.getLogin())) {
            return userDatabase.get(user.getLogin()).equals(user.getPass());
        }

        return false;
    }
}

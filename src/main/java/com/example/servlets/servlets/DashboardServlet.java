package com.example.servlets.servlets;

import com.example.servlets.models.Book;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

import static com.example.servlets.wrappers.HTMLWrapper.getHTMLFoot;
import static com.example.servlets.wrappers.HTMLWrapper.getHTMLHead;

@WebServlet(name = "DashboardServlet", value = "/dashboard")
public class DashboardServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext servletContext = request.getServletContext();
        ArrayList<Book> books = (ArrayList<Book>) servletContext.getAttribute("books");

        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");

        Writer writer = response.getWriter();

        writer.write(getHTMLHead());

        for (Book book : books) {
            writer.write("<li>" + book.toString() + "</li>" + "</br>");
        }

        writer.write(getHTMLFoot());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}

package com.example.servlets.servlets;

import com.example.servlets.models.Book;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

import static com.example.servlets.wrappers.HTMLWrapper.*;

@WebServlet(name = "AdminServlet", value = "/admin")
public class AdminServlet extends HttpServlet {
    private ServletContext servletContext = null;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        servletContext = request.getServletContext();
        ArrayList<Book> books = (ArrayList<Book>) servletContext.getAttribute("books");

        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");

        Writer writer = response.getWriter();

        writer.write(getHTMLHead());

        for (Book book : books) {
            writer.write(book.toString()+ "</br>");
        }

        writer.write(getAddBookHTMLForm());
        writer.write(getRemoveBookHTMLForm());
        writer.write(getHTMLFoot());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("book-title") != null ? request.getParameter("book-title") : null;
        String author = request.getParameter("book-author") != null ? request.getParameter("book-author") : null;
        Integer year = request.getParameter("book-year") != null ? Integer.valueOf(request.getParameter("book-year")) : null;

        String titleToRemove = request.getParameter("title-to-remove") != null ? request.getParameter("title-to-remove") : null;

        if (title != null && author != null && year != null)  {
            Book book = new Book(title, author, year);
            ArrayList<Book> books;

            servletContext = request.getServletContext();
            books = ((ArrayList<Book>) servletContext.getAttribute("books"));
            books.add(book);
            servletContext.setAttribute("books", books);

        } else if (titleToRemove != null) {
            ArrayList<Book> books;

            servletContext = request.getServletContext();
            books = ((ArrayList<Book>) servletContext.getAttribute("books"));
            books.removeIf(book -> book.getTitle().equals(titleToRemove));
            servletContext.setAttribute("books", books);
        }

        doGet(request, response);
    }
}

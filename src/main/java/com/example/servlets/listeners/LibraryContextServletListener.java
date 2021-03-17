package com.example.servlets.listeners;

import com.example.servlets.models.Book;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.ArrayList;

@WebListener
public class LibraryContextServletListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book("Ogniem i Mieczem", "Henryk Sienkiewicz", 1884));
        books.add(new Book("Potop", "Henryk Sienkiewicz", 1886));
        books.add((new Book("Pan Wołodyjowski", "Henryk Sienkiewicz", 1888)));

        sce.getServletContext().setAttribute("books", books);
    }
}

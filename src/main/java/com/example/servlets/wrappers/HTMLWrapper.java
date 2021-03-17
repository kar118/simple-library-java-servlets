package com.example.servlets.wrappers;

public class HTMLWrapper {
    public static String getHTMLHead() {
        return "<!doctype html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "  <meta charset=\"utf-8\">\n" +
                "  <title>Library</title>\n" +
                "  <link rel=\"stylesheet\" href=\"css/dashboard-style.css\">\n" +
                "</head>\n" +
                "<body>" +
                "<h4>All books</h4>";
    }

    public static String getHTMLFoot() {
        return "</body>" +
                "</html>";
    }

    public static String getRemoveBookHTMLForm() {
        return  "<h4>Remove book</h4>" +
                "<form action=\"admin\" method=\"post\">\n" +
                "   <label>Title of the book to remove</label>\n" +
                "   <input type=\"text\" name=\"title-to-remove\">\n" +
                "   <button>Remove</button>\n" +
                "</form>";
    }

    public static String getAddBookHTMLForm() {
        return  "<h4>Add book</h4>" +
                "<form action=\"admin\" method=\"post\">\n" +
                "   <label>Name</label>\n" +
                "   <input type=\"text\" name=\"book-title\">\n" +
                "   <label>Author</label>\n" +
                "   <input type=\"text\" name=\"book-author\">\n" +
                "   <label>Year</label>\n" +
                "   <input type=\"number\" name=\"book-year\">\n" +
                "   <button>Add</button>\n" +
                "</form>";
    }
}

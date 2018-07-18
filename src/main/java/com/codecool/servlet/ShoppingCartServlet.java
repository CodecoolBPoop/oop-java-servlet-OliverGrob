package com.codecool.servlet;

import com.codecool.items.Item;
import com.codecool.items.ItemStore;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "shoppingCartServlet", urlPatterns = {"/shoppingcart"}, loadOnStartup = 1)
public class ShoppingCartServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        PrintWriter out = response.getWriter();
        String title = "I do hate strings!";
        StringBuilder tableContent = new StringBuilder();

        if (ItemStore.getShoppingCartItems().size() != 0) {
            tableContent.append("<tr>\n" + "<th>Item</th>\n" + "<th>Price</th>\n" + "</tr>\n");
            for (Item item : ItemStore.getShoppingCartItems()) {
                tableContent.append("<tr>\n" + "<td>")
                        .append(item.getName())
                        .append("</td>\n")
                        .append("<td>")
                        .append(item.getPrice())
                        .append("</td>\n" + "</tr>\n");
            }
        } else {
            tableContent.append("<h2>Your cart is empty!</h2>\n");
        }

        out.println(
                "<html>\n" +
                    "<head><title>" + title + "</title>" +
                        "<style>" +
                            "#link {" +
                                "font-family: \"Trebuchet MS\", Arial, Helvetica, sans-serif;" +
                            "}" +
                            "#items {" +
                                "font-family: \"Trebuchet MS\", Arial, Helvetica, sans-serif;" +
                                "border-collapse: collapse;" +
                                "width: 200px;" +
                            "}" +
                            "#items td, #items th {" +
                                "border: 1px solid #ddd;" +
                                "padding: 8px;" +
                                "text-align: center;" +
                                "}" +
                            "#items tr:nth-child(even){background-color: #f2f2f2;}" +
                            "#items tr:hover {background-color: #ddd;}" +
                            "#items th {" +
                                "padding-top: 12px;" +
                                "padding-bottom: 12px;" +
                                "background-color: #4CAF50;" +
                                "color: white;" +
                            "}" +
                        "</style>" +
                    "</head>\n" +
                    "<body>\n" +
                        "<h1 align = \"center\">" + title + "</h1>\n" +
                        "<table id =\"items\">\n" +
                            tableContent +
                        "</table>\n" +
                        "<h2 id = \"link\"><a href=\"/webshop\">Back to webshop</a></h2>" +
                "</body></html>"
        );
    }

}

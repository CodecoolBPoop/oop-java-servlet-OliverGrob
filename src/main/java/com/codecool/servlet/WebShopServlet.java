package com.codecool.servlet;

import com.codecool.items.Item;
import com.codecool.items.ItemFactory;
import com.codecool.items.ItemStore;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "webShopServlet", urlPatterns = {"/webshop"}, loadOnStartup = 1)
public class WebShopServlet extends HttpServlet {

    private static int visitCounter = 0;


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        if (visitCounter == 0) {
            this.init(8);
        }

        PrintWriter out = response.getWriter();
        String title = "I do hate strings!";
        StringBuilder tableContent = new StringBuilder();

        for (Item item : ItemStore.getShopItems()) {
            tableContent.append("<tr>\n" + "<td>")
                    .append(item.getName())
                    .append("</td>\n")
                    .append("<td>")
                    .append(item.getPrice())
                    .append("</td>\n" + "<td>" + "<form action=\"/webshop\" method=\"POST\">\n")
                    .append("<input name=\"itemNumber\" value=")
                    .append(item.getNumber())
                    .append(" hidden>\n")
                    .append("<input name=\"add\" type=\"submit\" value=\"Add\">\n")
                    .append("</form>" + "</td>\n" + "<td>" + "<form action=\"/webshop\" method=\"POST\">\n")
                    .append("<input name=\"itemName\" value=")
                    .append(item.getName())
                    .append(" hidden>\n")
                    .append("<input name=\"remove\" type=\"submit\" value=\"Remove\">\n")
                    .append("</form>" + "</td\n>" + "</tr>\n");
        }

        out.println(
                "<html>\n" +
                    "<head><title>" + title + "</title>" +
                        "<style>" +
                            "form {" +
                                "margin: 0;" +
                            "}" +
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
                        "<tr>\n" +
                            "<th>Item</th>\n" +
                            "<th>Price</th>\n" +
//                            "<th>Add</th>\n" +
//                            "<th>Remove</th>\n" +
                        "</tr>\n" +
                        tableContent +
                    "</table>\n" +
                    "<h2 id = \"link\"><a href=\"/shoppingcart\">View shopping cart</a></h2>" +
                "</body></html>"
        );
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        if (request.getParameter("add") != null) {
            ItemFactory itemFactory = new ItemFactory();
            ItemStore.addItemToShoppingCart(itemFactory.getItem(Integer.valueOf(request.getParameter("itemNumber"))));
        } else if (request.getParameter("remove") != null) {
            ItemStore.removeItemFromShoppingCart(request.getParameter("itemName"));
        }

        response.sendRedirect(request.getContextPath() + "/webshop");
    }

    private void init(int numberOfItems) {
        ItemFactory itemFactory = new ItemFactory();

        for (int i = 0; i < numberOfItems; i++) {
            ItemStore.addItemToShop(itemFactory.getItem(i));
        }
        visitCounter++;
    }

}

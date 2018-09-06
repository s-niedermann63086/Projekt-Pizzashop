package org.test.webapp.project;

import org.test.webapp.project.service.PizzashopService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Hello servlet
 */
@WebServlet("/pizzashop")
public class PizzaServlet extends HttpServlet    {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        PrintWriter writer = new PrintWriter(resp.getWriter());

        PizzashopService pizzashopService = new PizzashopService();

        String id = req.getParameter("idanzahl");

        int idInt = 0;

        String pizzaString = "hallo";

        if (id != null) {
            idInt = pizzashopService.idToInt(id);
        }

        if (idInt >= 1) {
            pizzaString = pizzashopService.getPizzaId(idInt);
        }


        writer.write("<html>");
        writer.write("<head>");
        writer.write("<title>Pizza Contentezza</title>");
        writer.write("</head>");
        writer.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\">");
        writer.write("<body>");
        writer.write("<h1>Welcome to Pizza Contentezza</h1>");
        writer.write("<br>\n");
        writer.write("show Pizza <form><label for=\"idanzahl\">Nummer: <input id=\"idanzahl\" name=\"idanzahl\"></label></form>");
        writer.write("<br>\n");
        writer.write(pizzaString);
        writer.write("<br>\n");
        writer.write("<table>");
        writer.write("<tr>");
        writer.write("<th>Pizza</th>");
        writer.write("<th>Preis</th>");
        writer.write("</tr><tr>");
        writer.write("<td>Margherita</td>");
        writer.write("<td>15,50.-</td>");
        writer.write("</tr><tr>");
        writer.write("<td>Prosciutto</td>");
        writer.write("<td>16,50.-</td>");
        writer.write("</tr><tr>");
        writer.write("<td>Salami</td>");
        writer.write("<td>16,50.-</td>");
        writer.write("</tr><tr>");
        writer.write("<td>Calabrese</td>");
        writer.write("<td>16,50.-</td>");
        writer.write("</tr><tr>");
        writer.write("<td>Diavola</td>");
        writer.write("<td>18.-</td>");
        writer.write("</tr></table>");
        writer.write("<br>\n");
        writer.write("<a href=\"Formular.html\">Bestellformular</a>");


        writer.write("</body>");
        writer.write("</html>");
    }
}

package org.test.webapp.project;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Hello servlet
 */
@WebServlet("/Formular.html")
public class BestellServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        PrintWriter writer = new PrintWriter(resp.getWriter());

        String paramName = "myParameter";
        String paramValue = req.getParameter(paramName);

        writer.write("<html>");
        writer.write("<head>");
        writer.write("<meta charset=\"utf-8\">");
        writer.write("<title>Pizzashop Formular für ihre Bestellung</title>");
        writer.write("</head>");
        writer.write("<body>");
        writer.write("<h1>Das Formular für ihre Bestellung</h1>");
        writer.write("<form>");
        writer.write("<fieldset>");
        writer.write("<label for=\"vname\">Vorname:\n" +
                "\t\t\t\t<input id=\"vname\" name=\"vname\">\n" +
                "\t\t\t</label>");
        writer.write("<label for=\"sname\">Nachname:\n" +
                "\t\t\t\t<input id=\"sname\" name=\"sname\"> </tr>\n" +
                "\t\t\t</label> |||");
        writer.write("<label for=\"viasname\">Per Nachname</label>\n" +
                "\t\t\t\t<input type=\"radio\" id=\"viasname\" name=\"zahlungsart\" value=\"0\">");
        writer.write("<label for=\"viarech\">Per Rechnung</label>\n" +
                "\t\t\t\t<input type=\"radio\" id=\"viarech\" name=\"zahlungsart\" value=\"1\">");
        writer.write("<br> <br> <label for=\"street\">Strasse:\n" +
                "\t\t\t\t<input id=\"street\" name=\"street\">");
        writer.write("<label for=\"town\">Ort:\n" +
                "\t\t\t\t<input id=\"town\" name=\"town\">");
        writer.write("<label for=\"number\">Postleitzahl:\n" +
                "\t\t\t\t<input id=\"number\" name=\"number\">");
        writer.write("<br> <br> <label for=\"tel\">Telefonnummer:\n" +
                "\t\t\t\t<input id=\"tel\" name=\"tel\">");
        writer.write("<label for=\"mailaddress\">e-Mail:\n" +
                "\t\t\t\t<input id=\"mailaddress\" name=\"mailaddress\">");
        writer.write("<label for=\"epass\">e-Mail Passwort:\n" +
                "\t\t\t\t<input id=\"epass\" name=\"epass\">");
        writer.write("</form>");
        writer.write("</body>");
        writer.write("</html>");

    }

}
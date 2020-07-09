package proyecto2.servicios;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import proyecto2.modelo.ListaExtras;
import proyecto2.modelo.dao.GestorExtras;

/**
 *
 * @author Morag
 */
@WebServlet(name = "ServicioPrueba", urlPatterns = "/ServicioPrueba")
public class ServicioPrueba extends HttpServlet { 

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println(listaExtrasJSON());
        }
    }

    public String listaExtrasJSON() {
        GestorExtras g = new GestorExtras();
        ListaExtras ext = new ListaExtras(g.listarExtras());
        System.out.println("Productos: "+ ext.toString());
        return ext.toString();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Servicio Prueba";
    }

    public static void main(String[] args) {
        System.out.println(new ServicioPrueba().listaExtrasJSON());
    }
}

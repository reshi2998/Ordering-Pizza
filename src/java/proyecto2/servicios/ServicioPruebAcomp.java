package proyecto2.servicios;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import proyecto2.modelo.ListaAcompanamientos;
import proyecto2.modelo.dao.GestorAcompanamiento;

/**
 *
 * @author Morag
 */
@WebServlet(name = "ServicioPruebAcomp", urlPatterns = "/ServicioPruebAcomp")
public class ServicioPruebAcomp  extends HttpServlet { 

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println(listaAcompanamientosJSON());
        }
    }

    public String listaAcompanamientosJSON() {
        GestorAcompanamiento g = new GestorAcompanamiento();
        ListaAcompanamientos ext = new ListaAcompanamientos(g.listarAcomp());
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
        return "Servicio Prueba Acompanamiento";
    }

    public static void main(String[] args) {
        System.out.println(new ServicioPruebAcomp().listaAcompanamientosJSON());
    }
}

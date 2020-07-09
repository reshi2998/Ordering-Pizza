package proyecto2.servicios;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import static java.lang.System.out;
import java.nio.charset.StandardCharsets;
import java.util.Enumeration;
import java.util.Optional;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.JSONArray;
import org.json.JSONObject;
import proyecto2.modelo.dao.GestorPizza;

// ServicioAgregarPizza.java
//
// EIF209 - Programación 4 - Proyecto #2
// Junio 2020
//
// Autores:
//    - 207950788     Sara Moraga Alfara
//    - 116980485     Scarleth Villarreal Jímenez
//    - 117250099     Josué Víquez Campos

@WebServlet(name = "ServicioAgregarPizza", urlPatterns = {"/ServicioAgregarPizza"})
@MultipartConfig
public class ServicioAgregarPizza extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.setCharacterEncoding(StandardCharsets.UTF_8.toString());
        encoding = Optional.of(request.getCharacterEncoding());
        System.out.printf("request character encoding: '%s'%n", encoding.get());
        response.setContentType("application/json;charset=UTF-8");
        
        try (PrintWriter out = response.getWriter()) {
            JSONObject r = new JSONObject();

            String id_Pizza = request.getParameter("id_pizza");
            String tamano = request.getParameter("tamano");
            String tipo_pasta = request.getParameter("tipo_pasta");
            String nombre_pizza = request.getParameter("nombre_pizza");

//            int idPizza = gestor.obtenerIdPizza(tamano, tipo_pasta, nombre_pizza);
            HttpSession sesion = request.getSession(true);
            sesion.setAttribute("idPizza", id_Pizza);
            
//            r.put("id_pizza", idPizza);
//            System.out.println(r.toString(4));
//            out.println(r);

            StringBuilder resp = new StringBuilder();
            resp.append("{\"result\": \"ok\"}"); 
            out.println(resp);

        }
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
        return "Short description";
    }
    
    private String toUTF8String(String s) throws UnsupportedEncodingException {
        return encoding.isPresent() ? s : new String(s.getBytes(), StandardCharsets.UTF_8);
    }

    private Optional<String> encoding;

    GestorPizza gestor = new GestorPizza();
}

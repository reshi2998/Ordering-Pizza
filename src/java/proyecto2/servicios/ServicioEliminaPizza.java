
package proyecto2.servicios;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Optional;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import proyecto2.modelo.dao.GestorPizza;

// ServicioLogin.java
//
// EIF209 - Programación 4 - Proyecto #2
// Junio 2020
//
// Autores:
//    - 207950788     Sara Moraga Alfara
//    - 116980485     Scarleth Villarreal Jiménez
//    - 117250099     Josué Víquez Campos

@WebServlet(name = "ServicioEliminaPizza", urlPatterns = {"/ServicioEliminaPizza"})
@MultipartConfig
public class ServicioEliminaPizza extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.setCharacterEncoding(StandardCharsets.UTF_8.toString());
        encoding = Optional.of(request.getCharacterEncoding());
        System.out.printf("request character encoding: '%s'%n", encoding.get());
        response.setContentType("application/json;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            
            String idPizza = request.getParameter("id_pizza");
            int id = Integer.parseInt(idPizza);
            
            if(gestor.eliminarPizza(id)){
                StringBuilder resp = new StringBuilder();
                resp.append("{\"result\": \"ok\"}"); 
                out.println(resp);
            } else{
                StringBuilder resp = new StringBuilder();
                resp.append("{\"result\": \"no\"}"); 
                out.println(resp);
            }
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
    }// </editor-fold>
    
    GestorPizza gestor = new GestorPizza();
    private Optional<String> encoding;

}

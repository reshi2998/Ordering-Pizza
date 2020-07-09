
package proyecto2.servicios;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import proyecto2.modelo.dao.GestorComentarios;

// ServicioCambiarClave.java
//
// EIF209 - Programación 4 - Proyecto #2
// Junio 2020
//
// Autores:
//    - 207950788     Sara Moraga Alfara
//    - 116980485     Scarleth Villarreal Jímenez
//    - 117250099     Josué Víquez Campos

@WebServlet(name = "ServiciosComentarios", urlPatterns = {"/ServiciosComentarios"})
@MultipartConfig
public class ServiciosComentarios extends HttpServlet {

    GestorComentarios gestor = new GestorComentarios();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
      
        String coment = request.getParameter("comentario");
        
        
        boolean exito = false;
        exito = gestor.insertarComentario(coment);
        if(exito){
            response.sendRedirect("paginaCliente.jsp");
        } else{
            response.sendRedirect("index.jsp");
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

}

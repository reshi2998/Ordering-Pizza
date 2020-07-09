package proyecto2.servicios;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;import javax.servlet.http.HttpSession;
;
import proyecto2.modelo.dao.GestorUsuario;

// ServicioLogin.java
//
// EIF209 - Programación 4 - Proyecto #2
// Junio 2020
//
// Autores:
//    - 207950788     Sara Moraga Alfara
//    - 116980485     Scarleth Villarreal Jímenez
//    - 117250099     Josué Víquez Campos


public class ServicioLogin extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8"); 
        PrintWriter out = response.getWriter();
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        if (username != null && !username.isEmpty() && password != null && !password.isEmpty()) {
            // Falta validar campos incompletos
            if (gestor.validarUsuario(username, password)) {
                // Obtiene el rol para saber a cual pagina redirigir
                int rol = gestor.obtenerRol(username);
                if (rol == 1) {
                    HttpSession sesion = request.getSession(true);
                    sesion.setAttribute("usuario", username);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/paginaCliente.jsp");
                    dispatcher.forward(request, response);
                } else {
                    HttpSession sesion = request.getSession(true);
                    sesion.setAttribute("usuario", username);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/paginaAdmin.jsp");
                    dispatcher.forward(request, response);
                }
            } else {
                RequestDispatcher dispatcher = request.getRequestDispatcher("/ventanasModales/errorLogin.jsp");
                dispatcher.forward(request, response);
            }
        } else{
            RequestDispatcher dispatcher = request.getRequestDispatcher("/ventanasModales/errorLogin.jsp");
            dispatcher.forward(request, response);
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
    
    GestorUsuario gestor = new GestorUsuario();
}

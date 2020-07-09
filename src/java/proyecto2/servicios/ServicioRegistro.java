package proyecto2.servicios;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import proyecto2.modelo.dao.GestorCliente;
import proyecto2.modelo.dao.GestorUsuario;

// ServicioRegistro.java
//
// EIF209 - Programación 4 - Proyecto #2
// Junio 2020
//
// Autores:
//    - 207950788     Sara Moraga Alfara
//    - 116980485     Scarleth Villarreal Jímenez
//    - 117250099     Josué Víquez Campos

public class ServicioRegistro extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.setHeader("cache-control", "no-cache, no-store, must-revalidate");
        
        boolean valido = false;
        boolean valido2 = false;
        String idCli = request.getParameter("cedClient");
        String idUsu = request.getParameter("idClient");
        String clave = request.getParameter("clave");
        String apell = request.getParameter("apelli");
        String nomb = request.getParameter("nomb");
        String direc = request.getParameter("direccion");
        String tel = request.getParameter("telefono");
        
        if (idCli != null && idUsu != null && apell != null && nomb != null && direc != null && tel != null && clave != null) {
            valido2 = servU.insertarUsuario(idUsu, clave, 1);                             //inserta un nuevo usuario
            valido = servC.insertarCliente(idCli, idUsu, apell, nomb, direc, tel);    //inserta un nuevo cliente
        }

        if (valido && valido2) {
            response.sendRedirect("index.jsp");
        } else {
            response.sendRedirect("registro.jsp");
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

    GestorCliente servC = new GestorCliente();
    GestorUsuario servU = new GestorUsuario();
}
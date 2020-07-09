/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2.servicios;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import proyecto2.modelo.dao.GestorOrdenes;

// ServicioProductos.java
//
// EIF209 - Programación 4 - Proyecto #2
// Junio 2020
//
// Autores:
//    - 207950788     Sara Moraga Alfara
//    - 116980485     Scarleth Villarreal Jímenez
//    - 117250099     Josué Víquez Campos

@WebServlet(name = "ServicioProductos", urlPatterns = {"/ServicioProductos"})
@MultipartConfig
public class ServicioProductos extends HttpServlet {
    GestorOrdenes gestor = new GestorOrdenes();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String idP = request.getParameter("producto");
        Integer aux = Integer.parseInt(idP);
        
        if(idP != null ){
          request.setAttribute("consultaOrden", gestor.listarOrdenPizza(aux));
      }
      RequestDispatcher dispatcher = request.getRequestDispatcher("reporteProductos.jsp");
        dispatcher.forward(request, response);
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
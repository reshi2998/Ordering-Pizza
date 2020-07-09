
package proyecto2.servicios;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONObject;
import proyecto2.modelo.Comentarios;
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

@WebServlet(name = "ServicioComenReci", urlPatterns = {"/ServicioComenReci"})
@MultipartConfig
public class ServicioComenReci extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");

        List<Comentarios> datos = gestor.obtenerListaComentarios();

        try (PrintWriter out = response.getWriter()) {
            JSONObject r = new JSONObject();
            JSONArray a = new JSONArray();

            for (int i = 0; i < datos.size(); i++) {
                JSONObject e = new JSONObject();
                e.put("comentario", datos.get(i).getComentario());
                e.put("fecha", datos.get(i).getFecha());
                a.put(e);
            }
            r.put("datos_comentarios", a);
            System.out.println(r.toString(4));
            out.println(r);
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
    
    GestorComentarios gestor = new GestorComentarios();
}


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
import proyecto2.modelo.dao.GestorOrdenes;

@WebServlet(name = "ServicioEliminarOrden", urlPatterns = {"/ServicioEliminarOrden"})
@MultipartConfig
public class ServicioEliminarOrden extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.setCharacterEncoding(StandardCharsets.UTF_8.toString());
        encoding = Optional.of(request.getCharacterEncoding());
        System.out.printf("request character encoding: '%s'%n", encoding.get());
        response.setContentType("application/json;charset=UTF-8");
        
        try (PrintWriter out = response.getWriter()) {
            
            int id = Integer.parseInt(request.getParameter("id"));
            if(gestor.eliminarOrden(id)){
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

    private Optional<String> encoding;
    
    GestorOrdenes gestor = new GestorOrdenes(); 
}

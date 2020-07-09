
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

@WebServlet(name = "ServicioEditarPizza", urlPatterns = {"/ServicioEditarPizza"})
@MultipartConfig
public class ServicioEditarPizza extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.setCharacterEncoding(StandardCharsets.UTF_8.toString());
        encoding = Optional.of(request.getCharacterEncoding());
        System.out.printf("request character encoding: '%s'%n", encoding.get());
        response.setContentType("application/json;charset=UTF-8");
        
        try (PrintWriter out = response.getWriter()) {
            
            int id = Integer.valueOf(request.getParameter("id"));
            String nombre = request.getParameter("nombre");
            String pasta = request.getParameter("pasta");
            String tamano = request.getParameter("tamano");
            String ingred = request.getParameter("ingredientes");
            Double precio = Double.valueOf(request.getParameter("precio"));
            int idImagen = 1;
            
            if(gestor.modificarPizza(tamano, pasta, nombre, ingred, precio, 1, id)){
                StringBuilder resp = new StringBuilder();
                resp.append("{\"result\": \"ok\"}"); 
                out.println(resp);
            } else{
                StringBuilder resp = new StringBuilder();
                resp.append("{\"result\": \"erro\"}"); 
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
    
    GestorPizza gestor = new GestorPizza();
}

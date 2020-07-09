
package proyecto2.servicios;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Optional;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONObject;
import proyecto2.modelo.Pizza;

@WebServlet(name = "ServicioLlenarEditar", urlPatterns = {"/ServicioLlenarEditar"})
@MultipartConfig
public class ServicioLlenarEditar extends HttpServlet {

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
            String ingred = request.getParameter("ingred");
            Double precio = Double.valueOf(request.getParameter("precio"));
            int idImagen = 1;
            
            Pizza pizza = new Pizza(id,tamano,pasta,nombre,ingred,precio,idImagen);
            
            ArrayList<Pizza> datos = new ArrayList<>();
            datos.add(pizza);
            
            JSONObject r = new JSONObject();
            JSONArray a = new JSONArray();

            for (int i = 0; i < datos.size(); i++) {
                JSONObject e = new JSONObject();
                e.put("id_pizza", pizza.getIdPizza());
                e.put("id_tamano", pizza.getTamano());
                e.put("pasta", pizza.getTipoPasta());
                e.put("nombre", pizza.getNomberPizza());
                e.put("ingredientes", pizza.getIngredientes());
                e.put("precio", pizza.getPrecio());
                e.put("imagen", pizza.getIdImagen());
                a.put(e);
            }
            r.put("datos_pizza", a);
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
    
    private Optional<String> encoding;

}


package proyecto2.servicios;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONObject;
import proyecto2.modelo.Pizza;
import proyecto2.modelo.dao.GestorPizza;

@WebServlet(name = "ServicioTablaPizzas", urlPatterns = {"/ServicioTablaPizzas"})
@MultipartConfig
public class ServicioTablaPizzas extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        
        ArrayList<Pizza> datos = gestorP.obtenerListaPizzas(); 
        try (PrintWriter out = response.getWriter()) {
            JSONObject r = new JSONObject();
            JSONArray a = new JSONArray();

            for (int i = 0; i < datos.size(); i++) {
                JSONObject e = new JSONObject();
                e.put("id_pizza", datos.get(i).getIdPizza());
                e.put("tamano", datos.get(i).getTamano());
                e.put("tipo_pasta", datos.get(i).getTipoPasta());
                e.put("nombre_pizza", datos.get(i).getNomberPizza());
                e.put("ingredientes", datos.get(i).getIngredientes());
                e.put("precio", datos.get(i).getPrecio());
                e.put("id_imagen", datos.get(i).getIdImagen());
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

    GestorPizza gestorP = new GestorPizza();
}

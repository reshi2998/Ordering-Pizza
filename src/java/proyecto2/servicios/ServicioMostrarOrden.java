
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
import javax.servlet.http.HttpSession;
import org.json.JSONArray;
import org.json.JSONObject;
import proyecto2.modelo.Ordenes;
import proyecto2.modelo.Pizza;
import proyecto2.modelo.dao.GestorOrdenes;
import proyecto2.modelo.dao.GestorPizza;

@WebServlet(name = "ServicioMostrarOrden", urlPatterns = {"/ServicioMostrarOrden"})
@MultipartConfig
public class ServicioMostrarOrden extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.setCharacterEncoding(StandardCharsets.UTF_8.toString());
        encoding = Optional.of(request.getCharacterEncoding());
        System.out.printf("request character encoding: '%s'%n", encoding.get());
        response.setContentType("application/json;charset=UTF-8");
        
        HttpSession sesionO = request.getSession(true);
        String idOrdenString = String.valueOf(sesionO.getAttribute("idOrden"));
        int idOrden = Integer.parseInt(idOrdenString);
        
        Ordenes orden = gestorO.obtenerOrden(idOrden);
        
        String pizza = String.valueOf(orden.getIdPizza())+" - "+gestorP.obtenerNombrePizza(orden.getIdPizza());
        
        ArrayList<Ordenes> datos = new ArrayList<>();
        datos.add(orden);
        
        try (PrintWriter out = response.getWriter()) {
            JSONObject r = new JSONObject();
            JSONArray a = new JSONArray();

            for (int i = 0; i < datos.size(); i++) {
                JSONObject e = new JSONObject();
                e.put("id_orden", idOrden);
                e.put("id_cliente", orden.getIdCliente());
                e.put("pizza", pizza);
                e.put("acomp", orden.getAcompanamiento());
                e.put("extras", orden.getExtras());
                e.put("unidadP", orden.getUnidadPizza());
                e.put("precioTot", orden.getPrecioTotal());
                a.put(e);
            }
            r.put("datos_orden", a);
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
    
    GestorOrdenes gestorO = new GestorOrdenes();
    GestorPizza gestorP = new GestorPizza();

}

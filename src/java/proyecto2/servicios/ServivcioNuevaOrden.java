
package proyecto2.servicios;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Enumeration;
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
import proyecto2.modelo.dao.GestorCliente;
import proyecto2.modelo.dao.GestorOrdenes;
import proyecto2.modelo.dao.GestorPizza;

@WebServlet(name = "ServivcioDetalles", urlPatterns = {"/ServivcioDetalles"})
@MultipartConfig
public class ServivcioNuevaOrden extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.setCharacterEncoding(StandardCharsets.UTF_8.toString());
        encoding = Optional.of(request.getCharacterEncoding());
        System.out.printf("request character encoding: '%s'%n", encoding.get());
        response.setContentType("application/json;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            
            String extras = request.getParameter("descripcionE");
            int totalGeneralE = Integer.parseInt(request.getParameter("totalGeneralE"));
            String acompanamientos = request.getParameter("descripcionA");
            int totalGeneralA = Integer.parseInt(request.getParameter("totalGeneralA"));
            int idPizza = Integer.parseInt(request.getParameter("idPizza"));
            
            HttpSession sesionCliente = request.getSession(true);
            String usuario = String.valueOf(sesionCliente.getAttribute("usuario"));
//            HttpSession sesion = request.getSession(true);
//            int idPizza = Integer.valueOf((String) sesion.getAttribute("idPizza"));
            
            double precioPizza = gestorP.obtenerPrecio(idPizza);
            String idCliente = gestorC.obtenerId(usuario);
            int unidadPizza = 1;
            double precioTotal = precioPizza + totalGeneralE + totalGeneralA;
            
            if(gestorO.insertarOrden(idPizza, acompanamientos, extras, idCliente, unidadPizza, precioTotal)){
                int idOrden = gestorO.obtenerIdOrden(idPizza, idCliente, precioTotal);
                HttpSession sesionO = request.getSession(true);
                sesionO.setAttribute("idOrden", idOrden);
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
    
    private String toUTF8String(String s) throws UnsupportedEncodingException {
        return encoding.isPresent() ? s : new String(s.getBytes(), StandardCharsets.UTF_8);
    }

    private Optional<String> encoding;

    private GestorOrdenes gestorO = new GestorOrdenes();
    private GestorPizza gestorP = new GestorPizza();
    private GestorCliente gestorC = new GestorCliente();

}

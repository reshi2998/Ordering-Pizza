package proyecto2.modelo.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import proyecto2.datos.BaseDatos;
import proyecto2.modelo.Acompanamientos;

/**
 *
 * @author Morag
 */
public class GestorAcompanamiento {

    public void agregar(Acompanamientos nuevoAcomp) {
        try (Connection cnx = obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(IMEC_Acompanamiento.AGREGAR.obtenerComando())) {
            stm.clearParameters();
            stm.setInt(1, nuevoAcomp.getIdAcompanamiento());
            stm.setString(2, nuevoAcomp.getNombre());
            stm.setDouble(3, nuevoAcomp.getPrecioAcomp());
            stm.setBoolean(4, nuevoAcomp.getDisponible());

            if (stm.executeUpdate() != 1) {
                throw new Exception("Error no determinado");
            }
        } catch (Exception ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
    }
    
   public List<Acompanamientos> listarAcomp(){
        List<Acompanamientos> r = new ArrayList<>();

        try (Connection cnx = obtenerConexion();
                Statement stm = cnx.createStatement();
                ResultSet rs = stm.executeQuery(IMEC_Acompanamiento.LISTAR.obtenerComando())) {
            while (rs.next()) {
                int id = rs.getInt("id_acompanamientos");
                String descripcion = rs.getString("nombre");
                double precioAcomp = rs.getDouble("precioAcomp");
                boolean disponible = rs.getBoolean("disponible");
                r.add(new Acompanamientos(id, descripcion, precioAcomp, disponible));
            }
        } catch (IOException
                | ClassNotFoundException
                | IllegalAccessException
                | InstantiationException
                | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
        return r;
    } 
   
    public JSONObject toJSON() {
        List<Acompanamientos> extras = listarAcomp();
        JSONArray a = new JSONArray();
        extras.forEach((p) -> {
            a.put(p.toJSON());
        });

        JSONObject r = new JSONObject();
        r.put("lista-acompanamientos", a);
        return r;
    }
   
   public Connection obtenerConexion() throws
            ClassNotFoundException,
            IllegalAccessException,
            InstantiationException,
            IOException,
            SQLException {
        BaseDatos bd = BaseDatos.obtenerInstancia();
        Connection cnx = bd.obtenerConexion();
        return cnx;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}


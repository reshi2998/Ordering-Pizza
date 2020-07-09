package proyecto2.modelo.dao;

// GestorUsuario.java

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
import proyecto2.modelo.Cliente;
import proyecto2.modelo.Extras;

//
// EIF209 - Programación 4 - Proyecto #2
// Junio 2020
//
// Autores:
//    - 207950788     Sara Moraga Alfaro
//    - 116980485     Scarleth Villarreal Jímenez
//    - 117250099     Josué Víquez Campos

public class GestorExtras {

    public void agregar(Extras nuevoExtras) {
        try (Connection cnx = obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(IMEC_Extras.AGREGAR.obtenerComando())) {
            stm.clearParameters();
            stm.setInt(1, nuevoExtras.getIdExtras());
            stm.setString(2, nuevoExtras.getNombre());
            stm.setDouble(3, nuevoExtras.getPrecio());
            stm.setBoolean(4, nuevoExtras.getDisponible());

            if (stm.executeUpdate() != 1) {
                throw new Exception("Error no determinado");
            }
        } catch (Exception ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
    }
    
   public List<Extras> listarExtras(){
        List<Extras> r = new ArrayList<>();

        try (Connection cnx = obtenerConexion();
                Statement stm = cnx.createStatement();
                ResultSet rs = stm.executeQuery(IMEC_Extras.LISTAR.obtenerComando())) {
            while (rs.next()) {
                int id = rs.getInt("id_extras");
                String descripcion = rs.getString("nombre");
                double precio = rs.getDouble("precio");
                boolean disponible = rs.getBoolean("disponible");
                r.add(new Extras(id, descripcion, precio, disponible));
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
        List<Extras> extras =  listarExtras();
        JSONArray a = new JSONArray();
        extras.forEach((p) -> {
            a.put(p.toJSON());
        });

        JSONObject r = new JSONObject();
        r.put("lista-extras", a);
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
        GestorCliente su = new GestorCliente();
         //System.out.println(su.insertarCliente("1234567", "papu", "Viquez", "Josue", "Llorente Flores", "88229933"));
        //System.out.println(su.obtenerCliente("enau"));
        //System.out.println(su.cambiarCliente("456789","enau","Vega Rojas","Salomon","San Jose","88888888"));
        List<Cliente> clientes = su.obtenerListaClientes();
        int i = 0;
        for (Cliente u : clientes) {
            System.out.printf("%4d: %s,%n", ++i, u);
       }

    }
}


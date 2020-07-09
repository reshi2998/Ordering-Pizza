
package proyecto2.modelo.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import proyecto2.datos.BaseDatos;
import proyecto2.modelo.Ordenes;
import proyecto2.modelo.Pizza;

/**
 *
 * @author Josue
 */
public class GestorOrdenes {
    
    public ArrayList<Ordenes> listarOrdenPizza(int idP) {
        ArrayList<Ordenes> r = new ArrayList<>();
        try (Connection cnx = obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(IMEC_Ordenes.LISTARPIZZA.obtenerComando());) {
            stm.clearParameters();
            stm.setInt(1, idP);
            try (ResultSet rs = stm.executeQuery()) {
                while (rs.next()) {
                    Ordenes o = new Ordenes(
                            rs.getInt("id_orden"),
                            rs.getInt("id_pizza"),
                            rs.getString("acompanamientos"),
                            rs.getString("extras"),
                            rs.getString("id_cliente"),
                            rs.getInt("unidad_pizza"),
                            rs.getDouble("precioTotal"),
                            rs.getDate("fecha")
                    );
                    r.add(o);
                }
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
 
    
    public boolean insertarOrden(int idP, String acomp, String extras, String idC, int unidadP, double precio ){
        try (Connection cnx = obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(IMEC_Ordenes.INSERTAR.obtenerComando());) {
            stm.clearParameters();
            stm.setInt(1, idP);
            stm.setString(2, acomp);
            stm.setString(3, extras);
            stm.setString(4, idC);
            stm.setInt(5, unidadP);
            stm.setDouble(6, precio);
            if(stm.executeUpdate() == 1) {
                return true;
            }
        } catch (IOException
                | ClassNotFoundException
                | IllegalAccessException
                | InstantiationException
                | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
        return false;
    }
    
    public ArrayList<Ordenes> listarOrdenFecha(String fecI, String fecF) {
        ArrayList<Ordenes> r = new ArrayList<>();
        try (Connection cnx = obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(IMEC_Ordenes.LISTARFECHA.obtenerComando());) {
            stm.clearParameters();
            stm.setString(1, fecI);
            stm.setString(2, fecF);
            try (ResultSet rs = stm.executeQuery()) {
                while (rs.next()) {
                    Ordenes o = new Ordenes(
                            rs.getInt("id_orden"),
                            rs.getInt("id_pizza"),
                            rs.getString("acompanamientos"),
                            rs.getString("extras"),
                            rs.getString("id_cliente"),
                            rs.getInt("unidad_pizza"),
                            rs.getDouble("precioTotal"),
                            rs.getDate("fecha")
                    );
                    r.add(o);
                }
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
    
    public boolean eliminarOrden(int idOrden){
        try (Connection cnx = obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(IMEC_Ordenes.ELIMINAR.obtenerComando());) {
            stm.clearParameters();
            stm.setInt(1, idOrden);
            if(stm.executeUpdate() == 1) {
                return true;
            }
        } catch (IOException
                | ClassNotFoundException
                | IllegalAccessException
                | InstantiationException
                | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
        return false;
    }
    
    public int obtenerIdOrden(int idP, String idU, double precio) {
        int id = 0;
        try (Connection cnx = obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(IMEC_Ordenes.OBTENER_ID.obtenerComando());) {
            stm.clearParameters();
            stm.setInt(1, idP);
            stm.setString(2, idU);
            stm.setDouble(3, precio);
            try (ResultSet rs = stm.executeQuery()) {
                if (rs.next()) {
                    id = rs.getInt("id_orden");
                }
            }
        } catch (IOException
                | ClassNotFoundException
                | IllegalAccessException
                | InstantiationException
                | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
        return id;
    }
    
    public Ordenes obtenerOrden(int idOrden) {
        Ordenes orden = null;
        try (Connection cnx = obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(IMEC_Ordenes.OBTENER_ORDEN.obtenerComando());) {
            stm.clearParameters();
            stm.setInt(1, idOrden);
            try (ResultSet rs = stm.executeQuery()) {
                if (rs.next()) {
                    orden = new Ordenes(rs.getInt("id_orden"),rs.getInt("id_pizza"), rs.getString("acompanamientos"), 
                            rs.getString("extras"), rs.getString("id_cliente"), rs.getInt("unidad_pizza"),  
                            rs.getDouble("precioTotal"));
                }
            }
        } catch (IOException
                | ClassNotFoundException
                | IllegalAccessException
                | InstantiationException
                | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
        return orden;
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

    // Funcionan bien
    public static void main(String[] args) {
//        GestorOrdenes su = new GestorOrdenes();
//        
//        System.out.println(su.obtenerIdOrden(21, "456789", 2000));

//        Ordenes o = su.obtenerOrden(2);
//        System.out.println(o.toString());
    }
}

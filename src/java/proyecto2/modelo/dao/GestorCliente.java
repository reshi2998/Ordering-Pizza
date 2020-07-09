package proyecto2.modelo.dao;


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import proyecto2.datos.BaseDatos;
import proyecto2.modelo.Cliente;

// GestorUsuario.java
//
// EIF209 - Programación 4 - Proyecto #2
// Junio 2020
//
// Autores:
//    - 207950788     Sara Moraga Alfaro
//    - 116980485     Scarleth Villarreal Jímenez
//    - 117250099     Josué Víquez Campos

public class GestorCliente {
    
    public boolean insertarCliente(String id, String user, String apellidos, String nombre, String direccion, String telefono){
        try (Connection cnx = obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(IMEC_Cliente.INSERTAR.obtenerComando());) {
            stm.clearParameters();
            stm.setString(1, id);
            stm.setString(2, user);
            stm.setString(3, apellidos);
            stm.setString(4, nombre);
            stm.setString(5, direccion);
            stm.setString(6, telefono);
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
    
    public String obtenerId(String usuario) {
        String id = "";
        try (Connection cnx = obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(IMEC_Cliente.OBTENER_ID.obtenerComando());) {
            stm.clearParameters();
            stm.setString(1, usuario);
            try (ResultSet rs = stm.executeQuery()) {
                if (rs.next()) {
                    id = rs.getString("id_cliente");
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
    
    public List<Cliente> obtenerListaClientes() {
        List<Cliente> r = new ArrayList<>();
        try (Connection cnx = obtenerConexion();
                Statement stm = cnx.createStatement();
                ResultSet rs = stm.executeQuery(IMEC_Cliente.LISTAR.obtenerComando())) {
            while (rs.next()) {
                Cliente e = new Cliente(
                        rs.getString("id_cliente"),
                        rs.getString("usuario_id"),
                        rs.getString("apellidos"),
                        rs.getString("nombre"),
                        rs.getString("direccion"),
                        rs.getString("telefono")
                );
                r.add(e);
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
    
        public Cliente obtenerCliente(String usuariId) {
        Cliente cli = null;
        try (Connection cnx = obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(IMEC_Cliente.OBTENER_CLIENTE.obtenerComando());) {
            stm.clearParameters();
            stm.setString(1, usuariId);
            try (ResultSet rs = stm.executeQuery()) {
                if (rs.next()) {
                    cli = new Cliente(rs.getString("id_cliente"),rs.getString("usuario_id"),rs.getString("apellidos"),
                    rs.getString("nombre"),rs.getString("direccion"),rs.getString("telefono"));
                }
            }
        } catch (IOException
                | ClassNotFoundException
                | IllegalAccessException
                | InstantiationException
                | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
        return cli;
    }
    
    public boolean cambiarCliente(String idC, String usId, String ape, String nom, String dir, String tel) {
        try (Connection cnx = obtenerConexion();
            PreparedStatement stm = cnx.prepareStatement(IMEC_Cliente.CAMBIAR_CLIENTE.obtenerComando());) {
            stm.clearParameters();

            stm.setString(1, usId);
            stm.setString(2, ape);
            stm.setString(3, nom);
            stm.setString(4, dir);
            stm.setString(5, tel);
            stm.setString(6, idC);

            if (stm.executeUpdate() == 1) {
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

//        List<Cliente> clientes = su.obtenerListaClientes();
//        int i = 0;
//        for (Cliente u : clientes) {
//            System.out.printf("%4d: %s,%n", ++i, u);
//       }

    }
}

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
import proyecto2.modelo.Usuario;

// GestorUsuario.java
//
// EIF209 - Programación 4 - Proyecto #2
// Junio 2020
//
// Autores:
//    - 207950788     Sara Moraga Alfaro
//    - 116980485     Scarleth Villarreal Jímenez
//    - 117250099     Josué Víquez Campos

public class GestorUsuario {
    
    public boolean insertarUsuario(String id, String clave, int rol){
        try (Connection cnx = obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(IMEC_Usuario.INSERTAR.obtenerComando());) {
            stm.clearParameters();
            stm.setString(1, id);
            stm.setString(2, clave);
            stm.setInt(3, rol);
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
    
    public boolean validarUsuario(String id, String clave) {
        try (Connection cnx = obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(IMEC_Usuario.CONSULTAR_USUARIO.obtenerComando());) {
            stm.clearParameters();
            stm.setString(1, id);
            stm.setString(2, clave);
            try (ResultSet rs = stm.executeQuery()) {
                if (rs.absolute(1)) {
                    return true;
                }
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
    
    public List<Usuario> obtenerListaUsuarios() {
        List<Usuario> r = new ArrayList<>();
        try (Connection cnx = obtenerConexion();
                Statement stm = cnx.createStatement();
                ResultSet rs = stm.executeQuery(IMEC_Usuario.LISTAR.obtenerComando())) {
            while (rs.next()) {
                Usuario e = new Usuario(
                        rs.getString("id_usuario"),
                        rs.getString("clave_acceso"),
                        rs.getInt("rol")
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
    
    public int obtenerRol(String id) {
        int numRol = 0;
        try (Connection cnx = obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(IMEC_Usuario.OBTENER_ROL.obtenerComando());) {
            stm.clearParameters();
            stm.setString(1, id);
            try (ResultSet rs = stm.executeQuery()) {
                if (rs.next()) {
                    numRol = rs.getInt("rol");
                }
            }
        } catch (IOException
                | ClassNotFoundException
                | IllegalAccessException
                | InstantiationException
                | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
        return numRol;
    }
    
        public boolean cambiarClave(String idU, String claveNueva) {
        try (Connection cnx = obtenerConexion();
            PreparedStatement stm = cnx.prepareStatement(IMEC_Usuario.CAMBIAR_CONTRASENA.obtenerComando());) {
            stm.clearParameters();

            stm.setString(1, claveNueva);
            stm.setString(2, idU);

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
        GestorUsuario su = new GestorUsuario();
        //System.out.println(su.insertarUsuario("papu", "000", 1));
        
//        List<Usuario> usuarios = su.obtenerListaUsuarios();
//        int i = 0;
//        for (Usuario u : usuarios) {
//            System.out.printf("%4d: %s,%n", ++i, u);
//       }
//       System.out.println(su.validarUsuario("enau", "4567"));

    }
}

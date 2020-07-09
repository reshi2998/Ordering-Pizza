
package proyecto2.modelo.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import proyecto2.datos.BaseDatos;
import proyecto2.modelo.Comentarios;

// GestorComentarios.java
//
// EIF209 - Programación 4 - Proyecto #2
// Junio 2020
//
// Autores:
//    - 207950788     Sara Moraga Alfaro
//    - 116980485     Scarleth Villarreal Jímenez
//    - 117250099     Josué Víquez Campos

public class GestorComentarios {

    public boolean insertarComentario(String comen) {
        try (Connection cnx = obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(IMEC_Comentarios.INSERTAR.obtenerComando());) {
            stm.clearParameters();
            stm.setString(1, comen);
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
    public List<Comentarios> obtenerListaComentarios() {
        List<Comentarios> r = new ArrayList<>();
        try (Connection cnx = obtenerConexion();
                Statement stm = cnx.createStatement();
                ResultSet rs = stm.executeQuery(IMEC_Comentarios.LISTAR.obtenerComando())) {
            while (rs.next()) {
                Comentarios e = new Comentarios(
                        rs.getInt("id_comentario"),
                        rs.getString("comentario"),
                        rs.getDate("fecha")
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
    
    /*Lista de acuerdo de con la fecha ingresada*/
    public ArrayList<Comentarios> obtenerListaComentariosFecha(Date fec) {
        ArrayList<Comentarios> r = new ArrayList<>();
        try (Connection cnx = obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(IMEC_Comentarios.LISTARFECHA.obtenerComando());) {
            stm.clearParameters();
            stm.setDate(1, fec);
            try (ResultSet rs = stm.executeQuery()) {
                while (rs.next()) {
                    Comentarios c = new Comentarios(
                            rs.getInt("id_comentario"),
                            rs.getString("comentario"),
                            rs.getDate("fecha")
                           
                    );
                    r.add(c);
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
        GestorComentarios su = new GestorComentarios();
        // System.out.println(su.insertarComentario("Buenisima las galletas."));
        //System.out.println(su.obtenerCliente("enau"));
        //System.out.println(su.cambiarCliente("456789","enau","Vega Rojas","Salomon","San Jose","88888888"));
//        List<Comentarios> comens = su.obtenerListaComentarios();
//        int i = 0;
//        for (Comentarios u : comens) {
//            System.out.printf("%4d: %s,%n", ++i, u);
//       }

    }
}

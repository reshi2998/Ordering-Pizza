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
import proyecto2.modelo.Pizza;

// GestorPizza.java
//
// EIF209 - Programación 4 - Proyecto #2
// Junio 2020
//
// Autores:
//    - 207950788     Sara Moraga Alfaro
//    - 116980485     Scarleth Villarreal Jímenez
//    - 117250099     Josué Víquez Campos

public class GestorPizza {
    
    public boolean insertarPizza(String tam, String pasta, String nombre, String ingredientes, double precio, int imagen ){
        try (Connection cnx = obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(IMEC_Pizza.INSERTAR.obtenerComando());) {
            stm.clearParameters();
            stm.setString(1, tam);
            stm.setString(2, pasta);
            stm.setString(3, nombre);
            stm.setString(4, ingredientes);
            stm.setDouble(5, precio);
            stm.setDouble(6, imagen);
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
    
    public boolean modificarPizza(String tam, String pasta, String nom, String ingred, double precio, int idIm, int idP){
        try (Connection cnx = obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(IMEC_Pizza.UPDATE.obtenerComando());) {
            stm.clearParameters();
            stm.setString(1, tam);
            stm.setString(2, pasta);
            stm.setString(3, nom);
            stm.setString(4, ingred);
            stm.setDouble(5, precio);
            stm.setDouble(6, idIm);
            stm.setDouble(7, idP);
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
    
    public ArrayList<Pizza> obtenerListaPizzas() {
        ArrayList<Pizza> r = new ArrayList<>();
        try (Connection cnx = obtenerConexion();
                Statement stm = cnx.createStatement();
                ResultSet rs = stm.executeQuery(IMEC_Pizza.LISTAR.obtenerComando())) {
            while (rs.next()) {
                Pizza e = new Pizza(
                        rs.getInt("id_pizza"),
                        rs.getString("tamano"),
                        rs.getString("tipo_pasta"),
                        rs.getString("nombre_pizza"),
                        rs.getString("ingredientes"),
                        rs.getDouble("precio"),
                        rs.getInt("id_imagen")
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
    
    public boolean eliminarPizza(int id){
        try (Connection cnx = obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(IMEC_Pizza.ELIMINAR.obtenerComando());) {
            stm.clearParameters();
            stm.setInt(1, id);
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
    
    public String obtenerNombrePizza(int id) {
        String nom = "";
        try (Connection cnx = obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(IMEC_Pizza.OBTENER_NOMBRE.obtenerComando());) {
            stm.clearParameters();
            stm.setInt(1, id);
            try (ResultSet rs = stm.executeQuery()) {
                if (rs.next()) {
                    nom = rs.getString("nombre_pizza");
                }
            }
        } catch (IOException
                | ClassNotFoundException
                | IllegalAccessException
                | InstantiationException
                | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
        return nom;
    }
    
    public int obtenerPrecio(int id) {
        int precio = 0;
        try (Connection cnx = obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(IMEC_Pizza.OBTENER_PRECIO.obtenerComando());) {
            stm.clearParameters();
            stm.setInt(1, id);
            try (ResultSet rs = stm.executeQuery()) {
                if (rs.next()) {
                    precio = rs.getInt("precio");
                }
            }
        } catch (IOException
                | ClassNotFoundException
                | IllegalAccessException
                | InstantiationException
                | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
        return precio;
    }
    
    public int obtenerIdPizza(String tam, String pasta, String nom) {
        int idPizza = 0;
        try (Connection cnx = obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(IMEC_Pizza.OBTENER_ID.obtenerComando());) {
            stm.clearParameters();
            stm.setString(1, tam);
            stm.setString(2, pasta);
            stm.setString(3, nom);
            try (ResultSet rs = stm.executeQuery()) {
                if (rs.next()) {
                    idPizza = rs.getInt("id_pizza");
                }
            }
        } catch (IOException
                | ClassNotFoundException
                | IllegalAccessException
                | InstantiationException
                | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
        return idPizza;
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
        GestorPizza su = new GestorPizza();
        
//        List<Pizza> pizzas = su.obtenerListaPizzas();
//        int i = 0;
//        for (Pizza u : pizzas) {
//            System.out.printf("%4d: %s,%n", ++i, u);
//       }
//        
//        System.out.println(su.obtenerIdPizza("Personal", "Delgada", "Suprema"));

    }
}

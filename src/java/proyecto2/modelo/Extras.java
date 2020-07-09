package proyecto2.modelo;


import java.io.Serializable;
import org.json.JSONObject;

// Extras.java
//
// EIF209 - Programación 4 - Proyecto #2
// Junio 2020
//
// Autores:
//    - 207950788     Sara Moraga Alfaro
//    - 116980485     Scarleth Villarreal Jímenez
//    - 117250099     Josué Víquez Campos

public class Extras implements Serializable{

    public Extras(int idExtras, String nombre, double precio, boolean disponible) {
        this.idExtras = idExtras;
        this.nombre = nombre;
        this.precio = precio;
        this.disponible = disponible;
    }

    public Extras() {
        this(0, "", 0.0, true);
    }
    
    @Override
    public String toString() {
        return toJSON().toString(4);
    }
    
    public JSONObject toJSON() {
        JSONObject r = new JSONObject();
        r.put("idExtras", getIdExtras());
        r.put("nombre", getNombre());
        r.put("precio", getPrecio());
        r.put("disponible", getDisponible());
        return r;
    }

    public int getIdExtras() {
        return idExtras;
    }

    public void setIdExtras(int idExtras) {
        this.idExtras = idExtras;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    public boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
    
    private int idExtras;
    private String nombre;
    private double precio;
    private boolean disponible;
}


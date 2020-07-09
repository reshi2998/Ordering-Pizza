package proyecto2.modelo;

import java.io.Serializable;
import org.json.JSONObject;

// Pizza.java
//
// EIF209 - Programación 4 - Proyecto #2
// Junio 2020
//
// Autores:
//    - 207950788     Sara Moraga Alfaro
//    - 116980485     Scarleth Villarreal Jímenez
//    - 117250099     Josué Víquez Campos

public class Pizza implements Serializable{

    public Pizza(int idPizza, String tamano, String tipoPasta, String nomberPizza, String ingredientes, 
            double precio, int idImagen) {
        this.idPizza = idPizza;
        this.tamano = tamano;
        this.tipoPasta = tipoPasta;
        this.nomberPizza = nomberPizza;
        this.ingredientes = ingredientes;
        this.precio = precio;
        this.idImagen = idImagen;
    }

    public Pizza() {
        this(0, "", "", "", "", 0.0, 0);
    }
    
    @Override
    public String toString() {
        return toJSON().toString(4);
    }
    
    public JSONObject toJSON() {
        JSONObject r = new JSONObject();
        r.put("idPizza", getIdPizza());
        r.put("tamano", getTamano());
        r.put("tipoPasta", getTipoPasta());
        r.put("nomberPizza", getNomberPizza()); 
        r.put("ingredientes", getIngredientes());
        r.put("precio", getPrecio());
        r.put("idImagen", getIdImagen());
        return r;
    }

    public int getIdPizza() {
        return idPizza;
    }

    public void setIdPizza(int idPizza) {
        this.idPizza = idPizza;
    }

    public String getTamano() {
        return tamano;
    }

    public void setTamano(String tamano) {
        this.tamano = tamano;
    }

    public String getTipoPasta() {
        return tipoPasta;
    }

    public void setTipoPasta(String tipoPasta) {
        this.tipoPasta = tipoPasta;
    }

    public String getNomberPizza() {
        return nomberPizza;
    }

    public void setNomberPizza(String nomberPizza) {
        this.nomberPizza = nomberPizza;
    }

    public String getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getIdImagen() {
        return idImagen;
    }

    public void setIdImagen(int idImagen) {
        this.idImagen = idImagen;
    }
    
    private int idPizza;
    private String tamano;
    private String tipoPasta;
    private String nomberPizza;
    private String ingredientes; 
    private double precio;
    private int idImagen;
}

package proyecto2.modelo;

import java.io.Serializable;
import java.sql.Date;
import org.json.JSONObject;

// Ordenes.java
//
// EIF209 - Programación 4 - Proyecto #2
// Junio 2020
//
// Autores:
//    - 207950788     Sara Moraga Alfara
//    - 116980485     Scarleth Villarreal Jímenez
//    - 117250099     Josué Víquez Campos

public class Ordenes implements Serializable{

        public Ordenes(int numeroOrden, int idPizza, String acompanamiento, String extras, String idCliente, int unidadPizza,
            double precioTotal) {
        this.numeroOrden = numeroOrden;
        this.idPizza = idPizza;
        this.acompanamiento = acompanamiento;
        this.extras = extras;
        this.idCliente = idCliente;
        this.unidadPizza = unidadPizza;
        this.precioTotal = precioTotal;
    }

    public Ordenes(int numeroOrden, int idPizza, String acompanamiento, String extras, String idCliente, int unidadPizza,
            double precioTotal, Date fecha) {
        this.numeroOrden = numeroOrden;
        this.idPizza = idPizza;
        this.acompanamiento = acompanamiento;
        this.extras = extras;
        this.idCliente = idCliente;
        this.unidadPizza = unidadPizza;
        this.precioTotal = precioTotal;
        this.fecha = fecha;
    }

    public Ordenes() {
        this(0, 0, "", "", "", 0, 0.0);
    }

    @Override
    public String toString() {
        return toJSON().toString(4);
    }

    public JSONObject toJSON() {
        JSONObject r = new JSONObject();
        r.put("numeroOrden", getNumeroOrden());
        r.put("idPizza", getIdPizza());
        r.put("idAcompanamiento", getAcompanamiento());
        r.put("idExtras", getExtras());
        r.put("idCliente", getIdCliente());
        r.put("unidadPizza", getUnidadPizza());
        r.put("precioTotal", getPrecioTotal());
        return r;
    }

    public int getNumeroOrden() {
        return numeroOrden;
    }

    public void setNumeroOrden(int numeroOrden) {
        this.numeroOrden = numeroOrden;
    }

    public int getIdPizza() {
        return idPizza;
    }

    public void setIdPizza(int idPizza) {
        this.idPizza = idPizza;
    }

    public String getAcompanamiento() {
        return acompanamiento;
    }

    public void setAcompanamiento(String acompanamiento) {
        this.acompanamiento = acompanamiento;
    }

    public String getExtras() {
        return extras;
    }

    public void setExtras(String extras) {
        this.extras = extras;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public int getUnidadPizza() {
        return unidadPizza;
    }

    public void setUnidadPizza(int unidadPizza) {
        this.unidadPizza = unidadPizza;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    private int numeroOrden;
    private int idPizza;
    private String acompanamiento;
    private String extras;
    private String idCliente;
    private int unidadPizza;
    private double precioTotal;
    private Date fecha;
}
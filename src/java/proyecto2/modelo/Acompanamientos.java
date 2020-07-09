package proyecto2.modelo;

// Acompanamientos.java
import java.io.Serializable;
import org.json.JSONObject;

//
// EIF209 - Programación 4 - Proyecto #2
// Junio 2020
//
// Autores:
//    - 207950788     Sara Moraga Alfaro
//    - 116980485     Scarleth Villarreal Jímenez
//    - 117250099     Josué Víquez Campos
public class Acompanamientos implements Serializable {

    public Acompanamientos(int idAcompanamiento, String nombre, double precioAcomp, boolean disponible) {
        this.idAcompanamiento = idAcompanamiento;
        this.nombre = nombre;
        this.precioAcomp = precioAcomp;
        this.disponible = disponible;
    }

    public Acompanamientos() {
        this(0, "", 0.0, false);
    }

    @Override
    public String toString() {
        return toJSON().toString(4);
    }

    public JSONObject toJSON() {
        JSONObject r = new JSONObject();
        r.put("idAcompanamiento", getIdAcompanamiento());
        r.put("nombre", getNombre());
        r.put("precioAcomp", getPrecioAcomp());
        r.put("disponible", getDisponible());
        return r;
    }

    public int getIdAcompanamiento() {
        return idAcompanamiento;
    }

    public void setIdAcompanamiento(int idAcompanamiento) {
        this.idAcompanamiento = idAcompanamiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecioAcomp() {
        return precioAcomp;
    }

    public void setPrecioAcomp(double precioAcomp) {
        this.precioAcomp = precioAcomp;
    }

    public boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    private int idAcompanamiento;
    private String nombre;
    private double precioAcomp;
    private boolean disponible;
}

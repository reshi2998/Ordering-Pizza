
package proyecto2.modelo;

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

public class Factura {

    public Factura(int idFactura, int numeroOrden) {
        this.idFactura = idFactura;
        this.numeroOrden = numeroOrden;
    }

    public Factura() {
        this(0, 0);
    }
    
    @Override
    public String toString() {
        return toJSON().toString(4);
    }
    
    public JSONObject toJSON() {
        JSONObject r = new JSONObject();
        r.put("idFactura", getIdFactura());
        r.put("numeroOrden", getNumeroOrden());
        return r;
    }

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public int getNumeroOrden() {
        return numeroOrden;
    }

    public void setNumeroOrden(int numeroOrden) {
        this.numeroOrden = numeroOrden;
    }
    
    private int idFactura;
    private int numeroOrden;
}


package proyecto2.modelo;

import java.sql.Date;
import org.json.JSONObject;

// Cometarios.java
//
// EIF209 - Programación 4 - Proyecto #2
// Junio 2020
//
// Autores:
//    - 207950788     Sara Moraga Alfaro
//    - 116980485     Scarleth Villarreal Jiménez
//    - 117250099     Josué Víquez Campos

public class Comentarios {

    public int getId_comentario() {
        return id_comentario;
    }

    public void setId_comentario(int id_comentario) {
        this.id_comentario = id_comentario;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Comentarios(int id_comentario, String comentario, Date fecha) {
        this.id_comentario = id_comentario;
        this.comentario = comentario;
        this.fecha = fecha;
    }
    
    @Override
    public String toString() {
        return toJSON().toString(4);
    }
    public JSONObject toJSON(){
        JSONObject r = new JSONObject();
        r.put("id_comentario",getId_comentario());
        r.put("comentario", getComentario());
        r.put("fecha", getFecha());
        return r;
    }
    
    private int id_comentario;
    private String comentario;
    private Date fecha;
}


package proyecto2.modelo;

import java.io.Serializable;
import org.json.JSONObject;

// Usuario.java
//
// EIF209 - Programación 4 - Proyecto #2
// Junio 2020
//
// Autores:
//    - 207950788     Sara Moraga Alfaro
//    - 116980485     Scarleth Villarreal Jímenez
//    - 117250099     Josué Víquez Campos

public class Usuario implements Serializable {

    public Usuario(String idUsuario, String claveAcceso, int rol) {
        this.idUsuario = idUsuario;
        this.claveAcceso = claveAcceso;
        this.rol = rol;
    }
    
    public Usuario() {
        this("", "", 0);
    }
    
    @Override
    public String toString() {
        return toJSON().toString(4);
    }
    
    public JSONObject toJSON() {
        JSONObject r = new JSONObject();
        r.put("idUsuario", getIdUsuario());
        r.put("claveAcceso", getClaveAcceso());
        r.put("rol", getRol());
        return r;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getClaveAcceso() {
        return claveAcceso;
    }

    public void setClaveAcceso(String claveAcceso) {
        this.claveAcceso = claveAcceso;
    }

    public int getRol() {
        return rol;
    }

    public void setRol(int rol) {
        this.rol = rol;
    }
    
    private String idUsuario;
    private String claveAcceso;
    private int rol;
                    
}

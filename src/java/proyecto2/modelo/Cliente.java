package proyecto2.modelo;

import java.io.Serializable;
import org.json.JSONObject;

// Cliente.java
//
// EIF209 - Programación 4 - Proyecto #2
// Junio 2020
//
// Autores:
//    - 207950788     Sara Moraga Alfaro
//    - 116980485     Scarleth Villarreal Jímenez
//    - 117250099     Josué Víquez Campos

public class Cliente implements Serializable {

    public Cliente(String idCliente, String usuarioId, String apellidos, String nombre, String direccion, String telefono) {
        this.idCliente = idCliente;
        this.usuarioId = usuarioId;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public Cliente() {
        this("", "", "", "", "", "");
    }
    
    @Override
    public String toString() {
        return toJSON().toString(4);
    }
    
    public JSONObject toJSON() {
        JSONObject r = new JSONObject();
        r.put("idCliente", getIdCliente());
        r.put("usuarioId", getUsuarioId());
        r.put("apellidos", getApellidos());
        r.put("nombre", getNombre()); 
        r.put("direccion", getDireccion());
        r.put("telefono", getTelefono());
        return r;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(String usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
      
    private String idCliente;
    private String usuarioId;
    private String apellidos;
    private String nombre;
    private String direccion;
    private String telefono;
}

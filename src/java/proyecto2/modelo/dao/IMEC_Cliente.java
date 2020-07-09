package proyecto2.modelo.dao;

// IMEC_Usuario.java
//
// EIF209 - Programación 4 - Proyecto #2
// Junio 2020
//
// Autores:
//    - 207950788     Sara Moraga Alfaro
//    - 116980485     Scarleth Villarreal Jímenez
//    - 117250099     Josué Víquez Campos

public enum IMEC_Cliente {
    LISTAR("SELECT id_cliente, usuario_id, apellidos, nombre, direccion, telefono FROM cliente ORDER BY id_cliente; "),
    OBTENER_ID("SELECT id_cliente FROM cliente WHERE usuario_id = ?; "),
    INSERTAR("INSERT INTO cliente (id_cliente, usuario_id, apellidos, nombre, direccion, telefono) VALUES (?, ?, ?, ?, ?, ?); "),
    OBTENER_CLIENTE("SELECT id_cliente, usuario_id, apellidos, nombre, direccion, telefono FROM cliente WHERE usuario_id = ?; "),
    CAMBIAR_CLIENTE("UPDATE cliente SET usuario_id=?, apellidos=?, nombre=?, direccion=?, telefono=? WHERE id_cliente=?; ");
    
    IMEC_Cliente(String comando) {
        this.comando = comando;
    }

    public String obtenerComando() {
        return comando;
    }

    private final String comando;
}

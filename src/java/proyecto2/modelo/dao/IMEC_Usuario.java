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

public enum IMEC_Usuario {
    INSERTAR("INSERT INTO usuario (id_usuario, clave_acceso, rol) VALUES (?, ?, ?); "),
    LISTAR("SELECT id_usuario, clave_acceso, rol FROM usuario ORDER BY id_usuario; "),
    OBTENER_ROL("SELECT rol FROM usuario WHERE id_usuario = ?; "),
    CONSULTAR_USUARIO("SELECT id_usuario, clave_acceso FROM usuario WHERE id_usuario = ? and clave_acceso = ?; "),
    CAMBIAR_CONTRASENA("UPDATE usuario SET clave_acceso=? WHERE id_usuario=?; ");
    
    IMEC_Usuario(String comando) {
        this.comando = comando;
    }

    public String obtenerComando() {
        return comando;
    }

    private final String comando;
}

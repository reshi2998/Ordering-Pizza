
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

public enum IMEC_Comentarios {
    INSERTAR("INSERT INTO comentarios (comentario) VALUES (?); "),
    LISTAR("SELECT * FROM comentarios ORDER BY id_comentario; "),
    LISTARFECHA("SELECT id_comentario, comentario, fecha FROM comentarios WHERE fecha = ? ORDER BY id_comentario; ");
    
    IMEC_Comentarios(String comando) {
        this.comando = comando;
    }

    public String obtenerComando() {
        return comando;
    }

    private final String comando;
}

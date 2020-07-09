package proyecto2.modelo.dao;

// IMEC_Pizza.java
//
// EIF209 - Programación 4 - Proyecto #2
// Junio 2020
//
// Autores:
//    - 207950788     Sara Moraga Alfaro
//    - 116980485     Scarleth Villarreal Jímenez
//    - 117250099     Josué Víquez Campos

public enum IMEC_Pizza {
    INSERTAR("INSERT INTO pizza (tamano, tipo_pasta, nombre_pizza, ingredientes, precio, id_imagen) "
            + "VALUES (?, ?, ?, ?, ?, ?); "),
    LISTAR("SELECT id_pizza, tamano, tipo_pasta, nombre_pizza, ingredientes, precio, id_imagen FROM pizza ORDER BY nombre_pizza; "),
    ELIMINAR("DELETE FROM pizza WHERE id_pizza=?; "),
    UPDATE("UPDATE pizza SET tamano = ?, tipo_pasta = ?, nombre_pizza = ?, ingredientes = ?, precio = ?, id_imagen = ?"
            + "WHERE id_pizza = ?; "),
    OBTENER_NOMBRE("SELECT nombre_pizza FROM pizza WHERE id_pizza = ?; "),
    OBTENER_PRECIO("SELECT precio FROM pizza WHERE id_pizza = ?; "),
    OBTENER_ID("SELECT id_pizza FROM pizza WHERE tamano = ? AND tipo_pasta = ? AND nombre_pizza = ?; ");
    
    IMEC_Pizza(String comando) {
        this.comando = comando;
    }

    public String obtenerComando() {
        return comando;
    }

    private final String comando;
}

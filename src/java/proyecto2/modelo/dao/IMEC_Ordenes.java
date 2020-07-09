
package proyecto2.modelo.dao;


public enum IMEC_Ordenes {
    ELIMINAR("DELETE FROM ordenes WHERE id_orden = ?; "),
    OBTENER_ORDEN("SELECT id_orden, id_pizza, acompanamientos, extras, id_cliente, unidad_pizza, precioTotal "
            + "FROM ordenes WHERE id_orden = ?; "),
    LISTARFECHA("SELECT * from ordenes where fecha between ? and ?;"),
    LISTARPIZZA("SELECT * from ordenes where id_pizza = ?;"),
    OBTENER_ID("SELECT id_orden FROM ordenes WHERE id_pizza = ? AND id_cliente = ? AND precioTotal = ?; "),
    INSERTAR("INSERT INTO ordenes (id_pizza, acompanamientos, extras, id_cliente, unidad_pizza, precioTotal)"
            + " VALUES (?, ?, ?, ?, ?, ?); ");
    
    IMEC_Ordenes(String comando) {
        this.comando = comando;
    }

    public String obtenerComando() {
        return comando;
    }

    private final String comando;
}

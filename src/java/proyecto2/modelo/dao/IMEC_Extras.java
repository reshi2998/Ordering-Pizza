package proyecto2.modelo.dao;

/**
 *
 * @author Morag
 */
public enum IMEC_Extras {
    LISTAR("SELECT id_extras, nombre, precio, disponible FROM extras ORDER BY id_extras; "),
    AGREGAR("INSERT INTO extras (id_extras, nombre, precio, disponible) VALUES (?, ?, ?, ?); ");

    IMEC_Extras(String comando) {
        this.comando = comando;
    }

    public String obtenerComando() {
        return comando;
    }

    private final String comando;
}


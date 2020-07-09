package proyecto2.modelo.dao;

/**
 *
 * @author Morag
 */
public enum IMEC_Acompanamiento {
    LISTAR("SELECT id_acompanamientos, nombre, precioAcomp, disponible FROM acompanamientos ORDER BY id_acompanamientos; "),
    AGREGAR("INSERT INTO acompanamientos (id_acompanamientos, nombre, precioAcomp, disponible) VALUES (?, ?, ?, ?); ");

    IMEC_Acompanamiento(String comando) {
        this.comando = comando;
    }

    public String obtenerComando() {
        return comando;
    }

    private final String comando;
}

package proyecto2.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import org.json.JSONArray;
import org.json.JSONObject;
import proyecto2.modelo.dao.GestorAcompanamiento;
/**
 *
 * @author Morag
 */
@XmlRootElement(name = "lista-acompanamientos")
public class ListaAcompanamientos implements Serializable {

    public ListaAcompanamientos() {
        acomp = new ArrayList<>();
    }

    public ListaAcompanamientos(List<Acompanamientos> acomp) {
        this.acomp = new ArrayList<>(acomp);
    }

    public void agregar(GestorAcompanamiento gp) {
        acomp.forEach((Acompanamientos p) -> {
            gp.agregar(p);
        });
    }

    @Override
    public String toString() {
        return toJSON().toString(4);
    }

    public JSONObject toJSON() {
        JSONArray a = new JSONArray();
        acomp.forEach((p) -> {
            a.put(p.toJSON());
        });

        JSONObject r = new JSONObject();
        r.put("lista-acompanamientos", a);
        return r;
    }

    @XmlElement(name = "acomp")
    private final List<Acompanamientos> acomp;
}



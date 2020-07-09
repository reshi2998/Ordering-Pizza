package proyecto2.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import org.json.JSONArray;
import org.json.JSONObject;
import proyecto2.modelo.dao.GestorExtras;

/**
 *
 * @author Morag
 */
@XmlRootElement(name = "lista-extras")
public class ListaExtras implements Serializable {

    public ListaExtras() {
        extras = new ArrayList<>();
    }

    public ListaExtras(List<Extras> extras) {
        this.extras = new ArrayList<>(extras);
    }

    public void agregar(GestorExtras gp) {
        extras.forEach((Extras p) -> {
            gp.agregar(p);
        });
    }

    @Override
    public String toString() {
        return toJSON().toString(4);
    }

    public JSONObject toJSON() {
        JSONArray a = new JSONArray();
        extras.forEach((p) -> {
            a.put(p.toJSON());
        });

        JSONObject r = new JSONObject();
        r.put("lista-extras", a);
        return r;
    }

    @XmlElement(name = "extras")
    private final List<Extras> extras;
}


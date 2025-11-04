import java.util.ArrayList;
import java.util.List;


public class ListaDispositivos {
    private List<Dispositivo> catalogo;

    public ListaDispositivos() {
        this.catalogo = new ArrayList<>();
    }

    public List<Dispositivo> getCatalogo() {
    
        return new ArrayList<>(catalogo);
    }

    public void agregarDispositivo(Dispositivo d) {
        if (d != null) {
            catalogo.add(d);
        }
    }

    public List<Dispositivo> obtenerTodos() {
        return getCatalogo();
    }

    public Dispositivo obtenerPorId(String id) {
        for (Dispositivo d : catalogo) {
            if (d.getId().equalsIgnoreCase(id)) {
                return d;
            }
        }
        return null;
    }

    public List<Dispositivo> obtenerPorNombre(String nombre) {
        List<Dispositivo> res = new ArrayList<>();
        for (Dispositivo d : catalogo) {
            if (d.getNombre().toLowerCase().contains(nombre.toLowerCase())) {
                res.add(d);
            }
        }
        return res;
    }
}
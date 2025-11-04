import java.util.ArrayList;
import java.util.List;

public class FiltroController {
    
    public FiltroController() { }

    public List<Medible> filtrarMedibles(ListaDispositivos lista) {
        List<Medible> res = new ArrayList<>();
        if (lista == null) return res;
        for (Dispositivo d : lista.obtenerTodos()) {
            if (d instanceof Medible) {
                res.add((Medible) d);
            }
        }
        return res;
    }

    public List<Accionable> filtrarAccionables(ListaDispositivos lista) {
        List<Accionable> res = new ArrayList<>();
        if (lista == null) return res;
        for (Dispositivo d : lista.obtenerTodos()) {
            if (d instanceof Accionable) {
                res.add((Accionable) d);
            }
        }
        return res;
    }

    public List<Registrable> filtrarRegistrables(ListaDispositivos lista) {
        List<Registrable> res = new ArrayList<>();
        if (lista == null) return res;
        for (Dispositivo d : lista.obtenerTodos()) {
            if (d instanceof Registrable) {
                res.add((Registrable) d);
            }
        }
        return res;
    }
}
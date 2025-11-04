
import java.util.List;

public interface Registrable {
    void registrarEvento(String evento);

    List<String> obtenerEventos();
}
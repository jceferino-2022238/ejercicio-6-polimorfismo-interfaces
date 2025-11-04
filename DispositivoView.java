import java.util.List;

public class DispositivoView {
    
    public DispositivoView() { }

    public void mostrarListado(List<Dispositivo> dispositivos) {
        System.out.println("=== Lista de Dispositivos ===");
        if (dispositivos == null || dispositivos.isEmpty()) {
            System.out.println("No hay dispositivos para mostrar.");
            return;
        }
        for (Dispositivo d : dispositivos) {
            // toString() de polimorfismo
            System.out.println(d.toString());
        }
    }

    public void mostrarListadoDetallado(List<Dispositivo> dispositivos) {
        System.out.println("=== Lista DETALLADA de Dispositivos ===");
        if (dispositivos == null || dispositivos.isEmpty()) {
            System.out.println("No hay dispositivos para mostrar.");
            return;
        }
        for (Dispositivo d : dispositivos) {
            System.out.println(d.toString(true));
        }
    }

    public void mostrarDispositivo(Dispositivo d) {
        if (d == null) {
            System.out.println("Dispositivo no encontrado.");
            return;
        }
        System.out.println("=== Dispositivo encontrado ===");
        System.out.println(d.toString(true));
        // Si está Registrable, mostrar eventos
        if (d instanceof Registrable) {
            Registrable r = (Registrable) d;
            List<String> ev = r.obtenerEventos();
            System.out.println("Eventos registrados:");
            if (ev.isEmpty()) {
                System.out.println("  (Sin eventos)");
            } else {
                for (String e : ev) {
                    System.out.println("  - " + e);
                }
            }
        }
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void mostrarMediciones(List<Medible> medibles) {
        System.out.println("=== Mediciones de dispositivos medibles ===");
        if (medibles == null || medibles.isEmpty()) {
            System.out.println("No hay dispositivos medibles.");
            return;
        }
        for (Medible m : medibles) {
            System.out.println(m.medir());
            System.out.println("  -> " + m.reportarDatos());
        }
    }

    public void mostrarAccionables(List<Accionable> accionables) {
        System.out.println("=== Accionables disponibles ===");
        if (accionables == null || accionables.isEmpty()) {
            System.out.println("No hay dispositivos accionables.");
            return;
        }
        int i = 1;
        for (Accionable a : accionables) {
            System.out.println(i + ". " + a.getClass().getSimpleName());
            i++;
        }
    }
}
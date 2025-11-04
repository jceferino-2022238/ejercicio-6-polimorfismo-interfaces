public class EstacionMetereologica extends Dispositivo implements Medible, Registrable{
    private String[] sensoresDisponibles;
    private String ubicacion;
    private java.util.List<String> eventos; // historial de eventos registrados

    public EstacionMetereologica() {
        super();
        this.sensoresDisponibles = new String[] {"Temperatura", "Humedad", "Viento"};
        this.ubicacion = "No definida";
        this.eventos = new java.util.ArrayList<>();
    }

    public EstacionMetereologica(String id, String nombre, String fabricante, double consumo, String estado,
                                 String[] sensoresDisponibles, String ubicacion) {
        super(id, nombre, fabricante, consumo, estado);
        this.sensoresDisponibles = sensoresDisponibles.clone();
        this.ubicacion = ubicacion;
        this.eventos = new java.util.ArrayList<>();
    }
    
    public String[] getSensoresDisponibles() { return sensoresDisponibles.clone(); }
    public void setSensoresDisponibles(String[] s) { this.sensoresDisponibles = s.clone(); }

    public String getUbicacion() { return ubicacion; }
    public void setUbicacion(String u) { this.ubicacion = u; }

    // Medible
    @Override
    public String medir() {
        // Devolvemos una medición simulada combinada
        double temp = Math.round((10 + Math.random() * 20) * 100.0) / 100.0;
        double hum = Math.round((20 + Math.random() * 60) * 100.0) / 100.0;
        return String.format("Estacion[%s] - T=%.2f°C, H=%.2f%%", id, temp, hum);
    }

    @Override
    public String reportarDatos() {
        return String.format("Reporte Estacion %s @%s - sensores: %s",
                nombre, ubicacion, String.join(", ", sensoresDisponibles));
    }

    // Registrable
    @Override
    public void registrarEvento(String evento) {
        eventos.add(java.time.LocalDateTime.now() + " - " + evento);
    }

    @Override
    public java.util.List<String> obtenerEventos() {
        return new java.util.ArrayList<>(eventos);
    }

    @Override
    public String toString() {
        return String.format("%s | Ubicacion: %s | Sensores: %s",
                super.toString(), ubicacion, String.join(", ", sensoresDisponibles));
    }

    @Override
    public String toString(boolean full) {
        if (!full) return super.toString();
        String ev = String.join(" | ", obtenerEventos());
        if (ev.isEmpty()) ev = "No eventos registrados";
        return toString() + " | Eventos: " + ev;
    }
}
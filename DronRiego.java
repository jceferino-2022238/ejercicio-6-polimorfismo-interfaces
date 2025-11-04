public class DronRiego extends Dispositivo implements Accionable, Registrable{
    private double capacidadTanque; 
    private double autonomiaVuelo;
    private java.util.List<String> eventos;

    public DronRiego() {
        super();
        this.capacidadTanque = 5.0;
        this.autonomiaVuelo = 25.0;
        this.eventos = new java.util.ArrayList<>();
    }

    public DronRiego(String id, String nombre, String fabricante, double consumo, String estado,
                     double capacidadTanque, double autonomiaVuelo) {
        super(id, nombre, fabricante, consumo, estado);
        this.capacidadTanque = capacidadTanque;
        this.autonomiaVuelo = autonomiaVuelo;
        this.eventos = new java.util.ArrayList<>();
    }

    public double getCapacidadTanque() { return capacidadTanque; }
    public void setCapacidadTanque(double c) { this.capacidadTanque = c; }

    public double getAutonomiaVuelo() { return autonomiaVuelo; }
    public void setAutonomiaVuelo(double a) { this.autonomiaVuelo = a; }

    // Accionable
    @Override
    public String ejecutarAccion() {
        String resultado = String.format("DronRiego[%s] iniciando riego (tanque=%.1fL, autonomia=%.1fmin)", id, capacidadTanque, autonomiaVuelo);
        registrarEvento("Inicio Riego - " + resultado);
        return resultado;
    }

    @Override
    public String detenerAccion() {
        String resultado = String.format("DronRiego[%s] detiene riego", id);
        registrarEvento("Detener Riego - " + resultado);
        return resultado;
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
        return String.format("%s | CapacidadTanque: %.1fL | Autonomia: %.1fmin", super.toString(), capacidadTanque, autonomiaVuelo);
    }

    @Override
    public String toString(boolean full) {
        if (!full) return super.toString();
        return toString() + " | Eventos: " + (obtenerEventos().isEmpty() ? "No eventos" : String.join(", ", obtenerEventos()));
    }
}
public class SensorSuelo extends Dispositivo implements Medible{
    private String tipoMedicion; 
    private double rangoHumedad; 
    private int frecuenciaMuestreo; 

    // Constructores
    public SensorSuelo() {
        super();
        this.tipoMedicion = "Humedad";
        this.rangoHumedad = 100.0;
        this.frecuenciaMuestreo = 60;
    }

    public SensorSuelo(String id, String nombre, String fabricante, double consumo, String estado,
                       String tipoMedicion, double rangoHumedad, int frecuenciaMuestreo) {
        super(id, nombre, fabricante, consumo, estado);
        this.tipoMedicion = tipoMedicion;
        this.rangoHumedad = rangoHumedad;
        this.frecuenciaMuestreo = frecuenciaMuestreo;
    }

    // Getters / setters
    public String getTipoMedicion() { return tipoMedicion; }
    public void setTipoMedicion(String tipo) { this.tipoMedicion = tipo; }

    public double getRangoHumedad() { return rangoHumedad; }
    public void setRangoHumedad(double r) { this.rangoHumedad = r; }

    public int getFrecuenciaMuestreo() { return frecuenciaMuestreo; }
    public void setFrecuenciaMuestreo(int f) { this.frecuenciaMuestreo = f; }

    // Implementación de Medible
    @Override
    public String medir() {
        // Se simula una lectura
        double humedad = Math.round((Math.random() * (rangoHumedad)) * 100.0) / 100.0;
        return String.format("SensorSuelo[%s] - medicion: %s = %.2f%%", id, tipoMedicion, humedad);
    }

    @Override
    public String reportarDatos() {
        // Devuelve un resumen simulado para la vista
        return String.format("Reporte SensorSuelo %s (%s) - frecuencia %ds, rango %.1f%%",
                nombre, fabricante, frecuenciaMuestreo, rangoHumedad);
    }

    @Override
    public String toString() {
        return String.format("%s | TipoMedicion: %s | RangoHumedad: %.1f%% | Frecuencia: %ds",
                super.toString(), tipoMedicion, rangoHumedad, frecuenciaMuestreo);
    }

    // Sobrecarga toString
    @Override
    public String toString(boolean full) {
        if (!full) return super.toString();
        return toString();
    }
}